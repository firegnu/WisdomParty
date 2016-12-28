package wuxc.wisdomparty.Internet;

import com.umeng.socialize.PlatformConfig;

import android.app.Application;

public class DemoApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		try {
			PlatformConfig.setWeixin("wx3a083b3b3abba07e", "4792e2f57f67bac037064c2c048034a2");
			// 微信 appid appsecret
			PlatformConfig.setSinaWeibo("3249415355", "db6647f411647e2de659ed669b00d3c6");
			// 新浪微博 appkey appsecret
			PlatformConfig.setQQZone("1105288473", "i3yO3XVvxQXDKDNz");
			super.onCreate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}