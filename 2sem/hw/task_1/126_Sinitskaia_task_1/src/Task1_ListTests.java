import Array.DynamicArray;
import DoubleLinkedList.*;
import org.junit.*;

public class Task1_ListTests extends Assert {

    @Test
    public void DoubleLinkedList_createEmpty_ListCreated()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertTrue(list.isEmpty());
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
    public void remove_fromEmptyAndFilled_ListChanged()
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.remove(list.getHead());
        list.pushBack(3);
        Node<Integer> one =  list.pushFront(2);
        list.pushFront(4);
        list.remove(list.getHead());
        assertEquals((Node<Integer>)list.getHead(), one);
        list.remove(list.getHead());
        list.remove(list.getHead());
        list.remove(list.getHead());
    }


}
