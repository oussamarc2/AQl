package org.emp.gl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void pushShouldAddElementToStack() {
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
    }

    @Test
    void popShouldRemoveAndReturnTopElement() {
        stack.push(5);
        stack.push(10);
        assertEquals(10, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void popShouldThrowExceptionWhenStackIsEmpty() {
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void peekShouldReturnTopElementWithoutRemovingIt() {
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void isEmptyShouldReturnTrueForNewStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmptyShouldReturnFalseAfterPush() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
