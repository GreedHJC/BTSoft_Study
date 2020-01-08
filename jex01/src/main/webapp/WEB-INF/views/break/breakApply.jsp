<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>휴가 신청</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/js/dist/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link href="/resources/js/dist/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/resources/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/resources/js/dist/gritter/css/jquery.gritter.css" />
    <!-- Custom styles for this template -->
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/style-responsive.css" rel="stylesheet">
</head>
<body>
	<!-- TOP MENU -->
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<!-- TOP MENU END -->
	
	<!-- LEFT MENU -->
	<%@ include file="/WEB-INF/views/left.jsp" %>
	<!-- LEFT MENU END -->
	
	<section id="main-content">
      <section class="wrapper site-min-height">
        <h3><i class="fa fa-angle-right"></i> 휴가 신청</h3>
        <div class="row mt">
          <div class="col-lg-12">
        	<table>
        		<tr>
        			<td colspan="3">
        				휴가 현황
        			</td>
        		</tr>
        		<tr align="center">
        			<td width="33%">생성 ${resultMap.TOTALDAYS}일</td>
        			<td width="33%">사용 ${resultMap.COUNT}일</td>
        			<td width="33%">잔여 ${resultMap.TOTALDAYS - resultMap.COUNT}일</td>
        		</tr>
        		<tr>
        			<td width="33%">사번</td>
        			<td colspan="2">${resultMap.OFFICENUM}</td>
        		</tr>
        		<tr>
        			<td width="33%">이름</td>
        			<td>${resultMap.USERNAME}</td>
        		</tr>
        		<tr>
        			<td width="33%">신청일</td>
        			<td colspan="2"><input id="breakDay" name="breakDay" type="date"/></td>
        		</tr>
        		<tr>
        			<td width="33%">휴가구분</td>
        			<td colspan="2">
        				<select id="breakOption" name="breakOption">
	          				<option label="연차" value="1?"/>
	          				<option label="병가" value="2?"/>
	          				<option label="기타" value="3?"/>
          				</select>
        			</td>
        		</tr>
        		<tr>
        			<td width="33%">사유</td>
        			<td colspan="2">
        				<select id="breakReson" name="breakReson">
		          			<option label="개인사유" value="1"/>
		          			<option label="기타" value="2"/>
		          			<option label="???" value="3"/>
		          		</select>
	          		</td>
	          	</tr>
        	</table>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    
    <!-- FOOTER MENU -->
    <%@ include file="/WEB-INF/views/footer.jsp" %>
    <!-- FOOTER MENU END -->
    
    <!-- js placed at the end of the document so the pages load faster -->
	<script src="/resources/js/dist/jquery/jquery.min.js"></script>
	
	<script src="/resources/js/dist/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="/resources/js/dist/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/resources/js/dist/jquery.scrollTo.min.js"></script>
	<script src="/resources/js/dist/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="/resources/js/dist/jquery.sparkline.js"></script>
	<!--common script for all pages-->
	<script src="/resources/js/dist/common-scripts.js"></script>
	<script type="text/javascript" src="/resources/js/dist/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="/resources/js/dist/gritter-conf.js"></script>
	<!--script for this page-->
	<script src="/resources/js/dist/sparkline-chart.js"></script>
	<script src="/resources/js/dist/zabuto_calendar.js"></script>
</body>
</html>