package Lesson3;

import java.util.Objects;

/**
 * Java. Level 2. Lesson 3. Homework.
 *
 * @author Dmitry Kozhinov d.kozhinov@mail.ru
 * Created on 20.02.2019
 */

public class PhoneBookRecord {
    private String fio;
    private String phoneNumber;

    public PhoneBookRecord(String fio, String phoneNumber) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookRecord phoneBookRecord = (PhoneBookRecord) o;
        return fio == phoneBookRecord.fio &&   Objects.equals(phoneNumber, phoneBookRecord.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, phoneNumber);
    }
}
