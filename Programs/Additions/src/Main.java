import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String first_Number;
        String second_Number;
        int number1;
        int number2;
        int sum;

        first_Number = JOptionPane.showInputDialog("Enter First Number");
        second_Number = JOptionPane.showInputDialog("Enter second Number");

        JOptionPane.showMessageDialog(null,"The sum is "+ first_Number+second_Number, " Result ",JOptionPane.PLAIN_MESSAGE);

        // convert numbers from type String
        number1 = Integer.parseInt(first_Number);
        number2 = Integer.parseInt(second_Number);

        sum = number1+number2;

        JOptionPane.showMessageDialog(null,"The sum is "+ sum , " Result ",JOptionPane.PLAIN_MESSAGE);
    }
}