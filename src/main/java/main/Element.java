package main.java.main;

public class Element<T> {
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

    public void setNext(Element next) {
        this.next = next;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }
}
