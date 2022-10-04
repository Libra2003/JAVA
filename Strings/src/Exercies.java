public class Exercies {
    public static void main(String[] args) {
        String name = "  Steve Irwein  ";
//Problem 1
        name = name.toLowerCase();
        System.out.println(name);
//Problem 2
        name = name.replace(' ','_');
        System.out.println(name);
//Problem 3
        String Letter = "Dear <|name|>, Thanks a lot";
        System.out.println(Letter);
        System.out.println(Letter.replace("name","Zain"));
//Problem 4
        String letter = "This Program contains  double or   triple Spaces";
        System.out.println(letter.indexOf("  "));
        System.out.println(letter.indexOf("   "));
        System.out.println(letter.indexOf("    "));
        //Problem 5

        System.out.println("\"Dear sir,\n\t This course is nice.\nThanks\" ");



    }
}
