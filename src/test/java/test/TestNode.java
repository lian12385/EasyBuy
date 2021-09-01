package test;

import org.junit.Test;

public class TestNode {
    @Test
    public void testNode(){

    }
    //void linkLast(E e){
    //    final Node<E> l = last;
    //}

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
