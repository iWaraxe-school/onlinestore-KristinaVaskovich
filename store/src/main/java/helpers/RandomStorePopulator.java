package helpers;

import categories.Category;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RandomStorePopulator {
    public static List<Category> fillStoreWithCategories() {
        List<Category> categoryArrayList = new ArrayList<>();
        Reflections reflections = new Reflections("categories");
        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);
        for (Class<? extends Category> type : subTypes) {
            try {
                categoryArrayList.add(type.getConstructor().newInstance());
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return categoryArrayList;
    }
}
