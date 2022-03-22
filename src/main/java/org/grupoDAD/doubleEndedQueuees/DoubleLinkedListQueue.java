package org.grupoDAD.doubleEndedQueuees;

import java.util.Comparator;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    private DequeNode<T> root;

    public DoubleLinkedListQueue(){
        root = null;
    }

    @Override
    public void append(DequeNode<T> node) {
        if(node != null){
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
        }else{
            throw new RuntimeException("Given Null Node");
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(node != null){
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
        }else{
            throw new RuntimeException("Given Null Node");
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
        }else{
            throw new RuntimeException("Empy List");
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
        }else{
            throw new RuntimeException("Empy List");
        }
    }

    @Override
    public DequeNode<T> peekFirst() {
        if(root==null){
            throw new RuntimeException("Empty List");
        }
        return root;
    }

    @Override
    public DequeNode<T> peekLast() {
        DequeNode<T> currentNode = root;

        if(root != null) {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
        }else{
            throw new RuntimeException("Empy List");
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

    @Override
    public DequeNode<T> getAt(int position) {
        DequeNode<T> currentNode = null;

        if(position >= 0 && position <= this.size()){
            currentNode = root;
            for(int i = 0; i < position; i++){
                currentNode = currentNode.getNext();
            }
        }else{
            throw new RuntimeException("Not Valid Position");
        }

        return currentNode;
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode<T> currentNode = null;

        if(root != null){
            currentNode = root;
            int size = size();
            int cont = 1;
            while(cont <= size && !currentNode.getItem().equals(item)){
                currentNode = currentNode.getNext();
                cont++;
            }
        }else{
            throw new RuntimeException("Empy List");
        }

        return currentNode;
    }

    @Override
    public void delete(DequeNode<T> node) {

        if(root != null){
            if(node != null){
                if(node.equals(root)){
                    root = node.getNext();
                }else if(node.getNext() == null){
                    node.getPrevious().setNext(null);
                }else{
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                }
            }else{
                throw new RuntimeException("Given Null Node");
            }
        }else{
            throw new RuntimeException("Empy List");
        }
    }

    @Override
    public void sort(Comparator<?> comparator) {

    }

    public DequeNode<T> getRoot(){return root;}
}
