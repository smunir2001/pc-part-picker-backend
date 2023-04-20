import javax.xml.crypto.Data;
import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to PC Utopia");
        System.out.println("--------------------\n");

        Address tempAddress = new Address("123 Main St.", "Somerset", "New Jersey", "08873", "United States");
        User tempUser = new User("John", "Doe", "johndoe123@email.com", "johnDoe123", tempAddress);

        Address tempAddress2 = new Address("456 Churchill Ln.", "Montgomery", "New Jersey", "08845", "United States");
        User tempUser2 = new User("Mary", "Smith", "marysmith237@email.com", "marySmith573", tempAddress2);

        DataManager dm = new DataManager();

//        FileWriter fileWriter = new FileWriter("data/Users.txt", true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        PrintWriter printWriter = new PrintWriter(bufferedWriter);
//        printWriter.println(tempUser.toString());
//        printWriter.print(tempUser2.toString());
//        printWriter.close();
    }
}