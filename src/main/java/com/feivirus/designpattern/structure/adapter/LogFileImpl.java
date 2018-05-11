package com.feivirus.designpattern.structure.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LogFileImpl implements LogFileApi{
	private String logFileFullPath = "file.log";
	
	public List<Log> readLogFile() {
		List<Log> logFileList = new ArrayList<Log>();
		
		System.out.println("读取日志文件");
		return logFileList;
	}

	public void writeLogFile(List<Log> logFileList) {
		File file = new File(logFileFullPath);
		
		System.out.println("写入文件日志列表");
		return;
	}	
}
