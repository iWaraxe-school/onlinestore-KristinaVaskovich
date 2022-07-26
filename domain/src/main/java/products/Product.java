package products;

import lombok.Getter;

@Getter
public class Product {
    private int price;
    private String name;
    private int rate;

    public Product(int price, String name, int rate) {
        this.price = price;
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return '\n' + "Product " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate;
    }
}
