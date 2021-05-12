package shop.service;

import java.util.ArrayList;

import model.Shop;
import shop.dao.ShopDao;
import shop.dao.ShopDaoImpl;

public class ShopServiceImpl implements ShopService{
	private ShopDao sdao;
	

	public ShopServiceImpl() {
		this.sdao = new ShopDaoImpl();
	}

	@Override
	public void addShop(Shop s) {
		sdao.insert(s);
	}

	@Override
	public Shop getShop(int num) {
		return sdao.select(num);
	}
	
	
	@Override
	public Shop getShop(String id) {
		return sdao.select(id);
	}
	
	@Override
	public Shop getShopByName(String s_name) {
		// TODO Auto-generated method stub
		return sdao.selectByName(s_name);
	}

	@Override
	public void editShop(Shop s) {
		sdao.update(s);
	}

	@Override
	public void delShop(int num) {
		sdao.delete(num);
	}

	@Override
	public ArrayList<Shop> getShopsAll() {
		return sdao.selectAll();
	}
	
	@Override
	public ArrayList<Shop> getShopsBySearch(String search) {
		// TODO Auto-generated method stub
		return sdao.selectAllBySearch(search);
	}

	@Override
	public ArrayList<Shop> getShopsByCategory(String category) {
		return sdao.selectAllByCategory(category);
	}
	

	@Override
	public ArrayList<Shop> getShopsByQnum() {
		return sdao.selectAllByQnum();
	}

	@Override
	public ArrayList<Shop> getShopsByscoreavg() {
		return sdao.selectAllByscoreavg();
	}

	@Override
	public void editQnum(int queue_num, String name) {
		sdao.updateQnum(queue_num, name);
	}

	@Override
	public void editScore(float scoreavg, String name) {
		sdao.updateScore(scoreavg, name);
	}
}
