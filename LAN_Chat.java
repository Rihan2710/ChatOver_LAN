importjava.net.*;
importjava.io.*;

classMyMicro
{
publicstaticvoidmain(String[]args)throwsException
{
intch;
BufferedReader br = new BufferedReader(new

InputStreamReader(System.in));

do
{
System.out.println("\t*************************");
System.out.println("\t1.Chat(serverside)");
System.out.println("\t2.Chat(clientside)");
System.out.println("\t3.PortScanner");
System.out.println("\t4.Exit");
System.out.println("\t*************************");
System.out.print("\tChoice:");
ch=Integer.parseInt(br.readLine());

switch(ch)
{
case1:
servers();
break;

9
case2:
clients();
break;
case3:
ports();
break;
case4:
System.out.println("\tThankYou....");
break;

}
}while(ch!=4);

}
publicstaticvoidservers()throwsException
{
ServerSocketss=newServerSocket(80);
Sockets=ss.accept();
Thread.sleep(100);

DataInputStreamdin=newDataInputStream(s.getInputStream());
DataOutputStream dout = new

DataOutputStream(s.getOutputStream());

BufferedReader br = new BufferedReader(new

InputStreamReader(System.in));
Stringstr="",str2="";
System.out.println("\tWaittillclientsendssomething....");
System.out.println("\tForstoppingthechatjusttypestopandhit

10

enter");

while(!str.equals("stop"))
{
str=din.readUTF();
System.out.println("\tClient:"+str);
System.out.print("\tYou:");
str2=br.readLine();
dout.writeUTF(str2);
dout.flush();
}
din.close();
s.close();
ss.close();
}
publicstaticvoidclients()throwsException
{
StringUserIp;
BufferedReader br =new BufferedReader(new

InputStreamReader(System.in));

System.out.println("\t***********************************");
System.out.print("\t\tEnterIPaddressofserver:");
UserIp=br.readLine();
System.out.println("\t***********************************");
Sockets=newSocket(UserIp,80);
DataInputStreamdin=newDataInputStream(s.getInputStream());
DataOutputStream dout = new

DataOutputStream(s.getOutputStream());
if(s.isConnected()==true)
{

11

System.out.println("\tConnected");
}
else
{
System.out.println("\tnotconnected");
}
Stringstr="",str2="";
System.out.println("\tForstoppingthechatjusttypestopandhit

enter");

while(!str.equals("stop"))
{
System.out.print("\tYou:");
str=br.readLine();
dout.writeUTF(str);
dout.flush();
str2=din.readUTF();
System.out.println("\tServer:"+str2);
}
dout.close();
s.close();
}
publicstaticvoidports()throwsException
{
Stringstr;
inta,b,j=0;
BufferedReader br = new BufferedReader(new

InputStreamReader(System.in));

System.out.println("\t\t\tURLinformatof");

12

System.out.println("\t\t\thttps://websitename");
System.out.println("\n\tEnterURL:");
str=br.readLine();

try
{
URLurl=newURL(str);
url.toURI();
System.out.println("\tEnterStartingport:");
a=Integer.parseInt(br.readLine());

System.out.println("\tEnterEndingport:");
b=Integer.parseInt(br.readLine());
System.out.println("\t\t\tOpenPortsare..");
InetAddress ip = InetAddress.getByName(new

URL(str).getHost());

for(inti=a;i<=b;i++)
{

try(Socketsocket=newSocket())
{
socket.connect(new

InetSocketAddress(ip,i),200);

System.out.println("\t"+i+"open");
j++;
}
catch(IOExceptione)
{

13
System.out.print("");
}
}
if(j==0)
System.out.println("\tNoportsareopen.....");

}
catch(MalformedURLExceptione)
{
System.out.println("Invalidurl");
}
catch(URISyntaxExceptionue)
{
System.out.println("Invalidurl");
}
}
}