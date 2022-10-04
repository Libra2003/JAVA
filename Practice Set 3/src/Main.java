import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Problem 1
        Scanner input = new Scanner(System.in);
        System.out.print("First Subject Marks: ");
        int a = input.nextInt();
        System.out.print("Second Subject Marks: ");
        int b = input.nextInt();
        System.out.print("Third Subject Marks: ");
        int c = input.nextInt();

        if(a>33){
            System.out.println("You are passed in the first Subject");

        }
        if(b>33){
            System.out.println("You are passed in the Second Subject");

        }
        if(c>33){
            System.out.println("You are passed in the third Subject");

        }
        int d = ((a+b+c)*100)/100;
        System.out.println(d);
        
        if(d>40){
            System.out.println("Percentage is over 40 percent you are passed");
        }
    }
}