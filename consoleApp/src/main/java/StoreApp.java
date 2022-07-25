import sorting.XMLParser;

import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        store.fillStore(3);
        //System.out.println(store);

        System.out.println("Enter command ( sort top quit ): ");
        Scanner sc = new Scanner(System.in);
        XMLParser xmlParser = new XMLParser();
        Map<String, String> map = xmlParser.getMap();
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }
            if (command.equalsIgnoreCase("sort")) {
                System.out.print("Choose field to sort (");
                map.keySet().forEach((key) -> {
                    System.out.print(" " + key);
                });
                System.out.print(" ):");
            }
        }

    }
}
