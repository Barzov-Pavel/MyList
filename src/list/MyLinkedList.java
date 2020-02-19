package list;

public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private Node<T> first;

    @Override
    public void add(T value) {
        if (size == 0) {
            first = new Node<>();
            first.setItem(value);
            size++;
        } else {
            Node<T> current;
            if (first.hasNext()) {
                current = first.getNext();
                while (current.hasNext()) {
                    current = current.getNext();
                }
                current.setNext(new Node<>(value));
                size++;
            } else {
                first.setNext(new Node<>(value));
                size++;
            }
        }
    }

    @Override
    public void delete(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node<T> current = first;
            Node<T> next;
            Node<T> prev = first;
            if (index == 0) {
                first = first.getNext();
                size--;
            } else {
                for (int i = 0; i < index; i++) {
                    if (current.hasNext()) {
                        prev = current;
                        current = current.getNext();
                    } else {
                        first = null;
                    }
                }
                prev.setNext(current.getNext());
                size--;
            }
        }
    }

    @Override
    public T get(int index) {
        Node<T> current;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size > 0 && index == 0) {
            return first.getItem();
        } else {
            if (first.hasNext()) {
                current = first.getNext();
                for (int i = 1; i < index; i++) {
                    if (current.hasNext()) {
                        current = current.getNext();
                    } else {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    return current.getItem();
                }
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        return current.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            sb = sb.append(current.getItem().toString() + ",");
            current = current.getNext();
        }

        sb = sb.deleteCharAt(sb.lastIndexOf(","));
        sb = sb.append("]");
        return sb.toString();
    }

    private class Node<T> {
        private T item;
        private Node<T> next;

        public Node() {
        }

        public Node(T item) {
            this.item = item;
        }

        public boolean hasNext() {
            if (next != null) {
                return true;
            } else {
                return false;
            }
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
