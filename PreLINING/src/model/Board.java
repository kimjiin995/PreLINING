package model;

import java.sql.Date;

public class Board {
	private int num;
	private String g_name;
	private String s_name;
	private Date w_date;
	private String content;
	private int score;
	private int parent;
	
	public Board() {}
	public Board(int num, String g_name, String s_name, Date w_date, String content, int score, int parent) {
		super();
		this.num = num;
		this.g_name = g_name;
		this.s_name = s_name;
		this.w_date = w_date;
		this.content = content;
		this.score = score;
		this.parent = parent;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", g_name=" + g_name + ", s_name=" + s_name + ", w_date=" + w_date + ", content="
				+ content + ", score=" + score + ", parent=" + parent + "]";
	}
	
	
}
