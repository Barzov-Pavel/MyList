package list;

public interface MyList<T> {
    void add(T value);

    void delete(int index);

    T get(int index);

    int size();
}
