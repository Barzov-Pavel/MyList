package list;


public class MyArrayList<T> implements MyList<T> {
    private int length = 0;
    private int capacity = 10;
    private T[] array;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[this.capacity];
    }

    public MyArrayList() {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (length < capacity) {
            array[length] = value;
            length++;
        } else {
            capacity *= 2;
            T[] buf = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++) {
                buf[i] = array[i];
            }
            array = buf;
            array[length] = value;
            length++;
        }
    }

    @Override
    public void delete(int index) {
        T[] buf = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < length; i++) {
            if (i == index) {
                continue;
            }
            buf[j] = array[i];
            j++;
        }
        length--;
        array = buf;
    }

    @Override
    public T get(int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb = sb.append(array[i] + ",");
        }

        sb = sb.deleteCharAt(sb.lastIndexOf(","));
        sb = sb.append("]");
        return sb.toString();
    }

    public int getCapacity() {
        return capacity;
    }
}
