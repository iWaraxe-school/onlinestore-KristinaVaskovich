package order;

import lombok.SneakyThrows;
import store.Store;

public class OrderProducer extends Thread {
    private Order order = new Order(Store.getStore());

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        order.putToOrder();
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
