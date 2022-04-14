package net.kzn.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String image_url;
	private boolean is_active = true; //admin can deactivate the category
	
	public Category(int id, String name, String description, String image_url, boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image_url = image_url;
		this.is_active = is_active;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", image_url=" + image_url
				+ ", is_active=" + is_active + "]";
	}
	
}
