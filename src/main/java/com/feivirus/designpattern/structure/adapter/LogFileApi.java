package com.feivirus.designpattern.structure.adapter;

import java.util.List;

public interface LogFileApi {
	public List<Log> readLogFile();
	
	public void writeLogFile(List<Log> logFileList);
}
