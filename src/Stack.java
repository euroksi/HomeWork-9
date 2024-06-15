public class Stack {
    private Node top;
    private int size;

    private static class Node {
        Object data;
        Node next;
        Node prev;

        Node(Object data) {
            this.data = data;
        }
    }

    public Stack() {
        top = null;
        size = 0;
    }
    public void push(Object value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top.prev = newNode;
            top = newNode;
        }
        size++;
    }
    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Node removedNode = top;
        top = top.next;
        if (top != null) {
            top.prev = null;
        }
        size--;
        return removedNode.data;
    }
    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = getNode(index);

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            top = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        size--;
    }
    public void clear() {
        top = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    private Node getNode(int index) {
        Node current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("First");
        stack.push("Second");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("Size: " + stack.size());

        stack.push("Third");
        stack.push("Fourth");
        stack.remove(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());

        stack.clear();
        System.out.println("Size: " + stack.size());
    }
}

