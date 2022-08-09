package commands;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import store.Order;

public class CreateOrderCommand extends Command {
    @SneakyThrows
    @Override
    public void execute() {
        Thread thread = new Thread(() -> {
            System.out.printf("%s started... \n", Thread.currentThread().getName());
            Order.getOrder().putToOrder();
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        });
        thread.start();
        Faker faker = new Faker();
        Thread.sleep(faker.number().numberBetween(1, 30));
    }
}
