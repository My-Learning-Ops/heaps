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

    // Checks if heap is emty
    public boolean isEmpty() {
        return list.isEmpty();
    }




}
