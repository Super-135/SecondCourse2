package Lesson3;

import java.util.TreeMap;
public class TelephoneDirectory {


    private static final String[] name  = {"Вася", "Илья", "Антон", "Марина", "Антон"};
    private static final String[] phone = {"+7(985)521-68-12", "+7(951)321-66-22", "+7(485)341-98-72", "+7(985)940-56-87", "+7(987)532-66-23"};

    static private TreeMap<String, RecordTelephon> mapTelDirs = new TreeMap<>();

    static public void get(String user){
        mapTelDirs.entrySet().stream().forEach(mapEntry -> {
            if (mapEntry.getKey() == user) {
                System.out.println(mapEntry.getValue().getPhone().toString());
            }});
    }


    static public void add(String name, String phone){
        if (! mapTelDirs.containsKey(name)) {
            mapTelDirs.put(name, new RecordTelephon(phone));
        }
        mapTelDirs.get(name).add(phone);
    }


    public static void main(String[] args) {
        for (int i = 0; i < name.length ; i++) {
                add(name[i],phone[i]);
        }
        get("Марина");

    }
}
