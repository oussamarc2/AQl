package org.emp.gl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushShouldAddElementToStack() {
        Stack stack = new Stack();
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void popShouldRemoveAndReturnTopElement() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        assertEquals(10, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void popShouldThrowExceptionWhenStackIsEmpty() {
        Stack stack = new Stack();
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void peekShouldReturnTopElementWithoutRemovingIt() {
        Stack stack = new Stack();
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void isEmptyShouldReturnTrueForNewStack() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmptyShouldReturnFalseAfterPush() {
        Stack stack = new Stack();
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
