import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {

    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int k = 0;
        for (int i = row; i < data.length; i++) {
                if (data[i].length == 0) {
                    k++;
                }
            }
        if (data.length == k) {
            return false;
        }
        return (column < data[row].length || row != data.length - 1);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            if (column >= data[row].length) {
                row++;
                column = 0;
            }
            try {
            return data[row][column++];
            } catch (IndexOutOfBoundsException e) {
               return next();
            }
        }
    }
}