

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PairInSet {

 public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int t = s.nextInt();
	String [] pair_left = new String[t];
	String [] pair_right = new String[t];
	
	for (int i = 0; i < t; i++) {
		pair_left[i] = s.next();
		pair_right[i] = s.next();
	}
        
	class Pair {
		private String first;
		private String second;

		public Pair(String first, String second) {
			this.first = first;
			this.second = second;
		}

		// 这里做了一个特殊的规定，就是在Pair里面，first和second的值对调之后，还是认为是和原来的Pair是同一个Pair。
		// 因此，需要同时改动两个方法，包括equals()和hashCode()方法。
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			Pair other = (Pair) obj;
			return (Objects.equals(first, other.first) && Objects.equals(second, other.second)) || (Objects.equals(first, other.second) && Objects.equals(second, other.first));
		
		}

		// 这里，我使用值较小的一个hash，作为这个Pair对象的hash。
		@Override
		public int hashCode() {

			int value0 = Objects.hash(first, second);
			int value1 = Objects.hash(second, first);

			return value0 < value1 ? value0 : value1;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"first='" + first + '\'' +
					", second='" + second + '\'' +
					'}';
		}
	}

	// Pair pair1 = new Pair("a", "b");
	// Pair pair2 = new Pair("b", "a");

	// System.err.println(pair1.equals(pair2));

	// HashSet<Pair> hashSet = new HashSet<>();
	// System.err.println(hashSet.size());
	// hashSet.add(pair1);
	// System.err.println(hashSet.size());
	// hashSet.add(pair1);
	// System.err.println(hashSet.size());
	// hashSet.add(pair2);
	// System.err.println(hashSet.size());

	// System.err.println("----------");

	// System.err.println(Objects.hash("a", "b"));
	// System.err.println(Objects.hash("b", "a"));


	HashSet<Pair> hashSet = new HashSet<>();

	for (int i = 0 ; i < t ; i++) {

		hashSet.add(new Pair(pair_left[i], pair_right[i]));

		System.out.println(hashSet.size());



	}



    }
}
