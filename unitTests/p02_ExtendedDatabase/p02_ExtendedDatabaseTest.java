package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class p02_ExtendedDatabaseTest {

    private static final Person[] PEOPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C")};
    private Database database;

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void when_correctElementsArePassed_then_createDatabaseInstance() throws OperationNotSupportedException {
        Assert.assertEquals("Elements count is not correct!", PEOPLE.length, database.getElements().length);
        Person[] databaseElements = database.getElements();
        Assert.assertArrayEquals(PEOPLE, databaseElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsLessThan1ToConstructor_then_OperationNotSupportedException() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsMoreThan16ToConstructor_then_OperationNotSupportedException() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    // add

    @Test(expected = OperationNotSupportedException.class)
    public void when_nullElementPassedToAdd_then_OperationNotSupportedException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void when_elementPassedToAdd_then_elementAddedOnLastIndex() throws OperationNotSupportedException {
        Person element = new Person(4, "D");
        database.add(element);
        Person[] databaseElements = database.getElements();
        Assert.assertEquals(PEOPLE.length + 1, databaseElements.length);
        Person actualPerson = databaseElements[databaseElements.length - 1];
        Assert.assertEquals(element.getId(), actualPerson.getId());
        Assert.assertEquals(element.getUsername(), actualPerson.getUsername());
    }

    // remove

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsArrIsEmpty_then_OperationNotSupportedException() throws OperationNotSupportedException {
        Database database = new Database(new Person(15, "a"));
        database.remove();
        database.remove();
    }

    @Test
    public void when_remove_then_lastElementRemoved() throws OperationNotSupportedException {
        database.remove();
        Person[] databaseElements = database.getElements();
        Assert.assertEquals(PEOPLE.length - 1, databaseElements.length);
        Person expectedPerson = PEOPLE[PEOPLE.length - 2];
        Person actualPerson = databaseElements[databaseElements.length - 1];
        Assert.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assert.assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    // findByUsername

    @Test(expected = OperationNotSupportedException.class)
    public void when_findPersonByUsernameNull_then_OperationNotSupportedException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_findPersonByUsernameInEmptyArr_then_OperationNotSupportedException() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findByUsername(PEOPLE[1].getUsername());
    }

    @Test
    public void when_findPersonByUsernameValidNamePassed_then_returnPerson() throws OperationNotSupportedException {
        Person person = database.findByUsername(PEOPLE[2].getUsername());
        Assert.assertEquals(person.getId(), PEOPLE[2].getId());
        Assert.assertEquals(person.getUsername(), PEOPLE[2].getUsername());
    }

    // findById

    @Test(expected = OperationNotSupportedException.class)
    public void when_findPersonByIdInEmptyArr_then_OperationNotSupportedException() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findById(PEOPLE[1].getId());
    }

    @Test
    public void when_findPersonByIdValidIdPassed_then_returnPerson() throws OperationNotSupportedException {
        Person person = database.findById(PEOPLE[2].getId());
        Assert.assertEquals(person.getId(), PEOPLE[2].getId());
        Assert.assertEquals(person.getUsername(), PEOPLE[2].getUsername());
    }
}
