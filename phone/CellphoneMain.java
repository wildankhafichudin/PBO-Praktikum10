package phone;

public class CellphoneMain {
    public static void main(String[] args){
        Cellphone cp = new Cellphone("Sumsang", "S400");
        cp.powerOn();
        cp.topUpPulsa(50000);
        cp.addContact("Wildan", "08123456789");
        cp.addContact("Purnama", "08987654321");
        cp.viewAllContacts();
        System.out.println("Sisa pulsa saat ini : " + cp.getPulsaBalance());
        cp.searchContact("Wildan");
        cp.searchContact("Purnama");
        cp.searchContact("Asep");
    }
}