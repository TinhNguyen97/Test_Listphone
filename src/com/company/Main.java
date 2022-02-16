package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        InfoManagement infoManagement = InfoManagement.getInstance();
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("---DANH SÁCH DANH BẠ---");
                    infoManagement.displayInfo();
                    break;
                }
                case 2:
                    System.out.println("---THÊM MỚI DANH BẠ---");
                    infoManagement.addInfo(inputInfo());
                    break;
                case 3:
                    System.out.println("---CẬP NHẬT DANH BẠ---");
                    updateInfo(infoManagement);
                    break;
                case 4:
                    System.out.println("---XÓA SỐ ĐIỆN THOẠI---");
                    deleteInfo(infoManagement);
                    break;
                case 5:
                    System.out.println("---TÌM KIẾM DANH BẠ---");
                    findInfo(infoManagement);
                    break;
                case 6:
                    try {
                        infoManagement.readFile("contact.csv");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        infoManagement.writeFile("contact.csv");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        } while (choice != 0);
    }

    private static void findInfo(InfoManagement infoManagement) {
        scanner.nextLine();
        System.out.println("Nhập số điện thoại cần tìm:");
        String phone = scanner.nextLine();
        int index=infoManagement.findIndexByPhone(phone);
        if (index==-1) {
            System.err.println("Số điện thoại cần tìm không hợp lệ!");
        } else {
            infoManagement.findInfoByPhone(phone);
        }
    }

    private static void deleteInfo(InfoManagement infoManagement) {
        System.out.println("Nhập số điện thoại cần xóa:");
        scanner.nextLine();
        String phone = scanner.nextLine();
        int index = infoManagement.findIndexByPhone(phone);
        if (index == -1) {
            System.err.println("Số điện thoại cần xóa không tồn tại trong danh bạ!");
        } else {
            infoManagement.deleteInfo(phone);
            System.out.println("Xóa thành công!");
        }
    }

    private static void updateInfo(InfoManagement infoManagement) {
        System.out.println("Nhập số điện thoại cần sửa:");
        scanner.nextLine();
        String phone = scanner.nextLine();
        int index = infoManagement.findIndexByPhone(phone);
        if (index == -1) {
            System.err.println("Số điện thoại cần xóa không tồn tại trong danh bạ!");
        } else {
            Info info = inputInfo();
            infoManagement.updateInfo(info, phone);
            System.out.println("Cập nhật thành công!");
        }
    }

    private static Info inputInfo() {
        System.out.println("Nhập tên:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại:");
        String phone = scanner.nextLine();
        System.out.println("Nhập địa chỉ:");
        String address = scanner.nextLine();
        System.out.println("Nhập email:");
        String email = scanner.nextLine();
        System.out.println("Nhập facebook:");
        String facebook = scanner.nextLine();
        Info info = new Info(name, phone, address, email, facebook);
        return info;
    }

    private static void menu() {
        System.out.println("---MENU QUẢN LÝ DANH BẠ---");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("0.Thoát");
        System.out.println("Chọn chức năng:");
    }

}
