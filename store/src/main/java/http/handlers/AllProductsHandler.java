package http.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import store.Store;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;

public class AllProductsHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Gson gson = new Gson();
        String response = gson.toJson(Store.getStore().getAllProducts().stream().collect(Collectors.toList()));
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
    }
}
