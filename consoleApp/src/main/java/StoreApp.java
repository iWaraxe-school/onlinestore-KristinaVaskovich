import sorting.Comparator;
import sorting.XMLParser;
import store.Store;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        store.fillStore(4);
        System.out.println(store);

        XMLParser xmlParser = new XMLParser();
        Map<String, String> xmlParserMap = xmlParser.getMap();
        Comparator comparator = new Comparator();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter command ( sort top quit ): ");
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }
            if (command.equalsIgnoreCase("sort")) {
                System.out.print("Choose field to sort (");
                xmlParserMap.keySet().forEach((key) -> System.out.print(" " + key));
                System.out.print(" ): ");
                String fieldToSort = sc.next();
                System.out.println(comparator.sortStore(fieldToSort, store, xmlParserMap));
            }
            if (command.equalsIgnoreCase("top")) {
                Map<String, String> topPrices = new HashMap<>();
                topPrices.put("price", "desc");
                System.out.println(comparator.top5Items("price", store, topPrices));
            }
        }
    }
}
