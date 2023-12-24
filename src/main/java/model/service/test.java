package model.service;

import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws Exception {
		UserManager userman = UserManager.getInstance();
		int result = userman.delete("user12");
		
		System.out.println(result);
	}
}
