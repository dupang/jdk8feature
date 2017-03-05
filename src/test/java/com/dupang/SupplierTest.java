package com.dupang;

import junit.framework.TestCase;

import java.util.function.Supplier;

/**
 * <p>ClassName:com.dupang.SupplierTest</p>
 * <p>描述：supplier test</p>
 * <p>日期：2017/3/5
 *
 * @version 3.3.0
 * @auther duguanxin
 * @since 1.10
 */
public class SupplierTest extends TestCase {

    public void testGet() {
        Supplier<String> supplier = () -> "dupang";

        String reStr = supplier.get();

        System.out.println("返回字符串============" + reStr);
    }

    public void testGet2() {
        Supplier<Double> supplier = () -> Math.random();

        Double reDouble = supplier.get();

        System.out.println("返回随机数============" + reDouble);
    }
}
