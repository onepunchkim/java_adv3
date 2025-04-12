package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Toamto")
                .collect(Collectors.toMap(
                        name -> name,           //keyMapper
                        name -> name.length()   //valueMapper
                ));
        System.out.println("map1 = " + map1);

        //키 중복 예외: java.lang.IllegalStateException: Duplicate key
/*        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Banana")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length()
                ));
        System.out.println("map2 = " + map2);
*/

        //키 중복 대안 (병합)
        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Banana")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length(),
                        (oldVal, newVal) -> oldVal + newVal //중복될 경우 기존 값 + 새 값
                ));
        System.out.println("map3 = " + map3);

        //Map의 타입 지정
        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Banana")
                .collect(Collectors.toMap(
                        name -> name,
                        String::length,
                        (oldVal, newVal) -> oldVal + newVal, //key 중복 발생 시 조정 로직
                        LinkedHashMap::new //결과 Map 타입 지정
                ));
        System.out.println("map4 = " + map4.getClass());
    }
}
