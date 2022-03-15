package org.grupoDAD.doubleEndedQueuees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {
    private DoubleLinkedListQueue<Integer> doubleLinkedListQueue;

    @BeforeEach
    public void setUp(){
        doubleLinkedListQueue=new DoubleLinkedListQueue<>();
    }

    @AfterEach
    public void tearDown(){
        doubleLinkedListQueue=null;
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
    public void shouldReturnNullAfterAppendANullNode(){
        doubleLinkedListQueue.append(null);
        assertNull(doubleLinkedListQueue.getRoot());
    }

    @Test
    public void shouldReturnNullAfterAppendLeftANullNode(){
        doubleLinkedListQueue.appendLeft(null);
        assertNull(doubleLinkedListQueue.getRoot());
    }


}