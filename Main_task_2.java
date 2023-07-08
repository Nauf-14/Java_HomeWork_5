import java.util.*;

public class Main_task_2 {
    // Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
    // Анна Крутова, Иван Юрин, Петр Лыков,Павел Чернов, Петр Чернышов,Мария Федорова, Марина Светлова,
    // Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин,Иван Ежов.
    // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
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
        );

        findDuplicateNames(employees);
    }

    public static void findDuplicateNames(List<String> employees) {
        Map<String, Integer> nameCounts = new TreeMap<>(Collections.reverseOrder());

        // Подсчитываем количество повторений каждого имени
        for (String employee : employees) {
            String name = employee.split(" ")[0]; // Берем только имя
            nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
        }

        // Преобразуем TreeMap в List для сортировки
        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCounts.entrySet());

        // Сортируем имена по убыванию популярности
        sortedNames.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Выводим повторяющиеся имена с количеством повторений
        for (Map.Entry<String, Integer> entry : sortedNames) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " повторений");
            }
        }
    }
}
