package main.java.main;

import main.List;

public class DoubleLinkedList<T> implements List<T> {

    private Element head;
    private Element tail;

    DoubleLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public int length() {
        int counter = 0;
        Element next = head;

        while (next != null) {
            counter++;
            next = next.getNext();
        }

        return counter;
    }

    private Element getElement(int pos){
        int length = length();
        Element returnvalue;
        if (pos > (length / 2)) {
            returnvalue = tail;
            for (int i = length; i > pos; i--) {
                returnvalue = returnvalue.getPrev();
            }
        } else {
            returnvalue = head;
            for (int i = 0; i < pos; i++) {
                returnvalue = returnvalue.getNext();
            }
        }
        return  returnvalue;
    }

    @Override
    public void insert(T elem, int pos) throws IllegalArgumentException {
        int length = length();
        Element newElement = new Element<T>(elem);
        Element mem;
        if (pos > length|| (head!=null && head.getValue().getClass()==elem.getClass())) {
            throw new IllegalArgumentException();
        }
        if (head == null) {
            head = newElement;
            tail = head;
        } else {
            mem = getElement(pos);
            newElement.setNext(mem);
            newElement.setPrev(mem.getPrev());
            mem.setPrev(newElement);
            newElement.getPrev().setNext(newElement);

        }
    }

    @Override
    public void delete(int pos) throws IllegalArgumentException {

    }

    @Override
    public T touch(int pos) throws IllegalArgumentException {
        return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public List<T> substitute(int start, int end) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<T> concat(List otherList) throws IllegalArgumentException {
        return null;
    }


}
