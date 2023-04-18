package testPage;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().toLowerCase();
		int max = -1;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0; i<str.length(); i++){
			int cnt = 0;
			for(String data : map.keySet()){
				if(data.equals(String.valueOf(str.charAt(i)))){
					cnt++;
					int num = map.get(data);
					map.put(data, num+1);
				}
			}
			if(cnt == 0){
				map.put(String.valueOf(str.charAt(i)), 1);
			}
		}
		int sum = 0;
		for(String data : map.keySet()){
			if(max == map.get(data)){
				sum = 1;
			}
			else if(map.get(data) > max){
				max = map.get(data);
				sum = 0;
			}
		}
		if(sum == 0){
			for(String data : map.keySet()){
				if(map.get(data).equals(max)){
					System.out.println(data);
					break;
				}
			}
		}else{
			System.out.println("?");
		}
		scan.close();
	}
}
