import java.util.ArrayList;


// Generic implementation of a Heap data structure
public class Heap<T extends Comparable<T>> {


    private final ArrayList<T> list;

    // Constructs a heap
    public Heap() {
        list = new ArrayList<>();
    }

    // Returns the size of the heap
    public int size() {
        return list.size();
    }

    // Checks if heap is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Clears the heap
    public void clear() {
        list.clear();
    }

    // Peeks at the top element in the heap
    public T peek() {  
        return isEmpty() ? null : list.get(0);
    }

    // Adds an element to the heap
    public void add(T item) {
        list.add(item);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parent = (currentIndex - 1) / 2;
            if (list.get(parent).compareTo(currentIndex) < 0) {
                T temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parent));
                list.set(parent, temp);
                currentIndex = parent;
            } else {
                break;
            }
        }
    }

    // Removes and returns an element from the heap
    public T remove() {

    }

    // Returns a string representation of the heap
    @Ovveride
    public String toString() {
    }




}
