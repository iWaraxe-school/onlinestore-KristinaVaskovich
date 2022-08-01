package categories;

import java.util.Objects;

public class CategoryFactory {

    public Category getCategory(CategoryName name) {
        if (Objects.equals(name, CategoryName.BIKE)) {
            return new BikeCategory();
        } else if (Objects.equals(name, CategoryName.MILK)) {
            return new MilkCategory();
        } else if (Objects.equals(name, CategoryName.PHONE)) {
            return new PhoneCategory();
        }
        return null;
    }
}
