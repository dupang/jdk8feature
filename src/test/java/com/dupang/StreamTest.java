/*
 * Copyright © 2017 damai.cn  All rights reserved. 
 * 北京红马传媒文化发展有限公司 版权所有 大麦网      
 *
 * 声明: 对未经许可擅自反编译、修改和使用本源码者，本公司保留追究其法律责任的权利.
 */
package com.dupang;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
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



}
