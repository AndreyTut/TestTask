public class AList {

    private int size = 0;
    private Object[] storage;

    public AList() {
        storage = new Object[16];
    }

    public AList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity can not be <0");
        }
        storage = new Object[initialCapacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Object e) {
        if (size < storage.length) {
            storage[size] = e;
        } else {
            Object[] newStor = new Object[(int) (storage.length * 1.5)];
            System.arraycopy(storage, 0, newStor, 0, size);
            storage = newStor;
            storage[size] = e;
        }
        size++;
    }

    public void add(int index, Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (size == storage.length) {
            Object[] newStor = new Object[(int) (storage.length * 1.5)];
            System.arraycopy(storage, 0, newStor, 0, size);
            storage = newStor;
        }
        for (int i = size - 1; i >= index; i--) {
            storage[i + 1] = storage[i];
        }
        storage[index] = e;
        size++;
    }

    public Object get(int index) {
        return storage[index];
    }

    public void set(int index, String e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (index < size) {
            storage[index] = e;
            return;
        }
        if (index > storage.length - 1) {
            Object[] newStor = new Object[(int) (index * 1.5)];
            System.arraycopy(storage, 0, newStor, 0, size);
            storage = newStor;
        }
        storage[index] = e;
        size = index + 1;
    }

    public Object remove(int index) {
        if (index < size) {
            Object toReturn = storage[index];
            storage[index] = null;
            size--;
            return toReturn;
        }
        throw new IndexOutOfBoundsException(index);
    }
}