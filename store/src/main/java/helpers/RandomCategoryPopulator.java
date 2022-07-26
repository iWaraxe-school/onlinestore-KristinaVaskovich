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
            switch (category.getName()) {
                case "Bike":
                    products.add(new Product(randomNumberFrom0To100, faker.aviation().aircraft(), randomNumberFrom0To10));
                    break;
                case "Milk":
                    products.add(new Product(randomNumberFrom0To100, faker.food().fruit(), randomNumberFrom0To10));
                    break;
                case "Phone":
                    products.add(new Product(randomNumberFrom0To100, faker.hipster().word(), randomNumberFrom0To10));
                    break;
                default:
                    products.add(new Product(randomNumberFrom0To100, null, randomNumberFrom0To10));
                    break;
            }
        }
        return products;
    }
}
