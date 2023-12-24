package model.service;

import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws Exception {
		UserManager m = UserManager.getInstance();
		int result = m.delete("user9");
		
		System.out.println("result" + result);
	}
}
