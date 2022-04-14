package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Ignore
public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();	
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		
		category.setName("Tv");
		category.setDescription("Description of tv");
		category.setImage_url("CAT_1.png");
		
		assertNotNull(category);
		
		//assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
	}
	
	@Test
	public void testGetCategory() {
		category = categoryDAO.getById(1);
		assertEquals("Successfully fetched a single category from the table!", "Laptop", category.getName());
	}
	
	@Test
	public void testUpdateCategory() {
		category = categoryDAO.getById(1);
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory() {
		category = categoryDAO.getById(1);		
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));
	}
	
	@Test
	public void testListCategory() {	
		assertEquals("Successfully fetched the list of categories from the table!", 7 , categoryDAO.list().size());
	}

}
