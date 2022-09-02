package helpers;

import categories.Category;
import lombok.Getter;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class RandomStorePopulator {
    private static List<Category> categoryArrayList = new ArrayList<>();

    public static List<Category> fillStoreWithCategories() {
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
