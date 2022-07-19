package categories;

import products.Product;
import java.util.ArrayList;

public class BikeCategory extends Category {
    protected BikeCategory(ArrayList<Product> products) {
        super("Bike", products);
    }
}