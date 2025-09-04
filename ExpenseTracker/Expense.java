package ExpenseTracker;

public class Expense {
    private String expenseName;
    private String description;
    private double expenseAmount;
    private String date;

    
    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public Expense(String expenseName, String description, double expenseAmount, String date) {
        this.expenseName = expenseName;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.date = date;
    }


    public String getExpenseName() {
        return expenseName;
    }


    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public double getExpenseAmount() {
        return expenseAmount;
    }


    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "Title: " + expenseName +  
            "\nDescription: " + description +
            "\nAmount: " + expenseAmount +
            "\nDate: " + date;
    }
}
