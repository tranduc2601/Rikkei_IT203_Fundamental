package SS7;

class User {
    private final int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Username: " + username);
    }
}

class UserManager {
    private static User[] userList = new User[10];
    private static int userCount = 0;

    public static void addUser(User u) {
        if (userCount < userList.length) {
            userList[userCount] = u;
            userCount++;
            System.out.println("Đã thêm user: " + u.getUsername());
        } else {
            System.out.println("Lỗi: Hệ thống đã đầy, không thể thêm người dùng mới!");
        }
    }

    public static boolean checkLogin(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (userList[i].getUsername().equals(username) && userList[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void printUsers() {
        System.out.println("\n--- DANH SÁCH NGƯỜI DÙNG HỆ THỐNG ---");
        for (int i = 0; i < userCount; i++) {
            userList[i].displayInfo();
        }
        System.out.println("-------------------------------------\n");
    }
}

public class BT6 {
    public static void main(String[] args) {
        User u1 = new User(1, "minhduc", "duc2006");
        User u2 = new User(2, "admin", "admin123");
        User u3 = new User(3, "guest", "123456");

        UserManager.addUser(u1);
        UserManager.addUser(u2);
        UserManager.addUser(u3);

        UserManager.printUsers();

        System.out.println(">> KIỂM TRA ĐĂNG NHẬP:");

        System.out.print("- Đăng nhập (minhduc/duc2006): ");
        System.out.println(UserManager.checkLogin("minhduc", "duc2006") ? "Thành công" : "Thất bại");

        System.out.print("- Đăng nhập (admin/sai_pass): ");
        System.out.println(UserManager.checkLogin("admin", "sai_pass") ? "Thành công" : "Thất bại");

        System.out.print("- Đăng nhập (khong_ton_tai/123): ");
        System.out.println(UserManager.checkLogin("khong_ton_tai", "123") ? "Thành công" : "Thất bại");
    }
}