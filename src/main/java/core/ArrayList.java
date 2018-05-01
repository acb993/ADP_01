package core;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {

    private T elements[];

    public ArrayList() {
        this.elements = (T[]) new Object[0];
    }//"Karsten ist haesslich" - Michel Kapell 2018


    public ArrayList(T array[]) {
        this.elements = (T[]) new Object[0];
        for (int i = 0; i < array.length ; i++) {
            this.insert(array[i],i);
        }
    }

    public int length() {
        return elements.length;
    }

    public void insert(T elem, int pos) throws IllegalArgumentException {
        if (elem == null || pos > length() || pos < 0) {
            throw new IllegalArgumentException();
        }


        T temp[] = (T[]) new Object[length() + 1];

        for (int i = 0; i <= elements.length; i++) {

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
        if (pos >= length() || pos < 0) {
            throw new IllegalArgumentException();
        }

        T temp[] = (T[]) new Object[this.length() - 1];

        for (int i = 0; i <= temp.length; i++) {

            if (i > pos) {
                temp[i - 1] = elements[i];
            } else if (i < pos) {
                temp[i] = elements[i];
            }
        }


        elements = temp;
        System.out.println(this.toString());
    }

    public T touch(int pos) throws IllegalArgumentException {
        if (pos >= length() || pos < 0) {
            throw new IllegalArgumentException();
        }

        return elements[pos];
    }

    public void clear() {
        elements = (T[]) new Object[0];
    }

    public List<T> concat(List<T> otherList) throws IllegalArgumentException {
        if (otherList == null) {
            throw new IllegalArgumentException();
        }

        T temp[] = (T[]) new Object[this.length() + otherList.length()];

        for (int i = 0; i < temp.length; i++) {
            if (i < length()) {
                temp[i] = elements[i];
            } else {
                temp[i] = otherList.touch(i-length());
            }
        }

        elements = temp;
        return this;
    }

    public List<T> substitute(int start, int end) throws IllegalArgumentException {
        if (start >= length() || start < 0 || end >= length()) {
            throw new IllegalArgumentException();
        }

        int anzahlEntfernteElems = end-start+1;

        T temp[] = (T[]) new Object[this.length() - anzahlEntfernteElems];
        T subTemp[] = (T[]) new Object[anzahlEntfernteElems];

        for (int i = 0; i < this.length(); i++) {
            if (i < start) {
                temp[i] = elements[i];
            } else if (i > end) {
                temp[i - (end)] = elements[i];
            } else
                subTemp[i - start] = elements[i];
        }
        elements = temp;

        return new ArrayList<T>(subTemp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;

        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(elements);
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
