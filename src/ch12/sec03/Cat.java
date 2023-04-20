package ch12.sec03;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cat {
	private String id;
	private String name;
	private int age;
}
