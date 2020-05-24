package Lesson3;

import java.util.HashSet;

public class RecordTelephon {

    private HashSet<String> phone;

    public RecordTelephon(String phone) {
        this.phone = new HashSet<>();
//        setPhone(phone);
    }

    public void add(String phone) {
        this.phone.add(phone);
    }

    public HashSet<String> getPhone() {
        return phone;
    }
}
