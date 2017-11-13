
package queue;
import java.lang.IllegalArgumentException;
/**
 *
 * @author eefuuu
 */
public class Queue {
    String[] array;
    int cap;
    int size;
    int front;
    int rear;
    
    Queue(int cap){
        this.cap = cap;
        array = new String[cap];
        size = 0;
        front = 0;
        rear = 0;
    }
    
    public void enqueue(String item){
        if(this.size == this.cap){
        expandArray();
        }
        array[rear] = item;
        rear = (rear + 1) % cap;
        size++;
    }
    
    public String dequeue(){
        String item;
        if(isEmpty()){
            throw new IllegalArgumentException("Queue underflow");
        }
        item = array[front];
        array[front] = null;
        front = (front + 1) % this.cap;
        
        return item;
    }
    
    public String peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue underflow");
        }
        return array[front];
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public int size(){
        return this.cap;
    }
    
    public void expandArray(){
        this.cap*=2;
        String[] newArr = new String[this.cap];
        for(int i = 0; i < this.size; i++){
            newArr[i] = array[front];
            front = (front + 1) % this.cap;
        }
        front = 0;
        rear = this.size;
        array = newArr;
    }
    
    public void display(){
        int i = 0;
        while(i != rear){
            System.out.println(array[i]);
            i = (i + 1) % this.cap;
        }
    }
}
