package baitapss6;
import java.util.Scanner;
public class Bt02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hoTen = "";
        String email = "";
        String soDienThoai = "";
        String matKhau = "";
        int luaChon = 0;

        do {
            // Hiển thị Menu
            System.out.println("\n******************* QUẢN LÝ NGƯỜI DÙNG *******************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            // Xử lý lỗi trôi lệnh khi nhập số
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                luaChon = 0;
            }

            // Kiểm tra xem người dùng đã nhập thông tin chưa (trừ chọn 1 và 6)
            if (hoTen.isEmpty() && luaChon >= 2 && luaChon <= 5) {
                System.out.println("Vui lòng chọn mục 1 để nhập thông tin trước!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.println("--- NHẬP THÔNG TIN ---");
                    System.out.print("Nhập họ và tên: ");
                    hoTen = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    soDienThoai = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    matKhau = scanner.nextLine();
                    System.out.println("Đã ghi nhận thông tin!");
                    break;

                case 2:
                    System.out.println("--- CHUẨN HÓA HỌ TÊN ---");
                    String[] cacTu = hoTen.trim().replaceAll("\\s+", " ").split(" ");
                    StringBuilder sb = new StringBuilder();
                    for (String tu : cacTu) {
                        if (!tu.isEmpty()) {
                            sb.append(Character.toUpperCase(tu.charAt(0)))
                                    .append(tu.substring(1).toLowerCase())
                                    .append(" ");
                        }
                    }
                    hoTen = sb.toString().trim();
                    System.out.println("Họ tên sau khi chuẩn hóa: " + hoTen);
                    break;

                case 3:
                    System.out.println("--- KIỂM TRA EMAIL ---");
                    String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
                    if (email.matches(regexEmail)) {
                        System.out.println("Email hợp lệ: " + email);
                    } else {
                        System.out.println("Email KHÔNG hợp lệ! Vui lòng nhập đúng định dạng (VD: example@domain.com).");
                    }
                    break;

                case 4:
                    System.out.println("--- KIỂM TRA SỐ ĐIỆN THOẠI ---");
                    String regexPhone = "^(0|\\+84)(3|5|7|8|9)[0-9]{8}$";
                    if (soDienThoai.matches(regexPhone)) {
                        System.out.println("Số điện thoại hợp lệ: " + soDienThoai);
                    } else {
                        System.out.println("Số điện thoại KHÔNG hợp lệ! Phải là số di động tại Việt Nam (10 số).");
                    }
                    break;

                case 5:
                    System.out.println("--- KIỂM TRA MẬT KHẨU ---");
                    String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!^&*]).{8,}$";
                    if (matKhau.matches(regexPassword)) {
                        System.out.println("Mật khẩu hợp lệ (Mạnh).");
                    } else {
                        System.out.println("Mật khẩu KHÔNG hợp lệ! Cần tối thiểu 8 ký tự, gồm chữ hoa, chữ thường, số và ký tự đặc biệt.");
                    }
                    break;

                case 6:
                    System.out.println("Chương trình kết thúc. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 6.");
                    break;
            }
        } while (luaChon != 6);

        scanner.close();
    }
}
