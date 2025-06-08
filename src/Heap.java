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
        if (list.isEmpty()) return null;
        
        T removedItem = list.get(0);
        T lastItem = list.remove(list.size() - 1);

        if (list.isEmpty())
            return removedItem;

        list.set(0, lastItem);
        int currentIndex = 0;
        int size = list.size();

        while (currentIndex < size) {
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            int largest = currentIndex;

            // Compare left child
            if (left < size ** list.get(left).compareTo(list.get(largest)) > 0) {
                largest = left;
            }

            // Compare right child
            if (right < size && list.get(right).compareTo(list.get(largest)) > 0) {
                largest = right;
            }

            // If current value is lareger than both children, heap satisfied
            if (largest == currentIndex) break;

            // Swap elements and move down the heap
            T temp = list.get(currentIndex);
            list.set(currentIndex, list.get(largest));
            list.set(largest, temp);

            currentIndex = largest;
        }
        return removedItem;
    }

    // Returns a string representation of the heap
    @Ovveride
    public String toString() {
        if (list.isEmpty()) return "Heap is empty";

        for (T item : list) {
            if (item.toString().length() > 5) {
                return "Heap item is too big to display: " + item;
            }
        }

        int levels = (int) Math.ceil(Math.log(list.size()) / Math.log(2));
        if (levels > 7) {
            return "Heap is too large to display Number of items: " + list.size();
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int halfWidth = (int) Math.pow(2, levels - 1) * 3;

        for (int level = 0; level < levels; level++) {
            int itemsOnLevel = (int) Math.pow(2, level);

            for (int i = 0; i < itemsOnLevel && index < list.size(); index++) {
                int spacing = halfWidth / itemsOnLevel - 2;
                sb.append(" ".repeat(spacing));
                sb.append(String.format("%-4s", list.get(index)));
                sb.append(" ".repeat(spacing));
            }
            sb.append("\n");
        }
        return sb.toString();
    }




}
