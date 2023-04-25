package ch15.sec05.exam03;

import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class TreeExample {
	public static void main(String[] args) {
		TreeSet<Human> treeSet = new TreeSet<>();
		treeSet.add(new Human("홍길동", 45));
		treeSet.add(new Human("홍길서", 25));
		treeSet.add(new Human("홍길남", 31));
		for(Human p : treeSet) {
			System.out.println(p);
		}
	}
}
@AllArgsConstructor
@ToString @Setter @Getter
class Human implements Comparable<Human>{
	private String name;
	private int age;
	@Override
	public int compareTo(Human o) {
		return this.age - o.age;
	}
}
