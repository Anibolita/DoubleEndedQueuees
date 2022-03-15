package org.grupoDAD.doubleEndedQueuees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {

    @Test
    public void createValidNotNullIntegerValuesListShould(){
        DequeNode<Integer> expectedFirstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> expectedLastNode = new DequeNode<>(1, null, null);
        int expectedSize = 2;

        DoubleLinkedListQueue<Integer> obtainedList = new DoubleLinkedListQueue<>();
        obtainedList.append(expectedFirstNode);
        obtainedList.append(expectedLastNode);

        assertEquals(expectedFirstNode, obtainedList.peekFirst());
        assertEquals(expectedLastNode, obtainedList.peekLast());
        assertEquals(expectedSize, obtainedList.size());

    }
}