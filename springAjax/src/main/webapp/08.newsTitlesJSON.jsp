<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.ajax.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public List<News> getNewsList(){
	    
		List<News> newsList=new ArrayList<News>();
		newsList.add(new News("참으로 수고 많으셨습니다…","연합뉴스",new Date().toLocaleString()));
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
%>

<%
	List<News> newsList=getNewsList();
	StringBuffer sb=new StringBuffer();
	sb.append("{\"count\":");
	sb.append(newsList.size());
	sb.append(",\"data\": [");
	for(int i=0;i<newsList.size();i++){
		News tempNews=newsList.get(i);
		sb.append("{\"newsTitle\":\""
				+tempNews.getTitle()+"\",\"company\":\""
				+tempNews.getCompany()+"\",\"date\":\""
				+tempNews.getDate()+"\"}");
		if(i!=(newsList.size()-1)){
			sb.append(",");
		}
	}
	sb.append("]}");
%>
<%=sb.toString()%>

<%
/*
{"count":9,
	"data": [
				{"newsTitle":"참으로 수고 많으셨습니다1","company":"한거레","date":"2015-11-30"},
				{"newsTitle":"참으로 수고 많으셨습니다2","company":"두거레","date":"2015-11-29"}
			]
}
*/
%>





