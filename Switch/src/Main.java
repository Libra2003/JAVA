public class Main {
    public static void main(String[] args) {

        String var = "Zain";

        switch (var) {
            case "Tayyab" -> System.out.println("You are selected for the trip");
            case "Zain" -> System.out.println("You are selected for the job");
            case "Harry" -> System.out.println("U r out");
            default -> System.out.println("Have a nice ");
        }
    }
}