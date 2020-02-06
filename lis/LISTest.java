package lis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LISTest {

	@Test
	void test1() {
		int[]arr = {1,2,3};
		int expected[] = {1,2,3};
		int actual[] = LIS.LIS2(arr);
		assertArrayEquals(expected, actual);
	}
	@Test
	void test2() {
		int[]arr = {8,1,100,101,2};
		int expected[] = {1,100,101};
		int actual[] = LIS.LIS2(arr);
		assertArrayEquals(expected, actual);
	}
	@Test
	void test3() {
		int[]arr = {3,2,1,0};
		int expected[] = {0};
		int actual[] = LIS.LIS2(arr);
		assertArrayEquals(expected, actual);
	}
	@Test
	void test4() {
		int[]arr = {-3, -2, 101, 9, 10, 11, 1, 2, 3, 100, 4, -1, 5, 6};
		int expected[] = {-3,-2,1,2,3,4,5,6};
		int actual[] = LIS.LIS2(arr);
		assertArrayEquals(expected, actual);
	}
	@Test
	void test5() {
		int[]arr = {8, 2, 9, 3, 1, 10, 4, 6, 5, 7};
		int expected[] = {2,3,4,5,7};
		int actual[] = LIS.LIS2(arr);
		assertArrayEquals(expected, actual);
	}
}
