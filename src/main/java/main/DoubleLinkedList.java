package main;


public class DoubleLinkedList<T> implements List<T> {

    private Element head;
    private Element tail;

    DoubleLinkedList() {
        head = null;
        tail = null;
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

    private Element getElement(int pos){
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
        return  returnValue;
    }


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


    public void delete(int pos) throws IllegalArgumentException {
        if(pos>=length()){
            throw new IllegalArgumentException();
        }

    }

    public T touch(int pos) throws IllegalArgumentException {
      //  return getElement(pos).getValue();
        return null;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public List<T> substitute(int start, int end) throws IllegalArgumentException {
        return null;
    }


    public List<T> concat(List otherList) throws IllegalArgumentException {
        return null;
    }


    private class Element<T> {
        private Element next;
        private Element prev;
        private T value;

        Element(T value){
            this.value=value;
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
}
