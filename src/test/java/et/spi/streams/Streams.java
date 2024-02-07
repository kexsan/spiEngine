package et.spi.streams;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    private List<Employee> emps = List.of(
            new Employee("Michael", "Smith", 243, 43, Position.CHEF),
            new Employee("Jane", "Smith", 523, 40, Position.MANAGER),
            new Employee("Jury", "Gagarin", 6423, 26, Position.MANAGER),
            new Employee("Jack", "London", 5543, 53, Position.WORKER),
            new Employee("Eric", "Jackson", 2534, 22, Position.WORKER),
            new Employee("Andrew", "Bosh", 3456, 44, Position.WORKER),
            new Employee("Joe", "Smith", 723, 30, Position.MANAGER),
            new Employee("Jack", "Gagarin", 7423, 35, Position.MANAGER),
            new Employee("Jane", "London", 7543, 42, Position.WORKER),
            new Employee("Mike", "Jackson", 7534, 31, Position.WORKER),
            new Employee("Jack", "Bosh", 7456, 54, Position.WORKER),
            new Employee("Mark", "Smith", 123, 41, Position.MANAGER),
            new Employee("Jane", "Gagarin", 1423, 28, Position.MANAGER),
            new Employee("Sam", "London", 1543, 52, Position.WORKER),
            new Employee("Jack", "Jackson", 1534, 27, Position.WORKER),
            new Employee("Eric", "Bosh", 1456, 32, Position.WORKER)
    );

    private List<Department> deps = List.of(
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East"),
            new Department(4, 2, "Germany"),
            new Department(5, 2, "France"),
            new Department(6, 3, "China"),
            new Department(7, 3, "Japan")
    );


    @Test
    public void creation() throws IOException {
        /*Stream<String> lines = Files.lines(Paths.get("."));
        Stream<Path> list = Files.list(Paths.get("./"));
        Stream<Path> walk = Files.walk(Paths.get("./"), 3);*/

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);
        IntStream range = IntStream.range(10, 100); // 10 .. 99
        IntStream intStream1 = IntStream.rangeClosed(10, 100); // 10 .. 100

        int[] ints = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(ints);

        Stream<String> stringStream = Stream.of("1", "2", "3");
        Stream<? extends Serializable> stream1 = Stream.of(1, "2", "3");

        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("joe")
                .build();

        Stream<Employee> stream2 = emps.stream();
        Stream<Employee> employeeStream = emps.parallelStream();

        Stream<Event> generate = Stream.generate(() ->
                new Event(UUID.randomUUID(), LocalDateTime.now(), "")
        );

        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3);

        Stream<String> concat = Stream.concat(stringStream, build);
    }


    @Test
    public void test1() throws IOException {
        Stream.iterate(1950, val -> val + 3)
                //.anyMatch(x->x>2000)
                .takeWhile(n -> n < 2000)
                //.limit(10)
                .forEach(x -> System.out.println(x));

    }

    @Test
    public void test11() throws IOException {
        Stream.iterate(1950, n -> n < 2000, val -> val + 3)
                .forEach(x -> System.out.println(x));

    }

    @Test
    public void test2() throws IOException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(10, Integer::sum);

        System.out.println(sum);

    }

    @Test
    public void test22() throws IOException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(10, (accumulator, element) -> accumulator + element);

        System.out.println(sum);

    }

    @Test
    public void test3() throws IOException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream()
                .takeWhile(n -> n < 5)
                .collect(Collectors.toList());

        System.out.println(result);

    }


}
