import com.company.MyArrayList;
import com.company.MyLinkedList;
import com.company.MyList;
import com.company.MyListIterator;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyLinkedListIteratorTest {
    Integer intNumber = 156;
    char character = 'a';
    String string = "Hello";
    int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int selector  = 0;
    public MyList fabricList() {
        switch (selector){
            case 0: return new MyArrayList();
            case 1: return new MyLinkedList();
            default: return null;
        }
    }


    @Test
    public void testAddFirstElementToNonEmptyList() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        iterator.add(character);
        assertEquals(character, list.get(0));
        assertEquals(intNumber, list.get(1));
    }

    @Test
    public void testAddMiddleElementToNonEmptyList() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.add(array);
        assertEquals(intNumber, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(array, list.get(2));
        assertEquals(string, list.get(3));
    }

    @Test
    public void testAddLastElementToNonEmptyList() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.add(array);
        assertEquals(intNumber, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(string, list.get(2));
        assertEquals(array, list.get(3));
    }

    @Test
    public void testHasNextTrue() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testHasNextFalse() {
        MyList list = fabricList();
        MyListIterator iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNextForIntegerCharacterStringAndArrayObjects() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        assertEquals(intNumber, iterator.next());
        assertEquals(character, iterator.next());
        assertEquals(string, iterator.next());
        assertEquals(array, iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextOutOfBounds() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
    }

    @Test
    public void testHasPreviousTrue() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        iterator.next();
        assertTrue(iterator.hasPrevious());
    }

    @Test
    public void testHasPreviousFalse() {
        MyList list = fabricList();
        MyListIterator iterator = list.iterator();
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void testPreviousForIntegerCharacterStringAndArrayObjects() throws Exception {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertEquals(array, iterator.previous());
        assertEquals(string, iterator.previous());
        assertEquals(character, iterator.previous());
        assertEquals(intNumber, iterator.previous());
    }


    @Test (expected = NoSuchElementException.class)
    public void testPreviousOutOfBounds () {
        MyList list = fabricList();
        MyListIterator iterator = list.iterator();
        iterator.previous();
    }

    @Test
    public void testNextIndex() {
        MyList list = fabricList();
        MyListIterator iterator = list.iterator();
        assertEquals(0, iterator.nextIndex());
        iterator.add(intNumber);
        assertEquals(1, iterator.nextIndex());
        iterator.add(character);
        assertEquals(2, iterator.nextIndex());
        iterator.add(string);
        assertEquals(3, iterator.nextIndex());
        iterator.add(array);
        assertEquals(4, iterator.nextIndex());
    }

    @Test
    public void testPreviousIndex() throws Exception {
        MyList list = fabricList();
        MyListIterator iterator = list.iterator();
        iterator.add(intNumber);
        iterator.add(character);
        iterator.add(string);
        iterator.add(array);
        assertEquals(3, iterator.previousIndex());
        iterator.previous();
        assertEquals(2, iterator.previousIndex());
        iterator.previous();
        assertEquals(1, iterator.previousIndex());
        iterator.previous();
        assertEquals(0, iterator.previousIndex());
        iterator.previous();
        assertEquals(-1, iterator.previousIndex());
    }

    @Test (expected = IllegalStateException.class)
    public void testRemoveWithoutNextOrPrevCalled() {
        MyList list = fabricList();
        MyListIterator iterator = list.iterator();
        iterator.add(intNumber);
        iterator.remove();
    }

    @Test
    public void testRemoveTheOnlyListElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.remove();
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveTheFirstElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.remove();
        assertEquals(3, list.size());
        assertEquals(character, list.get(0));
        assertEquals(string, list.get(1));
        assertEquals(array, list.get(2));
        assertEquals(-1, iterator.previousIndex());
    }

    @Test
    public void testRemoveMiddleElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(string, list.get(1));
        assertEquals(array, list.get(2));
        assertEquals(0, iterator.previousIndex());
    }

    @Test
    public void testRemoveLastElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(string, list.get(2));
        assertFalse(iterator.hasNext());
        assertEquals(list.size(), iterator.nextIndex());
    }

    @Test
    public void testRemoveTheOnlyListElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.remove();
        assertEquals(0, list.size());
        assertEquals(-1, iterator.previousIndex());
        assertEquals(0, iterator.nextIndex());
    }

    @Test
    public void testRemoveTheFirstElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.remove();
        assertEquals(3, list.size());
        assertEquals(character, list.get(0));
        assertEquals(string, list.get(1));
        assertEquals(array, list.get(2));
        assertEquals(-1, iterator.previousIndex());
    }

    @Test
    public void testRemoveMiddleElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.previous();
        iterator.remove();
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(string, list.get(1));
        assertEquals(array, list.get(2));
        assertEquals(0, iterator.previousIndex());
    }

    @Test
    public void testRemoveLastElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        list.add(array);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.previous();
        iterator.remove();
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(string, list.get(2));
        assertFalse(iterator.hasNext());
        assertEquals(list.size(), iterator.nextIndex());
    }

    @Test (expected = IllegalStateException.class)
    public void testSetWithoutNextOrPreviousCalled() {
        MyList list = fabricList();
        MyListIterator iterator = list.iterator();
        iterator.set(intNumber);
    }

    @Test
    public void testSetTheOnlyListElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        assertEquals(intNumber, iterator.next());
        iterator.set(character);
        assertEquals(character, iterator.previous());
    }

    @Test
    public void testSetTheFirstElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.set(array);
        assertEquals(3, list.size());
        assertEquals(array, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(string, list.get(2));
        assertEquals(1, iterator.nextIndex());
    }

    @Test
    public void testSetMiddleElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.set(array);
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(array, list.get(1));
        assertEquals(string, list.get(2));
        assertEquals(2, iterator.nextIndex());
    }

    @Test
    public void testSetLastElementWithNextCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.set(array);
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(array, list.get(2));
        assertFalse(iterator.hasNext());
        assertEquals(list.size(), iterator.nextIndex());
    }

    @Test
    public void testSetTheOnlyListElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.set(character);
        assertEquals(1, list.size());
        assertEquals(character, iterator.next());
    }

    @Test
    public void testSetTheFirstElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.set(array);
        assertEquals(3, list.size());
        assertEquals(array, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(string, list.get(2));
        assertEquals(-1, iterator.previousIndex());
    }

    @Test
    public void testSetMiddleElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.previous();
        iterator.set(array);
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(array, list.get(1));
        assertEquals(string, list.get(2));
        assertEquals(0, iterator.previousIndex());
    }

    @Test
    public void testSetLastElementWithPreviousCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.previous();
        iterator.set(array);
        assertEquals(3, list.size());
        assertEquals(intNumber, list.get(0));
        assertEquals(character, list.get(1));
        assertEquals(array, list.get(2));
        assertEquals(2, iterator.nextIndex());
    }

    @Test (expected = ConcurrentModificationException.class)
    public void testConcurrentModificationException () {
        MyList list = fabricList();
        list.add(intNumber);
        MyListIterator iterator = list.iterator();
        list.add(character);
        iterator.next();
    }

    @Test (expected = IllegalStateException.class)
    public void testSetAfterNextAndRemoveCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.remove();
        iterator.set(array);
    }

    @Test (expected = IllegalStateException.class)
    public void testSetAfterNextAndAddCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.add(array);
        iterator.set(array);
    }

    @Test (expected = IllegalStateException.class)
    public void testSetAfterPreviousAndRemoveCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.remove();
        iterator.set(array);
    }

    @Test (expected = IllegalStateException.class)
    public void testSetAfterPreviousAndAddCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.add(array);
        iterator.set(array);
    }
    @Test
    public void testRemoveAfterNextAndSetCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.set(array);
        iterator.remove();
    }

    @Test (expected = IllegalStateException.class)
    public void testRemoveAfterNextAndAddCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.add(array);
        iterator.remove();
    }

    @Test
    public void testRemoveAfterPreviousAndSetCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.set(array);
        iterator.remove();
    }

    @Test (expected = IllegalStateException.class)
    public void testRemoveAfterPreviousAndAddCalled() {
        MyList list = fabricList();
        list.add(intNumber);
        list.add(character);
        list.add(string);
        MyListIterator iterator = list.iterator();
        iterator.next();
        iterator.previous();
        iterator.add(array);
        iterator.remove();
    }


}
