package impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class HandlerImplTest {
	

    private final Handler handler = new HandlerImpl();
    
    @Test
    public void testReadFile() {
        String expected = "5 12 65 33 2 11 10 98 66 -12 -9 0 10 12";
        try {
            String actual = handler.readFile("numbers.txt");
            assertEquals(expected, actual);
        } catch (IOException ex) {
            fail("File not found!");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSortArray() {
        int[] unsorted = new int[] {1, 4, 5, 3, 2, -1, 0};
        int[] expected = new int[] {-1, 0, 1, 2, 3, 4, 5};
        int[] actual = handler.sortArray(unsorted);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testConvertToArray() {
        String content = "0 1 2 3 4 5";
        int[] actual = handler.convertToArray(content);
        int[] expected = new int[] {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testConvertToArrayInvalidValues() {
        String content = "mdasmodfkas fsdjiofsd";
        int[] actual = handler.convertToArray(content);
        int expectedLenght = 0;
        assertEquals(expectedLenght, actual.length);
    }
    
    @Test
    public void testEvens() {
    		// equivalence classes:
    		// even numbers: [-2, 0, 10]
    		int[] numbers = new int[] {-3, 0, 1, 4};
    		int[] expected = new int[] {0, 4};
    		int[] actual = handler.getEvenNumbers(numbers);
    		
    		assertArrayEquals(expected, actual);
    }


}
