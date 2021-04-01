package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<String> customLinkedList;

    @Before
    public void prepareCustomLinkedList() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("X");
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_emptyLinkedList_then_getShouldThrowException() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_indexGreaterThanElements_then_getShouldThrowException() {
        customLinkedList.get(3);
    }

    @Test
    public void when_elementsInLinkedListAndValidIndex_then_getShouldWorksCorrect() {
        Assert.assertEquals("X", customLinkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_emptyLinkedListInvalidIndex_then_setShouldThrowException() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.set(5, "Y");
    }

    @Test
    public void when_validIndex_then_setShouldSetElementOnIndex() {
        customLinkedList.set(0, "Y");
        Assert.assertEquals("Y", customLinkedList.get(0));
    }

    @Test
    public void when_addElementToNotEmptyList_then_elementAppended() {
        customLinkedList.add("Z");
        Assert.assertEquals("Z", customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_removeAtOnEmptyList_then_throwException() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.removeAt(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_removeAtInvalidIndex_then_throwException(){
        customLinkedList.removeAt(5);
    }
}
