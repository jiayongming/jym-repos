package joda;

import org.joda.time.DateTime;
import org.junit.Test;

public class JodaTest {
	@Test
	public void test2() {
		capacity(0) ;
	}
	
	static void capacity(int expectedSize) {
		if (expectedSize < 3) {
			checkNonnegative(expectedSize, "expectedSize");
			System.out.println( expectedSize + 1 );;
		}
		if (expectedSize < 1 << (Integer.SIZE - 2)) {
			System.out.println( expectedSize + expectedSize / 3 ) ;
		}
		System.out.println( Integer.MAX_VALUE ); // any large value
	}

	static int checkNonnegative(int value, String name) {
		if (value < 0) {
			throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
		}
		return value;
	}


	

}
