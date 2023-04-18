package ch08.sec14.exam03;

public class OracleDao implements DataAccessObject {

    @Override
    public void select() {
        // TODO Auto-generated method stub
        System.out.println("Oracle에서 DB검색");
    }

    @Override
    public void insert() {
        // TODO Auto-generated method stub
        System.out.println("Oracle에서 DB삽입");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        System.out.println("Oracle에서 DB수정");
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        System.out.println("Oracle에서 DB삭제");
    }
    
}
