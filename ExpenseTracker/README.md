# Expense Tracker

## URL OF THE PROJECT: https://roadmap.sh/projects/expense-tracker

## Overview
The **Expense Tracker** is a simple Java console application that allows users to manage their expenses. Users can add, update, remove, and view expenses, as well as get a summary of their expenses for all time or for a specific month.

## Features
- **Add Expense:** Users can add an expense with a title, description, amount, and date.
- **Update Expense:** Users can modify existing expenses.
- **Remove Expense:** Users can delete an expense.
- **View All Expenses:** Displays a list of all recorded expenses.
- **View Summary:** Shows the total amount spent across all expenses.
- **View Monthly Summary:** Displays total expenses for a specific month.

## Installation & Setup
1. Clone the repository or download the source code.
2. Ensure you have **Java 8+** installed on your system.
3. Compile the Java files:
   ```sh
   javac ExpenseTracker/*.java
   ```
4. Run the application:
   ```sh
   java ExpenseTracker.Main
   ```

## File Structure
- `Main.java` - Handles user interaction and menu navigation.
- `Expense.java` - Represents an individual expense.
- `ExpenseManager.java` - Manages expense-related operations.

## Usage
Upon running the application, the user will be presented with a menu to select different options by entering a number corresponding to the action they want to perform. The application will continue running until the user selects **0 (Exit).**

## Example Interaction
```sh
Expense Tracker application.
1. Add expense
2. Update expense
3. Remove expense
4. View all expenses
5. View summary of all expenses
6. View summary of all expenses for a specific month
0. Exit
Enter your choice: 1
Enter expense title: Coffee
Enter expense description: Morning coffee
Enter expense amount: 5.50
Enter date (YYYY-MM-DD): 2025-03-08
Expense added successfully.
```

## Improvements & Future Enhancements
- Store expenses in a **database or file** for persistence.
- Implement **categorization** of expenses.
- Add a **GUI version** for better user experience.
- Export expense summary to a **CSV file**.

## License
This project is open-source and available for modification and distribution.

