package arraylist;

import java.util.Collections;
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
            Collections.sort(studentManagement.getStudents());
            switch (choice) {
                case 1: {
                    studentManagement.displayStudent();
                    break;
                }
                case 2: {
                    addStudentInList(scanner, studentManagement);
                    break;
                }
                case 3: {
                    updateStudentInfoWithId(scanner, studentManagement);
                    break;
                }
                case 4: {
                    deleteStudentWithId(scanner, studentManagement);
                    break;
                }
                case 5: {
                    displayStudentInPoint(scanner, studentManagement);
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
                }

            }

        } while (choice != 0);
    }

    private static void displayStudentInPoint(Scanner scanner, StudentManagement studentManagement) {
        subMenu();
        System.out.println("Mời bạn chọn : ");
        int subChoice = scanner.nextInt();
        for (Student student : studentManagement.getStudents()) {
            boolean weak = student.getPoint() < 5;
            boolean normal = student.getPoint() < 6.5;
            boolean good = student.getPoint() < 8;
            boolean veryGood = student.getPoint() < 10;
            switch (subChoice) {
                case 1: {
                    if (weak) {
                        System.out.println(student);
                    }
                    break;
                }
                case 2: {
                    if (normal && !weak){
                        System.out.println(student);
                    }
                    break;
                }
                case 3: {
                    if (good && !weak && !normal){
                        System.out.println(student);
                    }
                    break;
                }
                case 4: {
                    if (veryGood && !good && !weak && !normal){
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

    private static void subMenu() {
        System.out.println("-----------------------");
        System.out.println("1. Hiển thị thông tin sinh viên điểm yếu (< 5)");
        System.out.println("2. Hiển thị thông tin sinh viên điểm trung bình (5 -> 6.5)");
        System.out.println("3. Hiển thị thông tin sinh viên điểm khá (6.5 -> 8)");
        System.out.println("4. Hiển thị thông tin sinh viên điểm giỏi (8 -> 10)");
        System.out.println("5. Quay lại");
        System.out.println("-----------------------");
    }

    private static void addStudentInList(Scanner scanner, StudentManagement studentManagement) {
        System.out.println("THÊM THÔNG TIN SINH VIÊN");
        Student student = createStudent(scanner);
        studentManagement.addStudent(student);
        System.out.println("THÊM THÀNH CÔNG");
    }

    private static void updateStudentInfoWithId(Scanner scanner, StudentManagement studentManagement) {
        System.out.println("CẬP NHẬT THÔNG TIN SINH VIÊN");
        System.out.print("Nhập mã sinh viên cần sửa thông tin : ");
        String id = scanner.nextLine();
        int index = findIndex(studentManagement, 0, studentManagement.getStudents().size() - 1, id);
        if (index != -1) {
            Student student = createStudent(scanner);
            studentManagement.editStudent(index, student);
            System.out.println("CẬP NHẬT THÀNH CÔNG");
        } else {
            System.out.println("Không tìm thấy thông tin sinh viên với id = " + id);
        }
    }

    private static void deleteStudentWithId(Scanner scanner, StudentManagement studentManagement) {
        System.out.print("Nhập mã sinh viên cần xóa thông tin : ");
        String id = scanner.nextLine();
        int index = findIndex(studentManagement, 0, studentManagement.getStudents().size() - 1, id);
        if (index != -1) {
            studentManagement.deleteStudent(index);
            System.out.println("XÓA THÀNH CÔNG");
        } else {
            System.out.println("Không tìm thấy thông tin sinh viên với id = " + id);
        }
    }

    private static void findStudentWithId(Scanner scanner, StudentManagement studentManagement) {
        System.out.print("Nhập mã sinh viên cần tìm thông tin : ");
        String id = scanner.nextLine();
        int index = findIndex(studentManagement, 0, studentManagement.getStudents().size() - 1, id);
        if (index != -1) {
            System.out.println(studentManagement.getStudents().get(index).toString());
        } else {
            System.out.println("Không tìm thấy thông tin sinh viên với id = " + id);
        }
    }

    private static int findIndex(StudentManagement studentManagement, int low, int high, String id) {
        int mid = (low + high) / 2;
        if (high >= low) {
            if (studentManagement.getStudents().get(mid).getId().compareTo(id) == 0) {
                return mid;
            } else if (studentManagement.getStudents().get(mid).getId().compareTo(id) > 0) {
                return findIndex(studentManagement, low, mid - 1, id);
            } else if (studentManagement.getStudents().get(mid).getId().compareTo(id) < 0) {
                return findIndex(studentManagement, mid + 1, high, id);
            }
        }
        return -1;
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
