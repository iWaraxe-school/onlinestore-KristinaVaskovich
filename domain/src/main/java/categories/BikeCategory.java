package categories;

import lombok.ToString;
import products.Product;
import java.util.ArrayList;

@ToString
public class BikeCategory extends Category {
    protected BikeCategory(ArrayList<Product> products) {
        super("Bike", products);
    }
}
