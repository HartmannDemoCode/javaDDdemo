package dk.cphbusiness;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainWednesday {
    public static void main(String[] args) {
        // Create streams from arrays, lists, maps, etc.
        Stream<String> strings = Stream.of("a1", "a2", "a3");
        strings.forEach(System.out::println);
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArray = Stream.of(array);
        streamFromArray.forEach(System.out::println);
        // List
        List<String> list = List.of("a1", "b8", "a2", "b5", "a3");
        Stream<String> listStrings = list.stream();
        listStrings.forEach(System.out::println);

        // map
        Map<String,String> map = Map.of("k1", "v1", "k2", "v2", "k3", "v3");
        Stream mapStream = Stream.of(map);
        mapStream.forEach(System.out::println);

        // Stream from I/O
        try (Stream<String> lines = Files.lines(Paths.get("content.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream.Builder<String> streamBuilder = Stream.builder();
        streamBuilder.add("apple").add("banana").add("cherry");
        Stream<String> manualStream = streamBuilder.build();
        manualStream.forEach(System.out::println);

        // Stream methods: map, filter, sorted, distinct, limit, skip, peek
        listStrings = list.stream();
        listStrings.mapToInt(str->Integer.parseInt(str.substring(1,2))).forEach(System.out::println);
        listStrings = list.stream();
        listStrings.filter(str->str.startsWith("a")).forEach(System.out::println);
        listStrings = list.stream();
        listStrings.sorted().forEach(System.out::println);
        listStrings = list.stream();
        listStrings.distinct().forEach(System.out::println);
        listStrings = list.stream();
        System.out.println("Limit 2");
        listStrings.limit(2).forEach(System.out::println);
        listStrings = list.stream();
        System.out.println("peek ");
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

    }
}
