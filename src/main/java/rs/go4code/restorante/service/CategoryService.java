package rs.go4code.restorante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import rs.go4code.restorante.data.CategoryRepository;
import rs.go4code.restorante.model.Category;

@Component
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
		
	public Page<Category> findAll(Pageable page){
		return categoryRepo.findAll(page);			
	}
	
	public Category findOne(Long id) {
		return categoryRepo.findById(id).get();
	}
	
	public Category findByName(String categoryName) {
		return categoryRepo.findByNameCategory(categoryName);
	}

	
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public void delete(Category c) {
		categoryRepo.delete(c);
	}
	
	public void deleteById(Long id) {
		categoryRepo.deleteById(id);
	}
	
	

}
