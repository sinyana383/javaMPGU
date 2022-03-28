import Array.DynamicArray;
import org.junit.*;

public class Task1_ArrayTests extends Assert {
    @Test
    public void DynamicArray_NegativeSize_Exception()
    {
        var exception = assertThrows
                (NegativeArraySizeException.class, () ->
                {
                    DynamicArray<Integer> arr = new DynamicArray<>(-1);
                });
        assertTrue(exception.toString().contains("Size can not be negative"));
    }

    @Test
    public void DynamicArray_normalSize_ArrayCreatedAndUsed()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(10);
        assertEquals(10, arr.getSize());
        arr.set(9, 9);
        assertEquals((Integer)9, arr.get(9));
    }

    @Test
    public void DynamicArray_DefaultSize_NullSizeArray()
    {
        DynamicArray<Integer> arr = new DynamicArray<>();
        assertEquals(0, arr.getSize());
    }

    @Test
    public void set_outOfBounds_Exception()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(10);
        var exception = assertThrows
                (IndexOutOfBoundsException.class, () -> arr.set(-1, 100));
        assertTrue(exception.toString().contains("Index out of bounds"));
        exception = assertThrows(IndexOutOfBoundsException.class, () -> arr.set(10, 101));
        assertTrue(exception.toString().contains("Index out of bounds"));
    }

    @Test
    public void get_outOfBounds_Exception()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(10);
        var exception = assertThrows
                (IndexOutOfBoundsException.class, () -> arr.get(-1));
        assertTrue(exception.toString().contains("Index out of bounds"));
        exception = assertThrows(IndexOutOfBoundsException.class, () -> arr.get(10));
        assertTrue(exception.toString().contains("Index out of bounds"));
    }

    @Test
    public void resize_NegativeSize_Exception()
    {
        DynamicArray<Integer> arr = new DynamicArray<>();
        var exception = assertThrows
                (NegativeArraySizeException.class, () -> arr.resize(-10));
        assertTrue(exception.toString().contains("Size can not be negative"));
    }

    @Test
    public void resize_moreThenCapacity_paramsChanged()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(1);
        arr.resize(2);
        assertEquals(2,arr.getSize());
        arr.set(1,2);
        assertEquals((Integer) 2,arr.get(1));
    }

    @Test
    public void resize_lessThenCapacity_paramsChanged()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(5);
        arr.resize(1);
        assertEquals(1,arr.getSize());
        arr.set(0,2);
        assertEquals((Integer) 2,arr.get(0));
    }

    @Test
    public void insert_middle_ArrayChanged()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(5);
        arr.set(0,1);
        arr.set(1,1);
        arr.set(2,1);
        arr.set(3,1);
        arr.set(4,1);
        arr.insert(2, 0);
        assertEquals((Integer)0,arr.get(2));
        assertEquals(6,arr.getSize());
        assertEquals((Integer)1,arr.get(5));
    }

    @Test
    public void pushBack_emptyAndFilledArray_ArrayChanged()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(5);
        arr.set(0,1);
        arr.set(1,1);
        arr.set(2,1);
        arr.set(3,1);
        arr.set(4,1);
        arr.pushBack(0);
        assertEquals((Integer)0,arr.get(5));
        assertEquals(6,arr.getSize());

        DynamicArray<Integer> arr2 = new DynamicArray<>();
        arr2.pushBack(0);
        assertEquals((Integer)0,arr2.get(0));
        assertEquals(1,arr2.getSize());
    }

    @Test
    public void popBack_emptyArray_Exception()
    {
        DynamicArray<Integer> arr = new DynamicArray<>();
        var exception = assertThrows
                (UnsupportedOperationException.class, () -> arr.popBack());
        assertTrue(exception.toString().contains("Array is empty"));
    }

    @Test
    public void popBack_normal_ArrayChanged()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(5);
        arr.set(0,1);
        arr.set(1,1);
        arr.set(2,1);
        arr.set(3,1);
        arr.set(4,1);
        arr.popBack();
        assertEquals(4,arr.getSize());
    }

    @Test
    public void remove_middleAndEnd_ArrayChanged()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(5);
        arr.set(0,1);
        arr.set(1,0);
        arr.set(2,1);
        arr.set(3,0);
        arr.set(4,1);
        arr.remove(2);
        assertEquals((Integer)0,arr.get(2));
        assertEquals(4,arr.getSize());
        arr.remove(3);
        assertEquals(3,arr.getSize());
    }
}
