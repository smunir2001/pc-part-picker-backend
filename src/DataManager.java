import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataManager {
    private ArrayList<User> usersList = new ArrayList<>();
    // private ArrayList<PCBuild> buildsList = new ArrayList<PCBuild>();

    public DataManager() {}

    private void populateUsers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/Users.txt"));
        String readLine;
        if (bufferedReader.readLine() == null) {
            System.out.println("data/Users.txt is empty.");
        }
    }
}
