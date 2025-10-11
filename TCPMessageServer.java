import java.io.*;
import java.net.*;
public class TCPMessageServer {
public static void main(String[] args) {
try {
ServerSocket serverSocket = new ServerSocket(9876);
System.out.println("TCP server is running...");

Socket socket = serverSocket.accept();
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
String message = in.readLine();
String reversedMessage = new StringBuilder(message).reverse().toString();
System.out.println("TCP Reversed Message: " + reversedMessage);
out.println(reversedMessage);
socket.close();
serverSocket.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}

