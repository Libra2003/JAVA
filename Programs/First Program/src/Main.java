import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    String s1,s2,s3;
    int n1,n2,n3;

    s1=JOptionPane.showInputDialog("Enter the first number: ");
    s2=JOptionPane.showInputDialog("Enter the second number:  ");
    s3=s1+s2;
    n1=Integer.parseInt(s1);
    n2=Integer.parseInt(s2);
    n3=n1+n2;
    JOptionPane.showMessageDialog(null,"The sum without conversation is ::"+s3);
    JOptionPane.showMessageDialog(null,"The sum with conversation is ::"+n3);


    }
}