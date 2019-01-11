package com.biz.oracle.exec;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSessionFactory;

import com.biz.oracle.service.ScoreService;
import com.biz.oracle.service.StdService;
import com.biz.oracle.vo.ScoreSumVO;
import com.biz.oracle.vo.StdVO;

public class OrExec05 {
	static Scanner scan;
	static StdService st;
	static ScoreService ss;
	static SqlSessionFactory sqlSessionFactory;
	static ScoreSumVO vo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		scan = new Scanner(System.in);
		st = new StdService();
		ss = new ScoreService();
		vo = new ScoreSumVO();
		
		
		while(true) {
		int ret = infoView();
		if(ret == 0) {
			System.out.println("종료합니다.");
			break;
		}
		if(ret == 1) {
			System.out.println("학번을 다시 입력하세요.");
		}
		if(ret == 2) {
			System.out.println("학생 정보를 보여줍니다.");
		}
		if(ret == 8) {
		
			//ss.insert(vo);
			System.out.println("점수를 입력받았습니다.");
		}
		if(ret == 9) {
			System.out.println("종료합니다...");
		}
		}
	}
	
	private static int infoView() {
		System.out.println("====================");
		System.out.println("학번을 입력하세요(0: 종료)");
		System.out.print("입력 >>");
		String st_num = scan.nextLine();
		if(st_num.equals("0")) {
			return 0;
		};
		
		StdVO stVO = st.stdView(st_num);
		
		System.out.println("====================");
		System.out.println("학생 정보 ");
		System.out.println("--------------------");
		if(stVO != null) {
			System.out.println(stVO);
			System.out.println("============================");
			System.out.println("학번을 입력하세요 >> ");
			String stNum = scan.nextLine();
			
			System.out.println("점수를 입력하세요(001)>>");
			String stScore1 = scan.nextLine();
			
			System.out.println("점수를 입력하세요(002)>>");
			String stScore2 = scan.nextLine();
			
			System.out.println("점수를 입력하세요(003)>>");
			String stScore3 = scan.nextLine();
			
			System.out.println("점수를 입력하세요(004)>>");
			String stScore4 = scan.nextLine();
			
			System.out.println("점수를 입력하세요(005)>>");
			String stScore5 = scan.nextLine();
			
			ss.insert(vo);
			return 8;
			
			//ScoreDao dao = ses
			
			
			//ScoreSumVO vo = new ScoreSumVO();
			
			//ScoreSQL.SC_INSERT;
			
		}else {
			System.out.println("학생정보없음 !!!");
			
		}
		return 9;
		
			
		
		
	}


	
}
