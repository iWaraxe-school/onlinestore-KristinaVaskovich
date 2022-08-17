package store;

import categories.Category;
import helpers.RandomCategoryPopulator;
import helpers.RandomStorePopulator;
import lombok.Getter;
import products.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Store {
    private List<Category> categoryList = new ArrayList<>();
    private static Store store = null;

    private Store() {
    }

    public static Store getStore() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }

    @Override
    public String toString() {
        return "Store with categories: " +
                categoryList;
    }

    public void fillStoreWithRandomPopulator(int numberOfItemsInCategory) {
        categoryList = RandomStorePopulator.fillStoreWithCategories();
        for (Category category : categoryList) {
            category.setProducts(RandomCategoryPopulator.fillCategoryWithProducts(category, numberOfItemsInCategory));
        }
    }

    public List<Product> getAllProducts() {
        return Store.getStore().getCategoryList().stream().map(Category::getProducts).
                flatMap(Collection::stream).collect(Collectors.toList());
    }
}