package model;

public class Shop {
	private int num;
	private String id;
	private String name;
	private String menu;
	private String location;
	private String phone;
	private String img;
	private String content;
	private String category;
	private int queue_num;
	private int viewcount;
	private float scoreavg;
	
	public Shop() {};
	public Shop(int num, String id, String name, String menu, String location, String phone, String img, String content,
			String category, int queue_num, int viewcount, float scoreavg) {
		super();
		this.num = num;
		this.id = id;
		this.name = name;
		this.menu = menu;
		this.location = location;
		this.phone = phone;
		this.img = img;
		this.content = content;
		this.category = category;
		this.queue_num = queue_num;
		this.viewcount = viewcount;
		this.scoreavg = scoreavg;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQueue_num() {
		return queue_num;
	}
	public void setQueue_num(int queue_num) {
		this.queue_num = queue_num;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public float getScoreavg() {
		return scoreavg;
	}
	public void setScoreavg(float scoreavg) {
		this.scoreavg = scoreavg;
	}
	@Override
	public String toString() {
		return "Shop [num=" + num + ", id=" + id + ", name=" + name + ", menu=" + menu + ", location=" + location
				+ ", phone=" + phone + ", img=" + img + ", content=" + content + ", category=" + category
				+ ", queue_num=" + queue_num + ", viewcount=" + viewcount + ", scoreavg=" + scoreavg + "]";
	}
}
