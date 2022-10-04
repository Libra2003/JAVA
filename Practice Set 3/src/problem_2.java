import java.util.Scanner;
public class problem_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Monthly Income: ");
        int income = input.nextInt();
            float tax = 0;
            if(income>250000&&income<=500000){
                System.out.println("Tax on your Income is: ");
                tax = tax + 0.05f * (income - 2.5f);
                System.out.println(tax);

            }
            else if(income>500000&&income<=1000000){
                System.out.println("Tax on your income is: ");
                tax = tax + 0.05f * (5.0f - 2.5f);
                tax = tax + 0.2f * (income - 5f);
                System.out.println(tax);

            }
            else if(income>1000000){
                System.out.println("Tax on your income is: ");
                tax = tax + 0.05f * (5.0f - 2.5f);
                tax = tax + 0.2f * (10.0f - 5f);
                tax = tax + 0.3f * (income - 10.0f);
                System.out.println(tax);

            }
            else {
                System.out.println("You are exampted from tax");

            }


    }
}
