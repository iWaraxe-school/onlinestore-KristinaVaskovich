import categories.Category;
import lombok.ToString;
import java.util.ArrayList;

@ToString
public class Store {
    private ArrayList<Category> categoryArrayList = new ArrayList<>();

    private ArrayList<Category> fillList(Category category, int numberOfItems) {
        categoryArrayList.add(RandomStorePopulator.fillListOfProducts(category, numberOfItems));
        return categoryArrayList;
    }
}
