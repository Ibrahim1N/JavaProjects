package ExpenseTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        try (Scanner scanner = new Scanner(System.in)) {
            while(true){
                System.out.println("Expense Tracker application.");
                System.out.println("1. Add expense");
                System.out.println("2. Update expense");
                System.out.println("3. Remove expense");
                System.out.println("4. View all expenses");
                System.out.println("5. View summary of all expenses");
                System.out.println("6. View summary of all expenses for a specific month");
                System.out.println("0. Exit");
                
                System.out.println("Enter you choice:");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice){
                    case 0:
                        System.out.println("Exiting...");
                        return;


                    case 1:
                        System.out.println("Enter expense title: ");
                        String title = scanner.nextLine();

                        System.out.println("Enter expense description: ");
                        String description = scanner.nextLine();

                        System.out.println("Enter expense amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Enter date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();


                        expenseManager.addExpense(title, description, amount, date);
                        System.out.println("Expense added successfully.");

                        break;
                    case 2:
                        System.out.println("Enter the number of expense to edit: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();

                        if(index <=0 || index>expenseManager.getExpenses().size()){
                            System.out.println("Invalid index. Please try again.");
                            break;
                        }

                        System.out.println("Enter new title: ");
                        String newTitle = scanner.nextLine();

                        System.out.println("Enter new description: ");
                        String newDescr = scanner.nextLine();

                        System.out.println("Enter new amount: ");
                        double newAmount = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Enter new month (MM): ");
                        String newMonth = scanner.nextLine();
                        
                        expenseManager.updateExpense(index, newTitle, newDescr, newAmount, newMonth);

                        break;

                        case 3:
                            System.out.println("Enter the number of expense to edit: ");
                            int index1 = scanner.nextInt();
                            if(index1 <=0 || index1>expenseManager.getExpenses().size()){
                                System.out.println("Invalid index. Please try again.");
                                break;
                            }

                            expenseManager.removeExpense(index1);

                            break;

                        case 4:
                            System.out.println("Here is all of your expenses: ");
                            expenseManager.viewAllExpenses();
                            break;

                        case 5:
                           
                            ExpenseManager.viewSummary(expenseManager.getExpenses());
                            break;

                        case 6:
                            System.out.println("Enter the month you want to view summary of (MM): ");
                            String month1 = scanner.nextLine();
                            ExpenseManager.viewMonthSummary(expenseManager.getExpenses(), month1);


                }

                System.out.println();
            }
        }
    }
}
