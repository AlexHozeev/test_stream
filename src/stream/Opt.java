package stream;

import serialization.Dog;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Opt {
    public static void main(String[] args) {
    {
        Dog dog = new Dog("Hasky","summer",1,12);

        Optional<Dog> dogOptional = Optional.of(dog);
        Optional<Integer> integer = dogOptional.map(s-> {
            s.setName(null);
            return s;
        }).map(Dog::getName).map(String::length); //.map(s->s.getName())

        integer.ifPresentOrElse( System.out::println, () -> System.out.println("sorry not present"));
        integer.ifPresent(System.out::println);
    }

        List<Dog> dogs = List.of(
            new Dog("Hasky","summer",12,12),
            new Dog("Hasky","summer",21,12),
            new Dog("Hasky","summer",11,12)
        );
       // Optional.of(23).flatMap(s-> Optional.of(null)).orElseThrow(()->new IndexOutOfBoundsException());
        Optional.of(dogs).stream().flatMap(Collection::stream);

    }
}
