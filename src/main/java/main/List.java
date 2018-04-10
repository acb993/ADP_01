package main;

public interface List<T> {

    /***
    * Abfrage der Anzahl der Elemente
    *
    * length: LIST -> INT; L.length()
    * pre: keine
    * post: Sei L = (a 0,...,a n) eine Liste,
    *       dann gibt L.length() n + 1 als Integer zurück.
    * */
    int length();

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
    void insert(T elem, int pos) throws IllegalArgumentException;

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
    void delete(int pos) throws IllegalArgumentException;

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
    T touch(int pos) throws IllegalArgumentException;

    /***
    * Leeren der Liste
    *
    * clear: LIST -> BOOLEAN; L.clear()
    * pre: keine
    * post: Sei L = (a 0,...,a n) eine Liste
    *       Dann bewirkt L.clear() = () und
    *       gibt einen Boolean zurück
    * */
    boolean clear();

    /***
    * Zusammenfügen von zwei Listen
    *
    * concat: LIST x LIST -> LIST ∪ { error }; L1.concat(L2)
    * pre: L1 && L2 sind nicht null und müssen vom selben Typ sein
    * post: L1L2 ist eine neue Liste, in welcher die ersten Zeichen von
    *       L1 sind, gefolgt von denen von L2 (L1 wird geändert und L2
    *       L2 bleibt gleich)
    * */
    List<T> concat(List<T> otherList) throws IllegalArgumentException;

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
    List<T> substitute(int start, int end) throws IllegalArgumentException;
}
