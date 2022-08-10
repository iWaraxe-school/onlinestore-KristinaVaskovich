package store;

import lombok.ToString;
import products.Product;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@ToString
public class Order {
    private Store store = Store.getStore();
    private static Order order = null;
    private List<Product> productList = store.getAllProducts();
    private List<Product> listOfOrders = new CopyOnWriteArrayList<>();

    private Order() {
    }

    public static Order getOrder() {
        if (order == null) {
            order = new Order();
        }
        return order;
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
        System.out.println("Remove from productlist to orders that product: " + randomElement);
        System.out.println("OrderList: " + getListOfOrders());
    }

    public synchronized void deleteFromOrderList() {
        System.out.println("OrderList cleared");
        listOfOrders.clear();
        System.out.println("OrderList: " + getListOfOrders());
    }
}