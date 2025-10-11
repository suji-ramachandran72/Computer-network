import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class Server {
static String[] hosts = {
"zoho.com", "gmail.com", "netflix.com", "google.com", "facebook.com",
"amazon.com", "leetcode.com", "geeksforgeeks.com", "youtube.com",
"hope3.org", "stackoverflow.com", "hackerrank.com", "codeforces.com",
"codechef.com"
};
static String[] ipAddresses = {
"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5",
"192.168.1.6", "192.168.1.7", "192.168.1.8", "192.168.1.9", "192.168.1.10",
"192.168.1.11", "192.168.1.12", "192.168.1.13", "192.168.1.14",
"192.168.1.15"
};
public static int search(String key) {
for (int i = 0; i < hosts.length; i++) {
if (key.equals(hosts[i])) {
return i;
}
} return -1;
}

public static void main(String[] args) {
try{
DatagramSocket ds = new DatagramSocket();
Scanner sc = new Scanner(System.in);
System.out.print("Enter host name: ");
String str = sc.nextLine();
int strIndex = search(str);
InetAddress ip = InetAddress.getLocalHost();
String message = strIndex != -1 ? ipAddresses[strIndex]
:"Host_name_not_found";
DatagramPacket dp = new
DatagramPacket(message.getBytes(), message.length(), ip, 3000);
ds.send(dp);
ds.close();
}
catch (Exception e) {
System.out.println(e);
}
}
}


