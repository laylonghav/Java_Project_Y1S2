package System_students;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class System_Students_Choose {

    public static void main(String[] array) {
        Scanner scanner = new Scanner(System.in);
        Scanner cin = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operation ");
            System.out.println("1. Insert data");
            System.out.println("2. Show all data");
            System.out.println("3. Search data");
            System.out.println("4. Eidt data");
            System.out.println("5. Delete data");
            System.out.println("6. Reset data");
            System.out.print("Input number : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Students Obj = new Students();
                    Obj.Input();

                    try {
                        // the true will append the new data 
                        FileWriter myWriter = new FileWriter("System_Students.txt", true);
                        //File myObj = new File("System_Students.txt");
                        //Scanner myReader = new Scanner(myObj);

                        myWriter.write(Obj.getId() + "," + Obj.getName() + "," + Obj.getGender() + ","
                                + Obj.getMajor() + "," + Obj.getContact() + "\n");

                        myWriter.close();
                        System.out.println("Cantact added to file.");
                    } catch (IOException e) {
                        System.out.println("An error occured.");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                   try {
                    File myObj = new File("System_Students.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        //System.out.println("data");
                        String[] lineSplit = data.split(",");
                        if (lineSplit.length == 5) {
                            //print the contact data
                            System.out.println("ID : " + lineSplit[0] + " " + "Name : " + lineSplit[1] + " " + "Gender : " + lineSplit[2]
                                    + " " + "Major : " + lineSplit[3] + " " + "Contact : " + lineSplit[4] + "\n");
                        }

                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
                case 3:
                     try {
                    System.out.print("Input Search ID : ");
                    String searchID = cin.nextLine();
                    File myObj = new File("System_Students.txt");
                    Scanner myReader = new Scanner(myObj);

                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        //System.out.println("data");
                        String[] lineSplit = data.split(",");
                        if (lineSplit[0].equals(searchID)) {
                            //print the contact data
                            System.out.println("ID : " + lineSplit[0] + " " + "Name : " + lineSplit[1] + " " + "Gender : " + lineSplit[2]
                                    + " " + "Major : " + lineSplit[3] + " " + "Contact : " + lineSplit[4] + "\n");
                            break;
                        }
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("An error occured.");
                    e.printStackTrace();
                }
                break;
                case 4:
                    System.out.print("Input my ID : ");
                    String myID = cin.nextLine();
                    System.out.print("Input my name : ");
                    String newName = cin.nextLine();
                    System.out.print("Input my gender : ");
                    String newgender = cin.nextLine();
                    System.out.print("Input my major : ");
                    String newmajor = cin.nextLine();
                    System.out.print("Input my contact : ");
                    String newcontact = cin.nextLine();
                    try {
                        File myObj = new File("System_Students.txt");
                        Scanner myReader = new Scanner(myObj);
                        boolean found = false;
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            //System.out.println("data");
                            String[] lineSplit = data.split(",");
                            String id = lineSplit[0];
                            String name = lineSplit[1];
                            String gende = lineSplit[2];
                            String major = lineSplit[3];
                            String contact = lineSplit[4];
                            if (id.equals(myID)) {
                                found = true;
                                break;
                            }
                        }

                        myReader.close();

                        if (found == true) {
                            // Copy Contact to tmp.txt
                            FileWriter myWriter = new FileWriter("Student.txt");
                            File newFile = new File("System_Students.txt");
                            Scanner newReader = new Scanner(newFile);
                            while (newReader.hasNextLine()) {
                                String data = newReader.nextLine();
                                String[] lineSplit = data.split(",");
                                String id = lineSplit[0];
                                String name = lineSplit[1];
                                String gende = lineSplit[2];
                                String major = lineSplit[3];
                                String contact = lineSplit[4];
                                if (id.equals(myID)) {
                                    myWriter.write(myID + "," + newName + "," + newgender + ","
                                            + newmajor + "," + newcontact + "\n");
                                } else {
                                    myWriter.write(data + "\n");
                                }
                            }

                            newReader.close();
                            myWriter.close();
                            //Remove file
                            File fileToRemove = new File("System_Students.txt");
                            fileToRemove.delete();
                            //Rename file
                            File file1 = new File("Student.txt");
                            File file2 = new File("System_Students.txt");
                            boolean success = file1.renameTo(file2);
                            if (success) {
                                System.out.println("Record : " + myID + " " + "Updated");
                            } else {
                                System.out.println("Record : " + myID + " " + "Not found");
                            }
                        }
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("An error occured.");
                        e.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.print("Input my ID : ");
                    String myID1 = cin.nextLine();
                    try {
                        File myObj = new File("System_Students.txt");
                        Scanner myReader = new Scanner(myObj);
                        boolean found = false;
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            //System.out.println("data");
                            String[] lineSplit = data.split(",");
                            String id = lineSplit[0];
                            String name = lineSplit[1];
                            String gende = lineSplit[2];
                            String major = lineSplit[3];
                            String contact = lineSplit[4];
                            if (id.equals(myID1)) {
                                found = true;
                                break;
                            }
                        }

                        myReader.close();

                        if (found == true) {
                            // Copy Contact to tmp.txt
                            FileWriter myWriter = new FileWriter("Student.txt");
                            File newFile = new File("System_Students.txt");
                            Scanner newReader = new Scanner(newFile);
                            while (newReader.hasNextLine()) {
                                String data = newReader.nextLine();
                                String[] lineSplit = data.split(",");
                                String id = lineSplit[0];
                                String name = lineSplit[1];
                                String gende = lineSplit[2];
                                String major = lineSplit[3];
                                String contact = lineSplit[4];
                                if (id.equals(myID1)) {
                                    continue;
                                }
                                myWriter.write(data + "\n");
                            }

                            newReader.close();
                            myWriter.close();
                            //Remove file
                            File fileToRemove = new File("System_Students.txt");
                            fileToRemove.delete();
                            //Rename file
                            File file1 = new File("Student.txt");
                            File file2 = new File("System_Students.txt");
                            boolean success = file1.renameTo(file2);
                            if (success) {
                                System.out.println("Record : " + myID1 + " " + "Deleted");
                            } else {
                                System.out.println("Record : " + myID1 + " " + "Not found");
                            }
                        }
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("An error occured.");
                        e.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 6:
                    File myObj = new File("System_Students.txt");
                    if (myObj.delete()) {
                        System.out.println("Delete the file : " + myObj.getName());
                    } else {
                        System.out.println("Faild to delete the file.");
                    }
                    break;
                default:
                    System.out.println("Invalid optoin!");
            }
        }
    }
}
