package commands;

import sorting.Comparator;
import store.Store;
import java.util.Map;

public abstract class Command {
    protected String fieldToSort;
    protected Store store;
    protected  Map<String, String> map;
    protected Comparator comparator = new Comparator();

    public Command(String fieldToSort, Store store, Map<String, String> map) {
        this.fieldToSort = fieldToSort;
        this.store = store;
        this.map = map;
    }

    public abstract void execute();
}
