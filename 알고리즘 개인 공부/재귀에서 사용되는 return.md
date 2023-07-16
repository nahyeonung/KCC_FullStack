# 재귀에서 사용되는 return



## return

- 함수를 실행했던 위치로 돌아가라
- 함수를 여기서 끝내라

### <span style="color:red"> 즉, 재귀함수에서 return은 함수를 종료시킬 때 사용한다.</span>

**ex) return을 사용하지 않았을 때**

```java
public static void main(String[] args){
	test(5);
}
static void test(int num){
	if(num == 0){
		System.out.println("END");
	}
	num--;
	test(num);
}
```

<span style="color:red">돌아가라/끝내라는 신호(return)가 없기 때문에 1000번 재귀호출 이후 에러가 발생</span>

**ex) return을 사용했을 때**

```java
public static void main(String[] args){
	test(5);
}
static void test(int num){
	if(num == 0){
		System.out.println("END");
		return;
	}
	num--;
	test(num);
}
```

<span style="color:red">돌아가라/끝내라는 신호(return)에서 재귀호출이 종료됨</span>

## <span style="color:orange">결론: 호출을 멈추고 싶은 곳에 return을 입력하자!!</span>