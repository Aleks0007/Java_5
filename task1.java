import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class PhoneBook {

    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите:\n1) Добавление номера\n2) Вывод всех контактов\n3) Выход");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Введите фамилию:");
                String lastName = scanner.nextLine();
                System.out.println("Введите номер:");
                String phoneNumber = scanner.nextLine();
                addPhoneNumber(lastName, phoneNumber);
            } else if (option == 2) {
                printAllContacts();
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Неизвестная опция, пожалуйста, введите 1, 2 или 3.");
            }
        }
        scanner.close();
    }

    public static void addPhoneNumber(String lastName, String phoneNumber) {
        ArrayList<String> phoneNumbers;
        if (phoneBook.containsKey(lastName)) {
            phoneNumbers = phoneBook.get(lastName);
        } else {
            phoneNumbers = new ArrayList<>();
        }
        phoneNumbers.add(phoneNumber);
        phoneBook.put(lastName, phoneNumbers);
    }

    public static void printAllContacts() {
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }
}