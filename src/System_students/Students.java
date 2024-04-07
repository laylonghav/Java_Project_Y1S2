package System_students;

import java.util.Scanner;

public class Students {

    private String id;
    private String name;
    private String gender;
    private String major;
    private String contact;
    public static Scanner cin = new Scanner(System.in);

    public Students() {
        
    }

    public Students(String id, String name, String gender, String major, String contact) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMajor() {
        return major;
    }

    public String getContact() {
        return contact;
    }

    public Scanner getCin() {
        return cin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void Input() {
        System.out.println("-----------Information students-----------");
        System.out.print("Input ID : ");
        id = cin.nextLine();
        System.out.print("Input Name : ");
        name = cin.nextLine();
        System.out.print("Input Gedner : ");
        gender = cin.nextLine();
        System.out.print("Input Major : ");
        major = cin.nextLine();
        System.out.print("Input Contact : ");
        contact = cin.nextLine();
    }

}
