package org.grupoDAD.doubleEndedQueuees;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    private DequeNode<T> root;

    public DoubleLinkedListQueue(){
        root = null;
    }

    @Override
    public void append(DequeNode<T> node) {
        if(root != null) {
            DequeNode<T> currentNode = root;

            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }

            currentNode.setNext(node);
            node.setPrevious(currentNode);
        }else{
            root = node;
            root.setNext(null);
            root.setPrevious(null);
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(root != null) {
            node.setNext(root);
            node.setPrevious(null);

            root.setPrevious(node);

            root = node;
        }else{
            root = node;
            root.setNext(null);
            root.setPrevious(null);
        }
    }

    @Override
    public void deleteFirst() {
        if(root != null){
            DequeNode<T> newRoot = root.getNext();

            if(newRoot != null) {
                newRoot.setPrevious(null);
            }

            root = newRoot;
        }
    }

    @Override
    public void deleteLast() {

        if(root != null) {
            if(root.getNext() != null) {
                DequeNode<T> currentNode = root;
                DequeNode<T> previousNode = null;

                while (currentNode.getNext() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }

                previousNode.setNext(null);
                currentNode.setPrevious(null);
            }else{
                root = null;
            }

        }
    }

    @Override
    public DequeNode<T> peekFirst() {
        return root;
    }

    @Override
    public DequeNode<T> peekLast() {
        DequeNode<T> currentNode = root;

        if(root != null) {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
        }

        return currentNode;
    }

    @Override
    public int size() {
        int size = 0;
        DequeNode<T> currentNode = root;

        while (currentNode != null) {
            currentNode = currentNode.getNext();
            size++;
        }

        return size;
    }
}
