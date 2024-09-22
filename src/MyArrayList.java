import java.util.Arrays;

public class MyArrayList<T> {
    private T[] collection;
    private int currentSize;
    private final int DEFAULT_CAPACITY = 10;
    private final int ADDITIONAL_CAPACITY = 5;

    public MyArrayList() {
        currentSize = 0;
        this.collection = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int size) {
        currentSize = 0;
        this.collection = (T[]) new Object[size];
    }

    public void remove(int index) {
        if(index == currentSize - 1){
            this.collection[index] = null;
            this.currentSize--;
            return;
        }
        T[] tmp = (T[]) new Object[currentSize];
        for (int counter = 0, i = 0; counter < currentSize; counter++){
            if(counter == index){
                i++;
            }
            if((counter + 1) == currentSize)
                break;
            tmp[counter] = this.collection[counter + i];
        }
        this.collection = tmp;
        this.currentSize--;
    }

    public void remove(T element) {
        int index = getIndex(element);
        if (index == -1){
            System.out.println("No element to delete...");
        } else remove(index);
    }

    public void add(T element) {
        if (currentSize >= collection.length) {
            extendCapacity();
        }
        this.collection[currentSize] = element;
        this.currentSize++;
    }

    private void extendCapacity() {
        this.collection = Arrays.copyOf(this.collection, this.collection.length + ADDITIONAL_CAPACITY);
    }

    public void showList() {
        for (T element : this.collection) {
            if (element == null)
                return;
            System.out.println(element);
        }
    }

    public int getSize() {
        return currentSize;
    }

    public T getElement(int index) {
        return this.collection[index];
    }

    public int getIndex(T element) {
        for (int counter = 0; counter < this.currentSize; counter++) {
            if (this.collection[counter].equals(element))
                return counter;
        }
        return -1;
    }

    public boolean isInCollection(T element) {
        int index = getIndex(element);
        return index != -1;
    }

    public void clearList() {
        this.collection = (T[]) new Object[DEFAULT_CAPACITY];
        this.currentSize = 0;
    }
}
