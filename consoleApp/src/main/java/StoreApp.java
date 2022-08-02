import categories.Category;
import categories.CategoryFactory;
import categories.CategoryName;
import commands.Command;
import commands.CommandExecutor;
import commands.SortCommand;
import commands.TopCommand;
import sorting.XMLParser;
import store.Store;
import java.util.Map;

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
    }
}
