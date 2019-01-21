package e.g.spitter.store;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import e.g.spitter.domain.Spittle;

@Repository
public class SpittleRepositoryLogic implements SpittleRepository {
	
	InputStream in = null;
	BufferedInputStream bin = null;
	ObjectInputStream oin = null;
	
	@Override
	public List<Spittle> recentSpittles() {
		List<Spittle> spittles = getSpittles();
		
		int size = spittles.size();
		List<Spittle> spittleList = new ArrayList();
		
		for(int i=0;i<=20;i++) {
			spittleList.add(spittles.get(size-i-1));
		}
		
		return spittleList;
	}
	
	@Override
	public List<Spittle> findSpittles(int index) {
		List<Spittle> spittles = getSpittles();
		
		int size = spittles.size();
		List<Spittle> spittleList = new ArrayList<>();
		
		for(int i=(index-1)*20;i<index*20;i++) {
			spittleList.add(spittles.get(size-i-1));
		}
		return spittleList;
	}
	
	@Override
	public Spittle findOne(long spittleId) {
		List<Spittle> spittles = getSpittles();
		
		int index=0;
		for(Spittle s : spittles) {
			if(s.getId() == spittleId)
				break;
			else 
				index++;
		}
		if(index < spittles.size()) {
			Spittle spittle = spittles.get(index);
			return spittle;
		}
		return null;
	}
	
	@Override
	public void save(Spittle spittle) {
		List<Spittle> spittles = getSpittles();
		Long id = Long.valueOf(spittles.size());
		spittle.setId(id);
		spittle.setTime(new Date());
		spittle.setLatitude(33.3333333);
		spittle.setLongitude(77.1234567);
		spittles.add(spittle);
		System.out.println(spittle.toString());
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		try {
			out = new FileOutputStream("c:/spittle/spittles.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
	        oout.writeObject(spittles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private List<Spittle> getSpittles() {
		List<Spittle> spittles = null;
		try {
			in = new FileInputStream("c:/spittle/spittles.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			spittles = (ArrayList<Spittle>)oin.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return spittles;
	}
}
