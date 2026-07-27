import java.util.Scanner;

class StudentNode {
    String name;
    int rollNo;
    StudentNode next;

    public StudentNode(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.next = null;
    }
}
class StudentLinkedList {
    StudentNode head = null;

    public void addStudent(int rollNo, String name) {
        if (findNode(rollNo) != null) {
            System.out.println("Roll No " + rollNo + " already exists.");
            return;
        }
        StudentNode newNode = new StudentNode(rollNo, name);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Student added !");
    }
    public void updateStudent(int rollNo, String newName) {
        StudentNode student = findNode(rollNo);
        if (student != null) {
            student.name = newName;
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
    public StudentNode findNode(int rollNo) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
public class StudentRecord {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Details");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            
            choice = scanner.nextInt();
            switch (choice) {
                case 1:{
                    System.out.print("Enter Roll Number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    list.addStudent(roll, name);
                    break;
                }
                case 2:{
                    System.out.print("Enter Roll Number to Update: ");
                    int updateRoll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    list.updateStudent(updateRoll, newName);
                    break;
                }
                case 3:{
                    System.out.println("Exiting...");
                    break;
                }
                default:{
                    System.out.println("Invalid option. Try again.");
                }
            }
        } while (choice != 3);
        scanner.close();
    }
}
