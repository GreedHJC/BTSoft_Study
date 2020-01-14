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
<title>휴가 정보 확인</title>
	<!-- SBGrid v2.5 라이브러리("SBGrid"폴더)의 경로 -->
    <script type="text/javascript">
        var SBpath = "/resources/js/";      
    </script> 
    <!-- SBGrid v2.5에서 사용하는 SBGrid.css, SBGrid_Default.css 파일 링크 -->
    <link href="/resources/js/SBGrid25/css/SBGrid.css" rel="stylesheet" type="text/css">
    <link href="/resources/js/SBGrid25/css/SBGrid_Default.css" rel="stylesheet" type="text/css">
 
    <!-- SBGrid v2.5를 사용하기 위한 SBGrid_Lib.js, SBGrid_min.js ( ※반드시 등록 전에 SBPath를 먼저 설정해야 합니다. ) -->
    <script src="/resources/js/SBGrid25/SBGrid_Lib.js" type="text/javascript"></script>
    <script src="/resources/js/SBGrid25/SBGrid_min.js" type="text/javascript"></script>
    
    <!-- Bootstrap core CSS -->
    <link href="/resources/js/dist/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link href="/resources/js/dist/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/resources/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/resources/js/dist/gritter/css/jquery.gritter.css" />
    <!-- Custom styles for this template -->
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/style-responsive.css" rel="stylesheet">
    <script src="/resources/js/dist/jquery/jquery.min.js"></script>
    <script type="text/javascript">
	    var datagrid;
	    var grid_data = {};
	    $(document).ready(function(){
	        createGrid();
	    });
	    
	    function createGrid(){
	    	grid_data.result = JSON.parse('${resultMap}');
	    	var SBGridProperties = setSBGridPropertiesCDC();
	        SBGridProperties.parentid = 'SBGridArea';
	        SBGridProperties.id = 'datagrid';
	        SBGridProperties.jsonref = grid_data.result;
	        SBGridProperties.columns = [
	            {caption : ['사번'],               ref : 'OFFICENUM',        width : '20%',    style : 'text-align:center',    type : 'output'},
	            {caption : ['신청일'],          ref : 'BREAKDAY',      width : '20%',   style : 'text-align:center',    type : 'output'},
	            {caption : ['사유'],    ref : 'BREAKREASON',         width : '20%',   style : 'text-align:center',    type : 'output'},
	            {caption : ['승인여부'],        ref : 'APPROVALXO',        width : '10%',   style : 'text-align:center',    type : 'output'},
	            {caption : ['비고'],        ref : 'RETURNREASON',         width : '30%',   style : 'text-align:center',    type : 'output'}
	        ];
	        datagrid = _SBGrid.create(SBGridProperties);
	    };
	    
	    function setSBGridPropertiesCDC(){
	    	var SBGridProperties = {};
	    	SBGridProperties.height					= '300px';
	    	SBGridProperties.rowheight				= '30';
	    	SBGridProperties.emptyrecords 			= '조회내역없음';							//그리드내 데이터가 없을 때의 문구를 설정합니다.
	    	SBGridProperties.emptyrecordsfontstyle	= "font-weight:bold; color:#0066CC;";	//그리드내 데이터가 없을 때의 문구에 대한 스타일을 설정합니다.
	    	SBGridProperties.extendlastcol			= 'scroll';								//그리드의 여백이 보이지 않도록 우측 마지막 열의 너비 확장 여부를 설정합니다. 디폴트 값은 'none' 이며, 'scroll'일 시에는 width 가 px로 설정되어 있어야 합니다. - 'none' : 우측 마지막 열의 너비가 확장되지 않습니다,  'scroll' : 우측 마지막 열의 너비가 확장됩니다  
	    	SBGridProperties.ellipsis				= true;									//그리드에 말줄임 기능의 사용여부를 설정합니다. 디폴트 설정은 true 이며, 설정 해제의 필요성이 있을때 사용합니다.
	    	SBGridProperties.allowselection 		= false;								//그리드내 데이터에 다중 선택에 대한 여부를 설정합니다. 디폴트 설정은 true 이며, 설정 해제의 필요성이 있을때 사용합니다. 
	    	return SBGridProperties;
	    };
	    
	    function moveApply(){
	    	location.href="/breakApply";
	    }
    </script>
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
        <h3><i class="fa fa-angle-right"></i> 휴가 정보 확인</h3>
        <div class="row mt">
          <div class="col-lg-12">
          	휴가 현황<br>
          	생성 <%-- ${resultMap.TOTALDAYS} --%>일   사용 <%-- ${resultMap.COUNT} --%>일   잔여 <%--  ${resultMap.TOTALDAYS - resultMap.COUNT} --%>일
            <div id="SBGridArea" style="width:100%; height:300px;"></div>
            <div align="right"><br><input type="button" value="휴가신청" onclick="moveApply()"/></div>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    
    <!-- FOOTER MENU -->
    <%@ include file="/WEB-INF/views/footer.jsp" %>
    <!-- FOOTER MENU END -->
    
    <!-- js placed at the end of the document so the pages load faster -->
	
	
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