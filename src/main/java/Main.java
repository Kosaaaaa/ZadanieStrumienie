import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Square> squares = new ArrayList<>();
        Random random = new Random();

        for(int i=0; i<100; i++){
            squares.add(new Square(random.nextInt(50)+1));
        }
        squares.forEach(System.out::println);

        // Podpunkt A
        List<Square> ex1  = squares.stream().filter(square -> square.getArea() > square.getPerimeter()).collect(Collectors.toList());
        System.out.println("----- Podpunkt A -----");
        ex1.forEach(System.out::println);

    }
}
