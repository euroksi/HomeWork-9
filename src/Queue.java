public class Queue {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        Object data;
        Node next;
        Node prev;

        Node(Object data) {
            this.data = data;
        }
    }

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(Object value) {
        Node newNode = new Node(value);
        if (tail == null) { // Черга порожня
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public Object remove() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Node removedNode = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // Якщо черга стала порожньою
        }
        size--;
        return removedNode.data;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("First");
        queue.add("Second");
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println("Size: " + queue.size());

        queue.clear();
        System.out.println("Size: " + queue.size());
    }
}
