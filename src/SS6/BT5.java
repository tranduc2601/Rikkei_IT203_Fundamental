package SS6;

public class BT5 {

    private String title;
    private String author;
    private int publishYear;

    public BT5(String title, String author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public void displayInfo() {
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + publishYear);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        BT5 book1 = new BT5("Lập trình Java từ zero đến hero", "CodeGym", 2023);
        BT5 book2 = new BT5("Clean Code", "Robert C. Martin", 2008);

        book1.displayInfo();
        book2.displayInfo();
    }
}