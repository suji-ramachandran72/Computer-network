import java.net.*;
public class UDPMessageServer {
public static void main(String[] args) {
DatagramSocket serverSocket = null;
try {
serverSocket = new DatagramSocket(9877);
byte[] receiveData = new byte[1024];

byte[] sendData;
System.out.println("UDP server isrunning...");
while (true) {
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
serverSocket.receive(receivePacket);
String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
// Simulate random packet loss
if (Math.random() > 0.9) {
System.out.println("UDP packet lost: " + message);
continue; // Skip to the next iteration
}
// Reverse the message
String reversedMessage = new StringBuilder(message).reverse().toString();
sendData = ("UDP Reversed Message: " + reversedMessage).getBytes();
// Get the client's address and port
InetAddress clientAddress = receivePacket.getAddress();
int clientPort = receivePacket.getPort();
// Create and send the response packet
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress,
clientPort);
serverSocket.send(sendPacket);
System.out.println("Processed message from client: " + message);
}
} catch (Exception e) {
e.printStackTrace();
} finally {
if (serverSocket != null && !serverSocket.isClosed()) {
serverSocket.close();
}

}
}
}
