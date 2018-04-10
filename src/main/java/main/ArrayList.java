package main;

public class ArrayList<T> implements List<T> {

    private T elements[];

    public ArrayList() {
        this.elements = (T[]) new Object[0]; //"Karsten ist haesslich" - Michel Kapell 2018
    }

    public int length() {
        return elements.length;
    }

    public void insert(T elem, int pos) throws IllegalArgumentException {
        if (elem == null || pos > length()) {
            throw new IllegalArgumentException();
        }


        T[] temp = (T[]) new Object[this.length() + 1];

        for (int i = 0; i <= temp.length; i++) {

            if (i > pos) {
                temp[i] = elements[i - 1];
            } else if (i == pos) {
                temp[i] = elem;
            } else {
                temp[i] = elements[i];
            }
        }
        elements = temp;
    }

    public void delete(int pos) throws IllegalArgumentException {
        if (pos > length()) {
            throw new IllegalArgumentException();
        }

        T[] temp = (T[]) new Object[this.length() - 1];

        for (int i = 0; i <= temp.length; i++) {

            if (i > pos) {
                temp[i] = elements[i -1];
            } else if (i < pos) {
                temp[i] = elements[i];
            }
        }
        elements = temp;
    }

    public T touch(int pos) throws IllegalArgumentException {
        if (pos > length()) {
            throw new IllegalArgumentException();
        }

        return elements[pos];
    }

    public void clear() {
        elements = (T[]) new Object[0];
    }

    public List<T> concat(List<T> otherList) throws IllegalArgumentException {

        T[] temp = (T[]) new Object[this.length() + otherList.length()];

        for (int i = 0; i <= temp.length ; i++) {
            if (i <= length()){
                temp[i] = elements[i];
            } else {
                temp[i] = otherList.touch(i);
            }
        }

        elements = temp;
        return this;
    }

    public List<T> substitute(int start, int end) throws IllegalArgumentException {
        return null;
    }
}
