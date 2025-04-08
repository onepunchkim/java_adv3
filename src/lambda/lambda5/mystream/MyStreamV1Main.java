package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;

public class MyStreamV1Main {
    public static void main(String[] args) {
        //짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        returnValue(numbers);
        methodChain(numbers);
    }

    private static void returnValue(List<Integer> numbers) {
        MyStreamV1 stream = new MyStreamV1(numbers);
        MyStreamV1 filteredStream = stream.filter(n -> n % 2 == 0);
        MyStreamV1 mappedStream = filteredStream.map(n -> n * 2);
        List<Integer> result1 = mappedStream.toList();
        System.out.println("result1 = " + result1);
    }

    private static void methodChain(List<Integer> numbers) {
        List<Integer> result2 = new ArrayList<>(numbers).stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .toList();
        System.out.println("result2 = " + result2);
    }
}
