# Kiến thức OOP - Session 6
## 1. Class (Lớp)
### Là bản vẽ thiết kế / Khuôn đúc
### Không chiếm không gian bộ nhớ vật lý
### Gồm 2 thành phần chính:
#### Thuộc tính (Attributes): Các đặc điểm, trạng thái (VD: màu sắc, tên)
#### Phương thức (Methods): Các hành vi, chức năng (VD: chạy, hiển thị)

## 2. Object (Đối tượng)
### Là thực thể có thật được tạo ra từ Class
### Chiếm dung lượng bộ nhớ (vùng nhớ Heap)
### Khởi tạo bằng từ khóa `new`
### Các đối tượng sinh ra từ cùng 1 class hoạt động hoàn toàn độc lập với nhau

## 3. Constructor (Hàm khởi tạo)
### Đặc điểm bắt buộc:
#### Tên hàm phải giống hệt tên Class
#### Tuyệt đối không có kiểu trả về (không dùng cả `void`)
#### Tự động được gọi khi dùng lệnh `new`
### Phân loại:
#### Constructor mặc định (Không có tham số)
#### Constructor có tham số (Dùng để truyền dữ liệu ban đầu)
### Constructor Overloading (Nạp chồng):
#### Cho phép 1 Class có nhiều Constructor
#### Bắt buộc phải khác nhau về số lượng hoặc kiểu dữ liệu của tham số

## 4. Từ khóa `this`
### Là biến tham chiếu chỉ đến chính đối tượng hiện tại đang gọi hàm
### Tác dụng lớn nhất: Dùng để phân biệt khi tên thuộc tính của Class và tên tham số truyền vào bị trùng nhau (VD: `this.name = name;`)

## 5. Encapsulation (Tính đóng gói)
### Bản chất: Lớp khiên bảo vệ, che giấu dữ liệu bên trong đối tượng
### Công thức triển khai:
#### Bước 1: Khai báo tất cả thuộc tính là `private` (Kín bưng)
#### Bước 2: Tạo các hàm `public` để giao tiếp: Getter và Setter
### Getter (Hàm lấy dữ liệu):
#### Trả về giá trị của thuộc tính (Dùng `return`)
### Setter (Hàm gán dữ liệu):
#### Nhận tham số đầu vào để cập nhật cho thuộc tính
#### Thường kẹp thêm lệnh `if-else` để kiểm tra tính hợp lệ của dữ liệu trước khi gán (Validation)