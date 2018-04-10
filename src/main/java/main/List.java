package main;

public interface List<T> {

    int length();

    boolean insert(T elem, int pos) throws IllegalArgumentException;

    T delete(int pos) throws IllegalArgumentException;

    T touch(int pos) throws IllegalArgumentException;

    boolean clear();

    List<T> concat(List<T> otherList) throws IllegalArgumentException;

    List<T> substitute(List<T> subList) throws IllegalArgumentException;
}
