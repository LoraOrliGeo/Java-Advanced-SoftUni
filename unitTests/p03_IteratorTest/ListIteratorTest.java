package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private static final String[] ELEMENTS = new String[]{"wood", "tree", "river"};
    private ListIterator listIterator;

    @Before
    public void prepareListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_nullElementsPassedToConstructor_then_OperationNotSupportedException() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void when_validElementsToListIteratorConstructor_then_moveReturnsCorrectBoolean() throws OperationNotSupportedException {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void when_validElementsToListIteratorConstructor_then_hasNextReturnsCorrectBoolean() throws OperationNotSupportedException {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void when_emptyListIterator_then_IllegalStateException() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void when_elementsInListIterator_then_print() throws OperationNotSupportedException {
        for (int i = 0; listIterator.hasNext(); listIterator.move(), i++) {
            Assert.assertEquals(ELEMENTS[i], listIterator.print());
        }
    }
}
