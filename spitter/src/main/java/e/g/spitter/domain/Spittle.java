package e.g.spitter.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spittle implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String message;
	private Date time;
  	private Double latitude;
  	private Double longitude;

  public Spittle() {
	// TODO Auto-generated constructor stub
  }
  public Spittle(String message, Date time) {
    this(null, message, time, null, null);
  }
	  
  public Spittle(Long id, String message, Date time, Double longitude, Double latitude) {
    this.id = id;
    this.message = message;
    this.time = time;
    this.longitude = longitude;
    this.latitude = latitude;
  }
  	public void setTime(Date time) {
  		this.time = time;
  	}
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public Date getTime() {
		return time;
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
		return "Spittle [id=" + id + ", message=" + message + ", time=" + time + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
}
