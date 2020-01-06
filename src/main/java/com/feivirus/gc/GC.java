package com.feivirus.gc;

/**
 * @author feivirus
 * 看默认垃圾收集器
 *  java -XX:+PrintCommandLineFlags -version
 *  默认是 -XX:+UseParallelGC
 *  指标:延迟，吞吐量,系统容量
 *  @link http://cmsblogs.com/?p=3786
 *  关注:1.分配速率,上次GC之后到此次GC之前的heap增加值除以时间.逻辑关系:增加Eden空间，
 *  会减少minor gc次数，减少了线程停顿时间,提高了分配率,但会影响major gc 的时间次数.
 *  2.过早提升,单位时间内从年轻代提升到年老代的数量.老年代填充越快，major gc越频繁.
 *  3.弱引用,比如缓存中的key.软引用，虚引用.
 */
public class GC {
}
