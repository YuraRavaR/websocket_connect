package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import websocket.SocketContext;
import websocket.WebClient;

public class WebSocketTest {
    @Test
    public void pieSocketSendMessageTest() {
        WebClient webClient = new WebClient();
        SocketContext context = new SocketContext();
        String url = "wss://free.blr2.piesocket.com/v3/1?api_key=NeVYZt17YZzJ7DIExTYUyze2UuqhaMu5ZWL14Lvz&notify_self=1";
        String expectedMessage = "Hello from test pieSocketTest";
        context.setURI(url);
        webClient.connectToSocket(context);
        webClient.sendMessage(expectedMessage);
        webClient.sendMessage("expectedMessage2");
        webClient.sendMessage("expectedMessage3");
        webClient.closeConnection();
        Assert.assertTrue(context.getMessageList().contains(expectedMessage), "ExpectedMessage: "
                + expectedMessage + " not received");
    }


    @Test
    public void pieSocketSendMessageAsyncTest() {
        WebClient webClient = new WebClient();
        SocketContext context = new SocketContext();
        String url = "wss://free.blr2.piesocket.com/v3/1?api_key=NeVYZt17YZzJ7DIExTYUyze2UuqhaMu5ZWL14Lvz&notify_self=1";
        String expectedMessage = "Hello from test pieSocketTestAsync";
        context.setURI(url);
        webClient.connectToSocket(context);
        webClient.sendMessageAsync("expectedMessage1")
                .thenCompose(ignore -> webClient.sendMessageAsync("expectedMessage2"))
                .thenCompose(ignore -> webClient.sendMessageAsync("expectedMessage3"))
                .thenCompose(ignore -> webClient.sendMessageAsync(expectedMessage))
                .join();
        webClient.closeConnection();
        Assert.assertTrue(context.getMessageList().contains(expectedMessage), "ExpectedMessage: "
                + expectedMessage + " not received");
    }

    @Test
    public void pieSocketReceiveMessageTest() {
        WebClient webClient = new WebClient();
        SocketContext context = new SocketContext();
        String url = "wss://free.blr2.piesocket.com/v3/1?api_key=NeVYZt17YZzJ7DIExTYUyze2UuqhaMu5ZWL14Lvz&notify_self=1";
        String expectedMessage = "Hello from test pieSocketReceiveMessageTest";
        context.setURI(url);
        webClient.connectToSocket(context);
        webClient.waitForMessages(15);
        webClient.closeConnection();
        Assert.assertTrue(context.getMessageList().contains(expectedMessage), "ExpectedMessage: "
                + expectedMessage + " not received");
    }

    @Test
    public void pieSocketReceiveMessageAsyncTest() {
        WebClient webClient = new WebClient();
        SocketContext context = new SocketContext();
        String url = "wss://free.blr2.piesocket.com/v3/1?api_key=NeVYZt17YZzJ7DIExTYUyze2UuqhaMu5ZWL14Lvz&notify_self=1";
        String expectedMessage = "Hello from test pieSocketReceiveMessageAsyncTest";
        context.setURI(url);
        webClient.connectToSocket(context);
        webClient.waitForMessages(15);
        webClient.closeConnection();
        Assert.assertTrue(context.getMessageList().contains(expectedMessage), "ExpectedMessage: "
                + expectedMessage + " not received");
    }
}
