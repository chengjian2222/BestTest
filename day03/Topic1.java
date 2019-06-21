package day03.homework;

import java.util.Collection;

/**
 * 作业1: 阅读ArrayList源码
 *
 * 能阅读多少就阅读多少,将你的心得,你的思路写下来.
 *
 * @author 成建
 */
public class Topic1 {
/**
 * 总结:
 * 一、构造方式有三种:
 * a.ArrayList()无参构造. 数组初始化size为0
 * b.ArrayList(int initialCapacity) .通过大小来构造同时初始化数组容量
 * c.ArrayList(Collection<? extends E> c).把其他集合类型的数据装换为Array，并判断Array的size
 * 如果size为0，则设为一个空数组，不为0则Arrays.copyOf去构造。
 * 二、其他
 * 1.没有容量限制，
 * 2.添加元素可能需要扩容,add(E e)
 * 3.删除元素的时候，删除的位置置为null (elementData[--size] = null)，数组的容量不会减少
 * 4.清空数组的，同样是把所有的元素都设为null,数组容量不变
 * 5.查找元素有get(index),indexOf(O),相比来说,get的效率更高，直接通过索引定位原生，indexOf需要遍历数组
 * 6.待补充...
 * 
 * */
}
