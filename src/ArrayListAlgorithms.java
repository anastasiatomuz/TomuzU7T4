import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ArrayListAlgorithms {
    /**
     * Returns true if any of the elements in stringList contain
     * target as a substring; false otherwise.  Use indexOf instead of contains
     * for AP practice! (although in reality, contains is preferred)
     * <p>
     * Does NOT mutate (modify) elements of stringList.
     * PRECONDITION: stringList.size() > 0
     *
     * @param stringList original arraylist of Strings
     * @return true if target is found in any of the strings, false otherwise
     */
    public static boolean containsTarget(ArrayList<String> stringList, String target) {
        for (int i = 0; i < stringList.size(); i ++){
            if (stringList.get(i).indexOf(target) >= 0){
                return true;
            }
        }
        return false;
    }

    /** Returns number of elements in intList that are less than the
     *  average of all elements.
     *
     *  Does NOT mutate (modify) elements of intList.
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  original arraylist of Integers
     *  @return  the number of ints in intList that are less than the average
     */
    public static int belowAverage(ArrayList<Integer> intList)
    {
        int sum = 0;
        for (int num : intList){
            sum += num;
        }
        double average = (double) sum / intList.size();

        int count = 0;
        for (int num : intList){
            if (num < average){
                count ++;
            }
        }
        return count;
    }

    /** Replaces all words in wordList that end in "s" with the all-uppercase
     *  version of the word.  For example, "apples" should be replaced with "APPLES".
     *  Assume all letters of all words in wordList are lowercase initially (no need
     *      *  to worry about checking for case or converting first to lowercase)
     *
     *  DOES mutate (modify) elements of wordList.
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  original arraylist of words
     */
    public static void replaceWithCaps(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i ++){
            if (wordList.get(i).substring(wordList.get(i).length() - 1).equals("s")){
                wordList.set(i, wordList.get(i).toUpperCase());
            }
        }
    }

    /** Returns the index at which the minimum value of all integers in
     *  intList appears; if the minimum value appears more than once in
     *  the arraylist, return the index of the first occurrence
     *
     *  Does NOT mutate (modify) elements in intList.
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  original arraylist of Integers
     *  @return  the index at which the minimum value occurs
     */
    public static int indexOfMinimum(ArrayList<Integer> intList)
    {
        int minimum = intList.get(0);
        for (int num : intList){
            if (num < minimum){
                minimum = num;
            }
        }

        for (int i = 0; i <intList.size(); i ++){
            if (intList.get(i) == minimum){
                return i;
            }
        }
        return 0;
    }

    /** Returns true if two array lists of the same length contain the exact
     *  same elements in the same order (i.e. the two arraylists are identical).
     *  Returns false otherwise.
     *
     *  Does NOT mutate (modify) elements in either arraylist
     *  PRECONDITION: numList1.size() == numList2.size()
     *
     *  @param numList1  first arraylist of Integers
     *  @param numList2  second arraylist of Integers, has the same size a first
     *  @return  true if both arraylists are identical, element for element
     */
    public static boolean areIdentical(ArrayList<Integer> numList1, ArrayList<Integer> numList2)
    {
        for (int i = 0; i < numList1.size(); i ++){
            if (numList1.get(i) != numList2.get(i)){
                return false;
            }
        }
        return true;
    }


    /** Removes all elements from numList that are ODD Integers.
     *
     *  DOES mutate (modify) elements in numList
     *  PRECONDITION: numList1.size() > 0
     *
     *  @param numList  arraylist of Integers
     */
    public static void removeOdds(ArrayList<Integer> numList)
    {
        for (int i = 0; i < numList.size(); i ++){
            if (numList.get(i) % 2 == 1){
                numList.remove(i);
                i --;
            }
        }
    }

    /** Removes all elements from wordList that contain an a, e, i , and/or o.
     *  All other words (i.e. those that have u and/or y as the vowel
     *  such as "ugh" or "sly", or no vowels, like "psh"), add a duplicate of
     *  that element to wordList at an adjacent index.
     *
     *  Assume all words have lowercase letters (i.e. no need to check for case)
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void wackyVowels(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i ++){
            if (wordList.get(i).contains("a") || wordList.get(i).contains("e")
                    || wordList.get(i).contains("i") || wordList.get(i).contains("o")){
                wordList.remove(i);
                i--;
            } else {
                wordList.add(i + 1, wordList.get(i));
                i ++;
            }
        }
    }

    /** Adds an uppercase version of each string directly AFTER the string
     *  in wordList; for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "HELLO", "my", "MY", "best", "BEST", "friend", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperAfter(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i ++){
            wordList.add(i + 1, wordList.get(i).toUpperCase());
            i ++;
        }
    }

    /** Appends an uppercase version of each string to the END of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperEnd(ArrayList<String> wordList)
    {
        int listLength = wordList.size();
        for (int i = 0; i <listLength; i ++){
            wordList.add(wordList.get(i).toUpperCase());
        }
    }

    /** Returns an arraylist of Strings that represents the input sentence parsed
     *  into separate words (using a space: " " as the delimiter) and REVERSED
     *  For example, if sentence = "This is my sentence!"
     *  this method return [sentence!, my, is, This]
     *
     *  PRECONDITION: sentence does not end with a space
     *
     *  @param sentence  the input String that represents one or more words
    separated by spaces
     *  @return  new arraylist of Strings containing the words of sentence reversed
     */
    public static ArrayList<String> parseWordsAndReverse(String sentence)
    {
        ArrayList <String> newList = new ArrayList<>();
        String word = "";
        for (int i = 0; i < sentence.length(); i ++){
            String letter = sentence.substring(i, i + 1);
            if (letter.equals(" ") || i == sentence.length() - 1) {
                word += letter;
                newList.add(0, word);
                word = "";
            }
            else {
                word += letter;
            }
        }
        return newList;
    }


    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static void removeDuplicates(ArrayList<Integer> intList)
    {
        for (int i = 0; i < intList.size(); i ++){
            int currentNum = intList.get(i);
            for (int j = 0; j < i; j ++){
                if (intList.get(j) == currentNum){
                    intList.remove(i);
                    i --;
                    break;
                }
            }
        }
    }

    /** Moves all words in wordList that begin with "b" to the front of
     *  wordList; all "b" words that are moved should appear in the same order
     *  in the modified arrayList as they did before being moved
     *
     *  For example, this method will take a wordList:
     *  ["apple", "banana", "cherry", "donut", "bagel", "danish", "berry", "baguette", "soda"]
     *  and modify it to
     *  ["banana", "bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: - wordList.size() > 0
     *                 - all strings in wordList have length >= 1
     *
     *  @param wordList  arraylist of words
     */
    public static void moveBWords(ArrayList<String> wordList)
    {
        int movedB = 0;
        for (int i = 0; i < wordList.size(); i ++){
            if (wordList.get(i).substring(0,1).equals("b")){
                wordList.add(movedB, wordList.remove(i));
                movedB ++;
            }
        }
    }

    /** Returns an arraylist of Integers that contain all mode(s) of the array numList.
     *  The mode of a list is the value that appears the greatest number of times.
     *  A list can have one mode, multiple mode, or no mode.
     *
     *  If all elements in the list appear the exact same number of times, there is no
     *  mode and this method should return an empty arraylist.
     *
     *  For example, if numList is: [1, 2, 6, 2, 3, 4, 6, 5, 5, 6, 7],
     *  then numList contains one mode: 6
     *  and this method returns an arrayList containing 6
     *
     *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6],
     *  then numList contains two modes: 2, 5
     *  and this method returns an arraylist containing 2 and 5 (in any order)
     *
     *  If numList is: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6],
     *  then numList contains no mode because all values appear the same number of times
     *  and this method returns an empty arrayList: []
     *
     *  Does NOT mutate (modify) elements in numList
     *  PRECONDITIONS: numList.length > 0
     *
     *  @param numList  numList of ints
     */
    public static ArrayList<Integer> modes(int[] numList)
    {
        /*
        method 1
        sort list,
        leave only one value of each number
        insert the num of times it appeared after it
        if every other number is the same, return empty list
        If value of 4th value is greater than of 2nd value, remove the first two values
        If second set is smaller, remove third and fourth values
        When finished iterating through list, remove every other value
         */
        Arrays.sort(numList);
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num: numList){
            nums.add(num);
        }
        for (int i = 0; i < nums.size(); i ++){
            int counter = 1;
            while (i < nums.size() - 1 && nums.get(i) == nums.get(i + 1)){
                counter ++;
                nums.remove(i + 1);
            }
            nums.add(i + 1, counter);
            i++;
        }
        int origLen = nums.size();
        for (int i = 1; i < nums.size(); i += 2){
            if (nums.get(i) > nums.get(i + 2)){
                nums.remove(i + 1);
                nums.remove(i + 1);
                i -= 2;
            } else if (nums.get(i) < nums.get(i + 2)){
                nums.remove(i);
                nums.remove(i - 1);
                while (i - 2 > 0 && nums.get(i) > nums.get(i - 2)){
                    nums.remove(i - 2);
                    nums.remove(i - 3);
                    i -= 2;//for the pair you remove each time
                }
                i -= 2; // for the "pair" removed initially
            }
            if (i + 2 >= nums.size() - 1){
                break;
            }
        }
        if (nums.size() == origLen){
            return new ArrayList<Integer>();
        }

        for (int i = 1; i < nums.size(); i += 2){
            nums.remove(i);
            i --;
        }

        return nums;

    }



}
