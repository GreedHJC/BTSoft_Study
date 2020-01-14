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
    <link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />

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
        			<td>시작일 <input id="startDate" name="startDate" type="text"/></td>
        			<td>종료일 <input id="endDate" name="endDate" type="text"/></td>
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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	
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
	<script type="text/javascript">
	jQuery.browser = {};
	(function () {
	    jQuery.browser.msie = false;
	    jQuery.browser.version = 0;
	    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
	        jQuery.browser.msie = true;
	        jQuery.browser.version = RegExp.$1;
	    }
	})();
	
	$.datepicker.setDefaults($.datepicker.regional['ko']); 
    $( "#startDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yymmdd",
         minDate: 0,
         maxDate: 4,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
         onClose: function( selectedDate ) {    
              //시작일(startDate) datepicker가 닫힐때
              //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
             $("#endDate").datepicker( "option", "minDate", selectedDate );
         }    

    });
    $( "#endDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yymmdd",
         maxDate: 40,                       // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
         onClose: function( selectedDate ) {    
             // 종료일(endDate) datepicker가 닫힐때
             // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
             $("#startDate").datepicker( "option", "maxDate", selectedDate );
         }    

    });    
	</script>
</body>
</html>