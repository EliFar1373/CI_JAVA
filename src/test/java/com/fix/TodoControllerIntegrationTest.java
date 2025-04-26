package com.fix;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate; // <<< CORRECT ONE
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // <<< ADD THIS
class TodoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "/api/todos";

    @BeforeEach
    void setUp() {
        // Clear or reset if needed
    }

    @Test
    void testGetAllTodos() {
        ResponseEntity<Todo[]> response = restTemplate.getForEntity(BASE_URL, Todo[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length >= 0);
    }

    @Test
    void testAddTodo() {
        Todo newTodo = new Todo();
        newTodo.setTask("Finish homework");
        newTodo.setCompleted(false);

        ResponseEntity<Todo> response = restTemplate.postForEntity(BASE_URL, newTodo, Todo.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody().getId());
        assertEquals("Finish homework", response.getBody().getTask());
        assertFalse(response.getBody().isCompleted());
    }
}

