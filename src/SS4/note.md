# Session 04 - String & Regex

## 1. Lớp String (Chuỗi)
### Bản chất
- Là Đối tượng (Object), thuộc java.lang.String
- Không phải kiểu dữ liệu nguyên thủy
### Tính Bất biến (Immutable)
- Nội dung không thể thay đổi sau khi tạo
- Mọi thao tác chỉnh sửa đều tạo ra Object mới (dễ gây rác bộ nhớ)
### Khai báo & Lưu trữ
- Trực tiếp (Literal - "..."): Lưu ở String Constant Pool (tối ưu bộ nhớ)
- Dùng từ khóa 'new': Tạo Object mới trực tiếp trên vùng nhớ Heap
### Nguyên tắc So sánh
- Toán tử ==: Chỉ so sánh địa chỉ ô nhớ
- Hàm .equals(): So sánh giá trị nội dung bên trong

## 2. Các phương thức thông dụng (String)
### Nhóm Truy xuất thông tin
- length(): Lấy tổng số ký tự
- charAt(index): Lấy ký tự tại vị trí (bắt đầu từ 0)
- indexOf(str): Tìm vị trí xuất hiện đầu tiên của chuỗi con
### Nhóm Kiểm tra
- equals() / equalsIgnoreCase(): Kiểm tra nội dung (có/không phân biệt hoa thường)
- contains(): Kiểm tra xem có chứa chuỗi con không
### Nhóm Biến đổi (Tạo chuỗi mới)
- substring(start, end): Cắt lấy chuỗi con
- trim(): Gọt sạch khoảng trắng dư thừa ở 2 đầu
- toLowerCase() / toUpperCase(): Ép kiểu viết hoa/viết thường
- replace(old, new): Thay thế ký tự/chuỗi
### Nhóm Tách & Nối
- split(regex): Băm chuỗi thành mảng (String[])
- concat() / Toán tử +: Ghép nối các chuỗi lại với nhau

## 3. Lớp StringBuilder & StringBuffer
### Mục đích ra đời
- Giải quyết bài toán tràn bộ nhớ (Memory Leak) khi nối chuỗi liên tục bằng String
- Đặc tính: Có thể thay đổi (Mutable) - Sửa trực tiếp trên Object hiện tại
### StringBuilder
- Tốc độ: Nhanh nhất
- An toàn luồng: Không (Non-thread-safe)
- Ứng dụng: Phổ biến nhất, dùng để nối chuỗi trong vòng lặp (đơn luồng)
### StringBuffer
- Tốc độ: Chậm hơn StringBuilder
- An toàn luồng: Có (Thread-safe / Synchronized)
- Ứng dụng: Thao tác chuỗi trong môi trường đa luồng
### Các phương thức chung
- append(): Nối thêm dữ liệu vào cuối
- insert(): Chèn dữ liệu vào vị trí bất kỳ
- delete(): Xóa đoạn ký tự
- reverse(): Đảo ngược toàn bộ chuỗi
- toString(): Chốt kết quả, chuyển đổi lại thành String

## 4. Biểu thức chính quy (Regex)
### Khái niệm
- Là một mẫu tìm kiếm (Search Pattern) cực mạnh
- Ứng dụng: Xác thực dữ liệu (Validate), Trích xuất (Extract), Thay thế (Replace)
### Lớp cốt lõi (java.util.regex)
- Pattern: Biên dịch chuỗi mẫu
- Matcher: Bộ máy thực thi lệnh so khớp
### Cú pháp cơ bản cần thuộc
- \d: Chữ số [0-9]
- \w: Chữ cái, chữ số, dấu gạch dưới
- \s: Khoảng trắng (Space, Tab, Enter)
- ^: Bắt đầu chuỗi
- $: Kết thúc chuỗi
### Các bộ định lượng (Quantifiers)
- *: Xuất hiện 0 hoặc nhiều lần
- +: Xuất hiện 1 hoặc nhiều lần
- ?: Xuất hiện 0 hoặc 1 lần
- {n,m}: Xuất hiện từ n đến m lần
### Kỹ thuật nâng cao
- Capturing Groups ( ): Đóng ngoặc để chia nhóm, dùng matcher.group() để trích xuất từng mảnh dữ liệu
- Pattern Flags: Bỏ qua viết hoa/thường (Pattern.CASE_INSENSITIVE)