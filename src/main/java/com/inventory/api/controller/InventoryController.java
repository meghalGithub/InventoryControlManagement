package com.inventory.api.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.api.entity.Inventory;
import com.inventory.api.exception.ProductNotExistException;
import com.inventory.api.exception.ProductNotFoundException;
import com.inventory.api.exception.SupplierListIsEmpty;
import com.inventory.api.service.InventoryService;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	/**
	 * @Class Inventory APIs
	 *
	 */
	
    @PostMapping(value = "/save_goods")
    public ResponseEntity<Boolean> saveGoods(@Valid @RequestBody Inventory inventory)
    {
    	boolean saveGoods = inventoryService.saveGoods(inventory);
    	if(saveGoods)
		  return new ResponseEntity<Boolean>(saveGoods, HttpStatus.OK);	
    	else
    		return new ResponseEntity<Boolean>(saveGoods, HttpStatus.INTERNAL_SERVER_ERROR);	
    }
	
    @GetMapping(value= "/get_goods_by_id/{goodsId}")
    public ResponseEntity<Inventory> getGoodsById(@PathVariable String goodsId){
    	Inventory inventory2 = inventoryService.getGoodsById(goodsId);
    	if(inventory2!=null)
    		return new ResponseEntity<Inventory>(inventory2,HttpStatus.OK);
    	else
    		throw new ProductNotFoundException("Product Not Found For this ID: "+goodsId);
    }
    
    @GetMapping(value= "/get_goods_by_name/{goodsName}")
    public ResponseEntity<List<Inventory>> getGoodsByName(@PathVariable String goodsName){
    	List<Inventory> inventory3 = inventoryService.getGoodsByName(goodsName);
    	if(inventory3!=null)
    		return new ResponseEntity<List<Inventory>>(inventory3,HttpStatus.OK);
    	else
    		throw new ProductNotFoundException("Product Not Found For this Name: "+goodsName);
    }
    
    @GetMapping(value = "/get_all_goods")
    public ResponseEntity<List<Inventory>> getAllGoods(){
    		List<Inventory> allGoods = inventoryService.getAllGoods();
    		if(!allGoods.isEmpty())
    		 return new ResponseEntity<List<Inventory>>(allGoods,HttpStatus.OK);
    		else
    		  throw new ProductNotExistException("There Are No Products Available");
    	}
    
    @DeleteMapping(value = "/delete_goods_by_id/{goodsId}")
    public ResponseEntity<Boolean> deleteGoodsById(@PathVariable String goodsId){
    		 boolean deleteGoods = inventoryService.deleleGoodsById(goodsId);
    		if(deleteGoods)
    		 return new ResponseEntity<Boolean>(deleteGoods,HttpStatus.OK);
    		else
    			throw new ProductNotFoundException("Product Not Found For this ID: "+goodsId);
    }
    
    @PostMapping(value = "/update_goods")
    public ResponseEntity<Boolean> updateGoods(@RequestBody Inventory inventory){
    		boolean updateGoods = inventoryService.updateGoods(inventory);
    		if(updateGoods)
    		 return new ResponseEntity<Boolean>(updateGoods,HttpStatus.OK);
    		else
    			throw new ProductNotExistException("There Are No Products Available");
   }
 
    @GetMapping(value="/get_list_of_supplier_name")
    public ResponseEntity<List<Inventory>> getListOfSupplierName(){
    	List<Inventory> listOfSupplierName = inventoryService.getListOfSupplierName();
    	if(!listOfSupplierName.isEmpty())
    		return new ResponseEntity<List<Inventory>>(listOfSupplierName,HttpStatus.OK);
    	else
    		throw new SupplierListIsEmpty("List is Empty");
    }
    
    @GetMapping(value = "/get_list_of_goods_name")
    public ResponseEntity<List<Inventory>> getListOfGoodsName(){
    	List<Inventory> listOfGoodsName = inventoryService.getListOfGoodsName();
    	if(!listOfGoodsName.isEmpty())
    		return new ResponseEntity<List<Inventory>>(listOfGoodsName,HttpStatus.OK);
    	else
    		throw new SupplierListIsEmpty("List is Empty");
    }
    
    @GetMapping(value = "/get_max_goods_price")
    public ResponseEntity<Double> getgetMaxGoodsPrice(){
    	double maxGoodsPrice = inventoryService.getMaxGoodsPrice();
    	return new ResponseEntity<Double>(maxGoodsPrice,HttpStatus.OK);	
    }
    
    @GetMapping(value = "/get_min_goods_price")
    public ResponseEntity<Double> getMinGoodsPrice(){
    	double minGoodsPrice = inventoryService.getMinGoodsPrice();
    	return new ResponseEntity<Double>(minGoodsPrice,HttpStatus.OK);	
    }
    
    @GetMapping(value="/get_goods_name_by_ascending")
    public ResponseEntity<List<Inventory>> getGoodsNameByAscending(){
    	List<Inventory> ascendingName = inventoryService.getGoodsNameByAscending();
    	if(!ascendingName.isEmpty())
    		return new ResponseEntity<List<Inventory>>(ascendingName,HttpStatus.OK);
    	else
    		throw new SupplierListIsEmpty("List is Empty");
    }  
    
    @GetMapping(value = "/sort_inventory/{sortBy}")
	public ResponseEntity<List<Inventory>> sortProducts(@PathVariable String sortBy) {
		List<Inventory> sort = inventoryService.sortInventory(sortBy);
		if (!sort.isEmpty())
			return new ResponseEntity<List<Inventory>>(sort, HttpStatus.OK);
		else 
			return new ResponseEntity<List<Inventory>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    
    @GetMapping(value = "/get_max_goods_price_product")
    public ResponseEntity<Inventory> getMaxGoodsPrice(){
    	Inventory maxGoodsPrice = inventoryService.getMaxGoodsPriceProduct();
    	if(maxGoodsPrice!=null)
		 return new ResponseEntity<Inventory>(maxGoodsPrice,HttpStatus.OK);
    	else
    		return new ResponseEntity<Inventory>(maxGoodsPrice,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}