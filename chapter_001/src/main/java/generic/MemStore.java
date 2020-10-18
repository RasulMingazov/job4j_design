package generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean b = false;
        for (int i = 0; i < mem.size(); i++) {
            if (id.equals(mem.get(i).getId())) {
                mem.set(i, model);
                b = true;
                break;
            }
        }
        return b;
    }

    @Override
    public boolean delete(String id) {
        boolean b = false;
        for (int i = 0; i < mem.size(); i++) {
            if (id.equals(mem.get(i).getId())) {
                mem.remove(i);
                b = true;
                break;
            }
        }
        return b;
    }

    @Override
    public T findById(String id) {
        T t = null;
        for (int i = 0; i < mem.size(); i++) {
            if (id.equals(mem.get(i).getId())) {
                t = mem.get(i);
               break;
            }
        }
        return t;
    }
}