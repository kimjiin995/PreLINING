package shop.dao;

import java.util.ArrayList;

import model.Shop;

public interface ShopDao {
	
	void insert(Shop s);
	Shop select(int num);
	Shop select(String id);
	Shop selectByName(String s_name);
	void update(Shop s);
	void delete(int num);
	ArrayList<Shop> selectAll();
	ArrayList<Shop> selectAllBySearch(String search);
	ArrayList<Shop> selectAllByCategory(String category);
	ArrayList<Shop> selectAllByQnum();
	ArrayList<Shop> selectAllByscoreavg();
	void updateQnum(int queue_num, String s_name);
	void updateScore(float scoreavg, String s_name);
	
}
