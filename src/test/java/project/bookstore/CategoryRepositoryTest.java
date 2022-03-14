package project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Find category by name
	@Test
	public void findByNameReturnName() {
		List<Category> category = categoryRepository.findByName("Runot");
		Assertions.assertThat(category.get(0).getName()).isEqualTo("Runot");
	}
	
	// Find category by name and check if right amount exists
	@Test
	public void findByNameReturnSize() {
		List<Category> category = categoryRepository.findByName("Runot");
		Assertions.assertThat(category).hasSize(1);
	}
	
	// Insert new category
	@Test
	public void insertNewCategory() {
		Category category = new Category("Käsityökirjat");
		categoryRepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	// Delete category
	@Test 
	public void deleteCAtegory() { 
		List<Category> category = categoryRepository.findByName("Runot");
		categoryRepository.deleteById(category.get(0).getCategoryid());
		category = categoryRepository.findByName("Runot");
		Assertions.assertThat(category).hasSize(0);
	}

}
