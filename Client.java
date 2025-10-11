import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Client {
public static void main(String[] args) {

try{
}
DatagramSocket ds = new DatagramSocket(3000);
byte[] arr = new byte[30];
DatagramPacket dp = new DatagramPacket(arr, arr.length);
ds.receive(dp);
String str = new String(dp.getData()).trim();
System.out.println("IP Address: " + str);
ds.close();
catch (Exception e) {
System.out.println(e);
}
}
}