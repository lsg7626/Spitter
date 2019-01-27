package e.g.spitter.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spitter{	
	
	@NotNull
	@Size(min=5, max=16, message="{username.size}")
	private String username;
	
	@NotNull
	@Size(min=5, max=25, message="{password.size}")
	private String password;
	
	private String fullName;
	private String email;
	private boolean updateByEmail;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUpdateByEmail() {
		return updateByEmail;
	}

	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}

	@Override
	  public boolean equals(Object that) {
	    return EqualsBuilder.reflectionEquals(this, that);
	  }
	  
	  @Override
	  public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	  }

	@Override
	public String toString() {
		return "Spitter [username=" + username + ", password=" + password + ", fullName=" + fullName
				+ ", email=" + email + ", updateByEmail=" + updateByEmail + "]";
	}
	  
}
