package com.dupang;

import junit.framework.TestCase;

import java.util.function.Predicate;

/**
 * <p>ClassName:com.dupang.PredicateTest</p>
 * <p>描述：predicate test</p>
 * <p>日期：2017/3/5
 *
 * @version 3.3.0
 * @auther duguanxin
 * @since 1.10
 */
public class PredicateTest extends TestCase {

    public void testTest(){
        Predicate<String> lengthTest = x->x.length()>8;

        boolean isGreaterThan = lengthTest.test("dupang");

        System.out.println("是否正确==========="+isGreaterThan);
    }

    public void testAnd(){
        Predicate<String> lengthTest = x->x.length()>3;

        Predicate<String> startWith = x->x.startsWith("d");


        boolean greaterThanAndStartWith = lengthTest.and(startWith).test("dupang");

        System.out.println("是否正确==========="+greaterThanAndStartWith);
    }

    public void testNegate(){
        Predicate<String> lengthTest = x->x.length()>8;

        boolean isGreaterThan = lengthTest.negate().test("dupang");

        System.out.println("是否正确==========="+isGreaterThan);
    }

    public void testOr(){
        Predicate<String> lengthTest = x->x.length()>3;

        Predicate<String> startWith = x->x.startsWith("d");


        boolean greaterThanAndStartWith = lengthTest.or(startWith).test("dupang");

        System.out.println("是否正确==========="+greaterThanAndStartWith);
    }

    public void testIsEqual(){
        Predicate<String> equalPredicate = Predicate.isEqual("dupang");
        boolean isEqual = equalPredicate.test("dupang");
        System.out.println("是否相等========"+isEqual);
    }



}
