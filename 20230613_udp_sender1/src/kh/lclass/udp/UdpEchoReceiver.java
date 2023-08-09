package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpEchoReceiver {

	public static void main(String[] args) {
		new UdpEchoReceiver().receiverUdp();

	}
	public void receiverUdp() {
		int port=5001;
		DatagramSocket ds=null;
		DatagramPacket dp=null;
		InetAddress ia= null;
		String recieveSt=null;
		byte[] receiverByte=new byte[1000];
		try {
			ds= new DatagramSocket(5001);
			dp=new DatagramPacket(receiverByte,receiverByte.length);
			while(true) {
			ds.receive(dp);
			recieveSt=new String(dp.getData());
			System.out.println(recieveSt);
			if(recieveSt.equals("exit"))
				break;
			System.out.println(dp.getPort());
			System.out.println(dp.getLength());
			System.out.println(dp.getAddress());
			}
		}
		catch(SocketException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ds!=null)
					ds.close();
				if(dp!=null)
					ds.close();
				if(ia!=null)
					ds.close();
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

}
