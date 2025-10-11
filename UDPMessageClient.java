import java.net.*;
import java.io.*;
public class UDPMessageClient {
public static void main(String[] args) {
DatagramSocket clientSocket = null;
try {
clientSocket = new DatagramSocket();
InetAddress serverAddress = InetAddress.getByName("localhost");
BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
byte[] sendData;
byte[] receiveData = new byte[1024];
System.out.print("Enter a message for UDP (type 'exit' to quit): ");
String message;
while (!(message = userInput.readLine()).equalsIgnoreCase("exit")) {
sendData = message.getBytes();
// Create and send the packet
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9877);
clientSocket.send(sendPacket);
// Receive the response
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
clientSocket.receive(receivePacket);
String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());

System.out.println("From server: " + serverResponse);
System.out.print("Enter a message for UDP (type 'exit' to quit): ");
}
} catch (Exception e) {
e.printStackTrace();
} finally {
if (clientSocket != null && !clientSocket.isClosed()) {
clientSocket.close();
}
}
}
}
