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
        OptionalDouble ex3 = squares.stream().mapToDouble(Square::getPerimeter).average();
        System.out.println("----- Podpunkt C -----");
        if (ex3.isPresent()) {
            System.out.println(ex3.getAsDouble());
        }

        // Podpunkt D
        OptionalDouble squaresAreaAvgOptional = squares.stream().mapToDouble(Square::getArea).average();
        double squaresAreaAvg = 0;
        System.out.println("----- Podpunkt D -----");
        if (squaresAreaAvgOptional.isPresent()) {
            squaresAreaAvg = squaresAreaAvgOptional.getAsDouble();
        }
        double finalSquaresAreaAvg = squaresAreaAvg;
        List<Square> ex4 = squares.stream().filter(square -> {
            return square.getArea() < finalSquaresAreaAvg;
        }).sorted((s1, s2) -> Double.compare(s2.getArea(), s1.getArea())).collect(Collectors.toList());
        System.out.println("Squares Area Avg: " + finalSquaresAreaAvg);
        ex4.forEach(System.out::println);

        //Podpunkt E
//        double sumAreaSquares = squares.stream().map(Square::getArea).reduce(0.0, Double::sum);
        double sumAreaSquares = squares.stream().mapToDouble(Square::getArea).sum();
        System.out.println("----- Podpunkt E -----");
        System.out.println("Squares Area Sum: " + sumAreaSquares);
    }
}
