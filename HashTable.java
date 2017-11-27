
package hashtable;

import java.util.*;

public class HashTable {
    public class HashNode{
        String key;
        int value;
        HashNode next;
        
        HashNode (String key, int value){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    HashNode[] hashTable;
    int MAX_SIZE;
    
    HashTable(){
        int MAX_SIZE = 50;
        hashTable = new HashNode[MAX_SIZE];
        
        for(int i = 0; i < MAX_SIZE; i++){
            hashTable[i] = null;
        }
    }
    
    int size;
    
    public void put(String key, int value){
       int hash = (key.hashCode() % MAX_SIZE) % MAX_SIZE;
           
        if(hashTable[hash] == null){
            hashTable[hash] = new HashNode(key, value);
           }
        else{
            HashNode newNode = hashTable[hash];
               
            while(newNode.next != null && newNode.key != key){
                newNode = newNode.next;
            }
            if(newNode.key == key){
                newNode.value = value;
            }
            else{
                newNode.next = new HashNode(key, value);
            }
        }
     size++;
    }
    
    
    public int get(String key){
        int hash = (key.hashCode() % MAX_SIZE) % MAX_SIZE;
        
        if(hashTable[hash] == null){
            return -1;
        }
        HashNode newNode = hashTable[hash];
        
        while(newNode.next != null && newNode.key != key){
            newNode = newNode.next;
        }
        if(newNode.key == null){
            return -1;
        }
        return newNode.value;
    }
    
    public int remove(String key){
        int hash = (key.hashCode() % MAX_SIZE) % MAX_SIZE;
        
        if(hashTable[hash] == null){
            return -1;
        }
        
        HashNode previous = null;
        HashNode newNode = hashTable[hash];
        
        while(newNode.next != null && newNode.key != key){
            previous = newNode;
            newNode.next = newNode;
        }
        
        if(newNode.key == null){
            return -1;
        }
        
        if(previous == null){
            hashTable[hash] = newNode.next;
        }
        else{
            previous.next = newNode.next;
        }
        
        size--;
        return newNode.value;
    }
    public boolean contains(String key){
        int hash = (key.hashCode() % MAX_SIZE) % MAX_SIZE;
        if(hashTable[hash] == null){
            return false;
        }
        
        HashNode newNode = hashTable[hash];
        
        while(newNode.next != null && newNode.key != key){
            newNode.next = newNode;
        }
        if(newNode.key == null){
            return false;
        }
        return true;
    }
    public void values(){
        for(int i = 0; i < MAX_SIZE; i++){
            HashNode newNode = hashTable[i];
            while(newNode != null){
                System.out.print(newNode.value + " \n");
                newNode = newNode.next;
            }
        }
    }
    public void keys(){
        for(int i = 0; i < MAX_SIZE; i++){
            HashNode newNode = hashTable[i];
            while(newNode != null){
                System.out.print(newNode.key + " \n");
                newNode = newNode.next;
            }
        }
    }
}