package usemap;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        runMainProgram(scanner, studentManagement);
    }

    private static void runMainProgram(Scanner scanner, StudentManagement studentManagement) {
        int choice;
        do {
            menu();
            System.out.print("Mời bạn chọn : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    studentManagement.displayStudentInMap();
                    break;
                }
                case 2: {
                    addStudentInfo(scanner, studentManagement);
                    break;
                }
                case 3: {
                    editStudentInfo(scanner, studentManagement);
                    break;
                }
                case 4: {
                    deleteStudentWithId(scanner, studentManagement);
                    break;
                }
                case 5: {
                    findStudentInPoint(scanner, studentManagement);
                    break;
                }
                case 6: {
                    findStudentWithId(scanner, studentManagement);
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println("SỐ BẠN NHẬP KHÔNG CÓ TRONG MENU. MỜI NHẬP LẠI!");
                    break;
                }
            }

        } while (choice != 0);
    }

    private static void addStudentInfo(Scanner scanner, StudentManagement studentManagement) {
        System.out.println("THÊM THÔNG TIN SINH VIÊN");
        Student student = createStudent(scanner);
        studentManagement.addStudentInMap(student);
    }

    private static void editStudentInfo(Scanner scanner, StudentManagement studentManagement) {
        System.out.println("CẬP NHẬT THÔNG TIN SINH VIÊN");
        System.out.print("Nhập vào mã sinh viên cần sửa : ");
        String id = scanner.nextLine();
        boolean checkId = studentManagement.findIndex(id);
        if (!checkId) {
            Student student = createStudent(scanner);
            studentManagement.editStudentInMap(id, student);
            System.out.println("SỬA THÀNH CÔNG");
        } else {
            System.out.println("Không tìm thấy sinh viên có mã sinh viên là : " + id);
        }
    }

    private static void deleteStudentWithId(Scanner scanner, StudentManagement studentManagement) {
        System.out.println("XÓA THÔNG TIN SINH VIÊN");
        System.out.print("Nhập vào mã sinh viên cần xóa : ");
        String id = scanner.nextLine();
        boolean checkId = studentManagement.findIndex(id);
        if (!checkId) {
            studentManagement.deleteStudentInMap(id);
            System.out.println("XÓA THÀNH CÔNG");
        } else {
            System.out.println("Không tìm thấy sinh viên có mã sinh viên là : " + id);
        }
    }

    private static void findStudentInPoint(Scanner scanner, StudentManagement studentManagement) {
        subMenu();
        System.out.println("Mời bạn chọn : ");
        int subChoice = scanner.nextInt();
        for (Map.Entry<String, Student> student : studentManagement.getStudentMap().entrySet()) {
            boolean weak = student.getValue().getPoint() < 5;
            boolean normal = student.getValue().getPoint() < 6.5;
            boolean good = student.getValue().getPoint() < 8;
            boolean veryGood = student.getValue().getPoint() < 10;
            switch (subChoice) {
                case 1: {
                    if (weak) {
                        System.out.println(student);
                    }
                    break;
                }
                case 2: {
                    if (normal && !weak) {
                        System.out.println(student);
                    }
                    break;
                }
                case 3: {
                    if (good && !weak && !normal) {
                        System.out.println(student);
                    }
                    break;
                }
                case 4: {
                    if (veryGood && !good && !weak && !normal) {
                        System.out.println(student);
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private static void findStudentWithId(Scanner scanner, StudentManagement studentManagement) {
        System.out.println("TÌM THÔNG TIN SINH VIÊN");
        System.out.print("Nhập vào mã sinh viên cần tìm : ");
        String id = scanner.nextLine();
        boolean checkId = studentManagement.findIndex(id);
        if (!checkId) {
            System.out.println(studentManagement.getStudentMap().get(id).toString());
        } else {
            System.out.println("Không tìm thấy sinh viên có mã sinh viên là : " + id);
        }
    }

    private static void subMenu() {
        System.out.println("-----------------------");
        System.out.println("1. Hiển thị thông tin sinh viên điểm yếu (< 5)");
        System.out.println("2. Hiển thị  thông tin sinh viên điểm trung bình (5 -> 6.5)");
        System.out.println("3. Hiển thị  thông tin sinh viên điểm khá (6.5 -> 8)");
        System.out.println("4. Hiển thị  thông tin sinh viên điểm giỏi (8 -> 10)");
        System.out.println("5. Quay lại");
        System.out.println("-----------------------");
    }


    private static Student createStudent(Scanner scanner) {
        System.out.print("Mã sinh viên : ");
        String id = scanner.nextLine();
        System.out.print("Họ và tên : ");
        String name = scanner.nextLine();
        System.out.print("Quê quán : ");
        String country = scanner.nextLine();
        System.out.print("Lớp : ");
        String className = scanner.nextLine();
        System.out.print("Điểm : ");
        double point = scanner.nextDouble();
        return new Student(id, name, country, className, point);
    }

    private static void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("MENU");
        System.out.println("1. Xem danh sách lớp");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Cập nhật thông tin");
        System.out.println("4. Xóa thông tin sinh viên");
        System.out.println("5. Tìm kiếm thông tin sinh viên theo điểm");
        System.out.println("6. Tìm kiếm thông tin theo mã sinh viên");
        System.out.println("0. Thoát chương trình");
        System.out.println("------------------------------------------------");
    }
}
