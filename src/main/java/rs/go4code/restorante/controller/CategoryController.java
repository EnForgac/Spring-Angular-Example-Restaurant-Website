package rs.go4code.restorante.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.go4code.restorante.dto.CategoryDTO;
import rs.go4code.restorante.model.Category;
import rs.go4code.restorante.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
		
	//get
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		List<Category> categories = categoryService.findAll();
		List<CategoryDTO> retVal = new ArrayList<>();
		for (Category category : categories) {
			retVal.add(new CategoryDTO(category));
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	//create
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CategoryDTO> create(@RequestBody Category c) {			
		Category newCategory = new Category();
		newCategory.setNameCategory(c.getNameCategory());			
		newCategory = categoryService.saveCategory(newCategory);
		return new ResponseEntity<>(new CategoryDTO(newCategory), HttpStatus.CREATED);
	}
	
	//update
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CategoryDTO> updateById (@PathVariable Long id, @RequestBody Category c){
		Category updatedC = categoryService.findOne(id);
		updatedC.setNameCategory(c.getNameCategory());
		updatedC = categoryService.saveCategory(updatedC);
		return new ResponseEntity<> (new CategoryDTO(updatedC), HttpStatus.OK);		
	}
	
	//delete
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeById (@PathVariable Long id){
		Category c = categoryService.findOne(id);
		if(c != null) {
			categoryService.delete(c);
			return new ResponseEntity<>(HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}	
	

}
