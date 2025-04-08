package methodref;

import java.util.function.Function;
import java.util.function.Supplier;

//매개변수 추가
public class MethodRefEx2 {
    public static void main(String[] args) {
        // 1. 정적 메서드 참조
        Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
        //클래스::정적메서드
        Function<String, String> staticMethod2 = Person::greetingWithName;

        System.out.println("staticMethod1: " + staticMethod1.apply("Kim"));
        System.out.println("staticMethod2: " + staticMethod2.apply("kim"));

        // 2. 특정 객체의 인스턴스 참조
        Person instance = new Person("Kim");
        Function<Integer, String> instanceMethod1 = n-> instance.introduceWithNumber(n);
        //객체::인스턴스 메서드
        Function<Integer, String> instanceMethod2 = instance::introduceWithNumber;

        System.out.println("instanceMethod1: " + instanceMethod1.apply(1));
        System.out.println("instanceMethod2: " + instanceMethod2.apply(1));

        // 3. 생성자 참조
        Function<String, Person> supplier1 = name -> new Person(name);
        //클래스::new
        Function<String, Person> supplier2 = Person::new;

        System.out.println("newPerson1: " + supplier1.apply("Kim"));
        System.out.println("newPerson2: " + supplier2.apply("Lee"));
    }
}
