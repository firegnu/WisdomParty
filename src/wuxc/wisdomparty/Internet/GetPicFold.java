package wuxc.wisdomparty.Internet;

public class GetPicFold {
	public static String getfold(String temp2) {
		// TODO Auto-generated method stub
		String[] pic = temp2.split("/");
		String result = "";
		for (int i = 0; i < pic.length - 1; i++) {
			result = result + pic[i] + "/";
		}

		return result;
	}
}
