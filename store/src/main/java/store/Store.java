package store;

import categories.Category;
import helpers.RandomCategoryPopulator;
import helpers.RandomStorePopulator;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Store {
    private List<Category> categoryList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store with categories: " +
                categoryList;
    }

    public void fillStore(int numberOfItemsInCategory) {
        categoryList = RandomStorePopulator.fillStoreWithCategories();
        for (Category category : categoryList) {
            category.setProducts(RandomCategoryPopulator.fillCategoryWithProducts(category, numberOfItemsInCategory));
        }
    }
}