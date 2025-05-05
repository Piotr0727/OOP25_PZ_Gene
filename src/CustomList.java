import java.util.AbstractList;

public class CustomList<T> extends AbstractList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    public void addLast(T value){
        Node<T> newNode = new Node<T>(value);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public T getLast(){
        if(head != null)
            return tail.value;
        return null;
    }
    public void addFirst(T value){
        Node<T> newNode = new Node<T>(value);
        if(head == null){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public T getFirst(){
        if(head != null)
            return head.value;
        return null;
    }
    public T removeFirst(){
        if(head != null){
            T valueToReturn = head.value;
            head = head.next;
            if(head == null){
                tail = null;
            }
            size --;
            return valueToReturn;
        }
        return null;
    }
    public T removeLast(){
        if(tail != null){
            T valueToReturn = tail.value;
            if(head == tail){
                head = tail = null;
                size--;
                return valueToReturn;
            }
            Node<T> currentElement = head;
            while(currentElement.next != tail)
                currentElement = currentElement.next;
            tail = currentElement;
            tail.next = null;
            size--;
            return valueToReturn;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if(size == 0)
            return null;
        if(index >= size && index<0){
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return size;
    }
    public boolean add(T value){
        int prevSize = size;
        addLast(value);
        return size > prevSize;
    }
    private static class Node<T>{
        T value;
        Node<T> next;
        Node(T value){
            this.value = value;
            this.next = null;
        }
    }
}
