import categories.Category;

public class Store {
    private Category fillList(int numberOfItems){
        return RandomStorePopulator.fillListOfProducts(numberOfItems);
    }
}