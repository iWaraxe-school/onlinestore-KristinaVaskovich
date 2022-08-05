package order;

import lombok.SneakyThrows;
import store.Store;

import java.util.TimerTask;

public class OrderConsumer extends TimerTask  {
    private Order order = new Order(Store.getStore());

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        order.deleteFromOrderList();
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
