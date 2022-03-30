package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		//adding first category
		Category category = new Category();
		category.setId(1);
		category.setName("Tv");
		category.setDescription("Description of tv");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description of Mobile");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		//adding third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description of Laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category getById(int id) {
		for(Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
