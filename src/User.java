public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int userID;
    private Address address;

    public User() {}

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        setUserID();
    }

    public User(String firstName, String lastName, String email, String password, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        setUserID();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    private void setUserID() {
        this.userID = Math.abs((this.firstName + " " + this.lastName + " " + this.email).hashCode());
    }

    public int getUserID() {
        return this.userID;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address.toString();
    }

    @Override
    public String toString() {
        String userOutput = this.userID + "\n" + this.firstName + " " + this.lastName + "\n" + this.email + "\n" + this.password +
                "\n" + this.getAddress();
        return userOutput;
    }
}
