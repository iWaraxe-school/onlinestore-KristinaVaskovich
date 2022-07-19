import categories.BikeCategory;
import categories.Category;
import categories.MilkCategory;
import products.Product;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class StoreApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        final Class bikeCategoryClass = categories.BikeCategory.class;
        Constructor<BikeCategory> bikeCategoryClassConstructor = bikeCategoryClass.getDeclaredConstructor(ArrayList.class);
        bikeCategoryClassConstructor.setAccessible(true);
        BikeCategory bikeCategory = bikeCategoryClassConstructor.newInstance(new ArrayList<Product>());

        final Class milkCategoryClass = categories.MilkCategory.class;
        Constructor<MilkCategory> milkCategoryClassConstructor = milkCategoryClass.getDeclaredConstructor(ArrayList.class);
        milkCategoryClassConstructor.setAccessible(true);
        MilkCategory milkCategory = milkCategoryClassConstructor.newInstance(new ArrayList<Product>());

        final Class newCategoryClass = categories.Category.class;
        Constructor<Category> newCategoryClassConstructor = newCategoryClass.getDeclaredConstructor(String.class, ArrayList.class);
        newCategoryClassConstructor.setAccessible(true);
        Category newCategory = newCategoryClassConstructor.newInstance("Cup", new ArrayList<Product>());

        Store store = new Store();
        Method fillList = store.getClass().getDeclaredMethod("fillList", Category.class, int.class);
        fillList.setAccessible(true);

        int numberOfBikeProducts = 5;
        int numberOfMilkProducts = 8;
        int numberOfCupProducts = 2;
        fillList.invoke(store, bikeCategory, numberOfBikeProducts);
        fillList.invoke(store, milkCategory, numberOfMilkProducts);
        fillList.invoke(store, newCategory, numberOfCupProducts);

        for (int i = 0; i < store.getCategoryArrayList().size(); i++) {
            System.out.println("Product category in store and products: " + store.getCategoryArrayList().get(i));
        }
    }
}
