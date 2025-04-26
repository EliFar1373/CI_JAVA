package com.fix.stepdefs;

import com.fix.Todo;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class TodoModelStepDefs {

    private Todo todo;

    @Given("I have a todo with id {long}, task {string}, and completed {string}")
    public void i_have_a_todo_with_values(Long id, String task, String completed) {
        boolean isCompleted = Boolean.parseBoolean(completed);
        todo = new Todo(id, task, isCompleted);
    }

    @Then("the todo should have id {long}")
    public void the_todo_should_have_id(Long expectedId) {
        Assertions.assertEquals(expectedId, todo.getId());
    }

    @Then("the task should be {string}")
    public void the_task_should_be(String expectedTask) {
        Assertions.assertEquals(expectedTask, todo.getTask());
    }

    @Then("the completed status should be {string}")
    public void the_completed_status_should_be(String expectedStatus) {
        boolean expected = Boolean.parseBoolean(expectedStatus);
        Assertions.assertEquals(expected, todo.isCompleted());
    }
}
