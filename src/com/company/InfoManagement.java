package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InfoManagement {
    List<Info> infos = new ArrayList<>();
    private static InfoManagement infoManagement;

    private InfoManagement() {

    }

    public static InfoManagement getInstance() {
        if (infoManagement == null) {
            infoManagement = new InfoManagement();
        }
        return infoManagement;
    }

    public void displayInfo() {
        for (Info info : infos) {
            System.out.println(info);
        }
    }

    public void addInfo(Info info) {
        this.infos.add(info);
    }

    public int findIndexByPhone(String phone) {
        int index = -1;
        for (int i = 0; i < this.infos.size(); i++) {
            if (this.infos.get(i).getPhone().equals(phone)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateInfo(Info info, String phone) {
        int index = findIndexByPhone(phone);
        this.infos.set(index, info);

    }

    public void deleteInfo(String phone) {
        int index = findIndexByPhone(phone);
        this.infos.remove(index);
    }

//    public boolean checkPhoneExist(String phone) {
//        int index = findIndexByPhone(phone);
//        boolean isPhone = false;
//        if (phone.equals(this.infos.get(index).getPhone())) {
//            return !isPhone;
//        }
//        return isPhone;
//    }

    public void findInfoByPhone(String phone) {
        int index = findIndexByPhone(phone);
        System.out.println(this.infos.get(index));
    }

    public void writeFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter("contact.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Info info : infos) {
            bufferedWriter.write(info.toString());
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public void readFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            String name = lines[0].trim();
            String phone = lines[1].trim();
            String address = lines[2].trim();
            String email = lines[3].trim();
            String facebook = lines[4].trim();
            Info info = new Info(name, phone, address, email, facebook);
            this.infos.add(info);
        }
        bufferedReader.close();
        fileReader.close();
    }

}
