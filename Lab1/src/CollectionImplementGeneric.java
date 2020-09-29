
public class CollectionImplementGeneric {
    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<Integer>();
        s.Push(1);
        s.Push(2);
        s.Push(3);
        s.Push(4);
        s.Push(5);
        System.out.println(s.Pop());
        System.out.println(s.Pop());
        System.out.println(s.Pop());
        System.out.println(s.Pop());
        System.out.println(s.Peek());
        System.out.println(s.Pop());
        System.out.println(s.Pop());
        s.Push(9);
        System.out.println(s.Pop());



    }
}

    class MyArrayList<T> {
        int capacity;
        T arr[];
        int length = 0;

        public MyArrayList(int capacity) {
            this.capacity = capacity;
            arr = (T[]) new Object[capacity];
        }

        public MyArrayList() {
            this.capacity = 8;
            arr = (T[]) new Object[capacity];
        }

        public void add(T item) {
            if (length < capacity)
                arr[length++] = item;
            else {
                capacity += 8;
                T arr1[] = (T[]) new Object[capacity];
                for (int i = 0; i < length; i++)
                    arr1[i] = arr[i];
                arr1[length++] = item;
                arr = arr1;
            }
        }

        public boolean remove(T o) {
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
            if (pos < 0 || pos >= length)
                return false;
            for (int i = pos; i < length; i++) {
                arr[i] = arr[i + 1];
            }
            length--;
            return true;
        }

        public boolean contains(Object o) {
            for (int i = 0; i < length; i++) {
                if (o.equals(arr[i])) ;
            }
            return false;
        }

        public Object[] ToArray() {
            return arr;
        }
    }

    class Node<T> {
        public T val;
        public Node next;

        public Node(T val) {
            this.val = val;
            next = null;
        }
    }

    class MyLinkedList<T> {
        Node<T> Head = null;
        Node<T> Last = null;
        int size = 0;

        public MyLinkedList() {
        }

        public void add(T item) {
            if (Head == null) {
                Head = new Node<T>(item);
                Last = Head;
            } else {
                Last.next = new Node<T>(item);
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

        public boolean remove(T o) {
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

        public boolean contains(T o) {
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

        public T[] toArray() {
            T[] arr = (T[])new Object[size];
            int i = 0;
            Node<T> h = Head;
            while (h != null) {
                arr[i++] = h.val;
                h = h.next;
            }
            return arr;

        }
    }

    class MyQueue<T> {
        Node<T> Head = null;
        Node<T> Tile = null;
        public int Size = 0;

        public void Enqueue(T item) {
            if (Head == null) {
                Head = new Node<T>(item);
                Tile = Head;
            } else {
                Tile.next = new Node<T>(item);
                Tile = Tile.next;
            }
            Size++;
        }

        public Object Dequeue() {
            if (Head == null)
                return null;
            Node<T> r = Head;
            Head = Head.next;
            Size--;
            return r.val;

        }

        public Object Peek() {
            return Head.val;
        }
    }

    class MyStack<T> {
        Node<T> Head;
        Node<T> Tile;
        public int Size;

        public void Push(T item) {
            if (Head == null) {
                Head = new Node<T>(item);
                Tile = Head;
            } else {
                Node<T> n = new Node<T>(item);
                n.next = Tile;
                Tile = n;
            }
            Size++;
        }

        public Object Pop() {
            if (Head == null)
                return null;
            Node<T> r;
            if (Tile.next == null) {
                r = Tile;
                Tile = Head = null;
            } else {
                r = Tile;
                Tile = Tile.next;
            }
            return r.val;
        }

        public T Peek() {
            if (Tile == null)
                return null;
            return Tile.val;
        }
    }
