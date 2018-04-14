import main.ArrayList;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ListTest {

    private ArrayList<Integer> testIntAry;
    private ArrayList<Integer> afterInsertAry;
    private ArrayList<Integer> afterDeleteAry;



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

        Integer tempDelete[] = new Integer[5];
        tempDelete[0] = 0;
        tempDelete[1] = 1;
        tempDelete[2] = 3;


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
        assertEquals(afterInsertAry, testIntAry);
    }

    @Test
    public void testDelete() {
        //Positiver Fall
        testIntAry.delete(2);
        assertEquals(afterDeleteAry,testIntAry);
    }

    @Test
    public void testTouch() {
        //Positiver Fall
    }

    @Test
    public void testClear() {
        //Positiver Fall
        testIntAry.clear();
        assertEquals(new ArrayList<Integer>(),testIntAry);
    }

    @Test
    public void testConcat() {
        //Positiver Fall
    }

    @Test
    public void testSubstitute() {
        //Positiver Fall
    }
}
