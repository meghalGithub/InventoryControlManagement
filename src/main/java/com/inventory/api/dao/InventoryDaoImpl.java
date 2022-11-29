package com.inventory.api.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.api.entity.Inventory;

@Repository
public class InventoryDaoImpl implements InventoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveGoods(Inventory inventory) {

		Session session = null;
		boolean saveGoods = false;
		try {
			session = sessionFactory.openSession();
			Inventory inventory2 = session.get(Inventory.class, inventory.getGoodsId());
			if (inventory2 == null) {
				Transaction transaction = session.beginTransaction();
				session.save(inventory);
				transaction.commit();
				saveGoods = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveGoods;
	}

	@Override
	public Inventory getGoodsById(String goodsId) {
		Session session = null;
		Inventory inventory = null;
		try {
			session = sessionFactory.openSession();
			inventory = session.get(Inventory.class, goodsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventory;
	}

	@Override
	public List<Inventory> getGoodsByName(String goodsName) {
		Session session = null;
		List<Inventory> inventory = null;
		try {
			session = sessionFactory.openSession();
			String hql = "FROM Inventory WHERE goodsName= :goodsName";
			Query query = session.createQuery(hql);
			query.setParameter("goodsName", goodsName);
			inventory= query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventory;
	}

	
	@Override
	public List<Inventory> getAllGoods() {
		Session session = null;
		List<Inventory> list = null;
		try {
		session =	sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleleGoodsById(String goodsId) {
		Session session = null;
		boolean delete = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Inventory inventory = session.get(Inventory.class, goodsId);
			if(inventory!=null) {
				session.delete(inventory);
				transaction.commit();
				delete = true;
			}
		 } catch (Exception e) {
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public boolean updateGoods(Inventory inventory) {
		Session session = null;
		boolean update = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Inventory inv = session.get(Inventory.class, inventory.getGoodsId());
			if(inv!=null) {
				session.evict(inv);
				session.update(inventory);
				transaction.commit();
				update = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public List<Inventory> getListOfSupplierName() {
		Session session = sessionFactory.openSession();
		List<Inventory> list = null;
		try {
			
			String hql = "SELECT supplierName FROM Inventory";
			Query query = session.createQuery(hql);
			list = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public List<Inventory> getListOfGoodsName() {
		Session session = sessionFactory.openSession();
		List<Inventory> list = null;
		try {
			
			String hql = "SELECT goodsName FROM Inventory";
			Query query = session.createQuery(hql);
			list = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public double getMaxGoodsPrice() {
		Session session = sessionFactory.openSession();
		  double maxvalue = 0;
		  try {
			  Criteria criteria = session.createCriteria(Inventory.class);
			  criteria.setProjection(Projections.max("goodsPrice"));
			  List<Double> list = criteria.list();
			  if(!list.isEmpty()) {
				  maxvalue = list.get(0);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxvalue;
	}

	@Override
	public double getMinGoodsPrice() {
		Session session = sessionFactory.openSession();
		  double minvalue = 0;
		  try {
			  Criteria criteria = session.createCriteria(Inventory.class);
			  criteria.setProjection(Projections.min("goodsPrice"));
			  List<Double> list = criteria.list();
			  if(!list.isEmpty()) {
				  minvalue = list.get(0);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return minvalue;
	}
	
	@Override
	public List<Inventory> getGoodsNameByAscending() {
			Session session = sessionFactory.openSession();
			List<Inventory> list = null;
		
			try {
				Criteria criteria = session.createCriteria(Inventory.class);
				criteria.addOrder(Order.asc("goodsName"));
				list = criteria.list();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
}