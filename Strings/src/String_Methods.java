public class String_Methods {
    public static void main(String[] args){
        String name = "Zain";
        System.out.println(name.length());

        String ustring = name.toUpperCase();
        System.out.println(ustring);

        String lstring = name.toLowerCase();
        System.out.println(lstring);

        String nonTrimmedString = "     Harry     ";
        System.out.println(nonTrimmedString);

        String trimmedString = nonTrimmedString.trim();
        System.out.println(trimmedString);

        System.out.println(name.substring(1));
        System.out.println(name.substring(0,3));

        String name1 = "harry";
        System.out.println(name1.replace('r','p'));

        System.out.println(name1.replace("r","eir"));

        System.out.println(name.startsWith("Za"));
        System.out.println(name.endsWith("dd"));

        System.out.println(name.charAt(2));


        String modifiedName = "Harryrryrry";
        System.out.println(modifiedName.indexOf("rry"));
        System.out.println(modifiedName.indexOf("rry", 4));
        System.out.println(modifiedName.lastIndexOf("rry", 7));

        System.out.println(name.equals("Harry"));
        System.out.println(name.equalsIgnoreCase("HarRY"));

        System.out.println("\\I am escape sequence\" double quote ");
    }
}
