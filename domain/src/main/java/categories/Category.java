package categories;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import products.Product;
import java.util.ArrayList;

@Setter
@Getter
@ToString
public class Category {
    private String name;
    private ArrayList<Product> products;

    protected Category(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }
}
