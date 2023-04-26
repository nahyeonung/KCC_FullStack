package ch17.sec04.exam01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@AllArgsConstructor
public class Product {
	private int pno;
	private String name;
	private String company;
	private int price;
}
