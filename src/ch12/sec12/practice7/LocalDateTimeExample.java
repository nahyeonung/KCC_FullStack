package ch12.sec12.practice7;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExample {
	public static void main(String[] args) {
		LocalDateTime startDate = LocalDateTime.now();
		LocalDateTime endDate = LocalDateTime.of(2023, 12, 31, 0, 0, 0);
		System.out.println(startDate.until(endDate, ChronoUnit.DAYS) + "일 남았습니다.");
		
	}
}
