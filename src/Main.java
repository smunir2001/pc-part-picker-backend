public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to PC Utopia");
        System.out.println("--------------------\n");

        Address tempAddress = new Address("123 Main St.", "Somerset", "New Jersey", "08873", "United States");
        User tempUser = new User("John", "Doe", "johndoe123@email.com", "johnDoe123", tempAddress);
        System.out.println(tempUser);
    }
}