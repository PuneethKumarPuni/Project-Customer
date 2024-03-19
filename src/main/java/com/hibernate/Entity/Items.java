package com.hibernate.Entity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ItemDtls")
public class Items {
	@Id
	@GeneratedValue
	private String Cid;
	
	private String I1;
	
	private int P1;

	private String I2;

	private int P2;
	
	private String I3;
	
	private int p3;
	
	public int getP1() {
		return P1;
	}
	public void setP1(int p1) {
		P1 = p1;
	}
	public int getP2() {
		return P2;
	}
	public void setP2(int p2) {
		P2 = p2;
	}
	public int getP3() {
		return p3;
	}
	public void setP3(int p3) {
		this.p3 = p3;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getI1() {
		return I1;
	}
	public void setI1(String i1) {
		I1 = i1;
	}
	public String getI2() {
		return I2;
	}
	public void setI2(String i2) {
		I2 = i2;
	}
	public String getI3() {
		return I3;
	}
	public void setI3(String i3) {
		I3 = i3;
	}

}
