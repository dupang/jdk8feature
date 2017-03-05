package com.dupang;

import junit.framework.TestCase;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * <p>ClassName:com.dupang.MapTest</p>
 * <p>描述：map test</p>
 * <p>日期：2017/3/5
 *
 * @version 3.3.0
 * @auther duguanxin
 * @since 1.10
 */
public class MapTest extends TestCase {


    public void testGetOrDefault() {

        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");

        String value = map.getOrDefault("dupang", "我是杜庞");
        String defaultValue = map.getOrDefault("robot", "My name is robot");

        System.out.println("有值的情况==========" + value);
        System.out.println("没有值的情况==========" + defaultValue);

    }

    public void testForEach() {
        BiConsumer<String, String> biConsumer = (k, v) -> {
            System.out.print("键是=====" + k);
            System.out.println("     值是=====" + v);
        };

        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        map.forEach(biConsumer);
    }

    public void testReplaceAll() {
        BiFunction<String, String, String> biFunction = (k, v1) -> {
            return k + " " + v1;
        };

        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        map.replaceAll(biFunction);


        BiConsumer<String, String> biConsumer = (k, v) -> {
            System.out.print("键是=====" + k);
            System.out.println("     值是=====" + v);
        };

        map.forEach(biConsumer);

    }

    public void testPutIfAbsent() {
        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        map.putIfAbsent("Lucy", "My name is Lucy");
        map.putIfAbsent("dupang", "杜庞222s");

        BiConsumer<String, String> biConsumer = (k, v) -> {
            System.out.print("键是=====" + k);
            System.out.println("     值是=====" + v);
        };

        map.forEach(biConsumer);

    }

    public void testRemove() {
        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        boolean remove = map.remove("dupang", "杜庞2");
        boolean anotherRemove = map.remove("dupang", "杜庞");

        System.out.println("是否删除========" + remove);
        System.out.println("是否删除========" + anotherRemove);

    }

    public void testReplace() {
        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        map.replace("dupang", "杜庞", "杜庞2");

        BiConsumer<String, String> biConsumer = (k, v) -> {
            System.out.print("键是=====" + k);
            System.out.println("     值是=====" + v);
        };

        map.forEach(biConsumer);


    }

    public void testComputeIfAbsent() {
        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        Function<String, String> function = (k) -> {
            return k + "22";
        };


        map.computeIfAbsent("lucy", function);


        BiConsumer<String, String> biConsumer = (k, v) -> {
            System.out.print("键是=====" + k);
            System.out.println("     值是=====" + v);
        };

        map.forEach(biConsumer);
    }

    public void testComputeIfPresent() {
        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        BiFunction<String, String, String> biFunction = (k, v1) -> {
            return k + " " + v1;
        };


        map.computeIfPresent("dupang", biFunction);


        BiConsumer<String, String> biConsumer = (k, v) -> {
            System.out.print("键是=====" + k);
            System.out.println("     值是=====" + v);
        };

        map.forEach(biConsumer);
    }


    public void testMerge() {
        Map<String, String> map = new HashMap<>();

        map.put("dupang", "杜庞");
        map.put("robot", "My name is robot");

        BiFunction<String, String, String> biFunction = (v1, v2) -> {
            return v1 + " " + v2;
        };

        map.merge("dupang2", "dupang2", biFunction);


        BiConsumer<String, String> biConsumer = (k, v) -> {
            System.out.print("键是=====" + k);
            System.out.println("     值是=====" + v);
        };

        map.forEach(biConsumer);

    }


    /**
     * 统计一个数字的个数
     * <p>
     * 100个10之内的随机数，分别统计他们出现的次数
     */


    public void test() {


        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            integerList.add(random.nextInt(10));

        }

        for (Integer i : integerList
                ) {
            System.out.println("数字=====" + i);
        }


        //方案1
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : integerList) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("统计数字=" + entry.getKey() + " 出现次数=" + entry.getValue());
        }

        //jdk8方案

        Map<Integer, Integer> anotherMap = new HashMap<>();
        for (Integer i : integerList) {
            anotherMap.computeIfPresent(i, (k, v) -> v + 1);
            anotherMap.putIfAbsent(i, 1);
        }

        System.out.println("=================华丽的分割线===============================");
        for (Map.Entry entry : anotherMap.entrySet()) {
            System.out.println("统计数字=" + entry.getKey() + " 出现次数=" + entry.getValue());
        }


    }


}
