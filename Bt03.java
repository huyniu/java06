package baitapss6;
import java.util.Scanner;
public class Bt03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dsBienSo = null;
        int soLuong = 0;
        int luaChon = 0;
        String regexBienSo = "^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$";

        do {
            System.out.println("\n**************** QUẢN LÝ BIỂN SỐ XE ****************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                luaChon = 0;
            }

            // Chặn thao tác nếu chưa có dữ liệu
            if (dsBienSo == null && luaChon >= 2 && luaChon <= 5) {
                System.out.println("Vui lòng chọn mục 1 để thêm biển số xe trước!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng biển số xe cần thêm: ");
                    soLuong = Integer.parseInt(scanner.nextLine());
                    if (soLuong <= 0) {
                        System.out.println("Số lượng phải lớn hơn 0!");
                        break;
                    }

                    dsBienSo = new String[soLuong];
                    for (int i = 0; i < soLuong; i++) {
                        boolean hopLe = false;
                        while (!hopLe) {
                            System.out.print("Nhập biển số thứ " + (i + 1) + " (Định dạng XXY-XXX.XX, VD: 30F-123.45): ");
                            String bienSo = scanner.nextLine().trim().toUpperCase();

                            if (bienSo.matches(regexBienSo)) {
                                dsBienSo[i] = bienSo;
                                hopLe = true;
                            } else {
                                System.out.println("Lỗi: Biển số không đúng định dạng. Vui lòng nhập lại!");
                            }
                        }
                    }
                    System.out.println("Đã thêm thành công " + soLuong + " biển số!");
                    break;

                case 2:
                    System.out.println("--- DANH SÁCH BIỂN SỐ XE ---");
                    // Sử dụng StringBuilder để tối ưu hóa việc nối chuỗi khi in danh sách
                    StringBuilder sbDanhSach = new StringBuilder();
                    for (int i = 0; i < soLuong; i++) {
                        sbDanhSach.append(i + 1).append(". ").append(dsBienSo[i]).append("\n");
                    }
                    System.out.print(sbDanhSach.toString());
                    break;

                case 3:
                    System.out.print("Nhập biển số xe cần tìm kiếm chính xác: ");
                    String timKiemChinhXac = scanner.nextLine().trim().toUpperCase();
                    boolean timThay = false;

                    // Thuật toán tìm kiếm tuyến tính (Linear Search)
                    for (int i = 0; i < soLuong; i++) {
                        if (dsBienSo[i].equals(timKiemChinhXac)) {
                            System.out.println("Đã tìm thấy biển số " + timKiemChinhXac + " tại vị trí thứ " + (i + 1));
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Không tìm thấy biển số này trong danh sách.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã tỉnh cần tìm (VD: 29, 30, 51...): ");
                    String maTinh = scanner.nextLine().trim();
                    boolean coBienSoTinh = false;

                    System.out.println("--- CÁC BIỂN SỐ THUỘC TỈNH " + maTinh + " ---");
                    for (int i = 0; i < soLuong; i++) {
                        // Cắt 2 ký tự đầu tiên của chuỗi để so sánh với mã tỉnh
                        if (dsBienSo[i].startsWith(maTinh)) {
                            System.out.println("- " + dsBienSo[i]);
                            coBienSoTinh = true;
                        }
                    }

                    if (!coBienSoTinh) {
                        System.out.println("Không có biển số nào thuộc mã tỉnh " + maTinh);
                    }
                    break;

                case 5:
                    // Thuật toán sắp xếp nổi bọt (Bubble Sort) với chuỗi
                    for (int i = 0; i < soLuong - 1; i++) {
                        for (int j = 0; j < soLuong - i - 1; j++) {
                            // Hàm compareTo trả về số dương nếu chuỗi trước lớn hơn chuỗi sau
                            if (dsBienSo[j].compareTo(dsBienSo[j + 1]) > 0) {
                                String temp = dsBienSo[j];
                                dsBienSo[j] = dsBienSo[j + 1];
                                dsBienSo[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp danh sách biển số tăng dần theo từ điển!");
                    System.out.println("Chọn chức năng 2 để xem lại danh sách.");
                    break;

                case 6:
                    System.out.println("Chương trình kết thúc. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 6!");
                    break;
            }
        } while (luaChon != 6);

        scanner.close();
    }
}

