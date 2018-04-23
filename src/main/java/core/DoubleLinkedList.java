package core;


import java.util.Arrays;

public class DoubleLinkedList<T> implements List<T> {

    private Element head;
    private Element tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public DoubleLinkedList(T array[]) {
        for (int i = 0; i < array.length; i++) {
            this.insert(array[i], i);
        }
    }

    public int length() {
        int counter = 0;
        Element next = head;

        while (next != null) {
            counter++;
            next = next.getNext();
        }

        return counter;
    }

    private Element getElement(int pos) {
        int length = length();
        Element returnValue;
        if (pos > (length / 2)) {
            returnValue = tail;
            for (int i = length; i > pos; i--) {
                returnValue = returnValue.getPrev();
            }
        } else {
            returnValue = head;
            for (int i = 0; i < pos; i++) {
                returnValue = returnValue.getNext();
            }
        }
        return returnValue;
    }


    public void insert(T elem, int pos) throws IllegalArgumentException {
        int length = length();
        Element newElement = new Element<T>(elem);
        Element mem;
        if (elem == null || pos > length || pos < 0 || (head != null && head.getValue().getClass() != elem.getClass())) {
            throw new IllegalArgumentException();
        }
        if (head == null) {
            head = newElement;
            tail = head;
        } else if (pos == length) {
            mem = getElement(pos - 1);
            mem.setNext(newElement);
            newElement.setPrev(mem);
            tail = newElement;
        } else {
            mem = getElement(pos);
            newElement.setNext(mem);
            newElement.setPrev(mem.getPrev());
            mem.setPrev(newElement);
            newElement.getPrev().setNext(newElement);
        }
    }


    public void delete(int pos) throws IllegalArgumentException {
        if (pos >= length()) {
            throw new IllegalArgumentException();
        }

    }

    public T touch(int pos) throws IllegalArgumentException {
        return (T) getElement(pos).getValue(); //Karsten ist haesslich
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public List<T> substitute(int start, int end) throws IllegalArgumentException {
        if (0 > start || start >= end || end >= length()) {
            throw new IllegalArgumentException();
        }
        int anzahlElem = end - start;
        List<T> returnValue = new DoubleLinkedList<T>();
        Element temp = getElement(start);
        Element vorStart = temp.getPrev();
        returnValue.insert((T) temp.getValue(), 0);

        if (start == 0) {

            for (int i = 1; i <= anzahlElem; i++) {
                temp = temp.getNext();
                returnValue.insert((T) temp.getValue(), i);
            }
            head = temp.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            temp.setNext(null);
        } else {
            for (int i = 1; i <= anzahlElem; i++) {
                temp = temp.getNext();
                returnValue.insert((T) temp.getValue(), i);
                vorStart.setNext(temp);
                temp.setPrev(vorStart);
            }
        }

        return returnValue;
    }

    // fehler muessen noch abgefangen werden.

    public List<T> concat(List otherList) throws IllegalArgumentException {
        if (otherList == null || otherList.touch(0).getClass() != this.touch(0).getClass()) {
            throw new IllegalArgumentException();
        }
        int lengthOtherList = otherList.length();


        for (int i = 0; i < lengthOtherList; i++) {
            insert((T) otherList.touch(i), length());
        }


        return this;
    }


    private class Element<T> {
        private Element next;
        private Element prev;
        private T value;

        Element(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Element getPrev() {
            return prev;
        }

        public Element getNext() {
            return next;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        public void setNext(Element next) {
            this.next = next;
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleLinkedList)) return false;

        DoubleLinkedList<?> that = (DoubleLinkedList<?>) o;

        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        int length = this.length();
        T[] arrayList = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            arrayList[i] = (T) this.getElement(i).getValue();
        }

        return Arrays.deepHashCode(arrayList);
    }
}
