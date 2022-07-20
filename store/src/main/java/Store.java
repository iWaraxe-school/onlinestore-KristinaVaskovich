import categories.Category;
import helpers.RandomCategoryPopulator;
import helpers.RandomStorePopulator;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@ToString
@Getter
public class Store {
    public List<Category> fillStore(int numberOfItemsInCategory) {
        List<Category> categoryList = RandomStorePopulator.fillStoreWithCategories();
        for (Category category : categoryList) {
            category.setProducts(RandomCategoryPopulator.fillCategoryWithProducts(category, numberOfItemsInCategory));
        }
        return categoryList;
    }
}