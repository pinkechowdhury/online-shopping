package net.kzn.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String brand;
	@JsonIgnore
	private String description;
	private double unit_price;
	private int quantity;
	@JsonIgnore
	private boolean is_active;
	@JsonIgnore
	private int category_id;
	@JsonIgnore
	private int supplier_id;
	private int purchases;
	private int views;
	
	public Product(int id, String code, String name, String brand, String description, double unit_price, int quantity,
			boolean is_active, int category_id, int supplier_id, int purchases, int views) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.unit_price = unit_price;
		this.quantity = quantity;
		this.is_active = is_active;
		this.category_id = category_id;
		this.supplier_id = supplier_id;
		this.purchases = purchases;
		this.views = views;
	}
	
	//default constructor
	public Product() {
		this.code = "PRD"+ UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unit_price=" + unit_price + ", quantity=" + quantity + ", is_active=" + is_active
				+ ", category_id=" + category_id + ", supplier_id=" + supplier_id + ", purchases=" + purchases
				+ ", views=" + views + "]";
	}
	
}
