package impl;
import java.io.IOException;

public interface Handler {

    
    /**
     * Read a file
     * @param filename The name of the file to read
     * @return The contents of the file as string
     * @throws IOException if file is missing or locked
     */
    public String readFile(String filename) throws IOException;

    /**
     * Converts the String's content to an int array
     * @param content The file content as a String
     * @return an int array of numbers
     */
    public int[] convertToArray(String content);
    
    /**
     * Sorts an unordered array
     * @param unsorted The array that has to be sorted
     * @return the sorted array
     */
    public int[] sortArray(int[] unsorted);

    /**
     * Tells us if a pair of numbers in the array can add up to the sum given
     * @param sum The amount a pair needs to equal
     * @param array The array whose values should add up to sum
     * @return truth value of the claim
     */    
    public boolean addsUpTo(int sum, int[] array);
    
    /**
     * Calculates if the array only contains prime numbers
     * @param array The sorted array containing the numbers to investigate
     * @return Whether the array consists of only primes or not
     */
    public boolean isOnlyPrimes(int[] array);
    
    /**
     * Extracts the even numbers from the array given
     * @param array The sorted array containing the numbers to investigate
     * @return An array of even numbers and an empty array if there is none.
     */
    public int[] getEvenNumbers(int[] array);
    
    /**
     * Calculate the sum of the numbers in the array
     * @param array The sorted array containing the numbers to investigate
     * @return The sum of the numbers
     */
    public int calculateSum(int[] array);
    
    /** 
     * Merge two integer arrays into one
     * @param array1 First integer array to merge
     * @param array2 Second integer array to merge
     * @return The merged array
     */
    public int[] mergeArrays(int[] array1, int[] array2);
    
    /**
     * Reverse an ordinary array of numbers
     * @param array The array whose numbers need to be changed
     * @return The reversed array
     */
    public int[] reverseArray(int[] array);
    
    /**
     * Removes the duplicate values
     * @param array It may or may not have duplicate values
     * @return An array with only the unique values
     */
    public int[] removeDuplicates(int[] array);
}
