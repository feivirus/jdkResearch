package com.feivirus.designpattern.behavior.chainofresponsibility.pattern2;

/**
 * 
 * @author feivirus
 *
 */
public class ProjectManager extends Handler{

	@Override
	public String handleRequest(String userName, double fee) {
		String result = "";
		
		if (fee < 500) {
			if ("feivirus".equals(userName)) {
				result = "项目经理同意" + userName + " 的费用";
			} else {
				result = "项目拒绝" + userName + " 的费用";
			}
		} else {
			if (getSuccessor() != null) {
				return getSuccessor().handleRequest(userName, fee);
			}
		}
		return result;
	}
}
