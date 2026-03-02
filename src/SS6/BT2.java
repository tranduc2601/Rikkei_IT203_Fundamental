package SS6;

public class BT2 {

    String username;
    String password;
    String email;

    public BT2(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void displayInfo() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Password: ***");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        BT2 userAccount = new BT2("user01", "oldPass123", "user01@gmail.com");

        userAccount.displayInfo();

        userAccount.changePassword("newSecurePass456");

        userAccount.displayInfo();
    }
}