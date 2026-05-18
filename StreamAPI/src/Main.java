import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Shop> products = new ArrayList<>();
        products.add(new Shop("RTX5090", 500000, 20));
        products.add(new Shop("RTX4090", 400000, 15));
        products.add(new Shop("RTX3090", 150000, 12));
        products.add(new Shop("RTX2090", 90000, 5));
        System.out.println("Бюджетные товары: ");
        products.stream()
                .filter(p -> p.getPrice() < 200000)
                .forEach(p -> System.out.println(p));

        System.out.println("\n");

        List<String> namesGPU = products.stream()
                .filter(p -> p.getPrice() > 200000)
                .map(Shop::getModel)
                .collect(Collectors.toList());
        System.out.println("Топ ГПУ: " + namesGPU);

        System.out.println("\n");

        List<Shop> available = products.stream()
                .filter(p -> p.getCount() > 10)
                .filter(p -> p.getModel().contains("RTX"))
                .filter(p -> p.getPrice() > 200000)
                .collect(Collectors.toList());
        System.out.println("Доступно: " + available);

        System.out.println("\n");

        products.stream()
                .filter(p -> p.getCount() > 0)
                .sorted((p1, p2) -> p2.getPrice() - p1.getPrice())
                .limit(2)
                .forEach(System.out::println);

        System.out.println("\n");

        double averagePrice = products.stream()
                .mapToInt(Shop::getPrice)
                .average()
                .orElse(0);
        System.out.println("Средний прайс: " + averagePrice);

        boolean hasExpensive = products.stream()
                .anyMatch(p -> p.getPrice() > 1000000);

        System.out.println("Товары дороже миллиона в наличии? " + (hasExpensive ? "Да" : "Нет"));

        System.out.println("\n");

        List<Shop> list = products.stream()
                .sorted(Comparator.comparingInt(Shop::getPrice))
                .collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}