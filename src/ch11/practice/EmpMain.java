package ch11.practice;


public class EmpMain {
	public static void main(String[] args) {
		EmpVO aa = new EmpVO();
		IEmpService empService = new EmpService();
		try {
			empService.insert(null);	
		} catch(RuntimeException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
//		empService.insert(null);
		System.out.println("메인 종료");
	}
}
