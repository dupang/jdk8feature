/*
 * Copyright © 2017 damai.cn  All rights reserved. 
 * 北京红马传媒文化发展有限公司 版权所有 大麦网      
 *
 * 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * <p>ClassName:com.dupang.StreamTest</p>
 * <p>描述:</p>
 * <p>日期:2017年03月06</p>
 *
 * @author duguanxin
 * @version 1.0
 * @since 1.0
 */
public class StreamTest extends TestCase{

    /**
     * 遍历
     */
    public void testStream(){
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i =0;i<100;i++){
            integerList.add(random.nextInt(10));
        }
        Stream<Integer> stream = integerList.stream();

        stream.forEach(x-> System.out.println(x));
    }

    /**
     * 映射
     */
    public void testMap(){
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i =0;i<100;i++){
            integerList.add(random.nextInt(10));
        }
        Stream<Integer> stream = integerList.stream();

        Stream<String> strStream = stream.map(x-> x.toString());

        strStream.forEach(x-> System.out.println(x));
    }

    /**
     * 过滤
     */
    public void testFilter(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");

        strList.stream().filter(x->x.startsWith("d")).forEach(x-> System.out.println(x));
    }

    /**
     * allMatch
     */

    public void testAllMatch(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        Predicate<String> stringPredicate = x->x.startsWith("d");
        System.out.println(strList.stream().allMatch(stringPredicate));
    }

    /**
     * anyMatch
     */
    public void testAnyMatch(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        Predicate<String> stringPredicate = x->x.startsWith("d");
        System.out.println(strList.stream().anyMatch(stringPredicate));
    }

    /**
     * count
     */

    public void testCount(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().count());
    }
    /**
     * findAny
     */
    public void testFindAny(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().findAny().get());
    }

    /**
     * findFirst
     */
    public void testFindFirst(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().findFirst().get());
    }
    /**
     * flatMap
     */
    public void testFlatMap(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        strList.stream().flatMap(x->Stream.of(x.toUpperCase())).forEach(x-> System.out.println(x));
    }

    /**
     * of
     */
    public void testStreamOf(){
        List<String> ssList = new ArrayList<>();
        ssList.add("ON");

        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");

        Stream.of(ssList,strList).forEach(x-> System.out.println(x));
    }

    /**
     * flatMapToDouble
     */
    public void testFlatMapToDouble(){
        List<String> doubleList = new ArrayList<>();
        doubleList.add("1.1");
        doubleList.add("2.1");
        doubleList.add("3.1");
        doubleList.stream().flatMapToDouble(x-> DoubleStream.of(Double.valueOf(x))).forEach(x-> System.out.println(x));
    }

    /**
     * reduce(U identity,
     * BiFunction<U, ? super T, U> accumulator,
     * BinaryOperator<U> combiner);
     */

    public void testReduce3(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");

        System.out.println("=====================================================");
        System.out.println(strList.stream().reduce("Begin=",(x,y)->x.concat(y),(a,b)->a.concat(b)));
    }

    /**
     * collect
     */

    public void testCollect(){

        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");

        System.out.println("=============================collect=========================================");
        String ss = strList.stream().collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString();
        System.out.println(ss.toString());
        List<String> asList = strList.stream().collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
    }


    /**
     * Collectors
     */
    /**
     * count，元素的个数
     */
    public void testCollectorCount(){
        Stream<Integer> numStream = Stream.of(1,2);
        System.out.println(numStream.collect(Collectors.counting()));
    }

    /**
     * averagingDouble
     * 平均数 double表示
     */
    public void testAverage(){
        Stream<Integer> numStream = Stream.of(1,2);
        System.out.println(numStream.collect(Collectors.averagingDouble(x->Double.valueOf(x))));
    }

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
    public void testSumInt(){
        Stream<Integer> numStream = Stream.of(1,2);
        System.out.println(numStream.collect(Collectors.summingInt(p->p)));
    }

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
    public void testGroupBy(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");

        System.out.println(strList.stream().collect(Collectors.groupingBy(x->x.length())));
    }
    /**
     * groupingBy
     * 分组
     */
    public void testGroupBy2(){

        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.groupingBy(x->x.length(), Collectors.summingInt(p->1))));
    }
    /**
     * groupingBy
     * 分组
     */
    public void testGroupBy3(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        HashMap<Integer,Integer> map = strList.stream().collect(Collectors.groupingBy(x->x.length(), HashMap<Integer,
                Integer>::new,
                Collectors.summingInt(p->1)));

        BiConsumer<Integer, Integer> biConsumer = (k, v) -> {
            System.out.print("长度=====" + k);
            System.out.println("     次数=====" + v);
        };
        map.forEach(biConsumer);
    }

    public void testGroupBy4(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");

        System.out.println(strList.stream().collect(Collectors.groupingBy(x->x.length(), Collectors.counting())));
    }
    /**
     * Collectors.mapping 把字符串的stream匹配给对应字符串的长度的list
     */
    public void testGroupBy5(){

        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.mapping(x->x.length(),Collectors.toList())));
    }

    /**
     * 概要统计 以double的格式显示
     */
    public void testSummary(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.summarizingDouble(x->x.length())));
    }

    /**
     * 概要统计 以int的格式显示
     */
    //System.out.println(strList.stream().collect(Collectors.summarizingInt(x->x.length())));

    /**
     * 概要统计 以long的格式显示
     */
    //System.out.println(strList.stream().collect(Collectors.summarizingLong(x->x.length())));


    /**
     * collectingAndThen
     */
    public void testCollectionAndThen(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println("==============================collectingAndThen================================");
        System.out.printf(strList.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(x->x.length()),a->a.toString())));
    }

    /**
     * Collectors.maxBy(
     */
    public void testMaxBy(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.maxBy((x,y)->x.compareTo(y))));
    }

    /**
     * Collectors.maxBy(
     */

    public void testMinBy(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        Optional<String> optional =  strList.stream().collect(Collectors.minBy((x, y)->x.compareTo(y)));
        System.out.println(optional.get());
    }

    /**
     * Collectors.partitioningBy
     */
    public void testPartitioningBy(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.partitioningBy(x->x.length()>5)));
    }


    /**
     * Collectors.partitioningBy
     */
    public void testPartitioningBy2(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.partitioningBy(x->x.length()>5, Collectors.counting())));
    }

    /**
     * Collectors.joining()
     */


    public void testJoin(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.joining()));
    }

    /**
     * Collectors.joining()
     */
    public void testJoin2(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.joining(",")));
    }

    /**
     * Collectors.joining()
     */
    public void testJoin3(){
        List<String> strList = new ArrayList<>();
        strList.add("dupang");
        strList.add("dupang");
        strList.add("beijing");
        strList.add("linux");
        strList.add("java");
        System.out.println(strList.stream().collect(Collectors.joining(",","(",")")));
    }










}
