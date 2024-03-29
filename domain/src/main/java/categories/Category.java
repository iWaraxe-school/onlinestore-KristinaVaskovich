package categories;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import products.Product;
import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
public class Category {
    private CategoryName name;
    private List<Product> products;

    public Category(CategoryName name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public CategoryName getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n=========================================\n" +
                "CATEGORY: " +
                "'" + name + '\''
                + products + "\n=========================================\n";
    }
}
