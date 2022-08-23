package helpers;

import categories.Category;
import com.github.javafaker.Faker;
import products.Product;
import java.util.ArrayList;
import java.util.List;

public class RandomCategoryPopulator {
    public static List<Product> fillCategoryWithProducts(Category category, int numberOfItemsInCategory) {
        List<Product> products = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numberOfItemsInCategory; i++) {
            int randomNumberFrom0To10 = faker.number().numberBetween(0, 10);
            int randomNumberFrom0To100 = faker.number().numberBetween(0, 1000);
            switch (category.getName().toString()) {
                case "bike" ->
                        products.add(new Product(randomNumberFrom0To100, faker.aviation().aircraft(), randomNumberFrom0To10));
                case "milk" ->
                        products.add(new Product(randomNumberFrom0To100, faker.food().fruit(), randomNumberFrom0To10));
                case "phone" ->
                        products.add(new Product(randomNumberFrom0To100, faker.hipster().word(), randomNumberFrom0To10));
                default -> products.add(new Product(randomNumberFrom0To100, null, randomNumberFrom0To10));
            }
        }
        return products;
    }
}
