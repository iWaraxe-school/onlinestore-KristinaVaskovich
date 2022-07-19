package products;

import lombok.ToString;

@ToString
public class Product {
    private int price;
    private String name;
    private int rate;

    public Product(int price, String name, int rate) {
        this.price = price;
        this.name = name;
        this.rate = rate;
    }
}
