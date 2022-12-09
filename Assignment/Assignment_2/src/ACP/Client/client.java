package ACP.Client;
import javax.swing.*;
import ACP.Employee.*;

import java.text.ParseException;

public class client {
    static String choice;//Used for selection
    static int id = 0;
    static int select;
    static String emp_name;
    static String job_cat;
    static int age = 0;
    static int i = 0;
    static Employee[] emp = new Employee[50];

    static String s;
    public static void main(String[] args) throws ParseException {
        for (int i = 0; i < 50; i++) {
            emp[i] = new Employee();
        }
        try {
            do {
                choice = JOptionPane.showInputDialog(null, """
                        Press 0 to exit the program
                        Press 1 Set Employee Information
                        Press 2 to Update Employee Information
                        Press 3 to Delete Employee Information
                        Press 4 to Search and View Employee Record
                        Press 5 to display all the Employee Information""", "Main Menu", JOptionPane.PLAIN_MESSAGE);
                switch (choice) {
                    case "1" -> {
                        do {
                            emp[i].setEmpInformation(emp, i);
                            i++;
                            choice = JOptionPane.showInputDialog(null, "Press 1 to Continue\nPress 2 to quit", "Menu", JOptionPane.QUESTION_MESSAGE);

                        } while (i<50 && choice.equals("1"));

                    }
                    case "2" -> {

                            i = Integer.parseInt(JOptionPane.showInputDialog(null, "Empoyee ID whose info you would like to update ", "Update", JOptionPane.QUESTION_MESSAGE));
                            i = i - 9000;
                            if (i < 50) {
                                emp[i].updateEmpInformation(emp[i]);
                            } else {
                                JOptionPane.showMessageDialog(null, "Employee does not exist", "Upgrade", JOptionPane.INFORMATION_MESSAGE);

                            }

                    }
                    case "3"-> {
                            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Employee ID: ", "Delete", JOptionPane.QUESTION_MESSAGE));
                            choice = String.valueOf(id);
                            i = id - 9000;
                            if(i<9050&&i>=9000){
                                emp[i].delete(emp[i], id);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Employee doesn't exist","Delete",JOptionPane.INFORMATION_MESSAGE);

                            }

                    }
                    case "4" -> {
                        i = 0;
                        select = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                Press 1 to Search by Employee ID
                                Press 2 to Search by Employee Name
                                Press 3 to Search by Job Category
                                Press 4 to Search by Age""", "Search", JOptionPane.QUESTION_MESSAGE));
                        switch (select) {

                            case 1 -> {
                                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Employee ID: ", "Employee ID", JOptionPane.QUESTION_MESSAGE));
                                i = id - 9000;
                                if (i >= 0 && i < 50) {
                                    emp[i].search(emp, select, i, emp_name, job_cat, age, id);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Employee does not exist", "Upgrade", JOptionPane.INFORMATION_MESSAGE);

                                }
                            }
                            case 2 -> {
                                emp_name = JOptionPane.showInputDialog(null, "Enter Employee Name: ", "Employee Name", JOptionPane.QUESTION_MESSAGE);
                                String s;
                                s = emp_name.toUpperCase();
                                emp[i].search(emp, select, i, emp_name, s, age, id);

                            }
                            case 3 -> {
                                job_cat = JOptionPane.showInputDialog(null, "Enter Job_Category: ", "Employee Job", JOptionPane.QUESTION_MESSAGE);
                                String s;
                                s = job_cat.toUpperCase();
                                emp[i].search(emp, select, i, emp_name, s, age, id);
                            }
                            case 4 -> {
                                age = Integer.parseInt(JOptionPane.showInputDialog(null, "Age: ", "Employee Job", JOptionPane.QUESTION_MESSAGE));
                                emp[i].search(emp, select, i, emp_name, job_cat, age, id);

                            }
                        }


                    }
                    case "5" -> {

                        i = 0;
                        int lim = Integer.parseInt(JOptionPane.showInputDialog(null, "How many number of employees you want to see?", "Data", JOptionPane.QUESTION_MESSAGE));
                        while (i < lim) {

                            emp[i].view(emp, i);
                            i++;
                        }


                    }
                }
            } while (!choice.equals("0") || !choice.matches("[1-5]"));
        }
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"Wrong input was givin casuing the program to crash","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}