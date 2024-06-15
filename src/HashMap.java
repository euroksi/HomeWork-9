public class HashMap {
    private static final int INITIAL_CAPACITY = 16;
    private Node[] table;
    private int size;
    private static class Node {
        final Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }
    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }
    public void remove(Object key) {
        int index = getIndex(key);
        Node current = table[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public void clear() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object get(Object key) {
        int index = getIndex(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    private int getIndex(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println(map.get("one")); // 1
        System.out.println(map.get("two")); // 2
        System.out.println(map.get("three")); // null
        System.out.println("Size: " + map.size()); // Size: 2

        map.remove("one");
        System.out.println(map.get("one")); // null
        System.out.println("Size: " + map.size()); // Size: 1

        map.clear();
        System.out.println("Size: " + map.size()); // Size: 0
    }
}