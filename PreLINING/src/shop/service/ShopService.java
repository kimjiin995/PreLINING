package shop.service;

import java.util.ArrayList;

import model.Shop;

public interface ShopService {
	void addShop(Shop s);
	Shop getShop(int num);
	Shop getShop(String id);
	Shop getShopByName(String s_name);
	void editShop(Shop s);
	void delShop(int num);
	ArrayList<Shop> getShopsAll();
	ArrayList<Shop> getShopsBySearch(String search);
	ArrayList<Shop> getShopsByCategory(String category);
	ArrayList<Shop> getShopsByQnum();
	ArrayList<Shop> getShopsByscoreavg();
	void editQnum(int queue_num, String name);
	void editScore(float scoreavg, String name);
}
