# 탐욕 알고리즘(Greedy) 1

- 탐욕 알고리즘은 각 단계에서 Local Minimum를 선택함으로써 전체 문제를 풀 수 있다는 개념이다. 단, 모든 경우에서 통하진 않는다.

**예를 들어,**

![greedy.png](https://github.com/nahyeonung/KCC_FullStack/blob/main/images/greedy.png)

위의 그래프에서 최소 값을 탐욕 알고리즘으로 찾으면 global minimum을 찾지 못하고 local minimum을 찾게 될 수 있다. 그래서 탐욕 알고리즘은 다음과 같은 그래프를 가질 때 사용할 수 있다.

![greedy2.png](https://github.com/nahyeonung/KCC_FullStack/blob/main/images/greedy2.png)

**동전 교환으로 위에 나오는 두 가지 그래프 경우의 수를 살펴보자.**

1. local minimum = global minimum인 경우

710원을 [10, 100, 500] 동전들을 사용해 최소의 반환 개수를 탐욕법으로 찾아내보면 500 ⇒ 1개, 100 ⇒ 2개, 10 ⇒ 1개를 찾아낼 수 있다. 이 경우 운이 좋게 local minimum이 global minimum과 같은 경우다.

1. local minimum ≠ global minimum인 경우

70원 [10, 30, 40, 50] 동전들로 탐욕법을 사용하면 50 ⇒ 1개, 10 ⇒ 2개가 나온다. 하지만 최소의 경우는 30 ⇒ 1개 , 40 ⇒ 1개이다. 이 경우 local minimum과 global minimum이 다른 경우다. 이때는 다이나믹 프로그래밍을 사용해야 한다.

### 결론적으로, 동전 교환에서 최소 개수를 찾아내려면(optimizing) greedy 말고 dp를 사용해야 함!

### 탐욕법을 사용하는 알고리즘 문제

![greedyAlg.png](https://github.com/nahyeonung/KCC_FullStack/blob/main/images/greedyAlg.png)

**상자(unit)에 물건의 개수(count) 만큼 담겨 있을 때, 트럭에 최대 4개의 상자를 실을 경우 최대 물건의 개수 구하라.**

⇒ 이 문제의 경우, 최대 개수를 구하는 문제이기 때문에 최적화 문제로 생각하여 다이나믹 프로그래밍을 사용할 수 있지만 사실 탐욕법을 사용하면 더욱 쉽게 구할 수 있다.

1. count를 기준으로 정렬하기
2. 정렬한 데이터를 가지고 순서대로 상자 4개를 담으면 총 12개의 물건을 담을 수 있다.