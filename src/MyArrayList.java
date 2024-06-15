import java.util.Arrays;

public class MyArrayList {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }
    public void add(Object value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = value;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
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
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("Hello");
        list.add("World");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println("Size: " + list.size());

        list.remove(0);
        System.out.println(list.get(0));
        System.out.println("Size: " + list.size());

        list.clear();
        System.out.println("Size: " + list.size());
    }
}