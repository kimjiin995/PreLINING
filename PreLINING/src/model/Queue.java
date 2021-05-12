package model;

import java.util.Date;

public class Queue {
	private int num;
	private String s_name;
	private String g_name;
	private String g_phone;
	private int pnum;
	private int snum;
	private Date r_date;
	
	public Queue() {}

	public Queue(int num, String s_name, String g_name, String g_phone, int pnum, int snum, Date r_date) {
		super();
		this.num = num;
		this.s_name = s_name;
		this.g_name = g_name;
		this.g_phone = g_phone;
		this.pnum = pnum;
		this.snum = snum;
		this.r_date = r_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getG_phone() {
		return g_phone;
	}

	public void setG_phone(String g_phone) {
		this.g_phone = g_phone;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	@Override
	public String toString() {
		return "Queue [num=" + num + ", s_name=" + s_name + ", g_name=" + g_name + ", g_phone=" + g_phone + ", pnum="
				+ pnum + ", snum=" + snum + ", r_date=" + r_date + "]";
	}
	
}