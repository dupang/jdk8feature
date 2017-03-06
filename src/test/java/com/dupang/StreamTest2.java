package com.dupang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by dupang on 16-4-5.
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i =0;i<100;i++){
            integerList.add(random.nextInt(10));
        }
        Stream<Integer> stream = integerList.stream();

        /**
         * 遍历
         */
        //stream.forEach(x-> System.out.println(x));
        /**
         * map映射
         * 从Integer到String
         */
        //Stream<String> strStream = stream.map(x-> x.toString());

        //strStream.forEach(x-> System.out.println(x));

        /**
         * 过滤
         */

        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        strList.add("java");

        List<String> ssList = new ArrayList<>();
        ssList.add("ON");

        List<String> doubleList = new ArrayList<>();
        doubleList.add("1.1");
        doubleList.add("2.1");
        doubleList.add("3.1");
        strList.stream().filter(x->x.startsWith("d")).forEach(x-> System.out.println(x));

        /**
         * allMatch
         */
        Predicate<String> stringPredicate = x->x.startsWith("d");
        System.out.println(strList.stream().allMatch(stringPredicate));

        /**
         * anyMatch
         */
        System.out.println(strList.stream().anyMatch(stringPredicate));

        /**
         * count
         */
        System.out.println(strList.stream().count());

        /**
         * findAny
         */
        System.out.println(strList.stream().findAny().get());

        /**
         * findFirst
         */
        System.out.println(strList.stream().parallel().findFirst().get());

        /**
         * flatMap
         */
        strList.stream().flatMap(x->Stream.of(x.toUpperCase())).forEach(x-> System.out.println(x));

        Stream.of(ssList,strList).forEach(x-> System.out.println(x));

        Stream.of(ssList,strList).flatMap(x->x.stream()).forEach(x-> System.out.println(x));
        /**
         * map
         */
        strList.stream().map(x-> x.charAt(2)).forEach(x-> System.out.println(x));

        /**
         * flatMapToDouble
         */
        doubleList.stream().flatMapToDouble(x-> DoubleStream.of(Double.valueOf(x))).forEach(x-> System.out.println(x));

        /**
         * distinct
         */
        strList.stream().distinct().forEach(x-> System.out.println(x));

        /**
         * limit
         */
        strList.stream().limit(2).forEach(x-> System.out.println(x));

        /**
         * forEachOrdered
         */
        strList.stream().forEachOrdered(x-> System.out.println(x));

        /**
         * max
         * min
         */
        System.out.println("====================max===========================");
        System.out.println(strList.stream().max((x,y)->x.compareTo(y)).get());
        System.out.println(strList.stream().min((x,y)->x.compareTo(y)).get());

        /**
         * peek
         */
        strList.stream().peek(x-> System.out.println(x)).forEach(x-> System.out.println(x));

        System.out.println("==========================peek============================");
        Stream.of("one", "two", "three", "four")
                         .filter(e -> e.length() > 3)
                         .peek(e -> System.out.println("Filtered value: " + e))
                         .map(String::toUpperCase)
                         .peek(e -> System.out.println("Mapped value: " + e)).forEach(x-> System.out.println(x));

        /**
         * skip
         */
        System.out.println("========================skip===============================");
        strList.stream().skip(2).forEach(x-> System.out.println(x));

        /**
         * reduce(BinaryOperator<T> accumulator)
         */
        System.out.println(strList.stream().reduce((x,y)->x.concat(y)).get());


        /**
         * reduce(T identity, BinaryOperator<T> accumulator);
         */
        System.out.println(strList.stream().reduce("Begin=",(x,y)->x.concat(y)));

        /**
         * reduce(U identity,
         * BiFunction<U, ? super T, U> accumulator,
         * BinaryOperator<U> combiner);
         */
        System.out.println("=====================================================");
        System.out.println(strList.stream().reduce("Begin=",(x,y)->x.concat(y),(a,b)->a.concat(b)));


        /**
         * collect
         */
        System.out.println("=============================collect=========================================");
        StringBuffer ss = strList.stream().collect(StringBuffer::new,(x,y)-> x.append(y),(a,b)-> a.append("X"));
        System.out.println(ss.toString());
        List<String> asList = strList.stream().collect(ArrayList::new, ArrayList::add,ArrayList::addAll);

        for (String s :asList){
            System.out.println(s);
        }
        /**
         * Collectors
         */
        /**
         * count，元素的个数
         */
        Stream<Integer> numStream = Stream.of(1,2);
        //System.out.println(numStream.collect(Collectors.counting()));

        /**
         * averagingDouble
         * 平均数 double表示
         */
        //System.out.println(numStream.collect(Collectors.averagingDouble(x->Double.valueOf(x))));

        /**
         * averagingInt
         * 平均数 int表示
         */
        //System.out.println(numStream.collect(Collectors.averagingInt(x->x)));

        /**
         * averagingLong
         * 平均数 long表示
         */
        //System.out.println(numStream.collect(Collectors.averagingLong(x->x)));

        /**
         * summingInt
         * 和 int表示 直观的理解是有几个元素，summingInt里面指定的值加几次
         */
        //System.out.println(numStream.collect(Collectors.summingInt(p->1)));

        /**
         * summingDouble
         * 和 Double表示 直观的理解是有几个元素，summingDouble里面指定的值加几次
         */
        //System.out.println(numStream.collect(Collectors.summingDouble(p->2)));

        /**
         * summingLong
         * 和 Long表示 直观的理解是有几个元素，summingLong里面指定的值加几次
         */
        //System.out.println(numStream.collect(Collectors.summingLong(p->1)));

        /**
         * groupingBy
         * 分组
         */
        //System.out.println(strList.stream().collect(Collectors.groupingBy(x->x.length())));

        /**
         * groupingBy
         * 分组
         */
        //System.out.println(strList.stream().collect(Collectors.groupingBy(x->x.length(), Collectors.summingInt(p->1))));

        /**
         * groupingBy
         * 分组
         */
