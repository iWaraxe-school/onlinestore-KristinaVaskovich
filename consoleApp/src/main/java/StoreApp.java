import commands.*;
import sorting.XMLParser;
import store.Store;
import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Store store = Store.getStore();
        store.fillStore(5);
        System.out.println(store);

        XMLParser xmlParser = new XMLParser();
        Map<String, String> xmlParserMap = xmlParser.getMap();

        Scanner sc = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor();
        System.out.println("Enter command ( sort top order quit ): ");

        Command deleteCommand = new DeleteOrdersCommand();
        commandExecutor.setCommand(deleteCommand);
        commandExecutor.execute();

        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }

            if (command.equalsIgnoreCase("sort")) {
                Command sortCommand = new SortCommand("rate", store, xmlParserMap);
                commandExecutor.setCommand(sortCommand);
                commandExecutor.execute();
            }

            if (command.equalsIgnoreCase("top")) {
                Command topCommand = new TopCommand("price", store, xmlParserMap);
                commandExecutor.setCommand(topCommand);
                commandExecutor.execute();
            }

            if (command.equalsIgnoreCase("order")) {
                Command orderCommand = new CreateOrderCommand();
                commandExecutor.setCommand(orderCommand);
                commandExecutor.execute();
            }
        }
    }
}