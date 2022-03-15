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
    public void ItemShouldBe10InNodeGiven10InSetter(){
        int expectedItem=10;
        DequeNode<Integer> node = new DequeNode<>(0, null, null);
        node.setItem(10);
        assertEquals(expectedItem,node.getItem());
    }

    @Test
    public void PreviousNodeShouldNotBeNullAfterSettingPrevious(){
        DequeNode<Integer> firstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(1, null, null);
        lastNode.setPrevious(firstNode);

        assertEquals(firstNode, lastNode.getPrevious());
    }

    @Test
    public void NextNodeShouldNotBeNullAfterSettingNext(){
        DequeNode<Integer> firstNode = new DequeNode<>(0, null, null);
        DequeNode<Integer> lastNode = new DequeNode<>(1, null, null);
        firstNode.setNext(lastNode);

        assertEquals(lastNode, firstNode.getNext());
    }

}