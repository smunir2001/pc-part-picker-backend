import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to PC Utopia");
        System.out.println("--------------------\n");

        Address tempAddress = new Address("123 Main St.", "Somerset", "New Jersey", "08873", "United States");
        User tempUser = new User("John", "Doe", "johndoe123@email.com", "johnDoe123", tempAddress);
        System.out.println(tempUser);

        FileWriter fileWriter = new FileWriter("data/Users.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println(tempUser.toString());
        printWriter.close();
    }
}