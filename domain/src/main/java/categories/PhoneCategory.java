package categories;

import lombok.ToString;
import products.Product;
import java.util.ArrayList;

@ToString
public class PhoneCategory extends Category{
    protected PhoneCategory(ArrayList<Product> products) {
        super("Phone", products);
    }
}
