package http;

import categories.Category;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import products.Product;
import store.Store;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class HTTPClient {
    private HttpClient client = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    @SneakyThrows
    public List<Product> getAllProducts() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("http://localhost:8080/products"))
                .header("Authorization", getBasicAuthenticationHeader("user", "password"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Arrays.asList(gson.fromJson(response.body(), Product[].class));
    }

    @SneakyThrows
    public List<Category> getСategories() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("http://localhost:8080/categories"))
                .header("Authorization", getBasicAuthenticationHeader("user", "password"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Arrays.asList(gson.fromJson(response.body(), Category[].class));
    }

    @SneakyThrows
    public void addToCart() {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(Store.getStore().getAllProducts().stream().findAny().toString()))
                .uri(new URI("http://localhost:8080/cart"))
                .header("Authorization", getBasicAuthenticationHeader("user", "password"))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
