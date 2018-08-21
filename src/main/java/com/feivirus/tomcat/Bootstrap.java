package com.feivirus.tomcat;

import com.feivirus.tomcat.base.HttpConnector;

public class Bootstrap {
	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		connector.start();
	}
}
