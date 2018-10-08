package com.lv.util;

import com.lv.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by simperLv
 * on 2018/07/31 14:30
 *
 * @Description 使用流来聚合集合中的每一项
 */
public class ParallelStreams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("item" + i);
        }
        /*list.stream()
                .forEach(str -> System.out.println(str));*/
        /**
         *@Author simperLv
         *@Description //并行流输出，在运行时将数据划分成了多个块。
         *@Date 2018/07/31  14:41
         *@Param [args]
         *@return void
         */
        /*list.stream()
                .parallel()
                .forEach(str -> System.out.println(str));*/
        long listSize = list.stream().count();
        System.out.println(listSize);
        long count = list.stream().parallel().count();
        System.out.println("并行流:" + count);

        //使用SumAndAverage 类来求和
        List<Person> people = new ArrayList<>();
        people.add(new Person("猪猪", 22));
        people.add(new Person("闵小", 24));
        people.add(new Person("叼比", 21));
        people.add(new Person("小吕帅棒棒哒", 22));
        int sum = people.stream()
                .mapToInt(p -> p.getAge())
                .sum();
        System.out.println("people集合中所有人的年龄和为:" + sum);
        //Optional类这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
        OptionalDouble avg = people.stream()
                .mapToInt(p -> p.getAge())
                .average();
        if (avg.isPresent())
            System.out.println("437平均年龄:" + avg.getAsDouble());
        else
            System.out.println("平均年龄不存在");
    }
}
