package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Product;

@Repository("SpringJPAProductDAOImpl")
public class SpringJPAProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<Product> getAllProducts() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("findAllProducts");
		List<Product> productList=query.getResultList();
		// TODO Auto-generated method stub
		return productList;
	}

	@Override
	public List<String> getCategoriesNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int checkProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

}
