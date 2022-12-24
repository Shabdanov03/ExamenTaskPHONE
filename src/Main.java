import model.Phone;
import service.impl.PhoneServiceImpl;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static PhoneServiceImpl service = new PhoneServiceImpl();

    public static void main(String[] args) {


        Set<Phone> phones = new LinkedHashSet<>(List.of(
                new Phone(1L, "Iphone", 128, LocalDate.ofYearDay(2022, 12), 70000),
                new Phone(2L, "Samsung", 256, LocalDate.ofYearDay(2021, 1), 27000),
                new Phone(3L, "Mi", 128, LocalDate.ofYearDay(2020, 2), 16000),
                new Phone(4L, "LG", 32, LocalDate.ofYearDay(2014, 3), 8000),
                new Phone(5L, "Nokia", 16, LocalDate.ofYearDay(2009, 4), 2000),
                new Phone(6L, "Poco", 256, LocalDate.ofYearDay(2020, 6), 20000),
                new Phone(7L, "Redmi", 512, LocalDate.ofYearDay(2018, 8), 9000),
                new Phone(8L, "Shark", 1000, LocalDate.ofYearDay(2021, 22), 90000)
        ));
        Phone phone = new Phone(1L, "Honor", 64, LocalDate.ofYearDay(2019, 8), 18000);

        while (true) {
            System.out.println("""
                    ===========COMMANDS==========
                    1.ADD PHONE :
                    2.GET PHONES BY MODEL:
                    3.UPDATE PHONE :
                    4.REMOVE PHONE BY ID :
                    5.GET ALL PHONES :
                    6.SORT PHONES BY YEAR OF ISSUE :
                    7.FILTER PHONES BY PRICE :
                    8.FIND PHONES WITH LARGE MEMORY AND SMALL MEMORY :
                    9.DELETE ALL PHONES :
                    =============================
                    """);
            System.out.print("ENTER BY COMMANDS : ");
            int command = new Scanner(System.in).nextInt();
            switch (command) {
                case 1 -> System.out.println(service.addPhones(phones));
                case 2 -> {
                    System.out.println("Enter by phone model : ");
                    String model = new Scanner(System.in).nextLine();
                    System.out.println(service.getPhonesByModel(model));
                }
                case 3 -> {
                    System.out.println("Enter by id phone :");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(service.updatePhone(id, phone));
                }
                case 4 -> {
                    System.out.println("Enter by id phone : ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(service.removePhoneById(id));
                }
                case 5 -> System.out.println(service.getAllPhones());
                case 6 -> System.out.println(service.sortPhonesByYearOfIssue());
                case 7 -> {
                    System.out.print("Enter by price from :");
                    int from = new Scanner(System.in).nextInt();
                    System.out.print("Enter by price up to :");
                    int upTo = new Scanner(System.in).nextInt();
                    System.out.println(service.filterPhonesByPrice(from, upTo));
                }
                case 8 -> System.out.println(service.findPhonesWithLargeMemoryAndSmallMemory());
                case 9 -> System.out.println(service.deleteAllPhones());
            }
        }
    }
}