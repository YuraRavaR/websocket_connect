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

    private Date openedTime;


    public Client(SocketContext context) throws URISyntaxException {
        super(new URI(context.getURI()));
        this.context = context;
    }

    public int getAliveTime() {
        Date closeDate = new Date();
        int timeInSeconds = (int) (closeDate.getTime() - openedTime.getTime()) / 1000;
        context.setTimeTaken(timeInSeconds);
        return timeInSeconds;
    }


    @Override
    public void onOpen(ServerHandshake handshakedata) {
        openedTime = new Date();
        logger.info("Opened Connection {}", context.getURI());
    }


    @Override
    public void onMessage(String message) {
        logger.info("Received new message {}", message);
        context.getMessageList().add(message);
        String expectedMessage = context.getExpectedMessage();
        if (expectedMessage != null && expectedMessage.equals(message)) {
            closeConnection(1000, "Received expected message");
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        logger.info("Close socket with code {}, reason is {}", code, reason);
        context.setStatusCode(code);
    }

    @Override
    public void onError(Exception ex) {
        logger.error("WebSocket connection error", ex);
    }

}
