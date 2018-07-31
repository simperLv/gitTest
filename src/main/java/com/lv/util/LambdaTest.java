package com.lv.util;

import com.lv.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by simperLv
 * on 2018/07/31 16:06
 *
 * @Description //lambda表达式测试
 */
public class LambdaTest {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java8之前实现runnable");
            }
        }).start();

        new Thread(() -> System.out.println("java8中lambda表达式函数替换匿名类")).start();

        //java8之前迭代集合
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features){
            System.out.println("before java8 :"+feature);
        }
        //通过流迭代
        //features.stream().forEach(p -> System.out.println("after java8 :"+p));
        //使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        features.forEach(System.out :: println);

        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startWithJ = (p) -> p.startsWith("J");
        Predicate<String> fourLetterLong = (p) -> p.length() == 4;
        languages.stream()
                .filter(startWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("两个条件" + n));
    }
}
