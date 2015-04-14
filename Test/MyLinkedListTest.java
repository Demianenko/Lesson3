import com.company.MyArrayList;
import com.company.MyLinkedList;
import static org.junit.Assert.*;

import com.company.MyList;
import org.junit.Test;
/**
 * Created by sega on 23.03.2015.
 */
public class MyLinkedListTest {
    Integer intNumber = 156;
    char character = 'a';
    String string = "Hello";
    int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int selector = 0;
    public MyList fabricList() {
        switch (selector){
            case 0: return new MyArrayList();
            case 1: return new MyLinkedList();
            default: return null;
        }
    }
    @org.junit.Test
    public void testIsEmptyMethodForEmptyList() {
        MyList testList = fabricList();
        assertTrue(testList.isEmpty());
    }

    @org.junit.Test
    public void testIsEmptyMethodForNonEmptyList() {
        MyList testList = fabricList();
        testList.add("hello");
        assertFalse(testList.isEmpty());
    }

    @org.junit.Test
    public void testAddMethodToEmptyList() {
        MyList testList = fabricList();
        assertTrue(testList.isEmpty());
        testList.add("Hello world");
        assertFalse(testList.isEmpty());
        assertEquals("Hello world", testList.get(0));
    }

    @org.junit.Test
    public void testAddMethodToNonEmptyList() {
        MyList testList = fabricList();
        assertTrue(testList.isEmpty());
        testList.add("Hello world");
        testList.add("Hi world");
        assertFalse(testList.isEmpty());
        assertEquals("Hi world", testList.get(1));
    }

    @org.junit.Test
    public void testAddMethodForDifferentObjects() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertEquals(intNumber, testList.get(0));
        assertEquals(character, testList.get(1));
        assertEquals(string, testList.get(2));
        assertEquals(array, testList.get(3));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testGetNodeMethodForEmptyList() {
        MyList testList = fabricList();
        testList.get(0);
    }

    @org.junit.Test
    public void testGetNodeMethodForTheFirstElement() {
        MyList testList = fabricList();
        testList.add(intNumber);
        assertEquals(testList.get(0), intNumber);
    }

    @org.junit.Test
    public void testGetNodeMethodForTheLastElement() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertEquals(testList.get(3), array);
    }


    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testGetNodeMethodOutOfBounds() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        testList.get(4);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testGetMethodForEmptyList() {
        MyList testList = fabricList();
        testList.get(0);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testGetMethodForNegativeIndex() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.get(-1);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testGetMethodOutOfBounds() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        testList.get(4);
    }

    @org.junit.Test
    public void testRemoveListOfOneElement() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.remove(0);
        assertTrue(testList.isEmpty());
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmptyList() {
        MyList testList = fabricList();
        testList.remove(0);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.remove(2);
    }

    @org.junit.Test
    public void testClearEmptyList() {
        MyList testList = fabricList();
        testList.clear();
        assertTrue(testList.isEmpty());
    }

    @org.junit.Test
    public void testClearNonEmptyList() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertEquals(intNumber, testList.get(0));
        assertEquals(array, testList.get(3));
        testList.clear();
        assertTrue(testList.isEmpty());
    }

    @org.junit.Test
    public void testContainsEmptyList() {
        MyList testList = fabricList();
        assertFalse(testList.contains(1));
    }

    @org.junit.Test
    public void testContainsFalse() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertFalse(testList.contains(1));
    }

    @org.junit.Test
    public void testContainsTrue() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertTrue(testList.contains("Hello"));
    }

    @org.junit.Test
    public void testSizeEmptyList() {
        MyList testList = fabricList();
        assertEquals(0, testList.size());
    }

    @org.junit.Test
    public void testSizeOneElementList() {
        MyList testList = fabricList();
        testList.add(intNumber);
        assertEquals(1, testList.size());
    }

    @org.junit.Test
    public void testSizeGenericList() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertEquals(4, testList.size());
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testPutOutOfBoundsToEmptyList() {
        MyList testList = fabricList();
        testList.put(1, string);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testPutNewElementToEmptyList() {
        MyList testList = fabricList();
        testList.put(0, string);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testPutOutOfBoundsToNonEmptyList() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        testList.put(4, "Some string");
    }

    @org.junit.Test
    public void testGenericPut() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        testList.put(2, "Some string");
        assertEquals("Some string", testList.get(2));
    }

    @org.junit.Test
    public void testIndexOfEmptyList() {
        MyList testList = fabricList();
        assertEquals(-1, testList.indexOf(1));
    }

    @org.junit.Test
    public void testIndexOfNonPresentElement() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertEquals(-1, testList.indexOf("Some string"));
    }

    @org.junit.Test
    public void testIndicesOfPresentElements() {
        MyList testList = fabricList();
        testList.add(intNumber);
        testList.add(character);
        testList.add(string);
        testList.add(array);
        assertEquals(0, testList.indexOf(intNumber));
        assertEquals(1, testList.indexOf(character));
        assertEquals(2, testList.indexOf(string));
        assertEquals(3, testList.indexOf(array));
    }
}

