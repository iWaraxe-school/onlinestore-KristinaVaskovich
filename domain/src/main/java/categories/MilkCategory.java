package categories;

import lombok.ToString;
import products.Product;
import java.util.ArrayList;

@ToString
public class MilkCategory extends Category{
    protected MilkCategory(ArrayList<Product> products) {
        super("Milk", products);
    }
}
