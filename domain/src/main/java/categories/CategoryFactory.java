package categories;

import java.util.Objects;

public class CategoryFactory {

    public Category getCategory(CategoryName name) {
        if (Objects.equals(name, CategoryName.bike)) {
            return new BikeCategory();
        } else if (Objects.equals(name, CategoryName.milk)) {
            return new MilkCategory();
        } else if (Objects.equals(name, CategoryName.phone)) {
            return new PhoneCategory();
        }
        return null;
    }
}
