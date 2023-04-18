package ch05.sec10;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class CmdLineExample {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(args));
//		String data = JOptionPane.showInputDialog("입력하세요"); 얘는 문자열로만 받아줌 배열X
	
	}
}
