package wuxc.wisdomparty.Internet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;

public class savePNG {
	public static File savePNG_After(Bitmap bitmap, String name, String HeadimgAbsolutePath) {
		HeadimgAbsolutePath = GetPicFold.getfold(HeadimgAbsolutePath);
		File file = new File(HeadimgAbsolutePath + "image_headimg.jpg");
		try {
			FileOutputStream out = new FileOutputStream(file);
			if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)) {
				out.flush();
				out.close();
				return file;
			} else {
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
