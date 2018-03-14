package net.fbamate.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aord {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Integer id;
	
	@Column(length=100)
	private String oid;
	
	private Integer uid;
	
	@Column(name = "tasktime",columnDefinition="timestamp")
	private Timestamp tasktime ;
	
	@Column(name = "expire",columnDefinition="timestamp")
	private Timestamp expire ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Timestamp getTasktime() {
		return tasktime;
	}

	public void setTasktime(Timestamp tasktime) {
		this.tasktime = tasktime;
	}

	public Timestamp getExpire() {
		return expire;
	}

	public void setExpire(Timestamp expire) {
		this.expire = expire;
	}
	
	
}
