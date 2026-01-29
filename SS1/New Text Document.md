# Java Fundamentals

## 1. Tổng quan
### Giới thiệu
- Cha đẻ: Sun Microsystems (1995) -> Oracle
- Mục tiêu: Dễ học, An toàn, Độc lập nền tảng
- Triết lý: "Write Once, Run Anywhere" (WORA)

### Đặc điểm nổi bật
- Hướng đối tượng (OOP)
- Quản lý bộ nhớ tự động (Garbage Collection)
- Đa luồng (Multithreading)
- Bảo mật cao

### Ứng dụng thực tế
- Web Backend (Spring, Java EE)
- Mobile App (Android)
- Enterprise (Ngân hàng, CRM)
- Big Data

## 2. Thành phần cốt lõi (Core Components)
### JVM (Java Virtual Machine)
- Là "Máy ảo" chạy bytecode
- Nhiệm vụ:
    - Dịch bytecode (.class) sang mã máy
    - Quản lý bộ nhớ (Heap/Stack)
    - Garbage Collection (GC)
- Đặc điểm: Mỗi OS có JVM riêng -> Giúp Java đa nền tảng

### JRE (Java Runtime Environment)
- Môi trường để CHẠY ứng dụng
- Bao gồm: JVM + Thư viện chuẩn (Core Libs)
- Dành cho: Người dùng cuối (User)

### JDK (Java Development Kit)
- Bộ công cụ để LẬP TRÌNH
- Bao gồm: JRE + Trình biên dịch (javac) + Tools (Debug, Javadoc)
- Dành cho: Lập trình viên (Developer)

### Quy trình hoạt động
- Code (.java) -> Javac -> Bytecode (.class) -> JVM -> OS

## 3. Biến & Bộ nhớ (Memory)
### Phân loại vùng nhớ
- **Stack (Ngăn xếp)**
    - Lưu: Biến cục bộ, Tham số, Địa chỉ tham chiếu
    - Tốc độ: Rất nhanh
    - Quản lý: Tự động (LIFO)
- **Heap (Vùng nhớ động)**
    - Lưu: Đối tượng (Object), từ khóa `new`
    - Tốc độ: Chậm hơn Stack
    - Quản lý: Garbage Collector (GC)

### So sánh quan trọng
- Primitive nằm ở Stack
- Reference (Object) nằm ở Heap, Stack chỉ giữ địa chỉ
- **Lưu ý:** String là Reference Type (nằm ở Heap)

## 4. Kiểu dữ liệu (Data Types)
### Primitive (Nguyên thủy)
- Đặc điểm: Lưu giá trị thực, hiệu năng cao
- 8 loại:
    - Số nguyên: byte, short, int, long
    - Số thực: float, double
    - Khác: char, boolean

### Reference (Tham chiếu)
- Đặc điểm: Lưu địa chỉ bộ nhớ, có phương thức
- Loại: String, Array, Class, Interface
- Có thể nhận giá trị `null`

### Wrapper Class
- Dùng để bao bọc Primitive thành Object (VD: int -> Integer)
- Dùng trong Collection (ArrayList)

## 5. Toán tử (Operators)
### Số học
- `+`, `-`, `*`, `/`
- `%`: Chia lấy dư

### So sánh
- `==`, `!=`, `>`, `<`, `>=`, `<=`
- **Lưu ý:** Không dùng `==` để so sánh nội dung String (Phải dùng `.equals()`)

### Logic
- `&&` (AND)
- `||` (OR)
- `!` (NOT)

### Tăng giảm
- `++` (Tăng 1), `--` (Giảm 1)
- Phân biệt Tiền tố (`++x`) và Hậu tố (`x++`)

## 6. Nhập & Xuất (Input/Output)
### Xuất dữ liệu (System.out)
- `print()`: Không xuống dòng
- `println()`: Có xuống dòng
- `printf()`: Có định dạng (%d, %.2f)

### Nhập dữ liệu (Scanner)
- Khởi tạo: `Scanner sc = new Scanner(System.in);`
- Các hàm:
    - `nextInt()`: Nhập số nguyên
    - `nextDouble()`: Nhập số thực
    - `nextLine()`: Nhập chuỗi
- **Lỗi thường gặp:** Trôi lệnh khi dùng `nextLine()` ngay sau `nextInt()`
    - *Fix:* Thêm `sc.nextLine()` để nuốt dòng thừa.