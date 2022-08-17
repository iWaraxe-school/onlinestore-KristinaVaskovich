package sorting;

import db.DBHelper;
import products.Product;
import store.Store;
import java.util.List;
import java.util.Map;

public class Comparator {
    public List<Product> sortStore(String field, Store store, Map<String, String> map) {
//        List<Product> productList = store.getCategoryList().stream().map(Category::getProducts).
//                flatMap(Collection::stream).collect(Collectors.toList());
        DBHelper dbHelper = new DBHelper();
        List<Product> productList = dbHelper.getAllProductsFromDB();
        String value = map.get(field);
        try {
            if (value.equalsIgnoreCase("asc")) {
                if (field.equals("name")) {
                    productList.sort(java.util.Comparator.comparing(Product::getName));
                }
                if (field.equals("price")) {
                    productList.sort(java.util.Comparator.comparing(Product::getPrice));
                }
                if (field.equals("rate")) {
                    productList.sort(java.util.Comparator.comparing(Product::getRate));
                }
            }
            if (value.equalsIgnoreCase("desc")) {
                if (field.equals("name")) {
                    productList.sort(java.util.Comparator.comparing(Product::getName).reversed());
                }
                if (field.equals("price")) {
                    productList.sort(java.util.Comparator.comparing(Product::getPrice).reversed());
                }
                if (field.equals("rate")) {
                    productList.sort(java.util.Comparator.comparing(Product::getRate).reversed());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Type current type of sorting");
        }
        return productList;
    }

    public List<Product> top5Items(String field, Store store, Map<String, String> map) {
        return sortStore(field, store, map).subList(0, 5);
    }
}
