package http;
import com.sun.net.httpserver.HttpServer;
import http.handlers.CartHandler;
import http.handlers.CategoryHandler;
import http.handlers.AllProductsHandler;
import lombok.SneakyThrows;
import java.net.*;

public class HTTPService {
    protected static HTTPService httpService = null;
    private HTTPService() {
    }

    public static HTTPService getHTTPService() {
        if (httpService == null) {
            httpService = new HTTPService();
            System.out.println("Service created...");
        }
        return httpService;
    }

    @SneakyThrows
    public void startHttpServer() {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/categories", new CategoryHandler());
        server.createContext("/products", new AllProductsHandler());
        server.createContext("/cart", new CartHandler());
        server.setExecutor(null);
        server.start();
    }
}
