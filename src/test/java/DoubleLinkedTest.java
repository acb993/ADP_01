import core.ArrayList;
import core.DoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleLinkedTest {
    private DoubleLinkedList<Integer> arrayListTestAry;
    private DoubleLinkedList<Integer> arrayListEmptyAry;
    private DoubleLinkedList<Object> arrayListNullAry;

    @BeforeEach
    public void setUp() throws Exception {
        //Initialisierung für die ArrayList Implementation
        Integer arrayListTest[] = new Integer[4];
        arrayListTest[0] = 0;
        arrayListTest[1] = 1;
        arrayListTest[2] = 2;
        arrayListTest[3] = 3;
        arrayListTestAry = new DoubleLinkedList<Integer>(arrayListTest);

        Object arrayListNull[] = new Object[4];
        arrayListNull[0] = null;
        arrayListNull[1] = null;
        arrayListNull[2] = null;
        arrayListNull[3] = null;
        arrayListNullAry = new DoubleLinkedList<Object>(arrayListNull);

        arrayListEmptyAry = new DoubleLinkedList<Integer>();
    }

    @Test
    public void testLength() throws Exception {
        //Positiver Fall
        Assertions.assertEquals(4, arrayListTestAry.length());

        //Grenzfälle (Leeres Ary & Ary mit null als Inhalt)
        Assertions.assertEquals(0, arrayListEmptyAry.length());
        Assertions.assertEquals(4, arrayListNullAry.length());
    }

    @Test
    public void testInsert() throws Exception {
        //Positiver Fall
        Integer expectedResult[] = new Integer[5];
        expectedResult[0] = 0;
        expectedResult[1] = 1;
        expectedResult[2] = 2;
        expectedResult[3] = 8;
        expectedResult[4] = 3;
        DoubleLinkedList<Integer> expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);

        arrayListTestAry.insert(8, 3);
        Assertions.assertTrue(expectedResultAry.equals(arrayListTestAry));


        //Negativer Fall (null,unter den Index und darüber)
        try {
            arrayListTestAry.insert(null, 2);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            arrayListTestAry.insert(7, -1);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            arrayListTestAry.insert(7, 6);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }


        //Grenzfall (geringster und höchster Index)
        expectedResult = new Integer[6];
        expectedResult[0] = 9;
        expectedResult[1] = 0;
        expectedResult[2] = 1;
        expectedResult[3] = 2;
        expectedResult[4] = 8;
        expectedResult[5] = 3;
        expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);
        arrayListTestAry.insert(9, 0);
        Assertions.assertTrue(expectedResultAry.equals(arrayListTestAry));

        expectedResult = new Integer[7];
        expectedResult[0] = 9;
        expectedResult[1] = 0;
        expectedResult[2] = 1;
        expectedResult[3] = 2;
        expectedResult[4] = 8;
        expectedResult[5] = 3;
        expectedResult[6] = 12;
        expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);
        arrayListTestAry.insert(12, 6);
        Assertions.assertTrue(expectedResultAry.equals(arrayListTestAry));
    }

    @Test
    public void testDelete() throws Exception {
        Integer expectedResult[] = new Integer[3];
        expectedResult[0] = 0;
        expectedResult[1] = 1;
        expectedResult[2] = 2;
        DoubleLinkedList<Integer> expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);

        arrayListTestAry.delete(3);
        Assertions.assertTrue(expectedResultAry.equals(arrayListTestAry));


        //Negativer Fall (unter den Index und darüber)
        try {
            arrayListTestAry.delete(-1);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            arrayListTestAry.delete(3);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }


        //Grenzfall (geringster und höchster Index)
        expectedResult = new Integer[2];
        expectedResult[0] = 1;
        expectedResult[1] = 2;
        expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);
        arrayListTestAry.delete(0);
        Assertions.assertTrue(expectedResultAry.equals(arrayListTestAry));

        expectedResult = new Integer[1];
        expectedResult[0] = 1;
        expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);
        arrayListTestAry.delete(1);
        Assertions.assertTrue(expectedResultAry.equals(arrayListTestAry));
    }

    @Test
    public void testTouch() throws Exception {
        //Positiver Fall
        Integer temp = 2;
        Assertions.assertEquals(temp, arrayListTestAry.touch(2));

        //Negativer Fall
        try {
            arrayListTestAry.touch(-1);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            arrayListTestAry.touch(4);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }


        //Grenzfall
        temp = 0;
        Assertions.assertEquals(temp, arrayListTestAry.touch(0));
        temp = 3;
        Assertions.assertEquals(temp, arrayListTestAry.touch(3));
    }

    @Test
    public void testClear() throws Exception {
        //Positiver Fall
        arrayListTestAry.clear();
        Assertions.assertTrue(new DoubleLinkedList<Integer>().equals(arrayListTestAry));

        //Grenzfall (leeres Array || Null gefülltes Array)
        arrayListEmptyAry.clear();
        Assertions.assertTrue(new DoubleLinkedList<Integer>().equals(arrayListEmptyAry));

        arrayListNullAry.clear();
        Assertions.assertTrue(new DoubleLinkedList<Integer>().equals(arrayListNullAry));
    }

    @Test
    public void testConcat() throws Exception {
        //Positiver Fall
        Integer expectedResult[] = new Integer[7];
        expectedResult[0] = 0;
        expectedResult[1] = 1;
        expectedResult[2] = 2;
        expectedResult[3] = 3;
        expectedResult[4] = 4;
        expectedResult[5] = 5;
        expectedResult[6] = 6;
        DoubleLinkedList<Integer> expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);

        Integer temp[] = new Integer[3];
        temp[0] = 4;
        temp[1] = 5;
        temp[2] = 6;
        DoubleLinkedList<Integer> tempAry = new DoubleLinkedList<Integer>(temp);

        arrayListTestAry.concat(tempAry);
        Assertions.assertTrue(arrayListTestAry.equals(expectedResultAry));


        //Negativer Fall
        try {
            arrayListTestAry.concat(null);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        //Grenzfall

        expectedResult = new Integer[7];
        expectedResult[0] = 0;
        expectedResult[1] = 1;
        expectedResult[2] = 2;
        expectedResult[3] = 3;
        expectedResult[4] = 4;
        expectedResult[5] = 5;
        expectedResult[6] = 6;
        expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);
        arrayListTestAry.concat(arrayListEmptyAry);
        Assertions.assertTrue(arrayListTestAry.equals(expectedResultAry));

        expectedResult = new Integer[11];
        expectedResult[0] = 0;
        expectedResult[1] = 1;
        expectedResult[2] = 2;
        expectedResult[3] = 3;
        expectedResult[4] = 4;
        expectedResult[5] = 5;
        expectedResult[6] = 6;
        expectedResult[7] = null;
        expectedResult[8] = null;
        expectedResult[9] = null;
        expectedResult[10] = null;
        expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);
        arrayListTestAry.concat(arrayListNullAry);
        Assertions.assertTrue(arrayListTestAry.equals(expectedResultAry));
    }

    @Test
    public void testSubstitute() throws Exception {
        //Positiver Fall
        Integer expectedResult[] = new Integer[2];
        expectedResult[0] = 0;
        expectedResult[1] = 3;
        DoubleLinkedList<Integer> expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);

        arrayListTestAry.substitute(1, 2);
        Assertions.assertTrue(expectedResultAry.equals(arrayListTestAry));


        //Negativer Fall (unter den Index und darüber)
        try {
            arrayListTestAry.substitute(-1, 1);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            arrayListTestAry.substitute(-1, 2);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            arrayListTestAry.substitute(0, 2);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }


        //Grenzfall (geringster und höchster Index)
        expectedResultAry = new DoubleLinkedList<Integer>(expectedResult);
        arrayListTestAry.substitute(0, 1);
        Assertions.assertTrue(new DoubleLinkedList<Integer>().equals(arrayListTestAry));
    }
}
