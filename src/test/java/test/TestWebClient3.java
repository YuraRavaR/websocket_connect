package test;

import org.testng.annotations.Test;
import websocket.SocketContext;
import websocket.WebClient;

public class TestWebClient3 {
    @Test
    public void testE() {
        WebClient webClient = WebClient.getInstance();
        SocketContext context = new SocketContext();
        String url = "wss://free.blr2.piesocket.com/v3/1?api_key=TKuLcaxJt7IeqA4Qkzxt2J3WbKC8Gg93Ng9VOg1Q&notify_self=1";
        String expectedMessage = "Hello from test 3";
        context.setExpectedMessage(expectedMessage);
        context.setURI(url);
        webClient.connectToSocket(context);
        webClient.waitForMessages(10);
//        webClient.sendMessageAsync("expectedMessage")
//                .thenCompose(ignore -> webClient.sendMessageAsync("expectedMessage2"))
//                .thenCompose(ignore -> webClient.sendMessageAsync("expectedMessage"))
//                .join();
        webClient.sendMessage("expectedMessage");
        webClient.sendMessage("expectedMessage2");
        webClient.sendMessage("expectedMessage3");
        context.getMessageList().forEach(message -> {
            System.out.println("Received message: " + message);
        });
        webClient.closeConnection();
        webClient.sendMessage("ex");
    }
}
