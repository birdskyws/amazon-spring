package net.fbamate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp; 

@Entity
public class Tasklist {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	private String oid;
	
	
	@Column(name = "tasktime",columnDefinition="timestamp")
	private Timestamp tasktime ;
	
	private String pic;
	@Column(columnDefinition="tinyint",length=1)
	private int state;
	
	private int num;
	
	private int aid;
	
	@Column(name="catch",columnDefinition="tinyint",length=1)
	private int catdo;
	
	@Column(length=1000)
	private String sellors;

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

	public Timestamp getTasktime() {
		return tasktime;
	}

	public void setTasktime(Timestamp tasktime) {
		this.tasktime = tasktime;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getCatdo() {
		return catdo;
	}

	public void setCatdo(int catdo) {
		this.catdo = catdo;
	}

	public String getSellors() {
		return sellors;
	}

	public void setSellors(String sellors) {
		this.sellors = sellors;
	}
	
	
}
