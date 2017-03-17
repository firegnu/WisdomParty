package wuxc.wisdomparty.Internet;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import android.util.Log;

public class UpLoadFile {
	private static final String CHARSET = "utf-8"; // 设置编码

	public static String uploadHeadImage(File file, String RequestURL, String userId, String ticket) {
		String result = null;
		int res = 0;
		RequestURL = RequestURL + "?userId=" + userId + "&scaleSmall=1&scaleWidth=60&scaleHeight=60&ticket=" + ticket;
		String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
		String PREFIX = "--", LINE_END = "\r\n";
		String CONTENT_TYPE = "multipart/form-data"; // 内容类型

		try {
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// conn.setReadTimeout(readTimeOut);
			// conn.setConnectTimeout(connectTimeout);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET); // 设置编码
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
			if (file != null) {
				DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				sb.append(
						"Content-Disposition: form-data; name=\"fup\"; filename=\"" + file.getName() + "\"" + LINE_END);
				sb.append("Content-Type: image/pjpeg; charset=" + CHARSET + LINE_END);
				sb.append(LINE_END);
				dos.write(sb.toString().getBytes());
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					dos.write(bytes, 0, len);
				}
				is.close();
				dos.write(LINE_END.getBytes());
				byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
				dos.write(end_data);
				dos.flush();
				res = conn.getResponseCode();
				if (res == 200) {
					InputStream input = conn.getInputStream();
					StringBuffer sb1 = new StringBuffer();
					int ss;

					while ((ss = input.read()) != -1) {
						sb1.append((char) ss);
					}
					result = sb1.toString();

				} else {
				}
			} else {
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.e("ImageUpLoadResult", "result=" + result);
		return result;
	}

	public static String uploadFile(File file, String RequestURL, String classify, String ticket) {
		String result = null;
		int res = 0;
		Log.e("uploadfile", "result=" + 15);
		RequestURL = RequestURL + "?classify=" + classify + "&ticket=" + ticket;
		Log.e("uploadfile", "result=" + 16);
		String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
		Log.e("uploadfile", "result=" + 17);
		String PREFIX = "--", LINE_END = "\r\n";
		Log.e("uploadfile", "result=" + 18);
		String CONTENT_TYPE = "application/x-www-form-urlencoded"; // 内容类型
		Log.e("uploadfile", "result=" + 1);
		try {
			URL url = new URL(RequestURL);
			Log.e("uploadfile", "result=" + 2);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// conn.setReadTimeout(readTimeOut);
			// conn.setConnectTimeout(connectTimeout);
			Log.e("uploadfile", "result=" + 3);
			conn.setDoInput(true); // 允许输入流
			Log.e("uploadfile", "result=" + 4);
			conn.setDoOutput(true); // 允许输出流
			Log.e("uploadfile", "result=" + 5);
			conn.setUseCaches(false); // 不允许使用缓存
			Log.e("uploadfile", "result=" + 6);
			conn.setRequestMethod("POST"); // 请求方式
			Log.e("uploadfile", "result=" + 7);
			conn.setRequestProperty("Charset", CHARSET); // 设置编码
			Log.e("uploadfile", "result=" + 8);
			conn.setRequestProperty("connection", "keep-alive");
			Log.e("uploadfile", "result=" + 9);
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
			Log.e("uploadfile", "result=" + 10);
			if (file != null) {
				Log.e("uploadfile", "result=" + 11);
				DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
				Log.e("uploadfile", "result=" + 12);
				StringBuffer sb = new StringBuffer();
				Log.e("uploadfile", "result=" + 13);
				sb.append(PREFIX);
				Log.e("uploadfile", "result=" + 14);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				sb.append(
						"Content-Disposition: form-data; name=\"fup\"; filename=\"" + file.getName() + "\"" + LINE_END);
				sb.append("Content-Type: application/x-www-form-urlencoded; charset=" + CHARSET + LINE_END);
				sb.append(LINE_END);
				dos.write(sb.toString().getBytes());
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					dos.write(bytes, 0, len);
				}
				is.close();
				dos.write(LINE_END.getBytes());
				byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
				dos.write(end_data);
				dos.flush();
				res = conn.getResponseCode();
				Log.e("uploadfile", "result=" + res);
				if (res == 200) {
					InputStream input = conn.getInputStream();
					StringBuffer sb1 = new StringBuffer();
					int ss;

					while ((ss = input.read()) != -1) {
						sb1.append((char) ss);
					}
					result = sb1.toString();

				} else {
				}
			} else {
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.e("uploadfile", "result=" + result);
		return result;
	}
}
