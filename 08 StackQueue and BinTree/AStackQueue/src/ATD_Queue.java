import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ATD_Queue<E> implements Queue {
    // FIFO - First in first out
//    E	peek()	– Извлича стойността на обекта в главата, без да го премахва
//    E	poll() – Премахва обекта, който се намира в главата на опашката, като го връща като стойност на метода
//    E	put(E item)	– Добавя обект item в края на опашката Хвърля изключение InterruptedException при прекъсване в нишката


    public static void main(String[] args) {
        ATD_Queue<Integer> qu = new ATD_Queue<>();

        try {
            qu.
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
