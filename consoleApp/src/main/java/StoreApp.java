import commands.*;
import sorting.XMLParser;
import store.Store;
import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Store store = Store.getStore();
        store.fillStore(4);
        System.out.println(store);

        XMLParser xmlParser = new XMLParser();
        Map<String, String> xmlParserMap = xmlParser.getMap();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter command ( sort top order deleteOrder quit ): ");
        while (sc.hasNext()) {
            CommandExecutor commandExecutor = new CommandExecutor();
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

            if (command.equalsIgnoreCase("deleteOrder")) {
                Command deleteCommand = new DeleteOrdersCommand();
                commandExecutor.setCommand(deleteCommand);
                commandExecutor.execute();
            }
        }
    }
}