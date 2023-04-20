import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataManager {
    private ArrayList<User> usersList = new ArrayList<>();
    // private ArrayList<PCBuild> buildsList = new ArrayList<PCBuild>();

    public DataManager() throws IOException {
        populateUsers();
    }

    private void populateUsers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/Users.txt"));
        String readLine;
        if (bufferedReader.readLine() == null) {
            System.out.println("No current users in the database.");
        } else {
            while ((readLine = bufferedReader.readLine()) != null) {
                System.out.println(readLine);
            }
            bufferedReader.close();
        }
    }
}
