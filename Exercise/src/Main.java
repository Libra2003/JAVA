import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner Mark = new Scanner(System.in);
        System.out.println("Sub_1: ");
        int f = Mark.nextInt();
        System.out.println("Sub_2: ");
        int a = Mark.nextInt();
        System.out.println("Sub_3: ");
        int b = Mark.nextInt();
        System.out.println("Sub_4: ");
        int c = Mark.nextInt();
        System.out.println("Sub_5: ");
        int d = Mark.nextInt();
        int sum = a+b+c+d+f;
        System.out.println("The sum is: ");
        System.out.println(sum);
        System.out.println("The percentage is: ");
        float per;
        per = sum*100/500;
        System.out.println(per);
    }
}