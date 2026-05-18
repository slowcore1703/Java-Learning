import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        arrayList.add("RTX5090");
        arrayList.add("RTX4090");
        arrayList.add("RTX3090");
        arrayList.add("RTX2090");

        linkedList.add("RTX5090");
        linkedList.add("RTX4090");
        linkedList.add("RTX3090");
        linkedList.add("RTX2090");


        long start = System.nanoTime();
        linkedList.add(0, "Old GPU");
        long end = System.nanoTime();
        System.out.println("Linked List: " + (end - start) + " нс");

        start = System.nanoTime();
        arrayList.add(0, "Old GPU");
        ;
        end = System.nanoTime();
        System.out.println("ArrayList вставка: " + (end - start) + " нс");

        for (String s : arrayList) {
            System.out.println("В списке: " + s);
        }
        System.out.println("\n");

//        SET PRACTICE

        Set<String> emails = new HashSet<>();
        emails.add("admin@proger.ru");
        emails.add("user@mail.com");
        emails.add("admin@proger.ru");
        emails.add("kiber-kotlet@java.io");
        System.out.println("Количество уникальных адресов: " + emails.size());

        for (String email : emails) {
            System.out.println("Рассылка для: " + email);
        }

        if (emails.contains("admin@proger.ru")) {
            System.out.println("Данный адрес уже есть в базе");
            System.out.println(emails.size());
        }

        Set<Shop> list = new HashSet<>();
        list.add(new Shop("RTX5090", 350000));
        list.add(new Shop("RTX5090", 350000));

        for(Shop show : list){
            System.out.println(show);
            System.out.println(list.size());
        }

        System.out.println("\n");

//        MAP PRACTICE

        Map<String, Shop> map = new HashMap<>();
        map.put("A-100", new Shop("RTX5090", 350000));
        map.put("B-100", new Shop("RTX4090", 250000));
        map.put("C-100", new Shop("RTX3090", 150000));

        System.out.println("По артикулу A-100 Найден следующий товар: " + map.get("A-100"));

        if (map.containsKey("B-100")) {
            System.out.println("Товар в наличии!");
        }

        for (Map.Entry<String, Shop> entry : map.entrySet()) {
            System.out.println("Артикул: " + entry.getKey() + " | Товар: " + entry.getValue());
        }

        Map<Integer, User> mapOfUser = new HashMap<>();
        mapOfUser.put(1, new User("Bob"));
        mapOfUser.put(2, new User("John"));
        mapOfUser.put(3, new User("Alice"));
        mapOfUser.put(1, new User("Neo"));

        for (Map.Entry<Integer, User> users : mapOfUser.entrySet()) {
            int id = users.getKey();
            User name = users.getValue();
            System.out.println("ID Сотрудника: " + id + " Имя: " + name);
        }

        for (User name : mapOfUser.values()) {
            System.out.println("Имена: " + name);
        }
        for (Integer id : mapOfUser.keySet()) {
            System.out.println("Всего ключей: " + id);
        }
        System.out.println("\n");


//      Практика Queue Deque Iterator Collections

        Queue<String> orders = new LinkedList<>();
        orders.add("Заказ№1");
        orders.add("Заказ№2");
        orders.add("Заказ№3");

        System.out.println("Обработка: " + orders.poll());

        List<String> items = new ArrayList<>(Arrays.asList("RTX5090", "Monitor", "KeyBoard"));
        Collections.sort(items);
        System.out.println("Отсортировано: " + items);

        Iterator<String> iterator = items.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("RTX5090")){
                iterator.remove();
            }
        }
        System.out.println("После очистки: " + items);

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("RTX5090");
        deque.addLast("RTX4090");
        deque.push("RTX2090");
        System.out.println("История: " + deque);

        System.out.println("Забрали сверху: " + deque.pop());
        System.out.println("Последний в очереди: " + deque.peekLast());
        System.out.println("Осталось: " + deque);


        String[] array = {"Яблоко", "Банан", "Апельсин"};
        List<String> list1 = Arrays.asList(array);

        // Изменение элемента
        list1.set(0, "Груша");
        System.out.println(list1);
    }
}