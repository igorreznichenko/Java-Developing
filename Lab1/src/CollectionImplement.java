import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionImplement {
    public static void main(String[] args) {

    }

    class MyArrayList {
        int capacity;
        Object arr[];
        int length = 0;

        public MyArrayList(int capacity) {
            this.capacity = capacity;
            arr = new Object[capacity];
        }

        public MyArrayList() {
            this.capacity = 8;
            arr = new Object[capacity];
        }

        public void add(Object item) {
            if (length < capacity)
                arr[length++] = item;
            else {
                capacity += 8;
                Object arr1[] = new Object[capacity];
                for (int i = 0; i < length; i++)
                    arr1[i] = arr[i];
                arr1[length++] = item;
                arr = arr1;
            }
        }

        public boolean remove(Object o) {
            for (int i = 0; i < length; i++) {
                if (arr[i].equals(o)) {
                    for (int j = i; j < length; j++)
                        arr[j] = arr[j + 1];
                    length--;
                    return true;
                }

            }
            return false;
        }

        public boolean remove(int pos) {
            if(pos < 0 || pos >= length)
                return false;
                for (int i = pos; i < length; i++) {
                    arr[i] = arr[i + 1];
                }
                length--;
                return true;


        }

        public boolean contains(Object o) {
            for (int i = 0; i < length; i++) {
                if (o.equals(arr[i]))
                    return true;
            }
            return false;
        }

        public Object[] ToArray() {
            return arr;
        }
    }

    class Node {
        public Object val;
        public Node next;

        public Node(Object val) {
            this.val = val;
            next = null;
        }
    }

    class MyLinkedList {
        Node Head = null;
        Node Last = null;
        int size = 0;

        public MyLinkedList() {
        }

        public void add(Object item) {
            if (Head == null) {
                Head = new Node(item);
                Last = Head;
            } else {
                Last.next = new Node(item);
                Last = Last.next;
            }
            size++;
        }

        public boolean remove(int index) {
            if (Head == null || index < 0 || index >=size)
                return false;
            if (index == 0) {
                Head = Head.next;
            } else {
                Node h = Head;
                int i = 1;
                while (i < index) {
                    h = h.next;
                    i++;
                }
                h.next = h.next.next;
            }
            size--;
            return true;
        }

        public boolean remove(Object o) {
            if (Head == null)
                return false;
            if (Head.val.equals(o)) {
                Head = Head.next;
            } else {
                Node h = Head;
                while (h.next != null && !h.next.val.equals(o))
                    h = h.next;
                if (h.next == null)
                    return false;
                h.next = h.next.next;
            }
            size--;
            return true;


        }

        public boolean contains(Object o) {
            Node h = Head;
            while (h != null && !h.val.equals(o))
                h = h.next;
            if (h != null)
                return true;
            return false;
        }

        public int size() {
            return size;
        }

        public Object[] toArray() {
            Object[] arr = new Object[size];
            int i = 0;
            Node h = Head;
            while (h != null) {
                arr[i++] = h.val;
                h = h.next;
            }
            return arr;

        }
    }

    class MyQueue {
        Node Head = null;
        Node Tile = null;
        public int Size = 0;

        public void Enqueue(Object item) {
            if (Head == null) {
                Head = new Node(item);
                Tile = Head;
            } else {
                Tile.next = new Node(item);
                Tile = Tile.next;
            }
            Size++;
        }

        public Object Dequeue() {
            if (Head == null)
                return null;
            Node r = Head;
            Head = Head.next;
            Size--;
            return r.val;

        }

        public Object Peek() {
            return Head.val;
        }
    }

    class MyStack {
        Node Head;
        Node Tile;
        public int Size;

        public void Push(Object item) {
            if (Head == null) {
                Head = new Node(item);
                Tile = Head;
            } else {
                Node n = new Node(item);
                n.next = Tile;
                Tile = n;
            }
            Size++;
        }

        public Object Pop() {
            if (Head == null)
                return null;
            Node r;
            if (Tile.next == null) {
                r = Tile;
                Tile = Head = null;
            } else {
                r = Tile;
                Tile = Tile.next;
            }
            return r.val;
        }

        public Object Peek() {
            if (Tile == null)
                return null;
            return Tile.val;
        }
    }
}