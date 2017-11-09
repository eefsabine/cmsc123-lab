package laaaaab;

/**
 *
 * @author eefuuu
 */
import java.util.*;
public class Stack<E> {
    LinkedList<E> list;
    
    public Stack(){
        list = new LinkedList();
    }
    
    public void push(E item){
        list.add(item);
    }
    
    public E pop(){
        int index = list.size() - 1;
        return list.remove(index);
    }
    
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int index = list.size() - 1;
        return list.get(index);
    }
    public boolean isEmpty(){
        return (list.size() == 0);
    }
    public int size(){
        return list.size();
    }
    
}