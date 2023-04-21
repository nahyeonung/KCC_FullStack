package ch12.sec11;

import lombok.Data;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionExample {
	public static void main(String[] args) {
		Class clazz = Car.class;
		System.out.println(clazz);
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor con : cons) {
			System.out.println(con.getName());
		}
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method.getName());
		}
	}
}

@Data
class Car{
	private String model;
	private String owner;
}
