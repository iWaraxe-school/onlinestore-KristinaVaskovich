import categories.Category;
import com.github.javafaker.Faker;
import products.Product;
import java.util.ArrayList;

public class RandomStorePopulator {
    public static Category fillListOfProducts(int numberOfItems) {
        Category category = null;
        ArrayList<Product> products = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < numberOfItems; i++) {
            int randomNumberFrom0To10 = 0 + (int) (Math.random() * 10);
            int randomNumberFrom0To100 = 0 + (int) (Math.random() * 100);
            products.add(new Product(randomNumberFrom0To100, faker.name().name(), randomNumberFrom0To10));
        }
        category.setProducts(products);
        return category;
    }
}
