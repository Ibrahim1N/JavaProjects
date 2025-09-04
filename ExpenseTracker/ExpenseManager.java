package ExpenseTracker;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager(){
        expenses = new ArrayList<>();
    }

    public void addExpense(String expenseName, String description, double expenseAmount, String date){
        Expense expense = new Expense(expenseName, description, expenseAmount, date);
        expenses.add(expense);
    }

    public void removeExpense(int index){
        expenses.remove(index);
        
    }

    public void updateExpense(int index, String expenseName, String description, double expenseAmount, String date){
        Expense expense = expenses.get(index);
        expense.setExpenseName(expenseName);
        expense.setDescription(description);
        expense.setExpenseAmount(expenseAmount);
        expense.setDate(date);

}

    public void viewAllExpenses(){
        if(expenses.isEmpty()) {
            System.out.println("No expenses found");
            return;
        } 
        for(int i = 0; i<expenses.size(); i++){
            System.out.println("Expense #" + (i+1));
            System.out.println(expenses.get(i));
            System.out.println();
        }
    }

    public List<Expense> getExpenses(){
        return expenses;
    }
    public static void viewSummary(List<Expense> expenses){
        double total = 0;

        for(Expense e: expenses){
            total += e.getExpenseAmount();
        }

        System.out.println("Summary of all expenses:" + total);
    }

    public static void viewMonthSummary(List<Expense> expenses, String month){
        double total =  0;
        for(Expense e : expenses){
            if(e.getDate().substring(5, 7).equals(month)){
                total += e.getExpenseAmount();
            }
        }
        System.out.println("Summary of all expenses in " + month + " is: " + total);
    }




}
