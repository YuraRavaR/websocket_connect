package websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketContext {

    private String URI;

    private String expectedMessage;

    private Map<String, String> requestHeaders = new HashMap<>();

    private List<String> messageList = new ArrayList<>();

    private int statusCode;

    private int timeOut = 10;
    private int timeTaken;

    private String body;

    private Runnable runnable;

    public void setURI(String URI) {
        this.URI = URI;
    }

    public void setExpectedMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public String getURI() {
        return URI;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public String getBody() {
        return body;
    }

    public Runnable getRunnable() {
        return runnable;
    }
}
