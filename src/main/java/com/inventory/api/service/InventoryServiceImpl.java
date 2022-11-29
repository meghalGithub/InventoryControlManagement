package com.inventory.api.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.api.dao.InventoryDao;
import com.inventory.api.entity.Inventory;
import com.inventory.api.sorting.GoodsIdComparator;
import com.inventory.api.sorting.GoodsNameComparator;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryDao dao;

	@Override
	public boolean saveGoods(Inventory inventory) {
	    boolean saveGoods = dao.saveGoods(inventory);
		return saveGoods;
	}

	@Override
	public Inventory getGoodsById(String goodsId) {
		return dao.getGoodsById(goodsId);
	}
	
	@Override
	public List<Inventory> getGoodsByName(String goodsName) {
		return dao.getGoodsByName(goodsName);
	}
	
	@Override
	public List<Inventory> getAllGoods() {	
		return dao.getAllGoods();
	}

	@Override
	public boolean deleleGoodsById(String goodsId) {
		boolean delete = dao.deleleGoodsById(goodsId);
		return delete;
	}

	@Override
	public boolean updateGoods(Inventory inventory) {
		boolean update = dao.updateGoods(inventory);
		return update;
	}

	@Override
	public List<Inventory> getListOfSupplierName() {
		return dao.getListOfSupplierName();
	}

	@Override
	public List<Inventory> getListOfGoodsName() {
		return dao.getListOfGoodsName();
	}

	@Override
	public double getMaxGoodsPrice() {
		return dao.getMaxGoodsPrice();
	}

	@Override
	public double getMinGoodsPrice() {
		return dao.getMinGoodsPrice();
	}	
	
	@Override
	public List<Inventory> getGoodsNameByAscending() {
		return dao.getGoodsNameByAscending();
	}

	@Override
	public Inventory getMaxGoodsPriceProduct() {
		
		List<Inventory> getGoodsList = getAllGoods();
		Inventory inventory = getGoodsList
				.stream()
				.max(Comparator.comparingDouble(Inventory::getGoodsPrice))
				.get();
		
		return inventory;	
	}

	@Override
	public List<Inventory> sortInventory(String sortBy) {
		List<Inventory> list = getAllGoods();
		if(sortBy.equalsIgnoreCase("goodsName")) {
			Collections.sort(list, new GoodsNameComparator());
			Collections.reverse(list);
		}
		else if(sortBy.equalsIgnoreCase("goodsId"))
			Collections.sort(list, new GoodsIdComparator());
		return list;
	}		
}