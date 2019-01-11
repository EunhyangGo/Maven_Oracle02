package com.biz.oracle.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Getter // getter만
//@Setter // setter만
//@ToString // tostring만
//@Builder  // 생성자만
//@data 이 모든걸 다 ~


// 맴버변수 초기화 생성자를 만들고
// 기본 생성자는 감춰버린다.
// @Builder
@AllArgsConstructor // 맴버변수 생성자
@NoArgsConstructor // 기본 super 생성자

public class StdVO {

	 private String st_num; 
     private String st_name ;
     private String st_grade ;
     private String st_tel ;
     
     
}