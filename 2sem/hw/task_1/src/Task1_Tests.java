import org.junit.*;

public class Task1_Tests extends Assert {

    @Test
    public void pushFront_pushFrontToList_FirstElementPushed()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.pushFront(2);
        list.pushFront(2);
        list.pushFront(1);
        assertEquals((Integer)1, ((Node<Integer>)list.getHead()).getData());
    }

    @Test
    public void pushBack_pushBackToList_LastElementPushed()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.pushBack(2);
        list.pushBack(2);
        list.pushBack(1);
        assertEquals((Integer)1, ((Node<Integer>)list.getTail()).getData());
    }

    @Test
    public void isEmpty_checkEmptyList_CorrectOutput()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertTrue(list.isEmpty());
        list.pushBack(20);
        assertFalse(list.isEmpty());
    }

    @Test
    public void insertAfter_EmptyList_ListChanged()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.pushBack(1);
        assertEquals(1, list.getSize());
        Node<Integer> head = (Node<Integer>) list.getHead();
        assertEquals((Integer)1 ,head.getData());
    }

    @Test
    public void insertAfter_addNewNode_ListChanged()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.pushBack(1);
        Node<Integer> head = (Node<Integer>) list.getHead();
        list.pushBack(3);
        Node<Integer> third = (Node<Integer>) (list.getHead().getNext());
        assertEquals(head ,head.getPrev().getNext());
        assertEquals(head ,head.getNext().getPrev());
        assertEquals(third ,third.getPrev().getNext());
        assertEquals(third ,third.getNext().getPrev());

        list.insertAfter(head, 2);
        Node<Integer> second = (Node<Integer>) (head.getNext());
        assertEquals(second ,second.getPrev().getNext());
        assertEquals(second ,second.getNext().getPrev());

        assertEquals((Integer) 1, head.getData());
        assertEquals((Integer) 2, second.getData());
        assertEquals((Integer) 3, third.getData());
    }

    @Test
    public void get_simpleCheckAndBounds_correctReturn()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        Node<Integer> first = (Node<Integer>)(list.get(0));
        Node<Integer> second = (Node<Integer>)(list.get(1));
        Node<Integer> third = (Node<Integer>)(list.get(2));

        var exception = assertThrows
                (IndexOutOfBoundsException.class, () -> list.get(-1));
        assertTrue(exception.toString().contains("index out of bounds"));
        exception = assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertTrue(exception.toString().contains("index out of bounds"));
    }

    @Test
    public void insertBefore_addNewNode_ListChanged()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.pushFront(3);
        Node<Integer> third = (Node<Integer>) list.getHead();
        list.pushFront(1);
        Node<Integer> one = (Node<Integer>) list.getHead();
        assertEquals(third ,third.getPrev().getNext());
        assertEquals(third ,third.getNext().getPrev());
        assertEquals(one ,one.getPrev().getNext());
        assertEquals(one ,one.getNext().getPrev());

        list.insertBefore(third, 2);
        Node<Integer> second = (Node<Integer>) (one.getNext());
        assertEquals(second ,second.getPrev().getNext());
        assertEquals(second ,second.getNext().getPrev());

        assertEquals((Integer) 1, one.getData());
        assertEquals((Integer) 2, second.getData());
        assertEquals((Integer) 3, third.getData());
    }

    @Test
    public void remove_fromFilled_ListChanged()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.pushFront(4);
        list.pushFront(3);
        list.pushFront(2);
        list.pushFront(1);
        list.remove(list.get(1));
        assertEquals((Integer)3,((Node<Integer>)list.get(1)).getData());
        assertEquals(list.get(0),list.get(1).getPrev());
        assertEquals(list.get(2),list.get(1).getNext());

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
    public void insert_outOfBounds_Exception()
    {
        DynamicArray<Integer> arr = new DynamicArray<>(10);
        var exception = assertThrows
                (IndexOutOfBoundsException.class, () -> arr.insert(-1, 2));
        assertTrue(exception.toString().contains("Index out of bounds"));
        exception = assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(10, 3));
        assertTrue(exception.toString().contains("Index out of bounds"));
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

//    @Test
//    public void remove_middleAndEnd_ArrayChanged()
//    {
//        DynamicArray<Integer> arr = new DynamicArray<>(5);
//        arr.set(0,1);
//        arr.set(1,2);
//        arr.set(2,3);
//        arr.set(3,4);
//        arr.set(4,5);
//        arr.remove(2);
//        assertEquals((Integer)4,arr.get(2));
//        assertEquals(4,arr.getSize());
//        arr.remove(3);
//        assertEquals(3,arr.getSize());
//    }
}
