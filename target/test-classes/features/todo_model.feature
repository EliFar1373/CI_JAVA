Feature: Todo Model

  Scenario: Create a new todo item with specific values
    Given I have a todo with id 1, task "Learn Cucumber", and completed false
    Then the todo should have id 1
    And the task should be "Learn Cucumber"
    And the completed status should be false
    
    
 