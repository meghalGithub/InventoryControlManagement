package com.inventory.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Inventory {

	@Id
	@Min(1)
	private String goodsId;
	
	@NotEmpty(message = "Goods Name is Required")
	private String goodsName;
	
	@NotEmpty(message = "Goods Type is Required")
	private String goodsType;
	
	@Min(1)
	private int goodsQty;
	
	@Min(1)
	private double goodsPrice;
	
	@NotEmpty(message = "Supplier Name should be added")
	private String supplierName;
	
	private long supplierContact;
	
	public Inventory() {
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public int getGoodsQty() {
		return goodsQty;
	}

	public void setGoodsQty(int goodsQty) {
		this.goodsQty = goodsQty;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public long getSupplierContact() {
		return supplierContact;
	}

	public void setSupplierContact(long supplierContact) {
		this.supplierContact = supplierContact;
	}

	public Inventory(String goodsId, String goodsName,String goodsType, int goodsQty,
			double goodsPrice, String supplierName, long supplierContact) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsQty = goodsQty;
		this.goodsPrice = goodsPrice;
		this.supplierName = supplierName;
		this.supplierContact = supplierContact;
	}

	@Override
	public String toString() {
		return "Inventory [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsType=" + goodsType + ", goodsQty="
				+ goodsQty + ", goodsPrice=" + goodsPrice + ", supplierName=" + supplierName + ", supplierContact="
				+ supplierContact + "]";
	}
	
	
	
}
