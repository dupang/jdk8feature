package com.dupang;

import junit.framework.TestCase;

import java.util.function.Consumer;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;

/**
 * <p>ClassName:com.dupang.ConsumerTest</p>
 * <p>描述：consumer test</p>
 * <p>日期：2017/3/5
 *
 * @version 3.3.0
 * @auther duguanxin
 * @since 1.10
 */
public class ConsumerTest extends TestCase{

    public void testAccept(){
        Consumer<String> consumer = x->x.length();

        consumer.accept("dupang");
    }
}
