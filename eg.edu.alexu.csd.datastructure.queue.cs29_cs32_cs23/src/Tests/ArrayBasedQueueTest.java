package Tests;

import Classes.ArrayBasedQueue;
import Classes.LinkedListBasedQueue;
import Interfaces.IQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBasedQueueTest {

    @Test
    void testAll()
    {
        ArrayBasedQueue Queue1 = new ArrayBasedQueue(100);
        LinkedListBasedQueue Queue2 = new LinkedListBasedQueue();

        testEnqueue(Queue1);
        testDequeue(new ArrayBasedQueue(100));
        testIsEmpty(new ArrayBasedQueue(100));
        testSize(new ArrayBasedQueue(100));

        testEnqueue(Queue2);
        testDequeue(new LinkedListBasedQueue());
        testIsEmpty(new LinkedListBasedQueue());
        testSize(new LinkedListBasedQueue());

    }


    void testEnqueue(IQueue Queue) {
        Queue.enqueue(5);
        Queue.enqueue(67);
        Queue.enqueue("hello");
        Queue.enqueue("*");
        Queue.enqueue("<>");
        Queue.enqueue('s');
        assertEquals(6,Queue.size());
    }

    void testDequeue(IQueue Queue) {
        assertThrows(RuntimeException.class,()->{Queue.dequeue();});
        Queue.enqueue(19);
        Queue.enqueue(87);
        assertEquals(19,Queue.dequeue());
        assertEquals(87,Queue.dequeue());
        assertThrows(RuntimeException.class,()->{Queue.dequeue();});
    }

    void testIsEmpty(IQueue Queue) {
        Queue.enqueue(78);
        Queue.enqueue(866);
        Queue.enqueue(88);
        assertFalse(Queue.isEmpty());
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        assertTrue(Queue.isEmpty());

    }

    void testSize(IQueue Queue) {
        Queue.enqueue(5);
        Queue.enqueue(67);
        Queue.enqueue(3);
        Queue.enqueue(6);
        Queue.enqueue(12);
        Queue.enqueue(45);
        Queue.enqueue(12);
        Queue.enqueue(32);
        assertEquals(8,Queue.size());
        Queue.dequeue();
        assertEquals(7,Queue.size());
        Queue.enqueue("*");
        Queue.enqueue("/");
        Queue.enqueue("()");
        assertEquals(10,Queue.size());
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        assertTrue(Queue.isEmpty());
        assertThrows(RuntimeException.class,()->{Queue.dequeue();});
    }

}