package products;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
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

    public Product(){
    }

    @Override
    public String toString() {
        return '\n' + "Product " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate;
    }
}
