<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>방가워요 JSP</TITLE>
</HEAD>
<BODY>
	<center>
		<H2>JSP 잘났어 정말 별꼴이야!!!!!!!!!</H2>
		
			<img src='tomcat.gif' />
			<center>
				<H2>JSP구구단</H2>
			</center>
			<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600
				cellspacing=0>
				<%
					for(int i=0;i<9;i++){ 
				%>
				<tr>
					<%
						for(int j=0;j<8;j++){
					%>
						<td align=center>
								<%
									out.print((j+2)+"*"+(i+1)+"="+(j+2)*(i+1));
								%>
						</td>
					<%
						}
					%>
				</tr>
				<%
					} 
				%>
			</table>
			<br/>
			<hr>
			<p> expression </p>
			<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600
				cellspacing=0>
				<%
					for(int i=0;i<9;i++){ 
				%>
				<tr>
					<%
						for(int j=0;j<8;j++){
					%>
						<td align=center>
								<%=(j+2)+"*"+(i+1)+"="+(j+2)*(i+1)%>
						</td>
					<%
						}
					%>
				</tr>
				<%
					} 
				%>
			</table>
	</center>	
	<%@ include file="5-6.directive_included_file.jspf" %>	
</BODY>
</HTML>
