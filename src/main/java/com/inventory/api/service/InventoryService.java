package com.inventory.api.service;

import java.util.List;

import com.inventory.api.entity.Inventory;

public interface InventoryService {

	public boolean saveGoods(Inventory inventory);

	public Inventory getGoodsById(String goodsId);
	
	public List<Inventory> getGoodsByName(String goodsName);

	public List<Inventory> getAllGoods();

	public boolean deleleGoodsById(String goodsId);

	public boolean updateGoods(Inventory inventory);
	
	public List<Inventory> getListOfSupplierName();
	
    public List<Inventory> getListOfGoodsName();
	
	public double getMaxGoodsPrice();
	
	public double getMinGoodsPrice();
	
	public List<Inventory> getGoodsNameByAscending();
	
	public Inventory getMaxGoodsPriceProduct();

	public List<Inventory> sortInventory(String sortBy);
}
