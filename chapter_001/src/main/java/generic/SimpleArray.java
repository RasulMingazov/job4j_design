package generic;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    Object[] array;
    int size;
    int point;

    public SimpleArray(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    void add(T model) {
        Objects.checkIndex(point, size);
        array[point++] = model;
    }

    T get(int i) {
        Objects.checkIndex(i, size);
        return (T) array[i];
    }

    public void set(int i, T model) {
        Objects.checkIndex(i, size);
        array[i] = model;
    }

    public void remove(int i) {
        Objects.checkIndex(i + 1, point);
        System.arraycopy(array, i + 1, array, i, array.length - 1 - i);
        array[array.length - 1] = null;
        point--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return point < array.length;
            }

            @Override
            public T next() {
                if (!iterator().hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[point++];
            }
        };
    }
}
