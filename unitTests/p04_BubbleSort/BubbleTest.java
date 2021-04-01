package p04_BubbleSort;

import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleTest {

    @Test
    public void when_notOrderedArrayPassed_then_arraySortedAsc() {
        int[] array = new int[]{3, 5, -2, 16, 43, 12};
        Bubble.sort(array);
        int[] expectedArray = new int[]{-2, 3, 5, 12, 16, 43};
        Assert.assertArrayEquals(expectedArray, array);
    }
}
