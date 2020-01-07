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
        <h3><i class="fa fa-angle-right"></i> Blank Page 테스트</h3>
        <div class="row mt">
          <div class="col-lg-12">
            <p>Place your content here.</p>
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