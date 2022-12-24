package service;

import model.Phone;

import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public interface PhoneService {
    String addPhones(Set<Phone> phones);

    Queue<Phone> getPhonesByModel(String model);

    String updatePhone(Long phoneId, Phone phone);

    String removePhoneById(Long phoneId);

    Deque<Phone> getAllPhones();

    List<Phone> sortPhonesByYearOfIssue(); //1 ди басканда ascending, 2 ни басканда descending кылып сорттосун

    List<Phone> filterPhonesByPrice(int fromThisPrice, int upToThisPrice);

    List<Phone> findPhonesWithLargeMemoryAndSmallMemory(); //найти телефоны с большой памятью и маленькой памятью

    String deleteAllPhones();

}
