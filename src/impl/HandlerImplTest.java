package impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

class HandlerImplTest {

	private final Handler handler = new HandlerImpl();

//	Two methods converted to Hamcrest:
	@Test
	public void testReadFile() {
		try {
			String actualString = handler.readFile("numbers.txt");
			Pattern pattern = Pattern.compile(", ");
			List<Integer> list = pattern.splitAsStream(actualString)
			                            .map(Integer::valueOf)
			                            .collect(Collectors.toList());
			
			List<Integer> expected = Arrays.asList(5, 12, 65, 33, 2, 11, 10, 98, 66, -12, -9, 0, 10, 12);
			
			assertThat(list, hasSize(14));
			assertThat(list, contains(expected));
			
		} catch (IOException ex) {
			fail("File not found!");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

//	Also Hamcrest test
	@Test
	public void testSortArray() {
		int[] unsorted = new int[] { 1, 4, 5, 3, 2, -1, 0 };
		int[] ints = handler.sortArray(unsorted);
		List<Integer> actual = Arrays.stream(ints).boxed().collect(Collectors.toList());
		
		assertThat(actual, contains(-1, 0, 1, 2, 3, 4, 5));
	}

	@Test
	public void testConvertToArray() {
		String content = "0 1 2 3 4 5";
		int[] actual = handler.convertToArray(content);
		int[] expected = new int[] { 0, 1, 2, 3, 4, 5 };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testConvertToArrayInvalidValues() {
		String content = "mdasmodfkas fsdjiofsd";
		int[] actual = handler.convertToArray(content);
		int expectedLenght = 0;
		assertEquals(expectedLenght, actual.length);
	}
	
	
//	The data-driven test method:
	@Test
	@DisplayName("Test getting even numbers")
	public void testEvensDataDriven() {
		int[] data1 = new int[] { -3, 0, 1, 4, 6 };
		int[] expected1 = new int[] {0, 4, 6};
		
		int[] data2 = new int[] { 4, 6, 8, 10 };
		int[] expected2 = new int[] {4, 6, 8, 10};
		
		int[] data3 = new int[] { 1, 5, 9 };
		int[] expected3 = new int[] {};
		
		testEvens(data1, expected1);
		testEvens(data2, expected2);
		testEvens(data3, expected3);
	}

	public void testEvens(int[] workable, int[] expected) {
		int[] actual = handler.getEvenNumbers(workable);
		assertArrayEquals(expected, actual);
	}

//	Also a data-driven test:
	@Test
	public void testSumDataDriven() {
		int[] data1 = new int[] { 1, 4, 5 };
		int expected1 = 10;
		
		int[] data2 = new int[] { 1, 99, 50 };
		int expected2 = 150;
		
		int[] data3 = new int[] { -50, 50, 1 };
		int expected3 = 1;
		
		testSum(data1, expected1);
		testSum(data2, expected2);
		testSum(data3, expected3);
	}
	
	public void testSum(int[] numArray, int sumExpected) {
		int sumActual = handler.calculateSum(numArray);
		
		System.out.println("Sum expected: " + sumExpected + "; sum actual: " + sumActual);
		assertEquals(sumExpected, sumActual);
	}

}
