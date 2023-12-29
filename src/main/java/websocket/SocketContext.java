package websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SocketContext class represents configuration for WebSocket connection
 */
public class SocketContext {

    /**
     * URI for the WebSocket connection
     */
    private String URI;
    /**
     * custom request headers for WebSocket connection
     */
    private Map<String, String> requestHeaders = new HashMap<>();

    /**
     * body to be sent as message to WebSocket server
     */
    private String body;

    /**
     * list to store received messages
     */
    private List<String> messageList = new ArrayList<>();

    public void setURI(String URI) {
        this.URI = URI;
    }


    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }


    public void setBody(String body) {
        this.body = body;
    }


    public String getURI() {
        return URI;
    }


    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public List<String> getMessageList() {
        return messageList;
    }


    public String getBody() {
        return body;
    }

}
