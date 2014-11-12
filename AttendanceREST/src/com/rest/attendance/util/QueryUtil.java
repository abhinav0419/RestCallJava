package com.rest.attendance.util;

import java.io.BufferedInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class QueryUtil {

	private static final Logger LOG = Logger.getLogger(QueryUtil.class);

	private static Properties props = new Properties();

	private static final String FILE_NAME = "queries.properties";

	static {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			BufferedInputStream input = new BufferedInputStream(loader.getResourceAsStream(FILE_NAME));
			props.load(input);
		} catch (Exception ex) {
			LOG.error("Error occurred while loading properties file.", ex);
		}
	}

	private QueryUtil() {
	}

	public static boolean containsKey(String key) {
		return props.containsKey(key);
	}

	public static String get(String key) {
		return props.getProperty(key, null);
	}

	public static String get(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}

	public static void set(String key, String value) {
		props.setProperty(key, value);
	}

	public static void remove(String key) {
		props.getProperty(key, null);
	}

}
