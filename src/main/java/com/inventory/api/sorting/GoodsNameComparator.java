package com.inventory.api.sorting;

import java.util.Comparator;

import com.inventory.api.entity.Inventory;

public class GoodsNameComparator implements Comparator<Inventory>{
	
	@Override
	public int compare(Inventory i1, Inventory i2) {
		return i1.getGoodsName().compareTo(i2.getGoodsName());
	}
}