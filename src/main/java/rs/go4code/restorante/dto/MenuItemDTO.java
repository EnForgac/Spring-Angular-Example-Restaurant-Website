package rs.go4code.restorante.dto;


import rs.go4code.restorante.model.MenuItem;

public class MenuItemDTO {

	private Long id;	
	private String name;
	private Double price;
	
	private CategoryDTO category;
	
	private long categoryID;
	private String categoryName;

	public MenuItemDTO() {
		super();
	}	

	public MenuItemDTO(Long id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public MenuItemDTO(MenuItem menu) {
		this.id = menu.getId();
		this.name = menu.getName();
		this.price = menu.getPrice();
		this.categoryID = menu.getCategory().getId();
		this.categoryName = menu.getCategory().getNameCategory();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
}

