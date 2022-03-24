package org.grupoDAD.doubleEndedQueuees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue<Integer> doubleLinkedListQueue;

    Comparator<Integer> com = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 < o2)?0 : 1;
        }
    };

    @BeforeEach
    public void setUp(){
        doubleLinkedListQueue = new DoubleLinkedListQueue<>();
    }

    @AfterEach
    public void tearDown(){
        doubleLinkedListQueue = null;
    }

    @Test
    public void shouldReturnSizeZeroGivenEmptyList(){
        int expectedValue=0;
        int obtainedValue=doubleLinkedListQueue.size();

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void shouldReturnEmptyListAfterDeleteFirstWithOnlyOneNode(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        doubleLinkedListQueue.append(node);
        doubleLinkedListQueue.deleteFirst();

        assertNull(doubleLinkedListQueue.getRoot());
    }

    @Test
    public void shouldReturnEmptyListAfterDeleteLastWithOnlyOneNode(){
        DequeNode<Integer> node = new DequeNode<>(1,null,null);

        doubleLinkedListQueue.append(node);
        doubleLinkedListQueue.deleteLast();

        assertNull(doubleLinkedListQueue.getRoot());

    }

    @Test
    public void shouldReturnSecondNodeAsRootAfterDeleteTheFirst(){
        DequeNode<Integer> node1 = new DequeNode<>(1,null,null);
        DequeNode<Integer> node2 = new DequeNode<>(1,null,null);
        DequeNode<Integer> expectedValue = node2;

        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.deleteFirst();

        assertEquals(expectedValue,doubleLinkedListQueue.getRoot());
    }

    @Test
    public void shouldReturnFirstNodeAsLastAfterDeleteTheSecond(){
        DequeNode<Integer> node1 = new DequeNode<>(1,null,null);
        DequeNode<Integer> node2 = new DequeNode<>(1,null,null);
        DequeNode<Integer> expectedValue = node1;

        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.deleteLast();

        assertEquals(expectedValue,doubleLinkedListQueue.peekLast());
    }


    @Test
    public void createValidNotNullIntegerValuesListUsingAppend(){
        DequeNode<Integer> expectedFirstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> expectedMiddleNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> expectedLastNode = new DequeNode<>(2, null, null);
        int expectedSize = 3;

        doubleLinkedListQueue.append(expectedFirstNode);
        doubleLinkedListQueue.append(expectedMiddleNode);
        doubleLinkedListQueue.append(expectedLastNode);

        assertEquals(expectedFirstNode, doubleLinkedListQueue.peekFirst());
        assertEquals(expectedLastNode, doubleLinkedListQueue.peekLast());
        assertEquals(expectedSize, doubleLinkedListQueue.size());

    }

    @Test
    public void createValidNotNullIntegerValuesListUsingAppendLeft(){
        DequeNode<Integer> expectedFirstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> expectedMiddleNode = new DequeNode<>(1, null, null);
        DequeNode<Integer> expectedLastNode = new DequeNode<>(2, null, null);
        int expectedSize = 3;


        doubleLinkedListQueue.appendLeft(expectedLastNode);
        doubleLinkedListQueue.appendLeft(expectedMiddleNode);
        doubleLinkedListQueue.appendLeft(expectedFirstNode);


        assertEquals(expectedFirstNode, doubleLinkedListQueue.peekFirst());
        assertEquals(expectedLastNode, doubleLinkedListQueue.peekLast());
        assertEquals(expectedSize, doubleLinkedListQueue.size());

    }


    @Test
    public void mustThrowRunTimeExceptionGivenEmptyList(){
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.deleteFirst());
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.deleteLast());
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.peekFirst());
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.peekLast());
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.find(null));
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.delete(null));
    }

    @Test
    public void mustThrowRunTimeExceptionGivenNullNode(){
        DequeNode<Integer> node = new DequeNode<>(0, null, null);

        doubleLinkedListQueue.append(node);

        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.append(null));
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.appendLeft(null));
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.appendLeft(null));
        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.delete(null));
    }


    @Test
    public void mustThrowRunTimeExceptionGivenNoValidPosition(){
        DequeNode<Integer> node = new DequeNode<>(0, null, null);

        doubleLinkedListQueue.append(node);
        int size= doubleLinkedListQueue.size();

        assertThrows(RuntimeException.class, ()-> doubleLinkedListQueue.getAt(size+1));
    }


    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    public void returnNodeGivenHisItem(int pos){
        DequeNode<Integer> FirstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> SecondNode = new DequeNode<>(4, null, null);
        DequeNode<Integer> ThirdNode = new DequeNode<>(2, null, null);

        doubleLinkedListQueue.append(FirstNode);
        doubleLinkedListQueue.append(SecondNode);
        doubleLinkedListQueue.append(ThirdNode);

        DequeNode<Integer> expectedValue = doubleLinkedListQueue.getAt(pos);
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.find(expectedValue.getItem());

        assertEquals(expectedValue,obtainedValue);

    }


    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    public void SizeAfterDeleteMustBeOneUnitLower(int pos){
        DequeNode<Integer> FirstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> SecondNode = new DequeNode<>(4, null, null);
        DequeNode<Integer> ThirdNode = new DequeNode<>(2, null, null);

        doubleLinkedListQueue.append(FirstNode);
        doubleLinkedListQueue.append(SecondNode);
        doubleLinkedListQueue.append(ThirdNode);
        DequeNode<Integer> nodeToDelete = doubleLinkedListQueue.getAt(pos);

        int expectedValue = doubleLinkedListQueue.size()-1;

        doubleLinkedListQueue.delete(nodeToDelete);

        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue,obtainedValue);

    }

    @Test
    public void mustReturnASortedListGivenValuesFromCeroToFour(){
        DequeNode<Integer> NodeOne = new DequeNode<>(0, null, null);
        DequeNode<Integer> NodeTwo = new DequeNode<>(1, null, null);
        DequeNode<Integer> NodeThree = new DequeNode<>(2, null, null);
        DequeNode<Integer> NodeFour = new DequeNode<>(3, null, null);
        DequeNode<Integer> NodeFive = new DequeNode<>(4, null, null);

        doubleLinkedListQueue.append(NodeOne);
        doubleLinkedListQueue.append(NodeFour);
        doubleLinkedListQueue.append(NodeFive);
        doubleLinkedListQueue.append(NodeTwo);
        doubleLinkedListQueue.append(NodeThree);

        doubleLinkedListQueue.sort(com);

        assertEquals(0,doubleLinkedListQueue.getAt(1).getItem());
        assertEquals(1,doubleLinkedListQueue.getAt(2).getItem());
        assertEquals(2,doubleLinkedListQueue.getAt(3).getItem());
        assertEquals(3,doubleLinkedListQueue.getAt(4).getItem());
        assertEquals(4,doubleLinkedListQueue.getAt(5).getItem());

    }

    @Test
    public void mustReturnASortedListGivenRepeatedElemtens(){
        DequeNode<Integer> NodeOne = new DequeNode<>(0, null, null);
        DequeNode<Integer> NodeTwo = new DequeNode<>(5, null, null);
        DequeNode<Integer> NodeThree = new DequeNode<>(5, null, null);
        DequeNode<Integer> NodeFour = new DequeNode<>(7, null, null);
        DequeNode<Integer> NodeFive = new DequeNode<>(8, null, null);

        doubleLinkedListQueue.append(NodeOne);
        doubleLinkedListQueue.append(NodeFour);
        doubleLinkedListQueue.append(NodeFive);
        doubleLinkedListQueue.append(NodeTwo);
        doubleLinkedListQueue.append(NodeThree);

        doubleLinkedListQueue.sort(com);

        assertEquals(0,doubleLinkedListQueue.getAt(1).getItem());
        assertEquals(5,doubleLinkedListQueue.getAt(2).getItem());
        assertEquals(5,doubleLinkedListQueue.getAt(3).getItem());
        assertEquals(7,doubleLinkedListQueue.getAt(4).getItem());
        assertEquals(8,doubleLinkedListQueue.getAt(5).getItem());

    }

    @Test
    public void mustThrowRunTimeExceptionWhenTryToSortEmptyList(){
        DoubleLinkedListQueue<Integer> emptyList = new DoubleLinkedListQueue<>();

        assertThrows(RuntimeException.class, ()-> emptyList.sort(com));
    }

}