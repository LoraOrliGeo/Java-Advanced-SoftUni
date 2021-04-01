package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    //refactoring
    private static final Integer[] ELEMENTS = new Integer[]{4, 6, 19, 32, 5};
    private Database database;

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    // constructor
        // creates correct Database object -> elements and their count
        // elements validation (setElements() -> 2 tests: >16, <1)
    // add()
    // remove()
    // getElements()

    @Test
    public void when_correctElementsArePassed_then_createDatabaseInstance() throws OperationNotSupportedException {
        // arrange
//        Integer[] elements = ;
        // act
//        Database database = new Database(ELEMENTS);
        // assert
        // elements count
        Assert.assertEquals("Elements count is not correct!", ELEMENTS.length, database.getElements().length);
        // elements - same values
        Integer[] databaseElements = database.getElements();
        Assert.assertArrayEquals(ELEMENTS, databaseElements); // or for loop and assert for each element
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsLessThan1ToConstructor_then_OperationNotSupportedException() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsMoreThan16ToConstructor_then_OperationNotSupportedException() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    // add

    @Test(expected = OperationNotSupportedException.class)
    public void when_nullElementPassedToAdd_then_OperationNotSupportedException() throws OperationNotSupportedException {
        // duplicate code for database creation, then refactor
//        Integer[] elements = new Integer[]{4, 6, 19, 32, 5};
//        Database database = new Database(ELEMENTS);
        database.add(null);
    }

    @Test
    public void when_elementPassedToAdd_then_elementAddedOnLastIndex() throws OperationNotSupportedException {
//        Integer[] elements = new Integer[]{4, 6, 19, 32, 5};
//        Database database = new Database(ELEMENTS);
        int element = 15;
        database.add(element);
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(ELEMENTS.length + 1, databaseElements.length);
        Assert.assertEquals(Integer.valueOf(element), databaseElements[databaseElements.length - 1]);
    }

    // remove

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsArrIsEmpty_then_OperationNotSupportedException() throws OperationNotSupportedException {
        Database database = new Database(1);
        database.remove();
        database.remove();
    }

    @Test
    public void when_remove_then_lastElementRemoved() throws OperationNotSupportedException {
//        Database database = new Database(ELEMENTS);
        database.remove();
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(ELEMENTS.length - 1, databaseElements.length);
        Assert.assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);
    }
}
