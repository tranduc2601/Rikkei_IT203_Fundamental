package SS6;

public class BT6 {

    private String id;
    private String username;
    private String password;
    private String email;

    public BT6(String id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = "defaultPass123";
        this.email = "default@email.com";

        setPassword(password);
        setEmail(email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
        } else {
            System.out.println("Lỗi (" + username + "): Password không được để trống!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Lỗi (" + username + "): Email không hợp lệ!");
        }
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Password: ***");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        BT6 user1 = new BT6("U01", "tranminhduc", "duc2006", "duc@gmail.com");
        user1.displayInfo();

        BT6 user2 = new BT6("U02", "guest_user", "", "guest_email");
        user2.displayInfo();

        System.out.println("--- Tiến hành cập nhật lại dữ liệu cho U02 ---");
        user2.setPassword("guestSecure456");
        user2.setEmail("guest@gmail.com");
        user2.displayInfo();
    }
}