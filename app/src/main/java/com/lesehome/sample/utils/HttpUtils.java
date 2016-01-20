package com.lesehome.sample.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
	private static final int READ_TIMEOUT = 5000;
	private static final int CONNECT_TIMEOUT = 5000;

	public static String executeGet(String urlString) throws Exception {
		InputStream inputStream = executeGetInputStream(urlString);
		ByteArrayOutputStream outputStream = null;
		try {
			outputStream = new ByteArrayOutputStream(1024);
			int readLength = 0;
			byte[] buffer = new byte[4 * 1024];
			while ((readLength = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, readLength);
			}
			String json = outputStream.toString("utf-8");
			return json;
		} finally {
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	public static InputStream executeGetInputStream(String urlString) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 指的是与请求网址的服务器建立连接的超时时间。
		connection.setConnectTimeout(CONNECT_TIMEOUT);
		// 指的是建立连接后如果指定时间内服务器没有返回数据的后超时。
		connection.setReadTimeout(READ_TIMEOUT);
		connection.setRequestMethod("GET");
		int code = connection.getResponseCode();
		if (code >= 200 && code <= 299)// 连接成功,返回结果
		{
			return connection.getInputStream();
		} else {
			String info = "executeGet network error urlString:" + urlString + " code:" + code;
			throw new Exception(info);
		}
	}
}
