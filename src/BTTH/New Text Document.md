# BÁO CÁO CHUYÊN ĐỀ: ANONYMOUS CLASS & SIMULATION LOOP
## 1. Anonymous Class (Lớp vô danh)
### Mục đích
- Khởi tạo đối tượng có hành vi đặc biệt (như Boss, Monster) ngay lập tức.
- Không cần tạo file .java riêng biệt.
- Tối ưu hóa cấu trúc dự án.
### Cú pháp triển khai (Ví dụ Goblin)
- Ghi đè (Override) phương thức `attack()` tại chỗ.
- Hành vi: Cắn trộm mục tiêu.
- Sát thương: Gây sát thương cố định (10 DMG).
- Bỏ qua thuộc tính `attackPower` thông thường.

## 2. Logic Nhân vật & Simulation Loop
### 2.1. Quản lý danh sách (Array & Null Check)
- Áp dụng tính đa hình (Polymorphism) để quản lý danh sách.
- Lưu trữ tất cả nhân vật trong mảng `GameCharacter[]`.
- Bắt buộc kiểm tra `null` trước khi thực hiện hành động.
- Mục đích: Tránh lỗi `NullPointerException` gây sập chương trình.
### 2.2. Vòng lặp mô phỏng (Simulation Loop)
- Bước 1: Thực hiện tấn công (`attack()`).
- Bước 2: Sử dụng chiêu cuối (`useUltimate()`).
- Bước 3: Hiển thị trạng thái sau lượt (`displayStatus()`).

## 3. Mindmap Chi tiết Nhóm 5
### Anonymous Class & Logic Goblin
- Đặc điểm Goblin
  - Hành vi: Cắn trộm
  - Sát thương: Cố định (10 DMG)
  - Không phụ thuộc thuộc tính attackPower
- Lợi ích kỹ thuật
  - Tạo class tạm thời
  - Override phương thức tại chỗ
  - Không làm rác thư mục Source code
### Simulation Loop & Thống kê
- Quản lý mảng
  - Lưu trữ: Warrior, Mage, Goblin
  - Kỹ thuật: Upcasting về GameCharacter
  - An toàn: Kiểm tra Null trước khi xử lý
- Hành động trong Loop
  - Tấn công (attack)
  - Chiêu cuối (useUltimate)
  - Xuất trạng thái (displayStatus)
- Thống kê & Kết quả
  - Biến Static: GameCharacter.count
  - Bảng trạng thái: Name, HP, Mana, Armor

## 4. Thống kê & Trạng thái cuối
### 4.1. Thống kê khởi tạo
- Dựa trên biến static `count` trong lớp cha.
- Kết quả: Đã khởi tạo thành công 3 nhân vật tham gia trận chiến.
### 4.2. Bảng trạng thái mô phỏng
- Yasuo: 400 HP | 20 Armor
- Veigar: 290 HP | 150 Mana
- Goblin: 50 HP

## 5. Kết luận
### Lợi ích của Anonymous Class
- Linh hoạt tạo các thực thể có hành vi riêng biệt (như Goblin).
- Vẫn đảm bảo tính thống nhất trong mảng quản lý.
### Sức mạnh của Simulation Loop
- Mở rộng số lượng nhân vật không giới hạn.
- Quản lý trạng thái trận đấu tự động và chính xác.