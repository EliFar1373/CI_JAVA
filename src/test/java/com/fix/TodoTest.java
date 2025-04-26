
package com.fix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    @Test
    public void testConstructorAndGetters() {
        Todo todo = new Todo(1L, "Learn JUnit", false);

        assertEquals(1L, todo.getId());
        assertEquals("Learn JUnit", todo.getTask());
        assertFalse(todo.isCompleted());
    }

    @Test
    public void testSetters() {
        Todo todo = new Todo();

        todo.setId(2L);
        todo.setTask("Write unit tests");
        todo.setCompleted(true);

        assertEquals(2L, todo.getId());
        assertEquals("Write unit tests", todo.getTask());
        assertTrue(todo.isCompleted());
    }
}
