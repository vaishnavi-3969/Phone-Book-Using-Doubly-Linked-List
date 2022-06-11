public class PhoneNode{
    String firstName;
    String lastName;
    long phoneNumber;
    String mail;
    String address;
    PhoneNode next;
    PhoneNode previous;
    public PhoneNode(String firstName, String lastName, long phoneNumber, String mail, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
        next = null;
        previous = null;
    }
}