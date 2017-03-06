# Java 新特性之Lambda表达式
- Oracle甲骨文公司在2014年3月发布了Java 8正式版
http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
http://www.tuicool.com/articles/E3M7be


# lambda表达式
- lambda表达式 ：一种新的语言特性，能够把函数作为方法的参数或将代码作为数据。lambda表达式使你在表示函数接口（具有单个方法的接口）的实例更加紧凑。
例如strList.stream().filter(x->x.startsWith(“d”))
# Lambda 作用域
- 在lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。你可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。
- 和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象是一致的

# 函数式接口
- 每一个lambda表达式都对应一个类型，通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
# 几个比较重要的函数式接口
- Consumer 表示一个操作，这个操作接受一个入参，并且没有返回结果，不同于其它函数式接口，Consumer被用来产生副作用,
            它的函数方法是accept
- Function 此函数接受一个参数并产生一个结果,它的函数方法是apply
- Predicate 表示这个参数的断言(布尔值函数),它的函数方法是test
- Supplier 在每次调用这个supplier的方法时，它不要求返回一个新的或者不同的结果  

# 不是函数式接口的接口
- Stream
- java.util.Stream 表示能应用在一组元素上一次执行的操作序列。Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。 Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set， Map不支持。Stream的操作可以串行执行或者并行执行。

# 接口的默认方法
- Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法

# 传统Map新增的方法
- V getOrDefault(Object key, V defaultValue) 如果map中没有指定的key的值，则返回给定的默认值
- V computeIfPresent(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction) 如果map中有指定的key,则执行BiFunction
- V computeIfAbsent(K key,Function<? super K, ? extends V> mappingFunction) 如果map没中有指定的key,则执行Function
- boolean remove(Object key, Object value) 如果给定的key和value都匹配，则删除
- replace(K key, V value) 替换给定key的value
- void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) 全部替换
- V putIfAbsent(K key, V value) 如果key不存在，则插入数据
- forEach(BiConsumer<? super K, ? super V> action) 遍历map
- V merge(K key, V value,BiFunction<? super V, ? super V, ? extends V> remappingFunction) 如果指定的key的值不存在或为null,则新增，如果存在，则替换

# Optional
- Optional 不是函数式接口，这是个用来防止NullPointerException异常的辅助类型，这是下一届中将要用到的重要概念。
- Optional 被定义为一个简单的容器，其值可能是null或者不是null。在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，而在Java 8中，不推荐你返回null而是返回Optional

# Stream方法
