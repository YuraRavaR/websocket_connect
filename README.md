# WebSocket Connection Library

This library allows easy connection to websocket servers with configuration.

## Usage

### 1. Add JitPack Repository

Add JitPack repository to your pom.xml:

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories> 
```

It is necessary because library is hosted on JitPack, service that dynamically builds and packages Git repositories
as Maven dependencies.

### 2. Add Dependency

Add dependency to your pom.xml:

```xml
<dependency>
    <groupId>com.github.YuraRavaR</groupId>
    <artifactId>websocket_connect</artifactId>
    <version>98ab85d5bf</version>
</dependency>
```

### 3. Create SocketContext

Initialize `SocketContext` object to configure your WebSocket connection.
You can create SocketContext with all necessary parameters.

- **URI:** To connect to WebSocket server

- **requestHeaders:** Custom request headers for WebSocket connection

- **body:** Body to be sent as message to WebSocket server


```java
SocketContext context=new SocketContext();
        context.setURI("wss://your.websocket.server");
        context.setRequestHeaders(Map.of("Authorization","Bearer Token"));
        context.setBody(json);
```
The `messageList` field in `SocketContext` class is list that stores all messages received during  WebSocket connection.
Example of usage: 
```java
Assert.assertTrue(context.getMessageList().contains(expectedMessage)
```
        
### 4.Use WebClient

To interact with WebSocket server, you can use `WebClient` class.

```java
WebClient webClient=new WebClient();

//Connect to WebSocket server
        webClient.connectToSocket(context);

// Send synchronous messages
        webClient.sendMessage("Hello, WebSocket!");

// Send asynchronous messages
        webClient.sendMessageAsync("Async message").join();

// Wait for incoming messages for 10 seconds
        webClient.waitForMessages(10);

// Asynchronously wait for incoming messages for 5 seconds
        webClient.waitForMessagesAsync(5);

// Close  WebSocket connection
        webClient.closeConnection();
```
### Logs
The library generates logs using log4j, which records key events such as opening  connection, receiving messages, 
and closing it.