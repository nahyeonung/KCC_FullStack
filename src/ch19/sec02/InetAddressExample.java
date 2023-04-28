package ch19.sec02;

import java.net.InetAddress;
import java.rmi.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			//getLocalHost() => 내 컴퓨터 ip주소를 InetAddress 객체로 반환
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress());
			//getAllByName(string domain) => 입력된 도메인 ip주소를 InetAddress 객체로 반환
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				//getHostAddress() => InetAddress 객체에서 ip주소 값을 string으로 가져옴
				System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
			}
		}catch(java.net.UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
