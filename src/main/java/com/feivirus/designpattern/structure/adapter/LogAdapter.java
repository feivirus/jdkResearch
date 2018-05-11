package com.feivirus.designpattern.structure.adapter;

import java.util.List;

public class LogAdapter  implements LogDBApi{
	private LogFileApi logFileAdaptee;
	
	public LogAdapter(LogFileApi logFileApi) {
		this.logFileAdaptee = logFileApi;
	}

	public void createLog(Log dbLog) {
		System.out.println("以db形式存储一条日志");
		List<Log> logFileList = logFileAdaptee.readLogFile();
		
		logFileList.add(dbLog);
		logFileAdaptee.writeLogFile(logFileList);
	}
	
}
