import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PhoneBook {
    // Реализуйте структуру телефонной книги с помощью HashMap, 
    // учитывая, что 1 человек может иметь несколько телефонов.

       // Метод, который добавляет номера в книгу
       public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }
    // Метод, который печатает список контактов
    public static void printBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) {
            String phones = "";
            for(int el: item.getValue()){
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Уилл Смит", 1234567890, bookPhone);
        addNumber("Уилл Смит", 987654321, bookPhone);
        addNumber("Уилл Смит", 655555556, bookPhone);
        addNumber("Майкл Корс", 1111111111,bookPhone);
        addNumber("Майкл Корс", 222222222,bookPhone);
        addNumber("Джузеппе Верди", 333333333,bookPhone);
        addNumber("Сергей Бурунов", 444444444,bookPhone);
        addNumber("Юлия Снегирь", 555555555,bookPhone);
        addNumber("Юлия Снегирь", 666666666,bookPhone);
        printBook(bookPhone);
       }
}
