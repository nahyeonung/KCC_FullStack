package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver"); //local에 db를 사용할 땐 안 써도 됨
			
			//연결하기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","hr");
			System.out.println("연결성공");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					//연결 끊기
					conn.close();
					System.out.println("연결 끊기");
				} catch(SQLException e) {}
			}
		}
	}
}
