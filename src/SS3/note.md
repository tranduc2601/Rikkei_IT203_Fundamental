# Java String & Regex

## 1. Tổng quan về String
### Bản chất
- Là **Đối tượng** (Object) của lớp `java.lang.String`.
- Không phải kiểu nguyên thủy (primitive).
- Là dãy ký tự (char sequence).

### Tính Bất Biến (Immutability)
- **Định nghĩa**: Không thể thay đổi nội dung sau khi tạo.
- **Hệ quả**: Mọi thao tác sửa đổi (nối, cắt, viết hoa...) đều tạo ra một **Object MỚI**.
- **Lý do**: Để bảo mật, đồng bộ hóa và tối ưu bộ nhớ (String Pool).

### Cách khai báo & Bộ nhớ
- **Cách 1: Literal** (Khuyên dùng)
    - VD: `String s = "Hello";`
    - Lưu tại: **String Constant Pool (SCP)** trong Heap.
    - Cơ chế: Tái sử dụng nếu chuỗi đã tồn tại -> Tiết kiệm RAM.
- **Cách 2: Từ khóa new**
    - VD: `String s = new String("Hello");`
    - Lưu tại: **Heap Memory** (Tạo mới hoàn toàn, không vào Pool).
    - Cơ chế: Luôn tạo object mới -> Tốn RAM hơn.

### So sánh (Rất quan trọng)
- `==`: So sánh **ĐỊA CHỈ** ô nhớ (Reference).
- `.equals()`: So sánh **NỘI DUNG** văn bản (Value).
- **Lưu ý**: Luôn dùng `.equals()` cho chuỗi.

## 2. Các phương thức xử lý (Methods)
### Truy xuất
- `length()`: Lấy độ dài.
- `charAt(index)`: Lấy ký tự tại vị trí.
- `indexOf(str)`: Tìm vị trí xuất hiện (trả về -1 nếu không thấy).

### So sánh & Kiểm tra
- `equals(str)`: So sánh nội dung (có phân biệt hoa/thường).
- `equalsIgnoreCase(str)`: So sánh nội dung (bỏ qua hoa/thường).
- `contains(str)`: Kiểm tra tồn tại.

### Biến đổi (Trả về chuỗi mới)
- `substring(start, end)`: Cắt chuỗi.
- `replace(old, new)`: Thay thế.
- `trim()`: Xóa khoảng trắng 2 đầu.
- `toLowerCase()` / `toUpperCase()`.

### Tách & Nối
- `split(regex)`: Tách thành mảng `String[]`.
- `concat(str)`: Nối chuỗi (ít dùng, thường dùng dấu `+`).

## 3. Bài toán Hiệu năng: StringBuilder vs StringBuffer
### Vấn đề của String
- Dùng `String` + `String` trong vòng lặp -> Tạo vô số object rác -> Tràn bộ nhớ (Memory Leak).

### Giải pháp
- **StringBuilder** (Khuyên dùng cho Android/Single Thread)
    - Đặc điểm: Có thể thay đổi (Mutable).
    - Ưu điểm: **Nhanh nhất**.
    - Nhược điểm: Không an toàn đa luồng (Non-thread-safe).
    - Dùng khi: Xử lý chuỗi trong vòng lặp, ứng dụng đơn luồng.
- **StringBuffer** (Ít dùng hơn)
    - Đặc điểm: Có thể thay đổi (Mutable).
    - Cơ chế: Đồng bộ hóa (`synchronized`).
    - Ưu điểm: An toàn đa luồng (Thread-safe).
    - Nhược điểm: Chậm hơn StringBuilder.

### Các hàm chung (Mutable)
- `append()`: Nối thêm vào cuối.
- `insert()`: Chèn vào giữa.
- `reverse()`: Đảo ngược.
- `toString()`: Chuyển về String để hiển thị.

## 4. Biểu thức chính quy (Regex)
### Khái niệm
- Quy định mẫu tìm kiếm (Pattern).
- Thư viện: `java.util.regex`.
- Class chính: `Pattern` (Biên dịch mẫu) & `Matcher` (Thực thi).

### Cú pháp cốt lõi
- **Ký tự đặc biệt**:
    - `.`: Bất kỳ ký tự nào.
    - `^`: Bắt đầu dòng.
    - `$`: Kết thúc dòng.
- **Lớp ký tự**:
    - `[abc]`: a hoặc b hoặc c.
    - `[^abc]`: Khác a, b, c.
    - `[0-9]`: Số (giống `\d`).
- **Ký tự định sẵn (Java phải dùng `\\`)**:
    - `\\d`: Số.
    - `\\w`: Chữ cái hoặc số.
    - `\\s`: Khoảng trắng.
- **Định lượng**:
    - `*`: 0 hoặc nhiều.
    - `+`: 1 hoặc nhiều.
    - `?`: 0 hoặc 1.
    - `{n,m}`: Từ n đến m lần.

### Ứng dụng
- Validate Form (Email, Phone, Password).
- Crawler (Cào dữ liệu).
- Replace (Thay thế phức tạp).