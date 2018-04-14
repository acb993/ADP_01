import core.ArrayList;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ListTest {

    private ArrayList<Integer> testIntAry;
    private ArrayList<Integer> afterInsertAry;
    private ArrayList<Integer> afterDeleteAry;
    private ArrayList<Integer> afterConcatAry;



    @Before
    public void setUp() {
        Integer temp[] = new Integer[4];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        temp[3] = 3;

        Integer tempInsert[] = new Integer[5];
        tempInsert[0] = 0;
        tempInsert[1] = 1;
        tempInsert[2] = 2;
        tempInsert[3] = 8;
        tempInsert[4] = 3;

        Integer tempDelete[] = new Integer[3];
        tempDelete[0] = 0;
        tempDelete[1] = 1;
        tempDelete[2] = 3;

        Integer tempConcat[] = new Integer[7];
        tempConcat[0] = 0;
        tempConcat[1] = 1;
        tempConcat[2] = 2;
        tempConcat[3] = 3;
        tempConcat[4] = 4;
        tempConcat[5] = 5;
        tempConcat[6] = 6;


        afterConcatAry = new ArrayList<Integer>(tempConcat);
        afterDeleteAry = new ArrayList<Integer>(tempDelete);
        afterInsertAry = new ArrayList<Integer>(tempInsert);
        testIntAry = new ArrayList<Integer>(temp);
    }

    @Test
    public void testLength() {
        //Positiver Fall
        assertEquals(4, testIntAry.length());
    }

    @Test
    public void testInsert() {
        //Positiver Fall
        testIntAry.insert(8,3);
        assertTrue(afterInsertAry.equals(testIntAry));
    }

    @Test
    public void testDelete() {
        //Positiver Fall
        testIntAry.delete(2);
        assertTrue(afterDeleteAry.equals(testIntAry));
    }

    @Test
    public void testTouch() {
        //Positiver Fall
        Integer temp = 0;
        assertEquals(temp, testIntAry.touch(0));
    }

    @Test
    public void testClear() {
        //Positiver Fall
        testIntAry.clear();
        assertTrue(new ArrayList<Integer>().equals(testIntAry));
    }

    @Test
    public void testConcat() {
        //Positiver Fall
        Integer tempConcat[] = new Integer[3];
        tempConcat[0] = 4;
        tempConcat[1] = 5;
        tempConcat[2] = 6;

        ArrayList<Integer> tempAry = new ArrayList<Integer>(tempConcat);
        testIntAry.concat(tempAry);
        assertTrue(testIntAry.equals(tempAry));
    }

    @Test
    public void testSubstitute() {
        ArrayList<Integer> tempAry;


    }
}
