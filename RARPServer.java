import java.io.*;
import java.net.*;
import java.util.*;

public class RARPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("RARP Server is running...");
            Socket socket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // MAC to IP mapping
            HashMap<String, String> rarpTable = new HashMap<>();
            rarpTable.put("00-A0-C9-14-C8-29", "192.168.1.2");
            rarpTable.put("00-A0-C9-14-C8-30", "192.168.1.3");
            rarpTable.put("00-A0-C9-14-C8-31", "192.168.1.4");

            String mac = dis.readUTF();
            System.out.println("Received MAC Address: " + mac);

            String ip = rarpTable.getOrDefault(mac, "IP Address not found");
            dos.writeUTF(ip);

            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}