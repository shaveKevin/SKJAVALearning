
# Java 数据结构
## Java Map 接口

Map接口中键和值一一映射. 可以通过键来获取值。

* 给定一个键和一个值，你可以将该值存储在一个Map对象. 之后，你可以通过键来访问对应的值。
* 当访问的值不存在的时候，方法就会抛出一个NoSuchElementException异常.
* 当对象的类型和Map里元素类型不兼容的时候，就会抛出一个 ClassCastException异常。
* 当在不允许使用Null对象的Map中使用Null对象，会抛出一个NullPointerException 异常。
* 当尝修改一个只读的Map时，会抛出一个UnsupportedOperationException异常。


| 序号  | 方法描述  | 
| ------ | ------ |
|1|void clear()  从此映射中移除所有映射关系（可选操作）。|
|2|boolean containsKey(Object k) 如果此映射包含指定键的映射关系，则返回 true。|
|3|boolean containsValue(Object v) 如果此映射将一个或多个键映射到指定值，则返回 true。|
|4|Set entrySet( )  返回此映射中包含的映射关系的 Set 视图。|
|5|boolean equals(Object obj)比较指定的对象与此映射是否相等。|
|6|Object get(Object k) 返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。|
|7|int hashCode( )返回此映射的哈希码值。|
|8|boolean isEmpty( ) 如果此映射未包含键-值映射关系，则返回 true。|
|9|Set keySet( ) 返回此映射中包含的键的 Set 视图。|
|10|Object put(Object k, Object v)  将指定的值与此映射中的指定键关联（可选操作）。|
|11|void putAll(Map m) 从指定映射中将所有映射关系复制到此映射中（可选操作）。|
|12|Object remove(Object k) 如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。|
|13|int size( ) 返回此映射中的键-值映射关系数。|
|14|Collection values( )返回此映射中包含的值的 Collection 视图。|


## 实例
```
import java.util.*;
public class CollectionsDemo {
	public static void main(String[] args) {
		Map m1 = new HashMap();
		m1.put("张三", "8");
		m1.put("李四", "31");
		m1.put("王二", "12");
		m1.put("麻子", "14");
		System.out.println();
		System.out.println(" Map Elements");
		System.out.print("\t" + m1);
	}
}
```
编译后的结果为：
```
 Map Elements
	{李四=31, 张三=8, 麻子=14, 王二=12}
```

源地址：[Java Map 接口](https://www.runoob.com/java/java-map-interface.html)
github地址：[Java学习](https://github.com/shaveKevin/SKJAVALearning)