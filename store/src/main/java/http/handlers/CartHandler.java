package http.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;
import store.Store;
import java.io.OutputStream;

public class CartHandler implements HttpHandler {
    @SneakyThrows
    @Override
    public void handle(HttpExchange exchange) {
        Gson gson = new Gson();
        String response = gson.toJson(Store.getStore().getAllProducts().stream().findAny().get());
        exchange.getResponseHeaders().set("Accept", "application/json");
        exchange.getResponseHeaders().set("Content-type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
    }
}
