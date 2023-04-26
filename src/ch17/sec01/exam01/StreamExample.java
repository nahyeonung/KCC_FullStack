package ch17.sec01.exam01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("World");
		list.add("Kosa");
		
		Iterator<String> listIter = list.iterator();
		while(listIter.hasNext()) {
			String data = listIter.next();
			System.out.println(data);
		}
		
		//1.5 Enhanced for loop
		for(String data : list) {
			System.out.println(data);
		}
		
		list.forEach(item -> System.out.println(item));
		
		//1.8
		Stream<String> stream = list.stream();
		stream.forEach(item -> System.out.println(item));
		
		//list의 문자열의 길이 총 합은
		int sum = 0;
		for(String data : list) {
			sum = sum + data.length();
		}
		//길이가 4보다 큰 문자열의 길이 총합
		sum=0;
		for(String data: list) {
			if(data.length()>4) {
				sum = sum + data.length();
			}
		}
		Stream<String> stream2 = list.stream();
		Stream<String> filterStream = stream2.filter(item -> item.length() > 4);
		IntStream mapStream = filterStream.mapToInt(item -> item.length());
		int result = mapStream.sum();
		System.out.println(result);
		
		int result2 = list.parallelStream().filter(item -> item.length()>4).mapToInt(item -> item.length()).sum();
		System.out.println(result2);
		
		//Stream 사용의 핵심 코드
		int result3 = list.stream().filter(item -> item.length()>4)
				.peek(item -> System.out.println(item))
				.mapToInt(item -> {return item.length();})
				.reduce(0, (a,b) -> a+b);
		System.out.println("result3: " +  result3);
	}
}
