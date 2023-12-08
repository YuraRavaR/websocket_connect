package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import websocket.SocketContext;
import websocket.WebClient;

public class exampleTest {
    @Test
    public void sendMessageAndVerify() {
        SocketContext context = new SocketContext();
//        String url = "wss://free.blr2.piesocket.com/v3/1?api_key=TKuLcaxJt7IeqA4Qkzxt2J3WbKC8Gg93Ng9VOg1Q&notify_self=1";
        String url = "";
        String expectedMessage = "Hello websocket";

        context.setURI(url);
        context.setBody(expectedMessage);
        context.setExpectedMessage(expectedMessage);
        context.setTimeOut(5);
        WebClient.getInstance().connectToSocket(context);
        Assert.assertNotEquals(context.getStatusCode(), 1006, "Expected message not received");
    }
}
