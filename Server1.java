import java.util.*;
import java.net.*;
import java.io.*;
public class Server1 {
public static void main(String[] args) {
try
{
ServerSocketss=new ServerSocket(3333);
Socket s=ss.accept();
String str,str2;
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
Scanner m=new Scanner(System.in);
System.out.println("Connection established");
System.out.println("enter any data(enter stop to terminate)");
do
{
str2=din.readUTF();
System.out.println("Data from client:"+str2);
str=m.next();
dout.writeUTF(str);
}while((str2.equals("stop"))==false);
din.close();
dout.close();
s.close();
ss.close();
System.out.println("Connection closed.");
}

catch(Exception e)
{
System.out.println(e);
}
}
}

