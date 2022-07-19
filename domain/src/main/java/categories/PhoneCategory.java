package categories;

import products.Product;
import java.util.ArrayList;

public class PhoneCategory extends Category{
    protected PhoneCategory(ArrayList<Product> products) {
        super("Phone", products);
    }
}
