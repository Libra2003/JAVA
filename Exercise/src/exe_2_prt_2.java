import java.util.Scanner;
public class exe_2_prt_2 {
    public static void main(String[] args){
        System.out.println("Input grade: ");
        Scanner input = new Scanner(System.in);
        char grade = input.next().charAt(0);
        grade = (char)(grade+8);
        System.out.println("Encrypted Grade: ");
        System.out.println(grade);
        grade = (char)(grade-8);
        System.out.println("Dycrypted grade: ");
        System.out.println(grade);
    }
}
