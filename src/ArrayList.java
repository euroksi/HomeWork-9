import java.util.Arrays;

public class ArrayList<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        elements[size++] = value;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        list.remove(0);
        System.out.println("Element at index 0 after removal: " + list.get(0));
        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}