import java.io.*;
import java.net.*;
import java.util.Scanner;
public class WebPage{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter a website name:");
String host = sc.nextLine();
int port = 80; 
String path = "/"; 
try {
Socket socket = new Socket(host, port);

PrintWriter out = new PrintWriter(socket.getOutputStream());
out.println("GET " + path + " HTTP/1.1");
out.println("Host: " + host);
out.println("Connection: close");
out.println(); 
out.flush();

BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String line;
boolean foundDoctype = false;
StringBuilder content = new StringBuilder();
while ((line = in.readLine()) != null){
if (line.contains("<!doctype html>")){
foundDoctype = true;
}
if (foundDoctype) {
content.append(line);
}
}
in.close();
out.close();
socket.close();

BufferedWriter writer = new BufferedWriter(new FileWriter("DownloadedPage.html"));
writer.write(content.toString());
writer.close();
System.out.println("Web page content downloaded and saved as DownloadedPage.html");
} catch (IOException e) {
e.printStackTrace();
}
}
}