package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpEchoSender {

	
	public static void main(String[] args) {
	
		new UdpEchoSender().SenderUdp();
	}

	public void SenderUdp() {
		int myport=6001;
		int destport=5001;
		String destName="localhost";
		DatagramSocket ds=null;
		DatagramPacket dp=null;
		InetAddress ia=null;
		Scanner sc= new Scanner(System.in);
		String sender=null;
		byte[] senderByte=null;
		try {
			ds= new DatagramSocket(6001);
			ia=InetAddress.getByName(destName);
			while(true) {
				sender=sc.nextLine();
				senderByte=sender.getBytes();
				dp=new DatagramPacket(senderByte,senderByte.length,ia,5001);
				ds.send(dp);
				if(sender.equals("exit"))
					break;
			}
		}
		catch(SocketException e) {
			e.printStackTrace();
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
