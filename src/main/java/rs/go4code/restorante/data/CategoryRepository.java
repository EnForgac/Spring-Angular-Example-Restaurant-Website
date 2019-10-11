package rs.go4code.restorante.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import rs.go4code.restorante.model.Category;

@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Category findByNameCategory (String nameCategory);

}
