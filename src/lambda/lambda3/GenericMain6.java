package lambda.lambda3;


public class GenericMain6 {
    public static void main(String[] args) {
        GenericFunction<String, String> upperCase = str -> str.toUpperCase();
        GenericFunction<String, Integer> stringLength = str -> str.length();
        GenericFunction<Integer, Integer> square = n -> n * n;
        GenericFunction<Integer, Boolean> isEven = num-> num % 2 == 0;

        System.out.println(upperCase.apply("hello"));
        System.out.println(stringLength.apply("hello"));
        System.out.println(square.apply(3));
        System.out.println(isEven.apply(3));
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T s);
    }
}
