package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveExistProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "шапка", 500);
        Product product2 = new Product(2, "кроссовки", 5_000);
        Product product3 = new Product(3, "спортивный костюм", 15_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldRemoveProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "шапка", 500);
        Product product2 = new Product(2, "кроссовки", 5_000);
        Product product3 = new Product(3, "спортивный костюм", 15_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        //   repo.remove(5);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );

    }
}
