package categories;

import products.Product;
import java.util.ArrayList;

public class MilkCategory extends Category{
    protected MilkCategory(ArrayList<Product> products) {
        super("Milk", products);
    }
}
