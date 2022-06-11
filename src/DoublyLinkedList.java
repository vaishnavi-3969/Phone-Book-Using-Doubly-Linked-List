import java.util.Scanner;

import static java.lang.System.*;

public class DoublyLinkedList{
    Scanner scan = new Scanner(System.in);
     PhoneNode head;
     PhoneNode tail;
     int length;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return head == null; //head == null
    }

    public void insertLast(PhoneNode pn){
        if(isEmpty()){
            head = pn;
        } else{
            tail.next = pn;
            pn.previous = tail;
        }
        tail = pn;
        length++;
    }

    public void displayForward(DoublyLinkedList dll) {
        out.println("Display all Records: ");
        out.println("  First Name  |   Last Name  |   Phone No.  |\t Mail \t |\tAddress\t| ");
        PhoneNode temp = dll.head;
        while(temp != null){
            out.println(temp.firstName+"\t"+temp.lastName + "\t" + temp.phoneNumber+ "\t" + temp.mail + "\t" + temp.address);
            temp = temp.next;
        }
    }
    public void displayReverse(DoublyLinkedList dll) {
        out.println("Display all Records in Reverse Order: ");
        out.println("  First Name  |   Last Name  |   Phone No.  |\t Mail \t |\tAddress\t| ");
        PhoneNode temp = dll.tail;
        while(temp != null){
            System.out.println(temp.firstName+" "+temp.lastName + " " + temp.phoneNumber+ " " + temp.mail + " " + temp.address);
            temp = temp.previous;
        }
    }
    public void insertFirst(PhoneNode newNode){
        if(isEmpty()){
            head = newNode;
            return;
        }else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        length++;
    }

    public PhoneNode search(DoublyLinkedList dll) {
        PhoneNode temp1 = dll.head;
        PhoneNode temp = null;
        boolean flag = false;
        out.println("Enter the Phone no.:");
        long phone = scan.nextLong();
        while (temp1 != null) {
            if (temp1.phoneNumber == phone) {
                out.println("Record with this Phone no. found!");
                out.println("First Name: " + temp1.firstName);
                out.println("Last Name: " + temp1.lastName);
                out.println("Phone No.:" + temp1.phoneNumber);
                out.println("Mail: " + temp1.mail);
                out.println("Address: " + temp1.address);
                flag = true;
                temp = temp1;
            }
            temp1 = temp1.next;
        }
        return temp;
    }

    private void updateRecord(PhoneNode flag) {
        int ch = 1;
        do{
            out.println("What do you wish to update? \n1. First Name \n2. Last Name \n3. Phone No. \n4. Mail \n5. Address");
            ch = scan.nextInt();
            switch (ch){
                case 1:
                    out.println("Updated First Name: ");
                    flag.firstName = scan.next();
                    break;
                case 2:
                    out.println("Updated Last Name: ");
                    flag.lastName = scan.next();
                    break;
                case 3:
                    out.println("Updated Phone no.: ");
                    flag.phoneNumber = scan.nextLong();
                    break;
                case 4:
                    out.println("Updated mail: ");
                    flag.mail = scan.next();
                    break;
                case 5:
                    out.println("Updated address: ");
                    flag.address = scan.next();
                    break;
                default:
                    out.println("Invalid Choice!!!");
                    break;
            }
            out.println("Do you wish to updated anything else? 1. Continue 0. Exit");
            ch = scan.nextInt();
        }while(ch != 0);
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner scan = new Scanner(in);
        int ch = 0;
        do{
            out.println("************************* MENU ************************* \n1. Insert a Record \n2. Update a Record \n3. Search for a Record \n4. Display all Records \n5. Display all Records in Reverse order\n6. Display the length of the Phone Book \n7. Inserting a Records at the beginning");
            ch = scan.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Insert a Record: \n1. First Name: ");
                    String fname = scan.next();
                    System.out.println("Last Name: ");
                    String lname = scan.next();
                    System.out.println("Phone No.: ");
                    long phno = scan.nextLong();
                    System.out.println("Mail: ");
                    String mail = scan.next();
                    System.out.println("Address: ");
                    String addr = scan.next();
                    PhoneNode newNode = new PhoneNode(fname,lname,phno,mail,addr);
                    dll.insertLast(newNode);
                    out.println("Record Inserted successfully...");
                    break;
                case 2:
                    out.println("Updating a Record");
                    out.println("Enter the Phone no. to be updated: ");
                    PhoneNode flag = dll.search(dll);
                    if(flag == null){
                        out.println("This phone no. doesn't exist");
                    } else {
                        dll.updateRecord(flag);
                    }
                    break;
                case 3:
                    out.println("Search for a Record:");
                    dll.search(dll);
                    break;
                case 4:
                    out.println("Displaying all records in Forward order: ");
                    dll.displayForward(dll);
                    break;
                case 5:
                    out.println("Displaying all records in Reverse order: ");
                    dll.displayReverse(dll);
                    break;
                case 6:
                    out.println("Length of all Record: ");
                    out.println(dll.length);
                    break;
                case 7:
                    System.out.println("Inserting a Records at the beginning: ");
                    out.println("First Name: ");
                    fname = scan.next();
                    System.out.println("Last Name: ");
                    lname = scan.next();
                    System.out.println("Phone No.: ");
                    phno = scan.nextLong();
                    System.out.println("Mail: ");
                    mail = scan.next();
                    System.out.println("Address: ");
                    addr = scan.next();
                    PhoneNode pn = new PhoneNode(fname,lname,phno,mail,addr);
                    dll.insertFirst(pn);
                    System.out.println("Successfully Inserted at the beginning....");
                    break;
                default:
                    out.println("Invalid Choice!!!");
                    break;
            }
            out.println("Do you wish to continue: 0. Exit 1. Continue");
            ch = scan.nextInt();
        }while(ch != 0);
    }


}