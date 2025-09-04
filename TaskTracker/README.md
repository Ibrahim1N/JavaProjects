Project URL: https://roadmap.sh/projects/task-tracker

# Task Management Application

## Overview

This Java-based Task Management Application allows users to manage their tasks efficiently. Users can add, edit, view, delete, and mark tasks as completed. The application is designed to be user-friendly and provides a simple command-line interface for interaction.

## Features

1. **Add a Task**: Users can add a new task by providing a title, description, and due date.
2. **Edit a Task**: Users can edit an existing task by specifying the task number and providing new details.
3. **View All Tasks**: Users can view all the tasks currently stored in the system, including their titles, descriptions, due dates, and completion status.
4. **Delete a Task**: Users can delete a task by specifying the task number.
5. **Mark a Task as Complete**: Users can mark a task as completed by specifying the task number.

## How to Use

1. **Running the Application**: Compile and run the `Main.java` file. The application will start and display a menu of options.
2. **Adding a Task**: Select option `1` from the menu and follow the prompts to enter the task title, description, and due date.
3. **Editing a Task**: Select option `2` from the menu, enter the task number you wish to edit, and provide the new details.
4. **Viewing Tasks**: Select option `3` from the menu to view all tasks.
5. **Deleting a Task**: Select option `4` from the menu and enter the task number you wish to delete.
6. **Marking a Task as Complete**: Select option `5` from the menu and enter the task number you wish to mark as completed.
7. **Exiting the Application**: Select option `0` to exit the application.

## Code Structure

- **Main.java**: Contains the main method and handles user input and menu navigation.
- **Task.java**: Defines the `Task` class with attributes like title, description, due date, and completion status.
- **TaskManager.java**: Manages the list of tasks and provides methods to add, edit, view, delete, and mark tasks as completed.

## Example Usage

```plaintext
Task Management Application
1. Add a task
2. Edit a task
3. View all tasks
4. Delete a task
5. Mark a task as complete
0. Exit

Enter your choice:
1
Enter the task title: Finish project
Enter the task description: Complete the final report
Enter the task due date (YYYY-MM-DD): 2023-12-31
Task added successfully
```

## Notes
The application uses LocalDate for handling dates, so ensure the date format is YYYY-MM-DD.

The task list is stored in memory and will be cleared when the application is closed.