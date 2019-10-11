package rs.go4code.restorante.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import rs.go4code.restorante.model.MenuItem;

@Component
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	Page<MenuItem> findMenuItemByName (String name, Pageable page);
}
