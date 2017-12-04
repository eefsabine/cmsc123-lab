package heap;

public class Heap {
    int max;
    int [] array;
    int size;
    
    Heap(int max){
        this.size = size;
        this.max = max;
        this.array = new int[max];
    }
    
    int parent(int i){
        return (i - 1) / 2;
    }
    
    int lc(int i){
        return (2 * i + 1);
    }
    
    int rc(int i){
        return (2 * i + 2);
    }
    
    void bubbleUp(int index){
        int temp;
        if(parent(index) > 0 && array[index] <= array[parent(index)]){
            if(array[index] < array[parent(index)]){
                temp = array[index];
                array[index] = array[parent(index)];
                array[parent(index)] = temp;
                bubbleUp(parent(index));
            }
        }
    }
    
    void trickleDown(int index){
        int temp;
        
        do{
            if(array[lc(index)] < array[rc(index)]){
                temp = array[index];
                array[index] = array[lc(index)];
                array[lc(index)] = temp;
                index = lc(index);
            }
            else{
                temp = array[index];
                array[index] = array[rc(index)];
                array[rc(index)] = temp;
                index = rc(index);
            }
        } while((lc(index) == size) || 
                (rc(index) == size) && 
                (array[index] > array[lc(index)]) && 
                 (array[index] > array[rc(index)]));
    }
    
    public void add(int value){
         if(size == max){
             System.out.println("Heap is full");
         }
         else{
             array[size - 1] = value;
             size++;
             bubbleUp(size - 1);
         }
    }
    public int remove(){
        if(size == 0){
            return -1;
        }
        
        int i = array[0];
        
        if(size > 1){
            array[0] = array[size];
            size--;
            
            trickleDown(0);
        }
        return i;    
    }
    public void preorder(int index){
        if(index <= size - 1 ){
            System.out.println(array[index]);
            preorder(lc(index));
            preorder(rc(index));
        }
    }
    public void inorder(int index){
        if(index <= size -1){
            inorder(lc(index));
            System.out.println(array[index]);
            inorder(rc(index));
        }
    }
    public void postorder(int index){
         postorder(rc(index));
         postorder(lc(index));
         System.out.println(array[index]);
         
    }
/*
    public static void main(String[] args) {
    }
*/  
}
