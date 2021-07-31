package com.zeedlabs.inventoryapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.zeedlabs.inventoryapp.entity.Product;
import com.zeedlabs.inventoryapp.repository.CartItemRepository;
import com.zeedlabs.inventoryapp.shopping.CartItem;
import com.zeedlabs.inventoryapp.user.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ShoppingCartTests {

	@Autowired
	private CartItemRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testAddItemFromDataBase() {
		Product product = entityManager.find(Product.class, 11);
		User user = entityManager.find(User.class, 20);

		CartItem item = new CartItem(2, product, user);

		repo.save(item);
	}

	@Test
	public void testAddItemByIds() {
		Product product = new Product(12);
		User user = new User(2);

		CartItem item = new CartItem(2, product, user);
		repo.save(item);

	}

	@Test
	public void testAddMultipleItems() {
		User user = new User(1);
		Product product1 = new Product(11);
		Product product2 = new Product(13);
		Product product3 = new Product(14);

		CartItem item1 = new CartItem(5, product1, user);
		CartItem item2 = new CartItem(6, product2, user);
		CartItem item3 = new CartItem(7, product3, user);

		repo.saveAll(List.of(item1, item2, item3));

	}
	@Test
	public void testListAllItems() {
		List<CartItem> listItems = repo.findAll();
		listItems.forEach(System.out::println);
	}
	@Test
	public void testUpdatItem() {
		CartItem cartItem = repo.findById(1).get();
		cartItem.setQuantity(3);
		cartItem.setProduct(new Product(12));
	}
	@Test
	public void testRemoveItem() {
		repo.deleteById(6);
	}
}
