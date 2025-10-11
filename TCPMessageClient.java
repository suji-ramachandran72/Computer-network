



import java.io.*;
import java.net.*;

public class TCPMessageClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9876);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter a message for TCP: ");
            String message = userInput.readLine();
            out.println(message);

            String response = in.readLine();
            System.out.println("From TCP server: " + response);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
