
# Java 数据结构
## Java Dictionary 类

Dictionary 类是一个抽象类，用来存储键/值对，作用和Map类相似。
给出键和值，你就可以将值存储在Dictionary对象中。一旦该值被存储，就可以通过它的键来获取它。所以和Map一样， Dictionary 也可以作为一个键/值对列表。
Dictionary定义的抽象方法如下表所示

| 序号  | 方法描述  | 
| ------ | ------ |
|1|Enumeration elements( )  返回此 dictionary 中值的枚举。|
|2|Object get(Object key)  返回此 dictionary 中该键所映射到的值。|
|3|boolean isEmpty( ) 测试此 dictionary 是否不存在从键到值的映射。|
|4|Enumeration keys( ) 返回此 dictionary 中的键的枚举。|
|5|Object put(Object key, Object value) 将指定 key 映射到此 dictionary 中指定 value。|
|6|Object remove(Object key) 从此 dictionary 中移除 key （及其相应的 value）。|
|7|int size( ) 返回此 dictionary 中条目（不同键）的数量。|

Dictionary类已经过时了。在实际开发中，你可以实现Map接口来获取键/值的存储功能。



源地址：[Java Dictionary 类](https://www.runoob.com/java/java-dictionary-class.html)
github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)