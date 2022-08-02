package commands;

import store.Store;
import java.util.Map;

public class SortCommand extends Command {

    public SortCommand(String fieldToSort, Store store, Map<String, String> map) {
        super(fieldToSort,store, map);
    }

    public void execute() {
        System.out.println("Store sorted by " + fieldToSort + ":");
        System.out.println(comparator.sortStore(fieldToSort, store, map));
    }
}
