package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPoolExample {
	
	private static BasicDataSource dataSource;
	static {
		//db를 연결하려면 1.드라이버 클래스 네임 2.Url 3.username 4.userpw 필요
		dataSource = new BasicDataSource();
		//BasicDataSource는 set메서드로 필요한 값을 세팅함
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		//아래 두 코드는 생략 가능
		dataSource.setInitialSize(10); //커넥션 풀에서 초기에 생성할 커넥션의 수를 설정하는 역할
		dataSource.setMaxTotal(20); //최대 20개까지 늘릴 수 있음
	}
	
	public static void main(String[] args) {
		System.out.println(getEmpCount());
		
	}
	public static int getEmpCount() {
		String sql = "select count(*) from employees";
		Connection con = null;
		int rowCount = 0;
		try {
//			con = DriverManager.getConnection(url)
			con = dataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			rowCount = rs.getInt(1);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(con != null) {
				try{con.close();}catch(Exception e) {}				
			}
		}
		return rowCount;
	}
}
