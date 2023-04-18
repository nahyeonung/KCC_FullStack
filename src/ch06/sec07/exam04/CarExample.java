package ch06.sec07.exam04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CarExample {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Car car1 = new Car();
		bw.write("car1.company: " + car1.company + "\n\n");
		bw.flush();
		
		Car car2 = new Car("자가용");
		bw.write("car2.company : " + car2.company + "\n");
		bw.write("car2.model : " + car2.model + "\n\n");
		bw.flush();
		
		Car car3 = new Car("자가용", "빨강");
		bw.write("car3.company : " + car3.company + "\n");
		bw.write("car3.model : " + car3.model + "\n");
		bw.write("car3.color : " + car3.color + "\n\n");
		bw.flush();
		
		Car car4 = new Car("택시" , "검정", 200);
		bw.write("car4.company : " + car4.company + "\n");
		bw.write("car4.model : " + car4.model + "\n");
		bw.write("car4.color : " + car4.color + "\n");
		bw.write("car4.maxSpeed : " + car4.maxSpeed + "\n");
		
		bw.close();
	}
}
