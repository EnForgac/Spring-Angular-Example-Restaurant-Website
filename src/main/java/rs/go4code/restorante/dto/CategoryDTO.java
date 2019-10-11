package rs.go4code.restorante.dto;

import rs.go4code.restorante.model.Category;

public class CategoryDTO {
	private Long id;
	private String nameCategory;
	
	public CategoryDTO() {
		super();
	}
	
	public CategoryDTO(Long id, String nameCategory) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
	}

	public CategoryDTO(Category c) {
		this.id = c.getId();
		this.nameCategory = c.getNameCategory();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

}
