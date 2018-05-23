package com.feivirus.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
	public static void  main(String[] args) {
			String content = "[核保流程]交强险重复投保,已经被占单,商业险投保单号:AHAZ382CTP18F014211U 投保单状态:核保通过 投保单系统来源代码:统一接入平台" +
						"经办人姓名:戚佳烽 经办人部门:上虞支公司 出单员姓名:戚佳烽 出单员部门:上虞支公司 保单起保日期：2018-05-23 00 保单终保日期：20" +
						"19-05-23 00\u003cbr\u003e商业险：[核保流程]商业险重复投保,已经被占单,交强险投保单号:AHAZ382Y1418F016237N 投保单状态:核保通过" + 
						"投保单系统来源代码:统一接入平台 经办人姓名:戚佳烽 经办人部门:上虞支公司 出单员姓名:戚佳烽 出单员部门:上虞支公司 保单起保日期";
			Pattern pattern = Pattern.compile("(.*)(交强险投保单号:|商业险投保单号:)(.*)(投保单状态)(.*)(交强险投保单号:|商业险投保单号:)(.*)(投保单状态)(.*)");
			Matcher matcher = pattern.matcher(content);
			
			if (matcher.find()) {
				for(int i = 0; i < matcher.groupCount(); i++) {
					String matchedMsg = matcher.group(i);
					
					System.out.println("匹配中的消息 " + i + ": " + matchedMsg);
				}
				
			} else {
				System.out.println("No match");
			}
			
	}
}
