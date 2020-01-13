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
          <div class="col-lg-12 mt">
          	<div class="form-inline">
	          	<input type="text" id="keyword" placeholder="검색" class="form-control"/>
	          	<button type="button" class="btn btn-primary" onclick="userDataSelect(2);">검색</button>
	            <button type="button" class="btn btn-default" onclick="">등록</button>
	            <button type="button" class="btn btn-default" onclick="">수정</button>
	            <button type="button" class="btn btn-default" onclick="">승인</button>
          	</div>
          </div>
          <div class="col-lg-12 mt">
            <div id="userGridArea" style="width:100%;height:500px;"></div>
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
	    	userDataSelect(1);
	    });
	    
	    function userDataSelect(type){
	    	var keyword = $("#keyword").val();
	    	
	    	$.ajax({
	    	    url: "selectUsersInfo", // 클라이언트가 요청을 보낼 서버의 URL 주소
	    	    type: "POST",                             // HTTP 요청 방식(GET, POST)
	    	    dataType: "json",                         // 서버에서 보내줄 데이터의 타입
	    	    data:{"keyword":keyword},
	    	    success:function(data) {
	    	    	console.log(data);
	    	    	grid_data = data;
	    	    	
	    	    	for(var i in grid_data){
	    	    		grid_data[i]["JOINDAY"] = convertDateFormat(grid_data[i]["JOINDAY"]);
	    	    		grid_data[i]["OUTDAY"] = convertDateFormat(grid_data[i]["OUTDAY"]);
	    	    	}
	    	    	
	    	    	if(type == 1){
		    	    	createGrid();
	    	    	}else{
	    	    		datagrid.refresh();
	    	    	}
	    	    	
	    	    }
	    	});
	    }
	     
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
	    	var rowIndex = datagrid.getSelectedRows();
	    	var rowData = datagrid.getRowData(rowIndex[0]);
	    	var rowData_json = JSON.stringify(rowData);
	        var form = document.createElement("form");

	        form.setAttribute("charset", "UTF-8");
	        form.setAttribute("method", "Post");  //Post 방식
	        form.setAttribute("action", "/userDetailInfo"); //요청 보낼 주소

	         var hiddenField = document.createElement("input");
	         hiddenField.setAttribute("type", "hidden");
	         hiddenField.setAttribute("name", "userData");
	         hiddenField.setAttribute("value", rowData_json);

	         form.appendChild(hiddenField);

	         document.body.appendChild(form);

	         form.submit();
	    	//location.href="userDetailInfo?userId="+rowData.USERID;
	    }
	</script>
</body>
</html>