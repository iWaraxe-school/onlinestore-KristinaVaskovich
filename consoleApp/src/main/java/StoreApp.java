import commands.*;
import db.DBConnector;
import sorting.XMLParser;
import store.Store;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Store store = Store.getStore();
        store.fillStore(8);
        System.out.println(store);

        XMLParser xmlParser = new XMLParser();
        Map<String, String> xmlParserMap = xmlParser.getMap();

        DBConnector dbConnector = new DBConnector();
        dbConnector.createAndFillDB();

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