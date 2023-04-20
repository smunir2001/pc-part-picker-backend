import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DataManager {
    private ArrayList<User> usersList = new ArrayList<>();
    // private ArrayList<PCBuild> buildsList = new ArrayList<PCBuild>();

    public DataManager() throws IOException {
        populateUsers();
    }

    private String[] getFullName(String input) {
        String[] fullName = input.split(" ");
        return fullName;
    }

    private String[] parseAddress2(String input) {
        String[] parsedAddress = input.split(" ");
        return parsedAddress;
    }
    private void populateUsers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/Users.txt"));
        File inputFile = new File("data/Users.txt");
        if (inputFile.length() == 0) {
            System.out.println("No users found in the database.");
            return;
        }
        String readLine;
        User tempUser = new User();
        Address tempAddress = new Address();
        int i = 0;
        while ((readLine = bufferedReader.readLine()) != null) {
            if (i == 0) {
                int userID = Integer.parseInt(readLine);
                tempUser.setUserID(userID);
                i++;
            } else if (i == 1) {
                String[] fullName = getFullName(readLine);
                String firstName = fullName[0];
                String lastName = fullName[1];
                tempUser.setFirstName(firstName);
                tempUser.setLastName(lastName);
                i++;
            } else if (i == 2) {
                String email = readLine;
                tempUser.setEmail(email);
                i++;
            } else if (i == 3) {
                String password = readLine;
                tempUser.setPassword(readLine);
                i++;
            } else if (i == 4) {
                String streetAddress = readLine;
                tempAddress.setStreetAddress(streetAddress);
                i++;
            } else if (i == 5) {
                String[] parsedAddress = parseAddress2(readLine);
                tempAddress.setCity(parsedAddress[0] + "\b");
                tempAddress.setState(parsedAddress[1] + " " + parsedAddress[2]);
                tempAddress.setZip(parsedAddress[3]);
                i++;
            } else if (i == 6){
                String country = readLine;
                tempAddress.setCountry(country);
                i++;
            }
            if (readLine.equals("-------")) {
                tempUser.setAddress(tempAddress);
                System.out.println(tempUser);
                usersList.add(tempUser);
                i = 0;
            }
        }
    }
}
