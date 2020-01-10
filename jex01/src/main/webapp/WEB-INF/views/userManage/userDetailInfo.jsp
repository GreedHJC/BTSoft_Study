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
	<title>Insert title here</title>
    <!-- SBGrid -->
    <link href="/resources/js/SBGrid25/css/SBGrid.css" rel="stylesheet">
    <link href="/resources/js/SBGrid25/css/SBGrid_Default.css" rel="stylesheet">
    
	<script src="/resources/js/SBGrid25/SBGrid_Lib.js" type="text/javascript"></script>
	<script src="/resources/js/SBGrid25/SBGrid_min.js" type="text/javascript"></script>
	<script src="/resources/js/SBGrid25/SBUtil.js" type="text/javascript"></script>
    
    <%@ include file="/WEB-INF/views/common.jsp" %>
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
        <h3><i class="fa fa-angle-right"></i> 사용자 정보 관리</h3>
        <div class="row">
          <div class="col-lg-12">
          	<div class="form-panel">
              <form class="form-horizontal style-form" method="get">
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">사번</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" value="${userData.OFFICENUM}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">아이디</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" value="${userData.USERID}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">비밀번호</label>
                  <div class="col-sm-10">
                    <button class="btn btn-danger">비밀번호 초기화</button>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">이름</label>
                  <div class="col-sm-10">
                    <p class="form-control-static">${userData.USERNAME}</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">생년월일</label>
                  <div class="col-sm-10">
                    <p class="form-control-static">${userData.USERBIRTH}</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">전화번호</label>
                  <div class="col-sm-10">
                    <p class="form-control-static">${userData.USERHP}</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">주소</label>
                  <div class="col-sm-10">
                    <p class="form-control-static">${userData.USERADDR}</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 col-sm-2 control-label">내선번호</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" value="${userData.OFFICETEL}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">직책</label>
                  <div class="col-sm-10">
                    <select class="form-control">
	                  <option <c:if test="${userData.GRADE == '1'}">selected</c:if>>1</option>
	                  <option <c:if test="${userData.GRADE == '2'}">selected</c:if>>2</option>
	                  <option <c:if test="${userData.GRADE == '3'}">selected</c:if>>3</option>
	                  <option <c:if test="${userData.GRADE == '4'}">selected</c:if>>4</option>
	                  <option <c:if test="${userData.GRADE == '5'}">selected</c:if>>5</option>
	                </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">소속</label>
                  <div class="col-sm-10">
                    <select class="form-control">
	                  <option <c:if test="${userData.DEPART == '1'}">selected</c:if>>1</option>
	                  <option <c:if test="${userData.DEPART == '2'}">selected</c:if>>2</option>
	                  <option <c:if test="${userData.DEPART == '3'}">selected</c:if>>3</option>
	                  <option <c:if test="${userData.DEPART == '4'}">selected</c:if>>4</option>
	                  <option <c:if test="${userData.DEPART == '5'}">selected</c:if>>5</option>
	                </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">입사일</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" value="${userData.JOINDAY}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">퇴사일</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" value="${userData.OUTDAY}">
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    
    <!-- FOOTER MENU -->
    <%@ include file="/WEB-INF/views/footer.jsp" %>
    <!-- FOOTER MENU END -->

	<script type="text/javascript">
		var datagrid;
	    var SBGridProperties = [];
	    var grid_data;
	
	    $(document).ready(function(){
	    	$.ajax({
	    	    url: "selectAllUser", // 클라이언트가 요청을 보낼 서버의 URL 주소
	    	    type: "POST",                             // HTTP 요청 방식(GET, POST)
	    	    dataType: "json",                         // 서버에서 보내줄 데이터의 타입
	    	    success:function(data) {
	    	    	console.log(data);
	    	    	grid_data = data;
	    	    	
	    	    	for(var i in grid_data){
	    	    		grid_data[i]["JOINDAY"] = convertDateFormat(grid_data[i]["JOINDAY"]);
	    	    		grid_data[i]["OUTDAY"] = convertDateFormat(grid_data[i]["OUTDAY"]);
	    	    	}
	    	    	
	    	    	createGrid();
	    	    }
	    	});
	    });
	     
	    //그리드 선언
	    function createGrid(){
	        SBGridProperties.parentid = 'userGridArea';
	        SBGridProperties.id = 'datagrid';
	        SBGridProperties.jsonref = 'grid_data';
	        SBGridProperties.columns = [
	        	{caption : [''],    ref : 'check',      width : '30px',    	style : 'text-align:center',    type : 'checkbox'},
	        	{caption:['사번'],	ref:'OFFICENUM',	width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['아이디'],	ref:'USERID',		width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['이름'],	ref:'USERNAME',		width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['소속'],	ref:'DEPART',		width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['직책'],	ref:'GRADE',		width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['전화번호'],	ref:'USERHP',		width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['내선번호'],	ref:'OFFICETEL',	width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['입사일'],	ref:'JOINDAY',		width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['퇴사일'],	ref:'OUTDAY',		width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['상태'],	ref:'TEST',			width:'100px',		style:'text-align:center',		type:'output'},
	        	{caption:['비고'],	ref:'TEST',			width:'100px',		style:'text-align:center',		type:'output'}
	        ];
	        datagrid = _SBGrid.create(SBGridProperties);
	        datagrid.bind("dblclick","rowDblClick");
	    };
	    
	    function rowDblClick(){
	    	//상세 피이지 이동
	    	//alert("event");
	    }
	</script>
</body>
</html>