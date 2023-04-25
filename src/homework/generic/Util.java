package homework.generic;

public class Util {
	public static <P extends Pair<K, V>, K, V> V getValue(P p, K k) {
	 if(p.getKey() == k) {
	 return p.getValue();
	 } else {
	 return null;
	 }
	}
}
