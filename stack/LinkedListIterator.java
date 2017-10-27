import java.util.NoSuchElementException;
import java.util.*;

public class LinkedListIterator<E> implements Collection<E>{
    private class Node {
        private E data;
        private Node next;

        Node(E data, Node next){
            this. data = data;
            this.next = next;
        }
    }

    Node head = null;
    int size = 0;

    LinkedListIterator(){}

    public boolean add(E item, int index){
        Node node = new Node(item, head);

        if(this.size == 0 || index == 0){
            this.head = node;
            this.size++;

            return true;
        }

        if(index > this.size + 1){
            throw new IndexOutOfBoundsException();
        }

        if(index == this.size) {
            Node current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(item, null);

            size++;
            return true;
        }
        Node previous = this.head;
        Node current = this.head.next;

        int cursor = 1;

        while(current != null){
            if(cursor == index){
                current = new Node(item, current);
                previous.next = current;

                this.size++;
                return true;
            }
            previous = previous.next;
            current = current.next;

            cursor++;
        }
        return false;
    }
    public boolean remove(int index){
         if(this.size == 0){
            return false;
        }
        Node current = this.head;
        Node previous = null;

        for(int i = 0; i < index; i++){
            previous = current;
            current = current.next;

            if(current == null){
                break;
            }
        }
        previous.next = current.next;
        current.next = null;
        this.size--;
        return true;
    }

    public E get(int index){
        Node current = this.head;
        Node previous = null;

        for(int i = 0; i < index; i++){
            previous = current;
            current = current.next;

            if(current == null){
                break;
            }
        }
        return current.data;
    }

    public void display(){
        Node current = this.head;
        Node previous = null;

        for(int i = 0; i < this.size; i++){
            System.out.println(current.data);
            previous = current;
            current = current.next;

            if(current == null){
                break;
            }
        }
    }

    public int size(){
         return this.size;

    }
    public Iterator<E> iterator(){
        return new LinkedListIter();
    }
    class LinkedListIter implements Iterator<E>{
        Node current = head;

        public boolean hasNext(){
            return (current != null);
        }
        public E next(){
            if(!(hasNext()))
                throw new NoSuchElementException();

            E item = current.data;
            current = current.next;
            return item;
        }
    }
}
