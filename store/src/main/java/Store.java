import categories.Category;
import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;

@ToString
@Getter
public class Store {
    private ArrayList<Category> categoryArrayList = new ArrayList<>();

    private ArrayList<Category> fillList(Category category, int numberOfItems) {
        categoryArrayList.add(RandomStorePopulator.fillCategoryWithProducts(category, numberOfItems));
        return categoryArrayList;
    }
}