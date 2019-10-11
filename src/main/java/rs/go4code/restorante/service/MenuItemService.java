package rs.go4code.restorante.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import rs.go4code.restorante.data.MenuItemRepository;
import rs.go4code.restorante.model.MenuItem;


@Component
public class MenuItemService {
	
	@Autowired
	MenuItemRepository menuIRepo;
		
	public MenuItem findOne(Long id) {
		return menuIRepo.findById(id).get();
	}
	
	public Page<MenuItem> findAll(Pageable page){
		return menuIRepo.findAll(page);
	}	
	
	public Page<MenuItem> getMenuItems (String name, Pageable page){
		return menuIRepo.findMenuItemByName(name, page);

	}
	
	public MenuItem saveMenu(MenuItem menu){
		return menuIRepo.save(menu);
	}
	
	public void remove(Long id){
		menuIRepo.deleteById(id);
	}
	

}
