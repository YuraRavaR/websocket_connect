package websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class WebClient {


    private Client client;

    private static final Logger logger = LogManager.getLogger(WebClient.class);


    public void connectToSocket(SocketContext context) {
        try {
            client = new Client(context);
            if (!context.getRequestHeaders().isEmpty()) {
                final Map<String, String> requestHeaderParams = context.getRequestHeaders();
                requestHeaderParams.forEach((key, value) -> {
                    client.addHeader(key, value);
                });
            }
            client.connectBlocking();
            if (context.getBody() != null) {
                client.send(context.getBody());
            }
        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        if (client != null && client.isOpen()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            client.send(message);
        } else {
            logger.error("WebSocket connection is not open. Cannot send message: " + message);
            throw new RuntimeException("WebSocket connection is not open. Cannot send message: " + message);
        }
    }

    public CompletableFuture<Void> sendMessageAsync(String message) {
        CompletableFuture<Void> sendMessageFuture = new CompletableFuture<>();
        sendMessage(message);
        CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
            sendMessageFuture.complete(null);
        });
        return sendMessageFuture;
    }

    public void waitForMessages(int seconds) {
        int timeout = seconds;
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeout * 1000) {
        }
    }

    public void waitForMessagesAsync(int seconds) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        CompletableFuture.delayedExecutor(seconds, TimeUnit.SECONDS)
                .execute(() -> future.complete(null));
        future.join();
    }


    public void closeConnection() {
        if (client != null && client.isOpen()) {
            client.close(1000);
            client = null;
            logger.info("WebSocket connection is closed");
        } else {
            logger.error("WebSocket connection is not open. Cannot close connection");
            throw new IllegalStateException("WebSocket connection is not open.");
        }
    }

}
