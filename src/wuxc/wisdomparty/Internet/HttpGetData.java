package wuxc.wisdomparty.Internet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class HttpGetData {
	private static final String ERROR_CODE = "0204";

	public static String GetData(final String Url, final ArrayList ArrayValues) {

		InputStream is = null;
		String jsonString = null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(URLcontainer.urlip + Url);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(ArrayValues, "UTF-8"));
			HttpResponse httpResponse;
			httpResponse = httpClient.execute(httpPost);
			is = httpResponse.getEntity().getContent();
			jsonString = Util.convertStreamToString(is);
			Log.e("HttpGetData", "url=" + Url + "\nresult=" + jsonString);
			return jsonString;

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Message msg = new Message();
		// msg.what = 1;
		// uiHandler.sendMessage(msg);
		return ERROR_CODE;
	}

}
