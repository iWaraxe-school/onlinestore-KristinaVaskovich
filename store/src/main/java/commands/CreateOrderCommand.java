package commands;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import order.OrderProducer;

public class CreateOrderCommand extends Command {
    @SneakyThrows
    @Override
    public void execute() {
        OrderProducer orderProducer = new OrderProducer();
        Faker faker = new Faker();
        new Thread(orderProducer).start();
        Thread.sleep(faker.number().numberBetween(1, 30));
    }
}
