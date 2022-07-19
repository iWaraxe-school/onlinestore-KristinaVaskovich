import categories.Category;

import java.util.ArrayList;

public class Store {
    private ArrayList<Category> categoryArrayList = new ArrayList<>();

    private ArrayList<Category> fillList(int numberOfItems) {
        categoryArrayList.add(RandomStorePopulator.fillListOfProducts(numberOfItems));
        return categoryArrayList;
    }
}