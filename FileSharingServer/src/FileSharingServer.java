import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class FileSharingServer {
    private static String DIRECTORY= "C://Users//veesh"; // Change to your folder path
    private static final int PORT = 8000; // Use any available port

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/", new FileHandler(DIRECTORY));
        server.setExecutor(null);
        server.start();
        
        System.out.println("File server running at:");
        System.out.println("http://localhost:" + PORT);
        System.out.println("Access it from phone: http://YOUR_PC_IP:" + PORT);
    }
}

class FileHandler implements HttpHandler {
    private final File directory;

    public FileHandler(String directoryPath) {
        this.directory = new File(directoryPath);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String uriPath = exchange.getRequestURI().getPath();
        File file = new File(directory, uriPath);

        if (file.isDirectory()) {
            sendFileList(exchange);
        } else if (file.exists() && file.getCanonicalPath().startsWith(directory.getCanonicalPath())) {
            sendFile(exchange, file);
        } else {
            send404(exchange);
        }
    }

    private void sendFileList(HttpExchange exchange) throws IOException {
        StringBuilder response = new StringBuilder("<html><body><h2>File Server</h2><ul>");
        for (File file : directory.listFiles()) {
            response.append("<li><a href=\"")
                    .append(file.getName())
                    .append("\">")
                    .append(file.getName())
                    .append("</a></li>");
        }
        response.append("</ul></body></html>");

        byte[] responseBytes = response.toString().getBytes();
        exchange.sendResponseHeaders(200, responseBytes.length);
        exchange.getResponseBody().write(responseBytes);
        exchange.getResponseBody().close();
    }

    private void sendFile(HttpExchange exchange, File file) throws IOException {
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        exchange.sendResponseHeaders(200, fileBytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(fileBytes);
        os.close();
    }

    private void send404(HttpExchange exchange) throws IOException {
        String response = "z04 Not Found";
        exchange.sendResponseHeaders(404, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.getResponseBody().close();
    }
}
