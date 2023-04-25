package homework.generic;

public class Util {
	public static <K, V, P extends Pair<K, V>> V getValue(P p, K k) {
	 if(p.getKey() == k) {
	 return p.getValue();
	 } else {
	 return null;
	 }
	}
}
