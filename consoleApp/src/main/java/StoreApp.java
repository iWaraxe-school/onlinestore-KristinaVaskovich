import com.github.javafaker.Faker;
import commands.Command;
import commands.CommandExecutor;
import commands.SortCommand;
import commands.TopCommand;
import order.OrderConsumer;
import order.OrderProducer;
import sorting.XMLParser;
import store.Store;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class StoreApp {
    public static void main(String[] args) {
        Store store = Store.getStore();
        store.fillStore(4);
        System.out.println(store);

        XMLParser xmlParser = new XMLParser();
        Map<String, String> xmlParserMap = xmlParser.getMap();

        CommandExecutor commandExecutor = new CommandExecutor();
        Command sortCommand = new SortCommand("rate", store, xmlParserMap);
        commandExecutor.setCommand(sortCommand);
        commandExecutor.printSortedProducts();

        Command topCommand = new TopCommand("price", store, xmlParserMap);
        commandExecutor.setCommand(topCommand);
        commandExecutor.printSortedProducts();


        Timer timer = new Timer();
        int numberOfOrders = 2;
        final TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                OrderProducer orderProducer = new OrderProducer();

                for (int i = 0; i < numberOfOrders; i++) {
                    new Thread(orderProducer).start();
                }
            }
        };
        Faker faker = new Faker();
        timer.schedule(timerTask1, 0, faker.number().numberBetween(1, 30));

        final TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                OrderConsumer orderConsumer = new OrderConsumer();
                new Thread(orderConsumer).start();
                timer.cancel();
            }
        };
        timer.schedule(timerTask2, 0, 120000);
    }
}
