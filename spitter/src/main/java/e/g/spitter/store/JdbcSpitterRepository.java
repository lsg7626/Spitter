package e.g.spitter.store;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import e.g.spitter.domain.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void SetDataSourceTag(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Spitter spitter) {
		String SQL = "insert into spitter values (?, ?, ?, ?, ?)";
		System.out.println(spitter.toString());
		String reception = "N";
		if(spitter.isUpdateByEmail())
			reception = "Y";
		jdbcTemplate.update(SQL, 
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getFullName(),
				spitter.getEmail(),
				reception
		);
	}

	@Override
	public Spitter findByUsername(String username) {
		String SQL = "select * from spitter where username = ?";
		return jdbcTemplate.queryForObject(SQL, new SpitterRowMapper(), username);
	}
	
	private static final class SpitterRowMapper implements RowMapper<Spitter> {

		@Override
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			Spitter spitter = new Spitter();
			spitter.setUsername(rs.getString("username"));
			spitter.setPassword(rs.getString("password"));
			spitter.setFullName(rs.getString("fullName"));
			spitter.setEmail(rs.getString("email"));
			if(rs.getString("updateByEmail").equals("Y"))
				spitter.setUpdateByEmail(true);
			else
				spitter.setUpdateByEmail(false);
			return spitter;
		}
		
	}
}
