import java.util.*;

class Main {
    public static void main(String[] args) {
        String[] employees = {
            "Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"
        };
        
        Map<String, Integer> nameCounts = new HashMap<>();
        
        // Подсчитываем количество повторений каждого имени
        for (String employee : employees) {
            String[] parts = employee.split(" ");
            String firstName = parts[0];
            int count = nameCounts.getOrDefault(firstName, 0);
            nameCounts.put(firstName, count + 1);
        }
        
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(nameCounts.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}