package com.lv.util;

import com.lv.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by simperLv
 * on 2018/07/30 16:25
 * java8 中的stream特性，尝试通过流的形式遍历集合。使用Predicate接口来测试集合遍历结果，
 * Predicate函数式接口主要是提供test方法，
 * 接受一个参数返回一个布尔类型，Predicate在stream api中进行一些判断的时候非常常用。
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("lv", 22));
        people.add(new Person("gou", 23));
        people.add(new Person("yueer", 21));

        Predicate<Person> pred = (p) -> p.getAge() > 22;
        displayPeople(people, pred);
        System.out.println(people.stream().mapToInt(p -> p.getAge()).sum());
        Person[] students = {
                new Person("小吕", 22),
                new Person("狗", 23),
                new Person("岳二", 21)};
        //Stream<Person> stream = Stream.of(students);
        Stream<Person> stream = Arrays.stream(students);
        stream.forEach(s -> System.out.println(s.getInfo()));
        IntStream.range(1, 4).forEach(System.out::println);
    }

    public static void displayPeople(List<Person> people, Predicate<Person> pred) {
        System.out.print("selected:");
        /*people.forEach(p -> {
            if (pred.test(p)){
                System.out.print(p.getName());
            }
        });*/
        people.stream()
                .filter(pred)
                .forEach(p -> System.out.println(p.getName()));
        people.stream()
                .forEach(p -> System.out.println(p.getName() + "的年龄是:" + p.getAge()));
    }
}
