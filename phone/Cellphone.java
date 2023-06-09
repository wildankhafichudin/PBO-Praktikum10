package phone;

import java.util.ArrayList;

public class Cellphone implements Phone {
    String merk;
    String type;
    int status;
    int volume;
    ArrayList<Contact> contacts;
    int pulsa;

    public Cellphone(String merk,String type)
    {
        this.merk = merk;
        this.type = type;
        contacts = new ArrayList<>(); 
    }

    public void powerOn(){
        this.status = 1;
        System.out.println("Ponsel menyala");
    }
    
    public void powerOff(){
        this.status = 0;
        System.out.println("Ponsel mati");
    }

    public void volumeUp() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume.");
        } else {
            this.volume++;
            if (this.volume >= MAX_VOLUME) {
                this.volume = MAX_VOLUME;
            }
        }
    }

    public void volumeDown() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menurunkan volume.");
        } else {
            this.volume--;
            if (this.volume <= MIN_VOLUME) {
                this.volume = MIN_VOLUME;
            }
        }
    }

    public int getVolume() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat mendapatkan volume.");
            return MIN_VOLUME;
        } else {
            return this.volume;
        }
    }

    public void topUpPulsa(int amount){
        pulsa += amount;
        System.out.println("Pulsa ditambahkan sebesar "+amount);
    }
    
    public int getPulsaBalance() {
        return pulsa;
    }

    public void addContact(String nama, String nomor) {
        Contact contact = new Contact(nama, nomor);
        contacts.add(contact);
        System.out.println("Kontak berhasil ditambahkan : " + nama + " - " + nomor);
    }

    public void viewAllContacts() {
        System.out.println("Daftar Kontak :");
        if (contacts.isEmpty()) {
            System.out.println("Tidak ada kontak.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println("Nama : " + contact.getNama());
                System.out.println("Nomor : " + contact.getNomor());
                System.out.println();
            }
        }
    }

    public void searchContact(String nama) {
        System.out.println("Hasil Pencarian :");
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Nama : " + contact.getNama());
                System.out.println("Nomor : " + contact.getNomor());
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
        }
    }
}