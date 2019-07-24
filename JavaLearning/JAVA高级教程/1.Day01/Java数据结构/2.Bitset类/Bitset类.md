
# Java 数据结构
## Java Bitset类

一个Bitset类创建一种特殊类型的数组来保存位值。BitSet中数组大小会随需要增加。这和位向量（vector of bits）比较类似。
这是一个传统的类，但它在Java 2中被完全重新设计。
BitSet定义了两个构造方法。
第一个构造方法创建一个默认的对象：

```
BitSet()
```
第二个方法允许用户指定初始大小。所有位初始化为0。
```
BitSet(int size)
```
BitSet中实现了Cloneable接口中定义的方法如下表所列：

| 序号  | 方法描述  | 
| ------ | ------ |
|1|void and(BitSet set) 对此目标位 set 和参数位 set 执行逻辑与操作。|
|2|void andNot(BitSet set) 清除此 BitSet 中所有的位，其相应的位在指定的 BitSet 中已设置。|
|3|int cardinality( ) 返回此 BitSet 中设置为 true 的位数。|
|4|void clear( ) 将此 BitSet 中的所有位设置为 false。|
|5|void clear(int index) 将索引指定处的位设置为 false。|
|6|void clear(int startIndex, int endIndex)将指定的 startIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 false。|
|7|Object clone( )复制此 BitSet，生成一个与之相等的新 BitSet。|
|8|boolean equals(Object bitSet)将此对象与指定的对象进行比较。|




源地址：[Java Bitset类](https://www.runoob.com/java/java-bitset-class.html)
github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)

