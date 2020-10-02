package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenArrayIt implements Iterator<Integer> {

    private int point = 0;
    private int[] data;

    EvenArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean b = false;
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                b = true;
                point = i;
                break;
            }
        }
        return b;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
