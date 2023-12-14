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

- **expectedMessage:** Expected message to verify if received

- **requestHeaders:** Custom request headers for WebSocket connection

- **messageList:** List to store received messages

- **statusCode:** Status code of  WebSocket connection

- **timeOut:** Timeout for WebSocket connection

- **timeTaken:** Time taken for  connection to remain alive

- **body:** Body to be sent as message to WebSocket server

- **runnable:** Runnable task to be executed during WebSocket connection

```java
SocketContext context=new SocketContext();
        context.setURI("wss://your.websocket.server");
        context.setExpectedMessage("Hello, WebSocket!");
        context.setRequestHeaders(Map.of("Authorization","Bearer YourToken"));
        context.setTimeOut(10);
```

### 4. Connect and Send Message

Use  `WebClient`  to connect to WebSocket server and send messages.

```java
WebClient.getInstance().connectToSocket(context);
```
