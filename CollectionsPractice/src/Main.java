import java.util.*;

public class Main {
    public static void main(String[] args) {
//        MAP
        Map<Integer, User> users = new HashMap<>();
        users.put(1, new User("Neo1", "keygen123"));
        users.put(2, new User("Neo2", "ghost1030"));
        users.put(3, new User("Neo3", "cybersec5678"));
        users.putIfAbsent(2, new User("Neo2", "Tsuhima1030"));

        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println("Ключ:" + entry.getKey() + " | " + "Данные: " + entry.getValue());
        }

        System.out.println("\n");

//        SET
        Random idGenerator = new Random();
        Set<Integer> keys = new HashSet<>();

        while (keys.size() < 10) {
            int keyGenerator = idGenerator.nextInt(1, 100);
            if (!keys.add(keyGenerator)) {
                System.out.println("ID уже существует..." + keyGenerator);
            }
        }
        System.out.println("Итоговый вывод уникальных чисел");
        for (Integer key : keys) {
            System.out.println(key);
        }

        System.out.println("\n");

        List<User> userList = new LinkedList<>();
        userList.add(new User("John", "keygen"));
        userList.add(new User("Bob", "ghost"));
        userList.add(new User("Alice", "cybersec"));
        userList.add(new User("Arthur", "Tsuhima"));
        userList.add(new User("Daniel", "Detroit"));
        userList.add(new User("Hank", "Umbrella"));

        userList.add(3, new User("Bain", "CrimeNET"));

        for (User user : userList) {
            System.out.println(user.hashCode());
        }


        int defaultBucketCount = 16; // Стандартное количество бакетов
        System.out.println("Бакеты и hashcode с числом бакетов 16 default");
//        Процесс рехеширования на hashcode на новое количество бакетов 32
        for (User user : userList) {
            int hash = user.hashCode();

            // Формула сжатия хэш-кода под размер массива: hash & (n - 1)
            // Процесс побитового & почти аналогичен оператору % остатка от деления
            int bucketIndex = Math.abs(hash & (defaultBucketCount - 1));
            System.out.println("User: " + user +
                    " | HashCode: " + hash +
                    " | Номер бакета: " + bucketIndex);
        }

        System.out.println("\n");

        System.out.println("Новые Бакеты и hashcode с числом бакетов 32");
        int newBucketCount = 32;
        // Новое количество бакетов
        for (User user : userList) {
            int hash = user.hashCode();
            // Формула сжатия хэш-кода под размер массива: hash & (n - 1)
            // Процесс побитового & почти аналогичен оператору % остатка от деления
            int newBucketIndex = Math.abs(hash & (newBucketCount - 1));
            System.out.println("User: " + user +
                    " | HashCode: " + hash +
                    " | Номер бакета: " + newBucketIndex);
        }


        System.out.println("\n");

//        QUEUE DEQUE PriorityQueue
        Queue<String> queue = new LinkedList<>();
        queue.offer("John");
        queue.offer("Bob");
        queue.offer("Alice");
        queue.offer("Daniel");
        queue.offer("Hank");
        queue.poll();
        queue.poll();
        System.out.println(queue.peek());

        System.out.println("\n");

        Deque<String> deque = new ArrayDeque<>();
        deque.offer("Client1");
        deque.offer("Client2");
        deque.offer("Client3");
        deque.offerLast("Client100");
        deque.offerFirst("VIP Client");
        deque.offerFirst("Boss");
        System.out.println("Следующий на очереди: " + deque.peekFirst());
        while (!deque.isEmpty()) {
            System.out.println("Обработано клиентов: " + deque.pollFirst());
        }


        Queue<Integer> pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(2);
        pQueue.offer(5);
        pQueue.offer(1);

        while (!pQueue.isEmpty()) {
            // poll() всегда забирает элемент с наивысшим приоритетом самый маленький
            System.out.println("Обработано число: " + pQueue.poll());
        }

        System.out.println("\n");

//        Comporator

        Comparator<Users> ageComparator = (u1, u2) -> Integer.compare(u2.getAge(), u1.getAge());
        // 2. Передаем эту инструкцию в конструктор очереди
        Queue<Users> userQueue = new PriorityQueue<>(ageComparator);

        // 3. Добавляем пользователей в случайном возрасте
        userQueue.offer(new Users("Иван", 20));
        userQueue.offer(new Users("Ольга Михайловна", 65)); // Самая старшая
        userQueue.offer(new Users("Пётр", 35));

        // 4. Достаем их из очереди
        while (!userQueue.isEmpty()) {
            System.out.println("Обслужен: " + userQueue.poll());
        }
    }
}
