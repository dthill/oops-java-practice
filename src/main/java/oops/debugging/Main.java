package oops.debugging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }

    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int slen = arr1.length;
        for (int i = 0; i < slen; i++) {
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt();
        for (int j = 1; j <= slen; j++) {
            if (options == j) {
                switch (options) {
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses + "\n");
                        optionsSelection();
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        expenses.addAll(arrlist);
                        System.out.println(expenses + "\n");
                        optionsSelection();

                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if (con_choice == options) {
                            expenses.clear();
                            System.out.println(expenses + "\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        sortExpenses(expenses);
                        optionsSelection();
                        break;
                    case 5:
                        searchExpenses(expenses);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }
            }
        }
    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        Integer searchedExpense = getExpensesSearch();
        boolean expenseFound = false;
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer currentExpence = iterator.next();
            if (searchedExpense.equals(currentExpence)) {
                expenseFound = true;
                System.out.println("Expense found: " + currentExpence);
            }
        }
        if (!expenseFound) {
            System.out.println("No expense found matching your search");
        }
    }

    private static Integer getExpensesSearch() {
        System.out.println("Enter the expense you need to search:\t");
        Scanner scanner = new Scanner(System.in);
        Integer searchInteger;
        while (true) {
            String searchInput = scanner.nextLine();
            try {
                searchInteger = Integer.valueOf(searchInput);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid integer to search.");
            }
        }
        return searchInteger;
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        arrayList = mergeSort(arrayList);
        System.out.println("Sorted expenses: ");
        System.out.println(arrayList);
    }

    private static ArrayList<Integer> mergeLists(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> result = new ArrayList<>();
        while (leftList.size() > 0 && rightList.size() > 0) {
            result.add(leftList.get(0) < rightList.get(0) ? leftList.remove(0) : rightList.remove(0));
        }
        if (leftList.size() > 0) {
            result.addAll(leftList);
        } else {
            result.addAll(rightList);
        }
        return result;
    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        int length = list.size();
        if (length <= 1) {
            return list;
        }
        int middle = length / 2;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i < middle) {
                leftList.add(list.get(i));
            } else {
                rightList.add((list.get(i)));
            }
        }
        return mergeLists(mergeSort(leftList), mergeSort(rightList));
    }
}