//        System.out.println(strList.stream().collect(Collectors.groupingBy(x->x.length(), HashMap::new,
//                Collectors.summingInt(p->1))));

        //Collectors collectors = Collectors.toList();

        //System.out.println(strList.stream().collect(Collectors.groupingBy(x->x.length(), Collectors.counting())));
        /**
         * Collectors.mapping 把字符串的stream匹配给对应字符串的长度的list
         */
        //System.out.println(strList.stream().collect(Collectors.mapping(x->x.length(),Collectors.toList())));

        /**
         * 概要统计 以double的格式显示
         */
        //System.out.println(strList.stream().collect(Collectors.summarizingDouble(x->x.length())));

        /**
         * 概要统计 以int的格式显示
         */
        //System.out.println(strList.stream().collect(Collectors.summarizingInt(x->x.length())));

        /**
         * 概要统计 以long的格式显示
         */
        //System.out.println(strList.stream().collect(Collectors.summarizingLong(x->x.length())));

        /**
         * 求和 以long的格式显示
         */
        //System.out.println(strList.stream().collect(Collectors.summingDouble(x->x.length())));

        /**
         * collectingAndThen
         */
        System.out.println("==============================collectingAndThen================================");
        System.out.printf(strList.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(x->x.length()),a->a.toString())));

        /**
         * Collectors.maxBy(
         */
        System.out.println(strList.stream().collect(Collectors.maxBy((x,y)->x.compareTo(y))));

        /**
         * Collectors.maxBy(
         */
        System.out.println(strList.stream().collect(Collectors.minBy((x,y)->x.compareTo(y))));

        /**
         * Collectors.minBy(
         */
        System.out.println(strList.stream().collect(Collectors.minBy((x,y)->x.compareTo(y))));

        /**
         * Collectors.partitioningBy
         */
        System.out.println(strList.stream().collect(Collectors.partitioningBy(x->x.length()>5)));

        /**
         * Collectors.partitioningBy
         */
        System.out.println(strList.stream().collect(Collectors.partitioningBy(x->x.length()>5, Collectors.counting())));

        /**
         * Collectors.joining()
         */
        System.out.println(strList.stream().collect(Collectors.joining()));

        /**
         * Collectors.joining()
         */
        System.out.println(strList.stream().collect(Collectors.joining("#")));

        /**
         * Collectors.joining()
         */
        System.out.println(strList.stream().collect(Collectors.joining("#","[","]")));


        /**
         * Collectors.joining()
         */
        System.out.println(strList.stream().collect(Collectors.joining("#","[","]")));
    }
}
