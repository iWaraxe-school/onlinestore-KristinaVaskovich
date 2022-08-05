package order;

import lombok.ToString;
import products.Product;
import store.Store;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ToString
public class Order {
    private Store store = Store.getStore();
    private List<Product> productList = store.getAllProducts();
    private List<Product> listOfOrders = new ArrayList<>();

    public Order(Store store) {
        this.store = store;
    }

    public List<Product> getListOfOrders() {
        return listOfOrders;
    }

    public synchronized void putToOrder() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(productList.size() - 1);
        Product randomElement = productList.get(randomIndex);
        listOfOrders.add(randomElement);
        productList.remove(randomIndex);
        System.out.println("remove from productlist to orders that product: " + randomElement);
        System.out.println("orderList: " + getListOfOrders());
    }

    public synchronized void deleteFromOrderList() {
        System.out.println("orderlist cleared");
        listOfOrders.clear();
        System.out.println("orderList: " + getListOfOrders());
    }
}