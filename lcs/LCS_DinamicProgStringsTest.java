package lcs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCS_DinamicProgStringsTest {

	@Test
	void test1() {
		String Y = "abcbdab", X  = "bdcaba"; 
		String expected = "bcba";
		String actual = LCS_DinamicProgStrings.maxSequence(X, Y);
		assertEquals(expected, actual);
		////////// check recursion
		expected = "bdab";
		actual = LCS_DinamicProgStrings.maxSequenceRecursiv(X, Y);
		assertEquals(expected, actual);
	}
	@Test
	void test2() {
		String X = "abca", Y = "bcb";
		String actual = LCS_DinamicProgStrings.maxSequence(X, Y);
		String expected = "bc";
		assertEquals(expected, actual);
		////////// check recursion
		expected = "bc";
		actual = LCS_DinamicProgStrings.maxSequenceRecursiv(X, Y);
		assertEquals(expected, actual);
	}
	@Test
	void test3() {
		String X = "abca", Y = "abcb";
		String actual = LCS_DinamicProgStrings.maxSequence(X, Y);
		String expected = "abc";
		assertEquals(expected, actual);
		////////// check recursion
		expected = "abc";
		actual = LCS_DinamicProgStrings.maxSequenceRecursiv(X, Y);
		assertEquals(expected, actual);
	}
	@Test
	void test4() {
		String X = "abcab", Y = "bcb";
		String actual = LCS_DinamicProgStrings.maxSequence(X, Y);
		String expected = "bcb";
		assertEquals(expected, actual);
		////////// check recursion
		actual = LCS_DinamicProgStrings.maxSequenceRecursiv(X, Y);
		assertEquals(expected, actual);
	}
	@Test
	void test5() {
		String X = "abcab", Y = "abcab";
		String actual = LCS_DinamicProgStrings.maxSequence(X, Y);
		String expected = "abcab";
		assertEquals(expected, actual);
		actual = LCS_DinamicProgStrings.maxSequenceRecursiv(X, Y);
		assertEquals(expected, actual);
		////////// check recursion
	}
	@Test
	void test6() {
		String X = "abcab", Y = "qwer";
		String actual = LCS_DinamicProgStrings.maxSequence(X, Y);
		String expected = "";
		assertEquals(expected, actual);
		actual = LCS_DinamicProgStrings.maxSequenceRecursiv(X, Y);
		assertEquals(expected, actual);
		////////// check recursion
	}
}
