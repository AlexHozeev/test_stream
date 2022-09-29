package stream;

import serialization.Dog;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
           //method reference
        String collect = IntStream.of(1, 2, 3, 4, 5)
                .mapToObj(Integer::toString)            //преобразование в обьект
                .peek(System.out::println)              // просто выводит елементы
                .collect(Collectors.joining(",")); // возращает строку
        System.out.println(collect);
    }



        List<Dog> dogs = List.of(
                new Dog("Hasky","summer",12,14),
                new Dog("Hasky","forest",21,11),
                new Dog("Hasky","summer",11,32),
                new Dog("labrador","chips",7,24)
        );

        long count = dogs.stream().filter(s-> s.getAge()>6).peek(System.out::println).count();
        System.out.println(count);

        int sum = dogs.stream().mapToInt(Dog::getAge).sum();
        System.out.println(sum);

        String collect1 = dogs.stream().map(s->s.getName() + "->"+ s.getBread()).collect(Collectors.joining(",\n"));
        System.out.println(collect1);
    }
}

