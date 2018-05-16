package com.feivirus.designpattern.behavior.chainofresponsibility.pattern2;

public class DeptManager extends Handler{

	@Override
	public String handleRequest(String userName, double fee) {
		String result = "";
		
		if (fee < 1000) {
			if ("feivirus".equals(userName)) {
				result = "部门经理同意" + userName + " 的费用";
			} else {
				result = "部门经理拒绝" + userName + " 的费用";
			}
		} else {
			if (getSuccessor() != null) {
				return getSuccessor().handleRequest(userName, fee);
			}
		}
		return result;
	}

}
