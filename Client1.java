import java.util.*;
import java.net.*;
import java.io.*;
public class Client1 {
public static void main(String[] args) {
try
{
Socket s=new Socket("localhost",3333);
String str,str2;
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
Scanner m=new Scanner(System.in);
System.out.println("enter any data(enter stop to terminate)");
do
{
str=m.next();
dout.writeUTF(str);
str2=din.readUTF();
System.out.println("Data from server:"+str2+"\n");
}while((str.equals("stop"))==false);
din.close();
dout.close();
s.close();

}
catch(Exception e)
{
System.out.println(e);
}
}
}