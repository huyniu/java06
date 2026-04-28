package baitapss6;
import java.util.Scanner;
public class Bt01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] diemSV = null; // Khởi tạo mảng điểm
        int soLuong = 0;
        int luaChon = 0;

        do {
            // Hiển thị Menu
            System.out.println("\n*******************QUẢN LÝ ĐIỂM SV*******************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            luaChon = scanner.nextInt();

            if (diemSV == null && luaChon >= 2 && luaChon <= 7) {
                System.out.println("Vui lòng nhập danh sách điểm (Lựa chọn 1) trước khi thực hiện các chức năng khác!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    soLuong = scanner.nextInt();
                    if (soLuong <= 0) {
                        System.out.println("Số lượng sinh viên phải lớn hơn 0!");
                        break;
                    }
                    diemSV = new double[soLuong];
                    for (int i = 0; i < soLuong; i++) {
                        System.out.print("Nhập điểm của sinh viên thứ " + (i + 1) + ": ");
                        diemSV[i] = scanner.nextDouble();
                    }
                    System.out.println("Đã nhập xong danh sách điểm!");
                    break;

                case 2:
                    System.out.println("--- Danh sách điểm sinh viên ---");
                    for (int i = 0; i < soLuong; i++) {
                        System.out.print(diemSV[i] + "  ");
                    }
                    System.out.println();
                    break;

                case 3:
                    double tong = 0;
                    for (int i = 0; i < soLuong; i++) {
                        tong += diemSV[i];
                    }
                    double diemTB = tong / soLuong;
                    System.out.printf("Điểm trung bình của sinh viên là: %.2f\n", diemTB);
                    break;

                case 4:
                    double max = diemSV[0];
                    double min = diemSV[0];
                    // Thuật toán tìm kiếm tuần tự
                    for (int i = 1; i < soLuong; i++) {
                        if (diemSV[i] > max) max = diemSV[i];
                        if (diemSV[i] < min) min = diemSV[i];
                    }
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    break;

                case 5:
                    int dat = 0, truot = 0;
                    for (int i = 0; i < soLuong; i++) {
                        if (diemSV[i] >= 5) dat++;
                        else truot++;
                    }
                    System.out.println("Số lượng sinh viên ĐẠT: " + dat);
                    System.out.println("Số lượng sinh viên TRƯỢT: " + truot);
                    break;

                case 6:
                    for (int i = 0; i < soLuong - 1; i++) {
                        for (int j = 0; j < soLuong - i - 1; j++) {
                            if (diemSV[j] > diemSV[j + 1]) {
                                double temp = diemSV[j];
                                diemSV[j] = diemSV[j + 1];
                                diemSV[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp điểm tăng dần thành công! Chọn 2 để xem lại danh sách.");
                    break;

                case 7:
                    int gioiXuatSac = 0;
                    for (int i = 0; i < soLuong; i++) {
                        if (diemSV[i] >= 8) gioiXuatSac++;
                    }
                    System.out.println("Số lượng sinh viên xếp loại Giỏi và Xuất sắc: " + gioiXuatSac);
                    break;

                case 8:
                    System.out.println("Chương trình đã thoát. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 8!");
                    break;
            }
        } while (luaChon != 8);

        scanner.close();
    }
}
