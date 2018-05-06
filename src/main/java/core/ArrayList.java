package core;

import java.util.Arrays;
/***
 * Die Klasse ArrayList verwendet das Interface List<T> um einen ADT in der gestallt einer Liste zu konstruieren.
 *
 *
 *
 * @param <T>
 ***/
public class ArrayList<T> implements List<T> {

    private T elements[];

    public ArrayList() {
        this.elements = (T[]) new Object[0];
    }


    public ArrayList(T array[]) {
        this.elements = (T[]) new Object[0];
        for (int i = 0; i < array.length ; i++) {
            this.insert(array[i],i);
        }
    }

    public int length() {
        return elements.length;
    }
    /***
     * Einfügen an beliebiger (gültiger) Position
     *
     * insert: LIST x ELEM, POS -> LIST ∪ { error }; L.insert(x, p)
     * pre: p ∈ {p 0,...,p n}; x != null
     * post: Sei L = (a 0,...,a n) eine Liste
     *       Sei a i das Element an Position p i
     *       Dann bewirkt L.insert(x, p i) = (a 0,...,a i-1,x, a i, a i+1,...a n)
     *      0 <= pos <= length()
     * */
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
    /***
     * Löschen von beliebiger (gültiger) Position
     *
     * delete: LIST x POS -> LIST ∪ { error }; L.delete(p)
     * pre: p ∈ {p 0,...,p n}
     * post: Sei L = (a 0,...,a n) eine Liste
     *       Sei a i das Element an Position p i
     *       Dann bewirkt L.delete(p i) = (a 0,...,a i-1,a i+1,...,a n)
     *       0 <= pos < length()
     * */
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
   //     System.out.println(this.toString());
    }
    /***
     * Elementzugriff an beliebiger (gültiger) Position
     *
     * touch: LIST x POS -> ELEM ∪ { error }; L.touch(p)
     * pre: p ∈ {p 0,...,p n}
     * post: Sei L = (a 0,...,a n) eine Liste
     *       Sei a i das Element an Position p i
     *       Dann gibt L.touch(p i) das Element a i zurück
     *       0 <= pos < length()
     * */
    public T touch(int pos) throws IllegalArgumentException {
        if (pos >= length() || pos < 0) {
            throw new IllegalArgumentException();
        }

        return elements[pos];
    }

    /***
     * Zusammenfügen von zwei Listen
     *
     * concat: LIST x LIST -> LIST ∪ { error }; L1.concat(L2)
     * pre: L1 && L2 sind nicht null und müssen vom selben Typ sein
     * post: L1L2 ist eine neue Liste, in welcher die ersten Zeichen von
     *       L1 sind, gefolgt von denen von L2 (L1 wird geändert und L2
     *       L2 bleibt gleich)
     * */
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
    /***
     * Subliste extrahieren
     *
     * Operation: LIST x POS x POS -> LIST ∪ { error }; L.substitute(p 1,p 2)
     * pre: p 1 && p 2 ∈ {p 0,...,p n}
     * post: Sei L = (a 0,...,a n) eine Liste
     *       Dann gibt L.substitute(p n, p m) eine Liste zurück,
     *       welche alle Elemete zwischen den ursprünglichen Positionen
     *       (inklusive) p start und p end enthält. L wird um diese Elemente
     *       reduziert.
     *       0 <= start < end < length()
     * */
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
