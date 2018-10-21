package com.feivirus.hotspot;
/***
 *
 *一.hotspot调试helloworld，
 *二.openjdk(类二分模型，类加载，堆栈结构，解释器的模板表与转发表，编译器，函数分发指令集),
 *三.性能监控分析，
 *四.集合(红黑树),
 *五.垃圾回收算法,
 *六.多线程,同步与可见性,内存模型(重排序).
 *七.IO/NIO/AIO,reactor/proactor
 * 
 * @author feivirus
 * 参考:
 * http://www.bubuko.com/infodetail-2488828.html
 */
public class Hotspot {
/***
 * OpenJDK目录结构
 * 一.hotspot
 * agent(Serviceability Agent可维护性代理),make(编译hotspot的makefile文件),
 * src(核心源码),test(测试用例)
 * src目录下:
 * cpu(依赖具体处理器架构的代码，实现汇编器、模板解释器、ad文件和部分runtime函数),
 * os(依赖操作系统的代码),
 * os_cpu(同时依赖操作系统和处理器类型的代码),share(核心业务)
 * share目录下:
 * vm(虚拟机功能),tools(虚拟机工具)
 * vm目录下:
 * 1.Adlc:平台描述文件(cpu或os_cpu目录中的*.ad文件)的编译器
 * 2.asm:汇编器
 * 3.c1 Client编译器
 * 4.ci 动态编译器的公共服务(从动态编译器到VM的接口)
 * 5.classfile 处理类文件(包括类加载和系统符号表等)
 * 6.code 管理动态生成的代码
 * 7.compiler 从VM调用动态编译器的接口
 * 8.gc_implementation GC实现
 * 9.gc_interface GC接口
 * 10.interpreter 解释器,包括模板解释器(官方版使用)和C++解释器(官方版未用)
 * 11.libadt:抽象数据结构
 * 12.memory 内存管理相关实现(老的分代式 GC 框架也位于此处)
 * 13.oops HotSpot VM的对象系统的实现
 * 14.opto Server编译器(即C2)
 * 15.prims HotSpot VM的对外接口,包括部分标准库的native部分实现和JVMTI实现
 * 16.rumtime 运行时支持库(包括线程管理、编译器调度、锁、反射等)
 * 17.services 用于支持JMX之类的管理功能的接口
 * 18.shark 基于LLVM的JIT编译器(官方版未用)
 * 19.utilities 一些基本工具类
 * 二.jdk
 * 核心在src\share目录下
 * 1.classes,native分别是java和c++实现，和java包相对应
 * 2.sample,demo一些示例程序，如nio
 * 3.back、instrument、javavm、npt、transport等目录包含了实现Java的基础部分的C++源码，
 * 在这里可以从最底层理解Java
 * 三.corba
 * 多语言、分布式通讯接口，类似微软的com技术
 * 四.langtools
 * javac,javap等程序源码
 */
}
