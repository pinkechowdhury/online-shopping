package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product getById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
	
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setIs_active(false);
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE is_active = :active";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE is_active = :active AND category_id =:categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE is_active = :active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
