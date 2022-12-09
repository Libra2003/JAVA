// Compare integers using if structures, relational operators
// and equality operators.

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String firstNumber;
        String secondNumber;
        int number1;
        int number2;

        // read first number from user as a string
        firstNumber = JOptionPane.showInputDialog( "Enter first integer:" );
       // read second number from user as a string
        secondNumber = JOptionPane.showInputDialog( "Enter second integer:" );
        // convert numbers from type String to type int
        number1 = Integer.parseInt( firstNumber );
        number2 = Integer.parseInt( secondNumber );
        // initialize result to empty String
        String result = "";

                if ( number1 == number2 ) {
                    result = number1 + " == " + number2;
                }
                 if ( number1 != number2 ) {
                    result = number1 + " != " + number2;
                }
                if ( number1 < number2 ) {
                     result = result + "\n" + number1 + " < " + number2;
                 }
                 if ( number1 > number2 ) {
                     result = result + "\n" + number1 + " > " + number2;
                 }
                 if ( number1 <= number2 ) {
                     result = result + "\n" + number1 + " <= " + number2;
                 }
                 if ( number1 >= number2 ) {
                    result = result + "\n" + number1 + " >= " + number2;
                 }
                 // Display results
                 JOptionPane.showMessageDialog(null, result, "Comparison Results",
                   JOptionPane.INFORMATION_MESSAGE );
                 System.exit( 0 );  // terminate application


    }
}