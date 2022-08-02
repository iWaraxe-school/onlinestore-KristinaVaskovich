package commands;

import store.Store;
import java.util.Map;

public class TopCommand extends Command {

    public TopCommand(String fieldToSort, Store store, Map<String, String> map) {
        super(fieldToSort,store, map);
    }

    public void execute() {
        System.out.println("Top 5 " + fieldToSort + "s in the store:");
        System.out.println(comparator.top5Items(fieldToSort, store, map));
    }
}
