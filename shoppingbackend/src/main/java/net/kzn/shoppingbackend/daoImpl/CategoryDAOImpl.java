package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE is_active=:active";
		
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Category getById(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			//add the category in the db
			sessionFactory.getCurrentSession().persist(category);			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);;			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setIs_active(false);
		
		try {

			sessionFactory.getCurrentSession().update(category);;			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



	//	private static List<Category> categories = new ArrayList<>();
	//	
	//	static {
	//		//adding first category
	//		Category category = new Category();
	//		category.setId(1);
	//		category.setName("Tv");
	//		category.setDescription("Description of tv");
	//		category.setImage_url("CAT_1.png");
	//		
	//		categories.add(category);
	//		
	//		//adding second category
	//		category = new Category();
	//		category.setId(2);
	//		category.setName("Mobile");
	//		category.setDescription("Description of Mobile");
	//		category.setImage_url("CAT_2.png");
	//		
	//		categories.add(category);
	//		
	//		//adding third category
	//		category = new Category();
	//		category.setId(3);
	//		category.setName("Laptop");
	//		category.setDescription("Description of Laptop");
	//		category.setImage_url("CAT_3.png");
	//		
	//		categories.add(category);
	//	}

	//	@Override
	//	public List<Category> list() {
	//		return categories;
	//	}
	//
	//	@Override
	//	public Category getById(int id) {
	//		for(Category category : categories) {
	//			if(category.getId() == id) {
	//				return category;
	//			}
	//		}
	//		return null;
	//	}


}
