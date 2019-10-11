package rs.go4code.restorante.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.go4code.restorante.dto.CategoryDTO;
import rs.go4code.restorante.dto.MenuItemDTO;
import rs.go4code.restorante.dto.PageDTO;
import rs.go4code.restorante.model.Category;
import rs.go4code.restorante.model.MenuItem;
import rs.go4code.restorante.service.CategoryService;
import rs.go4code.restorante.service.MenuItemService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/menus")
public class MenuItemController {
	
	@Autowired
	MenuItemService menuService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PageDTO<MenuItemDTO>> getMenusPage(@RequestParam(required = false, defaultValue="") String name, Pageable page) {
		List<MenuItemDTO> menuItems = new ArrayList<MenuItemDTO>();
		Page<MenuItem> onepage = menuService.getMenuItems(name, page);		
		
		for (MenuItem mi : onepage.getContent()) {
			MenuItemDTO midto = new MenuItemDTO(mi);
			midto.setCategory(new CategoryDTO(mi.getCategory()));			
			menuItems.add(midto);
		}	
		
		PageDTO<MenuItemDTO> pageDTO = new PageDTO<MenuItemDTO>(page.getPageNumber(), page.getPageSize(), onepage.getTotalElements(), menuItems);
		
		return new ResponseEntity<PageDTO<MenuItemDTO>>(pageDTO, HttpStatus.OK); 
	}
	
	//create
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Menu> createMenuItem(@RequestBody Menu menuItem) {
//		Category c = categoryService.findOne(menuItem.getCategory().getId());
//		Menu newItem = new Menu(null, menuItem.getName(), menuItem.getPrice(), c);
//		newItem = menuService.saveMenu(newItem);
//		
//		return new ResponseEntity<Menu>(newItem, HttpStatus.OK);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<MenuDTO> createMenuItem(@RequestBody MenuDTO menuItemDTO) {
//		Category c = categoryService.findByName(menuItemDTO.getCategorie().getNameCategory());
//		Menu newItem = new Menu(null, menuItemDTO.getName(), menuItemDTO.getPrice(), c);
//		newItem = menuService.saveMenu(newItem);
//		
//		return new ResponseEntity<MenuDTO>(new MenuDTO(newItem), HttpStatus.OK);
//	}	
	
	@PostMapping
	public ResponseEntity<MenuItemDTO> create(@RequestBody MenuItem menu) {
		
		MenuItem newItem = new MenuItem();
		newItem.setName(menu.getName());
		newItem.setPrice(menu.getPrice());		
		newItem.setCategory(new Category(null, menu.getCategory().getNameCategory()));		
		newItem = menuService.saveMenu(newItem);

		return new ResponseEntity<>(new MenuItemDTO(newItem), HttpStatus.CREATED);
	}
	
	//update
	@PutMapping(value = "/{id}")
	public ResponseEntity<MenuItemDTO> update(@PathVariable Long id, @RequestBody MenuItem menu){
		MenuItem menuItem = menuService.findOne(id);
		
		if (menuItem == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		menuItem.setName(menu.getName());
		menuItem.setCategory(menu.getCategory());
		menuItem.setPrice(menu.getPrice());
		
		menuItem = menuService.saveMenu(menuItem);

		return new ResponseEntity<>(new MenuItemDTO(menuItem), HttpStatus.OK);
	}

	//delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		MenuItem menuItem = menuService.findOne(id);
		if (menuItem != null) {
			menuService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	//findByName
//	@RequestMapping(value="/{name}", method=RequestMethod.GET)
//	public ResponseEntity<MenuItemDTO> findByName(@PathVariable String name) {
//		MenuItem menuItem =  menuService.findByName(name);		
//		if (menuItem == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}		
//		return new ResponseEntity<>(new MenuItemDTO(menuItem), HttpStatus.OK);
//	}
//	
	
	

}
