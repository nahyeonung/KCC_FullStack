# Arrays.sort()의 매개변수 comparator 활용법

- Arrays.sort()를 사용하면 1차원 배열의 숫자 or 문자를 오름차순 정렬으로 자동 정렬 해준다. ->
- 참고로 기본 정렬 조건이 오름차순인 이유는 Class 내에 기본적으로 구현되어 있는 Comparable Interface의 compareTo 메서드를 기준으로 하기 때문이다.
- 하지만 comparator를 활용하지 않으면 2차원 배열 정렬이나 내가 원하는 방식의 정렬을 할 수 없다.
- comparator는 람다식의 익명 객체로 생성할 수 있다.
- compareTo()를 활용해서 오름차순 or 내림차순 정렬을 지정할 수 있다.

```java
기준값.compareTo(비교값)
기준값과 비교값을 바꾸면 오름차순이 내림차순으로 바뀜.

//내림차순 예제
public class Main{
    public static void main(String[] args) throws IOException {
        String[] arr = {"a", "b", "d", "c", "z", "f"};
        Arrays.sort(arr, (o1, o2) -> {
            return o2.compareTo(o1);
        });
        System.out.println(Arrays.deepToString(arr));
	}
}
//[z, f, d, c, b, a] 출력됨
```

- 숫자도 compareTo를 사용할 수 있지만 위의 형태로 사용할 수 없다. ⇒ 원인: **primitive type은 클래스가 아니라 메소드를 호출할 수 없기 때문**
- 즉, int는 Integer로 바꿔줘야 한다.

```java
Integer[] arr3 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//정수 내림차순 정렬
public class Main{
    public static void main(String[] args) throws IOException {
         int[] arr = {1,3,2,5,4,7};
         Integer[] arr3 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
         Arrays.sort(arr3, (o1, o2) -> {
             return o2.compareTo(o1);
						//return o1 - o2; 가능
         });
         System.out.println(Arrays.toString(arr3));
	}
}
//[7, 5, 4, 3, 2, 1]
```

- int 타입 2차원 배열은 Integer.compare를 사용해서 정렬해주면 된다.

```java
//배열의 첫 번째 값을 비교해서 오름차순 정렬, 첫 번째 값이 같으면 두 번째 값으로 내림차순 정렬
public class Main {
    public static void main(String[] args) throws IOException {
         int[][] arr = {{1,2},{1,3},{2,1},{2,2},{5,5}};
         Arrays.sort(arr,(o1, o2) -> {
                if(o1[0] == o2[0]){
                    return Integer.compare(o2[1], o1[1]);
                }else{
                    return Integer.compare(o1[0], o2[0]);
                }
         });
         System.out.println(Arrays.deepToString(arr));
	}
}
//[[1, 3], [1, 2], [2, 2], [2, 1], [5, 5]]
```

- **String과 Int를 모두 사용한 정렬 예제**

```java
//문자열 길이로 오름차순 비교, 길이가 같다면 스펠링 오름차순 정렬 
Arrays.sort(arr, (o1, o2) -> {
		 	if(o1.length() == o2.length()) {
		 		return o1.compareTo(o2);
		 	}else {
		 		// return o1.length() - o2.length(); 가능
                 return Integer.compare(o1.length(),o2.length());		
        // return o1.length().compareTo(o2.length());	가능	 
		 	}
		});
```