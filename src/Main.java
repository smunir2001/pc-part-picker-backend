import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.ParameterizedType;
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

        PartDatabase partDatabase = new PartDatabase();
        PCBuild pcBuild1 = new PCBuild(tempUser, partDatabase);
//        pcBuild1.addComponent("psu", 2);
//        pcBuild1.addComponent("gpu", 0);
//        pcBuild1.writeList();
//
//        pcBuild1.addComponent("psu", 0);
//        pcBuild1.addComponent("cpu", 0);
//        pcBuild1.addComponent("case", 0);
//        pcBuild1.addComponent("mobo", 0);
//        pcBuild1.removeComponent("mobo");
//        pcBuild1.addComponent("mobo", 1);
//        pcBuild1.addComponent("gpu", 2);
//        pcBuild1.writeList();
////
        PCBuild pcBuild2 = new PCBuild(tempUser2, partDatabase);
//        pcBuild2.addComponent("psu", 0);
//        pcBuild2.addComponent("cpu", 2);
//        pcBuild2.removeComponent("psu");
//        pcBuild2.removeComponent("cpu");
//        pcBuild2.writeList();

        pcBuild2.addComponent("psu", 0);
        pcBuild2.addComponent("cpu", 2);
        pcBuild2.writeList();

        pcBuild2.addComponent("case", 0);
        pcBuild2.addComponent("mobo", 1);
        pcBuild2.addComponent("gpu", 1);
        pcBuild2.writeList();
    }
}