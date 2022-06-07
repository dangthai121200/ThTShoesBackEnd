package com.herokuapp.readjson;

public class JsonGiay {
	private String id;
	private String name;
	private String brand;
	private String gender;
	private String category;
	private String price;
	private String is_in_inventory;
	private String items_left;
	private String imageURL;
	private String slug;

	public JsonGiay() {
	}

	public String getId() {
		return id;
	}

	public JsonGiay(String id, String name, String brand, String gender, String category, String price,
			String is_in_inventory, String items_left, String imageURL, String slug) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.gender = gender;
		this.category = category;
		this.price = price;
		this.is_in_inventory = is_in_inventory;
		this.items_left = items_left;
		this.imageURL = imageURL;
		this.slug = slug;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIs_in_inventory() {
		return is_in_inventory;
	}

	public void setIs_in_inventory(String is_in_inventory) {
		this.is_in_inventory = is_in_inventory;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getItems_left() {
		return items_left;
	}

	public void setItems_left(String items_left) {
		this.items_left = items_left;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
