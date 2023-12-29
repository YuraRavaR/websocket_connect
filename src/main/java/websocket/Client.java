package websocket;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

public class Client extends WebSocketClient {
    private static final Logger logger = LogManager.getLogger(Client.class);

    private final SocketContext context;


    public Client(SocketContext context) throws URISyntaxException {
        super(new URI(context.getURI()));
        this.context = context;
    }

    @Override
    public void onOpen(ServerHandshake handShakeData) {
        logger.info("Opened Connection {}", context.getURI());
    }

    @Override
    public void onMessage(String message) {
        logger.info("Received new message {}", message);
        context.getMessageList().add(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        logger.info("Close socket with code {}, reason is {}", code, reason);
    }

    @Override
    public void onError(Exception ex) {
        logger.error("WebSocket connection error", ex);
    }

}
