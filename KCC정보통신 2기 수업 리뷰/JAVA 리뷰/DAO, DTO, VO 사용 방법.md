# DAO, DTO, VO 사용 방법

## DAO(Decentralized Autonomous Organization)

- DAO는 DB를 사용하여 데이터의 조회 및 조작하는 기능을 전담하는 오브젝트이다. 데이터를 저장할 object인 VO와 DTO별로 기능을 하는 함수들의 집합이라고 생각한다. 하지만 DTO를 사용할 일이 월등히 많을 것이기 때문에 대체로 DTO별로 짜여질 것 같다.(정해진 건 없다고 생각한다.)

## DTO(**Data Transfer Object)**

- 객체 간 데이터를 전달하는 용도로 데이터를 담는 object라고 생각한다. 그래서 DB에 있는 몇 가지 데이터만 추출해서 담을 경우, DTO를 사용하면 된다.

## VO(***\*Value Object)\****

- 데이터베이스의 테이블별로 만들어진 object라고 생각하면 편하다. 그래서 민감한 정보들이 담길 수 있기 때문에 가급적 건드리지 않는 것이 좋다.