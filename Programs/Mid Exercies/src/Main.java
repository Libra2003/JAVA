import javax.swing.JOptionPane;
class Patient{
    String Name;
    String Father_Name;
    String age;
    int value;
    void setRecord(){
        Name = JOptionPane.showInputDialog("Enter Your Name: ");
        Father_Name = JOptionPane.showInputDialog("Enter Father Name: ");
        age = JOptionPane.showInputDialog("Enter your Age: ");
        value =Integer.parseInt(age);
    }
    void showRecord(){
        JOptionPane.showMessageDialog(null,"Your Name: " + Name,"Name ",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"Age:"+value,"Age ",JOptionPane.PLAIN_MESSAGE );
        JOptionPane.showMessageDialog(null, "Father Name:"+ Father_Name,"Father ",JOptionPane.PLAIN_MESSAGE);
    }
}
public class Main {

    public static void main(String[] args) {
        String num1 ;
        num1 =  JOptionPane.showInputDialog("Enter Number of Ptients: ");
        int num = Integer.parseInt(num1);
        Patient obj[]=new Patient[num];
        for (int i = 0;i <num;i++){
            obj[i]=new Patient();
        }
        for (int i = 0;i <num;i++){
            obj[i].setRecord();
        }
        for (int i = 0;i <num;i++){
            obj[i].showRecord();
        }
    }
}