package algoritmTest;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import algoritm.*;

public class FibonacciHeapTest extends Assert {
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithKey() throws IllegalArgumentException {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>(null);
    }

    @Test
    public void testGetMinOnEmptyHeap() throws Exception {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();

        assertEquals(heap.getMin(), null);
    }

    @Test
    public void testGetMinAfterInsert() {
        Integer testValue = 5;
        FibonacciHeap<Integer> heap = new FibonacciHeap<>(testValue);

        assertEquals(heap.getMin().key, testValue);
    }

    @Test
    public void testGetSize() throws Exception {
        FibonacciHeap<String> heap = new FibonacciHeap<>();

        String[] strings = {"", "Hoi", "Test", "Value"};
        int testSize = strings.length;

        for (String s : strings) {
            heap.insert(s);
        }

        assertEquals(heap.getSize(), testSize);
    }

    @Test
    public void testInsertKeyDescending() throws Exception {
        FibonacciHeap<String> heap = new FibonacciHeap<>();

        String[] strings = {"Very long string", "Little shorter", "Empty", ""};

        for (String s : strings) {
            heap.insert(s);
            FibonacciHeap<String>.Node<String> min = heap.getMin();

            assertEquals(min.key, s);
        }
    }

    @Test
    public void testInsertKeyAscending() {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>(0);
        FibonacciHeap<Integer>.Node<Integer> testMinInt = heap.getMin();

        for (int i = 1; i < 10; i++) {
            heap.insert(i);
            assertEquals(heap.getMin(), testMinInt);
        }
    }

    @Test
    public void testMergeEmptyHeaps() throws Exception {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();
        FibonacciHeap<Integer> other = new FibonacciHeap<>();

        heap.merge(other);
        assertEquals(heap.getMin(), null);
    }

    @Test
    public void testMergeWithEmptyHeap() throws Exception {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>(0);
        FibonacciHeap<Integer> other = new FibonacciHeap<>();
        FibonacciHeap<Integer>.Node<Integer> testMinInt = heap.getMin();

        for (int i = 1; i < 10; i++) {
            heap.insert(i);
        }

        heap.merge(other);

        assertEquals(heap.getMin(), testMinInt);
    }

    @Test
    public void testMergeNotEmptyHeaps() throws Exception {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();
        FibonacciHeap<Integer> other = new FibonacciHeap<>();

        for (int i = 0; i < 20; i++) {
            if ((i & 1) == 0) { //even
                heap.insert(i);
            }
            else { //odd
                other.insert(i);
            }
        }

        heap.merge(other);

        assertEquals(heap.getMin().key, new Integer(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergeNullReference() throws IllegalArgumentException {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();
        heap.merge(null);
    }

    @Test
    public void testExtractMin() throws Exception {
        FibonacciHeap<String> heap = new FibonacciHeap<>();

        String[] strings = {"Very long string", "Little shorter", "Empty", ""};
        String[] rStrings = {"", "Empty", "Little shorter", "Very long string"};

        for (String s : strings) {
            heap.insert(s);
        }

        ArrayList<String> testStrings = new ArrayList<>();
        int len = heap.getSize();
        for (int i = 0; i < len; i++) {
            FibonacciHeap<String>.Node<String> min = heap.extractMin();
            testStrings.add(min.key);
        }

        String[] aStrings = new String[rStrings.length];
        testStrings.toArray(aStrings);

        assertArrayEquals(rStrings, aStrings);
    }

    @Test
    public void testDecreaseKey() throws Exception {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();
        for (int i = 1; i < 10; i++) {
            heap.insert(i);
        }

        FibonacciHeap<Integer>.Node<Integer> testMinNode = heap.getMin();
        Integer testNewKeyValue = 0;
        heap.decreaseKey(testMinNode, testNewKeyValue);

        assertEquals(heap.getMin().key, testNewKeyValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseKeyNullReference() throws IllegalArgumentException {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();
        heap.insert(1);
        FibonacciHeap<Integer>.Node<Integer> testMinNode = heap.getMin();
        heap.decreaseKey(testMinNode, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseKeyNullReferenceKey() throws IllegalArgumentException {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>(10);

        FibonacciHeap<Integer>.Node<Integer> testMinNode = heap.getMin();
        Integer testNewKeyValue = 15;
        heap.decreaseKey(testMinNode, testNewKeyValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseKeyNullReferenceNode() throws IllegalArgumentException {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>(5);
        Integer testNewKeyValue = 15;
        heap.decreaseKey(null, testNewKeyValue);
    }

    @Test
    public void testDelete() throws Exception {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);

        FibonacciHeap<Integer>.Node<Integer> testMinNode = heap.getMin();
        heap.delete(testMinNode);

        assertEquals(heap.getMin().key, new Integer(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNullReference() throws IllegalArgumentException {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>();

        heap.delete(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeleteEmptyHeap() throws IllegalStateException {
        FibonacciHeap<Integer> heap = new FibonacciHeap<>(1);
        FibonacciHeap<Integer>.Node<Integer> testMinNode = heap.getMin();
        heap.extractMin();
        heap.delete(testMinNode);
    }
}