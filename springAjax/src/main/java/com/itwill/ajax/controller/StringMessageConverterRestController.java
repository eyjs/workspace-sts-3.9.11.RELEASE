package com.itwill.ajax.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ajax.News;

@RestController
public class StringMessageConverterRestController {
	
	@RequestMapping(value = "02.ajaxRequest")
	public String ajaxRequest(@RequestParam(value ="id",
											required = true,
											defaultValue = "" ) String id) {
		String msg="";
		if(id.startsWith("guard")){
			msg="Y";
		}else{
			msg="N";
		}
		return msg;
	}
	@RequestMapping(value = "03.ajaxRequestGETPOST")
	public String ajaxRequestGETPOST(@RequestParam(value ="id",
											required = true,
											defaultValue = "" ) String id) {
		String msg="";
		if(id.startsWith("guard")){
			msg="Y";
		}else{
			msg="N";
		}
		return msg;
	}
	@RequestMapping(value = "04.server_clock",
					produces = "text/plain;charset=UTF-8")
	public String server_clock() {
		return new Date().toLocaleString();
	}
	@RequestMapping(value = "05.newsTitlesCSV",
					produces = "text/plain;charset=UTF-8")
	public String newsTitlesCSV() {
		List<News> newsList=this.getNewsList();
		/*
			3#title1,company1,date1|title2,company2,date2|title3,company3,date3
			2#title1,company1,date1|title2,company2,date2
			0#
		*/
		StringBuffer sb=new StringBuffer();
		sb.append(newsList.size()+"#");
		
		for(int i=0;i<newsList.size();i++){
			News tempNews=newsList.get(i);
			sb.append(tempNews.getTitle()+","+tempNews.getCompany()+","+tempNews.getDate());
			if(i!=(newsList.size()-1)){	
				sb.append("|");
			}
		}
		return sb.toString();
	}
	
	
	
	
	private List<News> getNewsList(){
	  
		List<News> newsList=new ArrayList<News>();
		newsList.add(new News("참으로 수고 많으셨습니다...","연합뉴스",new Date().toLocaleString()));
		newsList.add(new News("IS 60개국 테러 위협 영상 공개…한국도 포함 포토","SBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("통일부 남북 당국회담 실무접촉서 입장차","KBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("내년도 수도권 집값·전세값↑…2∼3년후 조정","TBC뉴스",new Date().toLocaleString()));
		newsList.add(new News("국토부 폴크스바겐 경유차 연비 3단계로 조사","OMY뉴스",new Date().toLocaleString()));
		newsList.add(new News("日롯데 신격호 소송 이해하는가 건강문제 제기","조선뉴스",new Date().toLocaleString()));
		newsList.add(new News("국가유공자 부인 위장 재혼시 유족자격 있다","YTN뉴스",new Date().toLocaleString()));
		newsList.add(new News("청소년에 한달 100건 성매매 강요 조폭 징역 6년","CBS뉴스",new Date().toLocaleString()));
		newsList.add(new News("한국인들 실직·이직 공포에 시달린다","ITWILL뉴스",new Date().toLocaleString()));
		return newsList;
	}
	
}










