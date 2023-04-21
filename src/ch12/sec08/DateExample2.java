package ch12.sec08;

import java.text.*;
import java.util.*;

public class DateExample2 {
	public static void main(String[] args) {
		Date now = new Date();
		String StrNow1 = now.toString();
		System.out.println(StrNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd HH:mm:ss");
		String StrNow2 = sdf.format(now);
		System.out.println(StrNow2);
	}
}
