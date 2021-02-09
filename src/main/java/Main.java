import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Square> squares = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            squares.add(new Square(random.nextInt(100) + 1));
        }
        squares.forEach(System.out::println);

        // Podpunkt A
        List<Square> ex1 = squares.stream().filter(square -> square.getArea() > square.getPerimeter()).collect(Collectors.toList());
        System.out.println("----- Podpunkt A -----");
        ex1.forEach(System.out::println);

        // Podpunkt B
        List<Square> ex2 = squares.stream().sorted(Comparator.comparingDouble(Square::getPerimeter)).collect(Collectors.toList());
        System.out.println("----- Podpunkt B -----");
        ex2.forEach(System.out::println);

        // Podpunkt C
        OptionalDouble ex3  = squares.stream().mapToDouble(Square::getPerimeter).average();
        System.out.println("----- Podpunkt C -----");
        if (ex3.isPresent()){
            System.out.println(ex3.getAsDouble());
        }
    }
}
