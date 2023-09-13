package dk.cphbusiness;

import lombok.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> streamOfElements = Stream.of("one", "two", "three","four","five");
        streamOfElements
                .filter((str)->str.startsWith("f"))
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"))) {
            // process each line
//            lines.forEach(System.out::println);
//            long count = lines.count();
//            long count = lines.mapToLong((el)->2L).sum();
//            System.out.println("Number of lines: " + count);
            lines.toList().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
        double result = numbers.collect(Collectors.averagingInt((el)->el));
        System.out.println("Average: " + result);
        // create stream of strings
        Stream<String> streamOfStrings = Stream.of("one", "two", "three");
        String result2 = streamOfStrings.reduce("",(subTotal,element)->subTotal + element+",");
        System.out.println("Result: " + result2);
        // joining
        Stream<String> streamOfStrings2 = Stream.of("one", "two", "three");
        String result3 = streamOfStrings2.collect(Collectors.joining(","));
        System.out.println("Result: " + result3);
        // create stream of integers
        Stream<Integer> streamOfIntegers = Stream.of(1,2,3,4,5,6,7,8,9,10);
        int result4 = streamOfIntegers.reduce(0,(subTotal,element)->subTotal + element);
        System.out.println("Result: " + result4);

        // Group by
        Stream<String> alphaNames = Stream.of("Alice", "Bob", "Charlie","Allan");
        Map<Character, List<String>> groupedNames = alphaNames
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Grouped names: "+groupedNames);

        // Create 10 cars
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Car car = Car.builder()
                    .make("Audi")
                    .model("Model"+i)
                    .year(2000+i)
                    .price(10000+i*1000)
                    .build();
            cars.add(car);
        }
        cars.stream().limit(5).forEach(car -> car.setMake("BMW"));
        cars.stream().forEach(System.out::println);
        // Find total price of all cars
        // Find all cars with price > 15000
        // Group by on Make -> find average price of each make
        //
    }
    @Setter
    @Getter
    @AllArgsConstructor
    @Builder
    @ToString
    private static class Car{
        String make;
        String model;
        int year;
        double price;
    }
}
