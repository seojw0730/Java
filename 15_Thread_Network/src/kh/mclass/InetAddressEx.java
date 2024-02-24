package kh.mclass;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressEx {
	public void method1(String domain) {
		System.out.println(domain + "===에 대한 정보들입니다.");
		try {
			InetAddress ia = InetAddress.getByName(domain);
			System.out.println(ia);
			boolean result = ia.isMulticastAddress();
			System.out.println(result);
			System.out.println("==============");
			System.out.println("HostName: " + ia.getHostName());
			System.out.println("HostAddress: " + ia.getHostAddress());
			System.out.println("HostName/HostAddress: \n\t" + ia.toString());
//			System.out.println("Address: " + ia.getAddress());
//			System.out.println(ia.getAllByName(domain));
			byte[] ipAddr = ia.getAddress();
			for (byte item : ipAddr) {
				if (item < 0) {
					System.out.println(item + 256);
				} else {
					System.out.println(item);
				}
			}
			System.out.println("getAddress(): " + Arrays.toString(ipAddr));
			System.out.print("HostAddress: ");
			for (int i = 0; i < ipAddr.length; i++) {
				if (ipAddr[i] < 0) {
					System.out.print(ipAddr[i] + 256);
				} else {
					System.out.print(ipAddr[i]);
				}
				System.out.print(".");
			}
			System.out.println();
//			System.out.println(ia.getByName(domain));
			System.out.println(ia.getCanonicalHostName());
//			System.out.println("HostAddress: " + ia.getHostAddress());
//			System.out.println("HostName: " + ia.getHostName());
			ia = InetAddress.getLocalHost();
			System.out.println("LocalHostName: " + ia.getHostName());
			System.out.println("LocalHostAddress: " + ia.getHostAddress());
			System.out.println("Local HostName/HostAddress: \n\t" + ia.toString());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
//		223.130.195.95
		byte[] num = new byte[4];
		num[0] = 223-256;
		num[1] = 130-256;
		num[2] = 195-256;
		num[3] = 95;
		try {
			System.out.println(InetAddress.getByAddress(num));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
