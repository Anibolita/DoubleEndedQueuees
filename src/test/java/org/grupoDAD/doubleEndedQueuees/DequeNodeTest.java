package org.grupoDAD.doubleEndedQueuees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {

    @Test
    public void createValidNotEmptyIntegerValueNode(){
        int expectedItem = 0;
        DequeNode<Integer> expectedNext = null;
        DequeNode<Integer> expectedPrevious = null;

        DequeNode<Integer> obtainedNode = new DequeNode<>(0, null, null);

        assertEquals(expectedItem,obtainedNode.getItem());
        assertEquals(expectedNext,obtainedNode.getNext());
        assertEquals(expectedPrevious,obtainedNode.getPrevious());
    }

    @Test
    public void createValidNotEmptyIntegerValueFirstNode(){
        DequeNode<Integer> obtainedNode = new DequeNode<>(0, null, null);

        assertTrue(obtainedNode.isFirstNode());
    }

    @Test
    public void createValidNotEmptyIntegerValueLastNode(){
        DequeNode<Integer> obtainedNode = new DequeNode<>(0, null, null);

        assertTrue(obtainedNode.isLastNode());
    }

    @Test
    public void createTwoLinkedNodes(){
        DequeNode<Integer> firstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(1, null, firstNode);
        firstNode.setNext(lastNode);

        assertEquals(lastNode, firstNode.getNext());
        assertEquals(firstNode, lastNode.getPrevious());
    }

    @Test
    public void createdTwoLinkedNodesAndTestFirstAndLast(){
        DequeNode<Integer> firstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(1, null, firstNode);
        firstNode.setNext(lastNode);

        assertTrue(firstNode.isFirstNode());
        assertFalse(firstNode.isLastNode());
        assertFalse(lastNode.isFirstNode());
        assertTrue(lastNode.isLastNode());
    }

    @Test
    public void createdMiddleNode(){
        DequeNode<Integer> firstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> middleNode = new DequeNode<>(1, null, firstNode);
        DequeNode<Integer> lastNode = new DequeNode<>(1, null, middleNode);
        firstNode.setNext(middleNode);
        middleNode.setNext(lastNode);

        assertTrue(middleNode.isNotATerminalNode());
    }


}