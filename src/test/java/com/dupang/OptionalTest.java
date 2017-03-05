package com.dupang;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <p>ClassName:com.dupang.OptionalTest</p>
 * <p>描述：项目同步信息</p>
 * <p>日期：2017/3/5
 *
 * @version 3.3.0
 * @auther duguanxin
 * @since 1.10
 */
public class OptionalTest extends TestCase {

    public void testEmpt() {
        Optional<String> emptyOptional = Optional.empty();

        String emptyStr = emptyOptional.get();

        System.out.println("字符串为============" + emptyStr);
    }

    public void testOf() {
        Optional<String> stringOptional = Optional.of("dupang");//不能为null
        String str = stringOptional.get();

        System.out.println("字符串为============" + str);
    }

    public void testOfNullable() {
        Optional<String> stringOptional = Optional.ofNullable(null);//可以为null
        String str = stringOptional.get();

        System.out.println("字符串为============" + str);
    }

    public void testIsPresent() {

        Optional<String> stringOptional = Optional.of("dupang");//不能为null
        boolean isPresent = stringOptional.isPresent();

        System.out.println("是否存在=======" + isPresent);

        Optional<String> nullableOptional = Optional.ofNullable(null);//可以为null
        boolean isPresent2 = nullableOptional.isPresent();

        System.out.println("是否存在2============" + isPresent2);
    }


    public void testIfPresent() {

        Consumer consumer = x -> System.out.println(x);

        Optional<String> stringOptional = Optional.of("dupang");//不能为null
        stringOptional.ifPresent(consumer);
        stringOptional.ifPresent(System.out::println);


        System.out.println("===================");
        Optional.empty().ifPresent(consumer);
    }

    public void testFilter() {

        Predicate<String> lengthPredicate = x -> x.length() > 8;

        Optional<String> stringOptional = Optional.of("dupang");//不能为null
        Optional<String> filteredOptional = stringOptional.filter(lengthPredicate);

        String filteredStr = filteredOptional.get();

        System.out.println("过滤后的结果============" + filteredStr);

    }


    public void testMap() {
        //大写功能的function
        Function<String, String> upperFunction = x -> x.toUpperCase();
        Optional<String> stringOptional = Optional.of("dupang");//不能为null
        Optional<String> mappedOptional = stringOptional.map(upperFunction);
        String mappedString = mappedOptional.get();

        System.out.println("转换过的str============" + mappedString);
    }

    public void testOrElse() {

        Optional<String> stringOptional = Optional.ofNullable(null);//不能为null

        String orAnother = stringOptional.orElse("another");

        System.out.println("或者是另一个结果=============" + orAnother);

    }

    public void testOrElseGet() {
        Optional<String> stringOptional = Optional.ofNullable(null);//不能为null
        Supplier<String> supplier = () -> "dupang2222";
        String str = stringOptional.orElseGet(supplier);

        System.out.println("supplier里的结果=============" + str);
    }

    public void testOrElseThrow() throws Exception {
        Optional<Exception> stringOptional = Optional.ofNullable(null);//不能为null
        Supplier<Exception> supplier = () -> new Exception();
        Exception exception = stringOptional.orElseThrow(supplier);

        System.out.println("异常结果============" + exception);
    }


}
