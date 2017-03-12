package wuxc.wisdomparty.Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {

	public final static String LINE_SEPARATOR = System
			.getProperty("line.separator");

	

	public static String convertStreamToString(InputStream is) {

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				is));
		final StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + LINE_SEPARATOR);
			}
		} catch (IOException e) {
		} finally {
			try {
				is.close();
			} catch (IOException e) {
                  e.printStackTrace();
			}
		}
		return sb.toString();
	}
		
	}
	
	

