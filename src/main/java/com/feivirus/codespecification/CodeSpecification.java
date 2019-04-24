package com.feivirus.codespecification;

/**
 * 
 * @author feivirus
 *
 *常用命名后缀
事件 event-handler,listener，actor,reactor,task,trigger,fire
请求/报文 request-context-connector-parse-processor-response
公共库/三方库 manager
流/网络/管道 input-output,filter,parser
对象封装 holder,container,keeper,wrapper,detector,creator,generator,inspector,
monitor,operator,sponsor,worker,reader,collector,editor,watcher,tracker
guard,executor,xx pool,xxx convertor util,helper,binder,xxx parser,channel,batch,
accumulator,interceptor,sender,receiver,request,response,client,server,selector,
callback,flush,serializer,metadata,xxx config,parseAndValidateAddress,main,bootstrap,
send,onSend,doSend,internalSend,onSendError,Info,Data,defaultXXX,assignor委托人,raise,fetcher,
dump xxx,practicer,xxxTran事务操作.
接口 impl,api
分层 entity,dao
设计模式 factory,chain,builder,abstract,facade,observer,adaptor,decorator,redirector,
command,successor,visitor,producer,instructor
 */
public class CodeSpecification {
	/***
	 * 代码细节
	 * 
	 * 1.类，变量，方法命名尽量简短，比如readAndCheckByRow()，考虑readRow().最好一两个单词，不超过三个单词
	 * 2.能用接口实现的不用类
	 * 3.能用引用的不用继承
	 * 4.函数参数多，超过三个用大对象DTO，包括controller里面和前端传递的查询参数
	 * 5.和前端传递参数能用Spring的@Validate校验的不写冗余代码校验
	 * 6.日志打印用{}，不用+
	 * 7.错误信息用枚举定义，不用普通字串打印
	 * 8.代码中不出现0,1,2等常量数值，统一用枚举定义
	 * 9.代码中不出现Integer.intValue() == 1，用.equals()
	 * 10.if else 的逻辑，if里面先写错误检验，错误逻辑尽早暴露
	 * 11.Controller的代码里面没有业务逻辑，，参数校验写到parseParam()方法里.
	 * 12.所有简单的配置逻辑常量，用ConfigServer，不写死在代码里.
	 * 13.涉及到list，map等Collection集合操作的，尽量用lambda,stream操作
	 * 14.工厂+策略是最常用设计模式的组合，能提出公用接口的，不写具体类.
	 * 15.表，或者列，已有相同业务定义的，不重复添加
	 * 16.能用mongo的尽量不用mysql存储json.
	 * 17.service的增、删、改一定要有事务
	 * 18.Mybatis的sql语句里面不用map，只用xxxDTO，map看不出来参数具体是什么
	 * 19.业务代码里面不包含main方法，统一写junit单元测试
	 * 20.接口和实现类的命名有两套规则,实现类和接口不一定, 也不建议要采用 Service -> ServiceImpl的对应方式, 
	 * 因为这样做会让设计的局限性很大, 可以参考一下Spring里面的命名方式
		BeanDefinition -> RootBeanDefinition
		BeanDefinition -> GenericBeanDefinition
		//这种命名就非常形象,容易理解
	 * 21.业务抛出异常抛出RuntimeException类的子类
	 * 22.mysql建表必备字段 d, add_time, creator, modify_time, modifier, deleted_id(或者sys_flag)
	 * 23.超过三个表禁止 join。需要 join 的字段，数据类型必须绝对一致;多表关联查询时， 保证被关联的字段需要有索引
	 * 24.mybatis所有的更新, 必须使用 MyBatis里面的 Mapper, updateXXXXSelective
	 * 25.比如导入结果ImportResult记录，用ImportResult还是用ImportResultDTO
	 * TODO
	 * 26.?变量或者类命名用AbstractConvertProcessor动词 + 名词形式，还是AbstractConvertorProcessor
	 * 	  名词 + 名词形式,待定
	 */
 
}
