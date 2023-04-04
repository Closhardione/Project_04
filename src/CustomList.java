import java.util.AbstractList;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CustomList <T> extends AbstractList<T> {


    private class Node{
        T value;
        Node next;
    }
    private Node first = null;
    private Node last = null;
    public void addLast(T value){
        Node node = new Node();
        node.next=null;
        node.value=value;
        if(first==null){
            first = node;
            last = node;
        }
        else{
            last.next=node;
            last = node;
        }
    }
    public T getLast(){
        if(last==null){
            throw new NoSuchElementException();
        }
        return last.value;
    }
    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        node.next=null;
        if(first==null){
            first=node;
            last=node;
        }
        else{
            node.next=first;
            first=node;
        }
    }
    public T getFirst(){
        if(first==null){
            throw new NoSuchElementException();
        }
        return first.value;
    }
    public T removeFirst(){
        if(first==null){
            throw new NoSuchElementException();
        }
        T oldFirstElement =  getFirst();
        if(first == last){
            first = null;
            last = null;
        }else {
            first = first.next;
        }
        return oldFirstElement;
    }
    public T removeLast(){
        if(last == null){
            throw new NoSuchElementException();
        }
        T oldLastElement = getLast();
        if(first == last){
            first = null;
            last = null;
        }else{
            Node ourElement = first;
            while (ourElement.next!=last){
                ourElement = ourElement.next;
            }
            ourElement.next = null;
            last = ourElement;
        }
        return oldLastElement;
    }
    @Override
    public T get(int index) {
        if( first != null && index < size()){
            Node ourElement=first;
            for(int i=0; i<index;i++){
                ourElement = ourElement.next;
            }
            return ourElement.value;
        }
        else{
            throw new NoSuchElementException();
        }

    }

    @Override
    public int size() {
        if(first!=null) {
            Node ourElement = first;
            int counter = 0;
            while (ourElement.next != last) {
                ourElement = ourElement.next;
                counter++;
            }
            return counter;
        }
        return 0;
    }
    public boolean add(T t){
        addLast((t));
        return true;
    }
}