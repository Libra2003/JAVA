package ACP.Employee;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.regex.Pattern;
import java.time.*;
public class Employee {
    String Employee_Name;
    String Father_Name;
    String Job_Category;
    String Education;
    String CNIC;
    int Emp_ID;
    int Pay_scale;
    LocalDate Date_of_birth;
int age;
    public Employee() {
        Employee_Name = null;
        Father_Name = null;
        Job_Category = null;
        Education = null;
        CNIC = null;
        Emp_ID = 9000;
        Pay_scale = 0;
        Date_of_birth = null;
        age=0;
    }

    public void setEmpInformation(Employee emp[], int i) throws ParseException {
        int category;

        //Employee Name
        emp[i].Employee_Name = JOptionPane.showInputDialog(null, "Employee Name ", "Employee Name", JOptionPane.QUESTION_MESSAGE);
        emp[i].Employee_Name.toUpperCase();
        while (!Pattern.matches("[a-z A-Z]+", emp[i].Employee_Name)) {
            emp[i].Employee_Name = JOptionPane.showInputDialog(null, "Employee Name ", "Employee Name", JOptionPane.QUESTION_MESSAGE);

        }
        //CNIC
        emp[i].CNIC = JOptionPane.showInputDialog(null, "CNIC(Without Daches) ", "CNIC", JOptionPane.QUESTION_MESSAGE);
        while (!emp[i].CNIC.matches("[0-9]{13}+")) {
            emp[i].CNIC = JOptionPane.showInputDialog(null, "CNIC(Without Dashes) ", "CNIC", JOptionPane.QUESTION_MESSAGE);
        }
        //Employee ID
        emp[i].Emp_ID = emp[i].Emp_ID + i;
        JOptionPane.showMessageDialog(null, "Employee ID " + Emp_ID, "ID", JOptionPane.INFORMATION_MESSAGE);

        //Father Name
        emp[i].Father_Name = JOptionPane.showInputDialog(null, "Father Name: ", "Father Name", JOptionPane.QUESTION_MESSAGE);
        while (!Pattern.matches("[a-z A-Z]+", emp[i].Father_Name)) {
            emp[i].Father_Name = JOptionPane.showInputDialog(null, "Father Name: ", "Father Name", JOptionPane.QUESTION_MESSAGE);

        }

        //Education

        String edu = JOptionPane.showInputDialog(null, "Education(Matric,FSC,BS,MS,PhD) ", "Education", JOptionPane.QUESTION_MESSAGE);
        edu = edu.toUpperCase();
        do {


            if (edu.equals("MATRIC") || edu.equals("FSC") || edu.equals("BS") || edu.equals("MS") || edu.equals("PHD")) {
                emp[i].Education = edu;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Sorry You are not qualified for any of the jobs", "Education", JOptionPane.ERROR_MESSAGE);

            }

            edu = JOptionPane.showInputDialog(null, "Education(Matric,FSC,BS,MS,PhD) ", "Education", JOptionPane.QUESTION_MESSAGE);
            edu = edu.toUpperCase();
        } while (!edu.equals("MATRIC") || !edu.equals("FSC") || !edu.equals("BS") || !edu.equals("MS") || !edu.equals("PHD"));


        //Job_Category

            if (emp[i].Education.equals("MATRIC")) {
                JOptionPane.showMessageDialog(null, "You are only eligible to work as a labour", "Job Choice", JOptionPane.INFORMATION_MESSAGE);

                emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                while ((!Pattern.matches("1+", emp[i].Job_Category))) {
                    if ((!Pattern.matches("1+",emp[i].Job_Category))) {
                        emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                    }

                }
                category = Integer.parseInt(emp[i].Job_Category);
                if (category == 1) {
                    emp[i].Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job: " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry you are only Qualified for Labour jobs plz press 1 ");
                }
            }
            else if (emp[i].Education.equals("FSC")) {
                emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for Staff", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                while ((!Pattern.matches("[1-2]+", emp[i].Job_Category))) {
                    if ((!Pattern.matches("[1-2]+",emp[i].Job_Category))) {
                        emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for staff", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                    }

                }
                category = Integer.parseInt(emp[i].Job_Category);


                if (category == 1) {
                    emp[i].Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job: " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 2) {
                    emp[i].Job_Category = "STAFF";
                    JOptionPane.showMessageDialog(null, "Job: " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry you are only Qualified for Labour and staff jobs, ", "Jobs", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if (emp[i].Education.equals("BS")) {

                emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for Staff\nPress 3 for Offcier", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                while ((!Pattern.matches("[1-3]+", emp[i].Job_Category))) {
                    if ((!Pattern.matches("[1-3]+",emp[i].Job_Category))) {
                        emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for staff\nPress 3 for Officer", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                    }

                }
                category = Integer.parseInt(emp[i].Job_Category);

                if (category == 1) {
                    emp[i].Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 2) {
                    emp[i].Job_Category = "STAFF";
                    JOptionPane.showMessageDialog(null, "Job " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 3) {
                    emp[i].Job_Category = "OFFICER";
                    JOptionPane.showMessageDialog(null, "Job " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Job " + "Sorry you are only Qualified for Labour, staff and Officer, ", "Jobs", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if (emp[i].Education.equals("MS") || emp[i].Education.equals("PHD")) {

                emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for Staff\nPress 3 for Offcier\nPress 4 for Teacher", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                while ((!Pattern.matches("[1-4]+", emp[i].Job_Category))) {
                    if ((!Pattern.matches("[1-4]+",emp[i].Job_Category))) {
                        emp[i].Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for staff\nPress 3 for Officer\nPress 4 for Teacher", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                    }

                }
                category = Integer.parseInt(emp[i].Job_Category);

                if (category == 1) {
                    emp[i].Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 2) {
                    emp[i].Job_Category = "STAFF";
                    JOptionPane.showMessageDialog(null, "Job " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 3) {
                    emp[i].Job_Category = "OFFICER";
                    JOptionPane.showMessageDialog(null, "Job " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 4) {
                    emp[i].Job_Category = "TEACHER";
                    JOptionPane.showMessageDialog(null, "Job " + emp[i].Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry you are only Qualified for Labour, staff jobs,Officer and Teacher ", "Jobs", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        //Pay Scale
            if (emp[i].Job_Category.equals("LABOUR")) {

                int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));

                if (num > 10 || num < 1) {
                    while ((num > 10 || num < 1)) {
                        JOptionPane.showMessageDialog(null, "Pay Scale for labour must be between 0 and 10", "Job Error", JOptionPane.ERROR_MESSAGE);
                        num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                        emp[i].Pay_scale = num;

                    }
                } else {
                    emp[i].Pay_scale = num;

                }

            }
            else if (emp[i].Job_Category.equals("STAFF")) {

                int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                if (num <= 16 && num > 10) {
                    emp[i].Pay_scale = num;
                } else {
                    while (num >= 16 || num < 11) {
                        JOptionPane.showMessageDialog(null, "Pay Scale for staff must be between 10 and 16", "Job Error", JOptionPane.ERROR_MESSAGE);
                        num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                        emp[i].Pay_scale = num;

                    }
                }

            }
            else if (emp[i].Job_Category.equals("OFFICER")) {

                int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                if (num >= 17) {
                    emp[i].Pay_scale = num;
                } else {
                    while (num < 17) {
                        JOptionPane.showMessageDialog(null, "Pay Scale for officer must be greater then or equal to 17", "Job Error", JOptionPane.ERROR_MESSAGE);
                        num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                        emp[i].Pay_scale = num;

                    }
                }
            }
            else if (emp[i].Job_Category.equals("TEACHER")) {

                int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                if (num >= 18) {
                    emp[i].Pay_scale = num;
                } else {
                    while (num < 18) {
                        JOptionPane.showMessageDialog(null, "Pay Scale for officer must be greater then or equal to 18", "Job Error", JOptionPane.ERROR_MESSAGE);
                        num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                        emp[i].Pay_scale = num;

                    }
                }
            }


        LocalDate today = LocalDate.now();
        int year,month,day;
        String y1,m1,d1;

            do {
                year = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your year of birth(Pattern: yyyy): ", "Year", JOptionPane.QUESTION_MESSAGE));

                y1 = String.valueOf(year);
            }while (year > today.getYear());
            do {
                month = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your month of birth", "Month", JOptionPane.QUESTION_MESSAGE));
                m1 = String.valueOf(month);
            }while (month > 12 | month < 1);
            do {

                day = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your day of birth", "Day", JOptionPane.QUESTION_MESSAGE));
                d1 = String.valueOf(day);
            }while (((month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) & (day > 31 | day < 1))
                    | ((month == 4 | month == 6 | month == 9 | month == 11) & (day > 30 | day < 1)) | (month == 2 & (day > 28 | day < 1)));
             emp[i].Date_of_birth = LocalDate.of(year, month, day);
            emp[i].age = Period.between(emp[i].Date_of_birth,today).getYears();


    }
    public void view(Employee emp[], int i){
        if(emp[i].Employee_Name==null){
            JOptionPane.showMessageDialog(null,"Employee does not exist","Delete",JOptionPane.INFORMATION_MESSAGE);
            System.exit(-1);
        }
        else {
            JOptionPane.showMessageDialog(null, "Employee Name: " + emp[i].Employee_Name +
                    "\nCNIC: " + emp[i].CNIC +
                    "\nEmployee ID: " + emp[i].Emp_ID +
                    "\nDate pf Birth: " + emp[i].Date_of_birth +
                    "\nAge: " + emp[i].age +
                    "\nFather Name: " + emp[i].Father_Name +
                    "\nEducation: " + emp[i].Education +
                    "\nJob: " + emp[i].Job_Category +
                    "\nPay Scale " + emp[i].Pay_scale, "Employee Info", JOptionPane.INFORMATION_MESSAGE);
        }


    }
    public void updateEmpInformation(Employee emp){

        int category;
        JOptionPane.showMessageDialog(null, "Education " + emp.Education, "ID", JOptionPane.INFORMATION_MESSAGE);

        //Education
        String edu = JOptionPane.showInputDialog(null, "Education(MAATRIC,FSC,BS,MS,PhD) ", "Education", JOptionPane.QUESTION_MESSAGE);
        edu = edu.toUpperCase();
        do {
            if (edu.equals("MATRIC") || edu.equals("FSC") || edu.equals("BS") || edu.equals("MS") || edu.equals("PHD")) {
                emp.Education = edu;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Sorry You are not qualified for any of the jobs", "Education", JOptionPane.ERROR_MESSAGE);

            }
            edu = JOptionPane.showInputDialog(null, "Education(Matric,FSC,BS,MS,PhD) ", "Education", JOptionPane.QUESTION_MESSAGE);
            edu = edu.toUpperCase();
        } while (!edu.equals("MATRIC") || !edu.equals("FSC") || !edu.equals("BS") || !edu.equals("MS") || !edu.equals("PHD"));

            if (emp.Education.equals("MATRIC")) {
                JOptionPane.showMessageDialog(null, "You are only eligible to work as a labour", "Job Choice", JOptionPane.INFORMATION_MESSAGE);

                emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                category = Integer.parseInt(emp.Job_Category);
                while (category != 1) {
                    if (category != 1) {
                        JOptionPane.showMessageDialog(null, "You are only eligible to work as a labour Plz enter 1 next time", "Job Category", JOptionPane.ERROR_MESSAGE);
                        emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                        category = Integer.parseInt(emp.Job_Category);
                    }

                }
                if (category == 1) {
                    emp.Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job: " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry you are only Qualified for Labour jobs plz press 1 ");
                }
            } else if (emp.Education.equals("FSC")) {
                emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for Staff", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                category = Integer.parseInt(emp.Job_Category);
                while (category != 1 && category != 2) {
                    if (category != 1 && category != 2) {
                        emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for staff", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                        category = Integer.parseInt(emp.Job_Category);
                    }


                }
                if (category == 1) {
                    emp.Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job: " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 2) {
                    emp.Job_Category = "STAFF";
                    JOptionPane.showMessageDialog(null, "Job: " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry you are only Qualified for Labour and staff jobs, ", "Jobs", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if (emp.Education.equals("BS")) {

                emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for Staff\nPress 3 for Offcier", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                category = Integer.parseInt(emp.Job_Category);
                while (category != 1 && category != 2 && category != 3) {
                    if (category != 1 && category != 2 && category != 3) {
                        emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for staff\nPress 3 for Officer", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                        category = Integer.parseInt(emp.Job_Category);
                    }


                }

                if (category == 1) {
                    emp.Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 2) {
                    emp.Job_Category = "STAFF";
                    JOptionPane.showMessageDialog(null, "Job " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 3) {
                    emp.Job_Category = "OFFICER";
                    JOptionPane.showMessageDialog(null, "Job " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Job " + "Sorry you are only Qualified for Labour, staff and Officer, ", "Jobs", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if (emp.Education.equals("MS") || emp.Education.equals("PHD")) {

                emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for Staff\nPress 3 for Offcier\nPress 4 for Teacher", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                category = Integer.parseInt(emp.Job_Category);
                while (category != 1 && category != 2 && category != 3 && category != 4) {
                    if (category != 1 && category != 2 && category != 3 && category != 4) {
                        emp.Job_Category = JOptionPane.showInputDialog(null, "Press 1 for Labour\nPress 2 for staff\nPress 3 for Officer\nPress 4 for Teacher", "Job Choice", JOptionPane.QUESTION_MESSAGE);
                        category = Integer.parseInt(emp.Job_Category);
                    }

                }

                if (category == 1) {
                    emp.Job_Category = "LABOUR";
                    JOptionPane.showMessageDialog(null, "Job " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 2) {
                    emp.Job_Category = "STAFF";
                    JOptionPane.showMessageDialog(null, "Job " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 3) {
                    emp.Job_Category = "OFFICER";
                    JOptionPane.showMessageDialog(null, "Job " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else if (category == 4) {
                    emp.Job_Category = "TEACHER";
                    JOptionPane.showMessageDialog(null, "Job " + emp.Job_Category, "Job", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry you are only Qualified for Labour, staff jobs,Officer and Teacher ", "Jobs", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        //Pay Scale
        if (emp.Job_Category.equals("LABOUR")) {

            int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));

            if (num > 10 || num < 1) {
                while ((num > 10 || num < 1)) {
                    JOptionPane.showMessageDialog(null, "Pay Scale for labour must be between 0 and 10", "Job Error", JOptionPane.ERROR_MESSAGE);
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                    emp.Pay_scale = num;

                }
            } else {
                emp.Pay_scale = num;

            }

        }
        else if (emp.Job_Category.equals("STAFF")) {

            int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
            if (num <= 16 && num > 10) {
                emp.Pay_scale = num;
            } else {
                while (num >= 16 || num < 11) {
                    JOptionPane.showMessageDialog(null, "Pay Scale for staff must be between 10 and 16", "Job Error", JOptionPane.ERROR_MESSAGE);
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                    emp.Pay_scale = num;

                }
            }

        }
        else if (emp.Job_Category.equals("OFFICER")) {

            int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
            if (num >= 17) {
                emp.Pay_scale = num;
            } else {
                while (num < 17) {
                    JOptionPane.showMessageDialog(null, "Pay Scale for officer must be greater then or equal to 17", "Job Error", JOptionPane.ERROR_MESSAGE);
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                    emp.Pay_scale = num;

                }
            }
        }
        else if (emp.Job_Category.equals("TEACHER")) {

            int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
            if (num >= 18) {
                emp.Pay_scale = num;
            } else {
                while (num < 18) {
                    JOptionPane.showMessageDialog(null, "Pay Scale for officer must be greater then or equal to 18", "Job Error", JOptionPane.ERROR_MESSAGE);
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Pay Scale", "Pay Scale", JOptionPane.QUESTION_MESSAGE));
                    emp.Pay_scale = num;

                }
            }
        }

    }
    public void search(Employee emp[],int select, int i, String emp_Name,String Job_Cat,int age1,int id) {
        Boolean found = false;
        if (select==1){
            for (int k = 0;k<50;k++){
                if(id==emp[k].Emp_ID){
                    JOptionPane.showMessageDialog(null,"Employee has been found","Employee",JOptionPane.INFORMATION_MESSAGE);
                    emp[k].view(emp, k);
                    found = true;
                    break;
                }


            }
            if(found==false){
                JOptionPane.showMessageDialog(null,"Employee does not exist","Employee",JOptionPane.INFORMATION_MESSAGE);

            }

        }
        else if (select==2){
            found = false;
            for (int j = 0;j<50;j++){
                if(emp[j].Employee_Name.equals(emp_Name)){
                    JOptionPane.showMessageDialog(null,"Employee has been found","Employee",JOptionPane.INFORMATION_MESSAGE);
                    emp[j].view(emp,j);
                    found =true;
                    break;
                }
            }
            if(found==false){
                JOptionPane.showMessageDialog(null,"Employee does not exist","Employee",JOptionPane.INFORMATION_MESSAGE);

            }
        }
        else if(select==3){
            found = false;
            for (int j = 0;j<50;j++){
                if(emp[j].Job_Category.equals(Job_Cat)){
                    JOptionPane.showMessageDialog(null,"Employee has been found","Employee",JOptionPane.INFORMATION_MESSAGE);
                    emp[j].view(emp,j);
                    found = true;
                    break;
                }
            }
            if(found==false){
                JOptionPane.showMessageDialog(null,"Employee does not exist","Employee",JOptionPane.INFORMATION_MESSAGE);

            }
        }
        else if(select==4){
            found = false;
            for (int j = 0;j<50;j++) {
                if(age1 == emp[j].age) {
                    JOptionPane.showMessageDialog(null, "Employee has been found", "Employee", JOptionPane.INFORMATION_MESSAGE);
                    emp[j].view(emp, j);

                }
            }
            if(found==false){
                JOptionPane.showMessageDialog(null,"Employee does not exist","Employee",JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }

    public void delete(Employee emp, int id){
            if(emp.Emp_ID==id && emp.Employee_Name==null){
                JOptionPane.showMessageDialog(null,"Employee does not exist","Delete",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Employee Record Successfully deleted","Delete",JOptionPane.INFORMATION_MESSAGE);
                emp.Job_Category = null;
                emp.Education = null;
                emp.Employee_Name = null;
                emp.Pay_scale = 0;
                emp.Father_Name = null;
                emp.CNIC = null;
                emp.Date_of_birth = null;
                emp.age = 0;
                emp.Emp_ID = 0;
            }

    }



}