package com.dupang;

import junit.framework.TestCase;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * <p>ClassName:com.dupang.FunctionTest</p>
 * <p>描述：function test</p>
 * <p>日期：2017/3/5
 *
 * @version 3.3.0
 * @auther duguanxin
 * @since 1.10
 */
public class FunctionTest extends TestCase {

    public void testApply(){

        Function<String,String> upperFunction = x->x.toUpperCase();

        String upperString = upperFunction.apply("dupang");
        System.out.println("转换为大写========"+upperString);



    }

    public void testCompose(){
        //大写功能的function
        Function<String,String> upperFunction = x->x.toUpperCase();
        //截取功能的function
        Function<String,String> subStrFunction = x->x.substring(0,2);
        //两个功能组合后的function
        Function<String,String> composedFunction = upperFunction.compose(subStrFunction);


        String upperString = upperFunction.apply("dupang");
        System.out.println("转换为大写========"+upperString);

        String subString = subStrFunction.apply("dupang");
        System.out.println("截取后的字符串========"+subString);

        //组合function应用后的结果
        String composedStr = composedFunction.apply("dupang");

        System.out.println("组合后的结果==========="+composedStr);

    }

    public void testAndThen(){
        //大写功能的function
        Function<String,String> upperFunction = x->x.toUpperCase();
        //截取功能的function
        Function<String,String> subStrFunction = x->x.substring(0,2);

        Function<String,String> andThenFunction = upperFunction.andThen(subStrFunction);

        String andThenStr = andThenFunction.apply("dupang");

        System.out.println("andThen 后的结果======="+andThenStr);
    }

    public void testAnotherAndThen(){
        //加1功能的function
        Function<Integer,Integer> addFunction = x->x+1;
        //乘2功能的function
        Function<Integer,Integer> multiplyFunction = x->x*2;
        // 加1乘2的function
        Function<Integer,Integer> andThenFunction = addFunction.andThen(multiplyFunction);
        Function<Integer,Integer> andThenFunction2 = multiplyFunction.andThen(addFunction);

        Integer addAndMultiplyResult = andThenFunction.apply(1);
        Integer multiplyAndAddResult = andThenFunction2.apply(1);

        System.out.println("先加后乘 后的结果======="+addAndMultiplyResult);
        System.out.println("先乘后加 后的结果======="+multiplyAndAddResult);
    }

    public void testIdentity(){
        Function<String,String> identityFunction = Function.identity();

        String identity = identityFunction.apply("dupang");

        System.out.println("identity==========="+identity);
    }

}
