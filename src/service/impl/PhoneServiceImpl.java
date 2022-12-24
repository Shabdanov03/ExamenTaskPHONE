package service.impl;

import dao.Database;
import model.Phone;
import service.PhoneService;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    Database database = new Database();

    @Override
    public String addPhones(Set<Phone> phones) {
        database.getPhones().addAll(phones);
        return "Successfully Added ! ";
    }

    @Override
    public Queue<Phone> getPhonesByModel(String model) {
        List<Phone> list = database.getPhones().stream().filter(x -> x.getModel().equals(model)).toList();
        Queue<Phone> phoneQueue = new PriorityQueue<>(list);
        return phoneQueue;
    }

    @Override
    public String updatePhone(Long phoneId, Phone phone) {
        database.setPhones(database.getPhones().stream().map(x->x.getId().equals(phoneId) ? x = phone : x ).toList());
        return "Successfully updated ! ";
    }

    @Override
    public String removePhoneById(Long phoneId) {
        List<Phone> list = database.getPhones().stream().filter(x -> x.getId().equals(phoneId)).toList();
        database.getPhones().removeAll(list);
        return "Successfully removed ! ";
    }

    @Override
    public Deque<Phone> getAllPhones() {
        Deque<Phone> phones = new ArrayDeque<>(database.getPhones());
        return phones;
    }

    @Override
    public List<Phone> sortPhonesByYearOfIssue() {
        System.out.println("Enter by command : (1.ascending/2.descending)");
        int num = new Scanner(System.in).nextInt();
        if (num == 1) {
            return database.getPhones().stream().sorted(Comparator.comparing(Phone::getYearOdIssue)).toList();
        } else if (num == 2) {
            return database.getPhones().stream().sorted(Comparator.comparing(Phone::getYearOdIssue).reversed()).toList();
        }
        return null;
    }

    @Override
    public List<Phone> filterPhonesByPrice(int fromThisPrice, int upToThisPrice) {
        return database.getPhones().stream().filter(x -> x.getPrice() > fromThisPrice & x.getPrice() < upToThisPrice).toList();
    }

    @Override
    public List<Phone> findPhonesWithLargeMemoryAndSmallMemory() {
        System.out.println("Enter by command : (1.max Memory / 2.min Memory)");
        int com = new Scanner(System.in).nextInt();
        if (com == 1) {
            return database.getPhones().stream().max(Comparator.comparing(Phone::getMemory)).stream().toList();
        } else if (com == 2) {
            return database.getPhones().stream().min(Comparator.comparing(Phone::getMemory)).stream().toList();
        }
        return null;
    }

    @Override
    public String deleteAllPhones() {
        database.getPhones().clear();
        return "Successfully deleted !";
    }
}
