package com.biz.oracle.exec;

import java.util.List;
import java.util.Scanner;

import com.biz.oracle.service.ScoreService;
import com.biz.oracle.vo.ScoreVO;

public class OrExec03 {

	public static void main(String[] args) {
		
	
		// scoreservice객체를 생성, 키보드에서 학번을 입력받아
		// socreservice로부터 점수 리스트를 가져온 후 console에 표시
		ScoreService ss = new ScoreService();
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("학번을 입력하세요 >>");
		System.out.print("입력 >>");
		String st_num = scan.nextLine();
		List<ScoreVO> scList = ss.viewScore(st_num);
		for(ScoreVO vo : scList) {
			System.out.println(vo);
		}

	}
	
		
}
