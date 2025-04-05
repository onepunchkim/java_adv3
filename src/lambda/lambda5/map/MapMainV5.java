package lambda.lambda5.map;

import java.util.List;

public class MapMainV5 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "orange");

        //String -> String
        List<String> upperFruits = GenericMapper.map(fruits, s -> s.toUpperCase());
        System.out.println("upperFruits = " + upperFruits);

        //String -> Integer
        List<Integer> lengthFruits = GenericMapper.map(fruits, s -> s.length());
        System.out.println("lengthFruits = " + lengthFruits);

        //Integer -> Integer
        List<Integer> integers = GenericMapper.map(fruits, s -> s.length());
        List<String> starList = GenericMapper.map(integers, n -> "*".repeat(n));
        System.out.println("starList = " + starList);
    }
}
