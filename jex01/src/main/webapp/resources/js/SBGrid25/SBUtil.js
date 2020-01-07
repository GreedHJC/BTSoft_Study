var datagrid = null; // SBGrid 전역변수 초기화

function setSBGridPropertiesCDC(){
	var SBGridProperties = {};
	SBGridProperties.parentid				= 'SBGridArea';
	SBGridProperties.id						= 'datagrid';
	SBGridProperties.jsonref				= 'eval1.resultList';
	SBGridProperties.height					= '400px';
	SBGridProperties.rowheight				= '30';
	SBGridProperties.emptyrecords 			= '조회내역없음';						//그리드내 데이터가 없을 때의 문구를 설정합니다.
	SBGridProperties.emptyrecordsfontstyle	= "font-weight:bold; color:#0066CC;";	//그리드내 데이터가 없을 때의 문구에 대한 스타일을 설정합니다.
	SBGridProperties.extendlastcol			= 'scroll';								//그리드의 여백이 보이지 않도록 우측 마지막 열의 너비 확장 여부를 설정합니다. 디폴트 값은 'none' 이며, 'scroll'일 시에는 width 가 px로 설정되어 있어야 합니다. - 'none' : 우측 마지막 열의 너비가 확장되지 않습니다,  'scroll' : 우측 마지막 열의 너비가 확장됩니다  
	SBGridProperties.ellipsis				= true;									//그리드에 말줄임 기능의 사용여부를 설정합니다. 디폴트 설정은 true 이며, 설정 해제의 필요성이 있을때 사용합니다.
	SBGridProperties.allowselection 		= false;								//그리드내 데이터에 다중 선택에 대한 여부를 설정합니다. 디폴트 설정은 true 이며, 설정 해제의 필요성이 있을때 사용합니다. 
	return SBGridProperties;
}
function hscrollAreaReSizeCDC(objGrid){
	var strId = objGrid.attr("id");
	var targetGridDiv = document.getElementById("SBHE_"+strId);
	var rowheight = objGrid.attr("rowheight");
	var ctnRows = objGrid.getRows();
	var exCm = 3;
	
	if (ctnRows > 1){
		if (rowheight != 30){
			if (rowheight < 30){
				exCm = 30 - rowheight + 3;	
			}else{
				exCm = (rowheight - 30) * - 1 + 3;
			}
		}
		targetGridDiv.style.height = rowheight * ctnRows + exCm + "px";	
	}
	
	objGrid = null;
}

// skFramework 페이지없는 callBack
function pageCallbackNoPageCDC(requestValue, mode) {
    try {
    	var responseValue = requestValue.responseXML.documentElement;
  	    var jsonText = responseValue.getAttribute("jsonList");
        eval1 = JSON.parse(jsonText);

        __createElements();
    } catch(e) {
    	alert("데이터를 불러오는 중 오류가 발생하였습니다.\n다시 시도 하시기 바랍니다.");
    }
}

//skFramework 페이지있는 callBack
function pageCallbackCDC(requestValue, mode) {
	try {
    	var responseValue = requestValue.responseXML.documentElement;
  	    var jsonText = responseValue.getAttribute("jsonList");
        eval1 = JSON.parse(jsonText);
        var naviMap = eval1.naviMap;
        pagingRander(naviMap);
		
        if(document.getElementById("cnt"))	{
        	document.getElementById("cnt").innerHTML = responseValue.getAttribute("cnt");
        }
        
        __createElements();
    } catch(e) {
    	alert("데이터를 불러오는 중 오류가 발생하였습니다.\n다시 시도 하시기 바랍니다.");
    }
}

//skFramework 페이지있는 callBack
function pagingRanderCDC(naviMap){
	var endPage =  parseInt(naviMap.endPage),		//종료 페이지
	nextStartTab = parseInt(naviMap.nextStartTab), // 다음
	pageNo = parseInt(naviMap.pageNo), // 현재 페이지
	totalPage = parseInt(naviMap.totalPage),		//전체 페이지
	startPage = parseInt(naviMap.startPage),		//시작 페이지
	totalPage = parseInt(naviMap.totalPage),
	prevStartTab = parseInt(naviMap.prevStartTab);
	
	var pagingDiv = "";
	
	if (totalPage != 0 && totalPage != 1) {
		pagingDiv +="\n<div class='page'>\n";
		
		if (startPage > 1) { 
			pagingDiv += "<a class=\"page_btn first\" href=\"#\"  onclick=\"f_search(1)\";></a>&#160;";
			pagingDiv += "<a class=\"page_btn prev\" href=\"#\"  onclick=\"f_search("+prevStartTab+")\";></a>&#160;";
		}
		for (var i = startPage; i <= endPage; i++) {
			if (i == pageNo) {
				pagingDiv += "<a href=\"#\" onclick=\"f_search("+i+")\";><b>"+ i +"</b></a>";
				
			} else {
				pagingDiv += "<a href=\"#\" onclick=\"f_search("+i+")\";>"+ i +"</a>";
			}
		}
		if (endPage < totalPage) {
			pagingDiv += "<a class=\"page_btn next\" href=\"#\" onclick=\"f_search('"+  nextStartTab +"')\";></a>&#160;";
			pagingDiv += "<a class=\"page_btn end\" href=\"#\"  onclick=\"f_search('"+ totalPage +"')\"></a>&#160;";
		}
		pagingDiv += "</div>\n";
	} else {
		pagingDiv += "&nbsp;";
	}
	
	$('#sbGridPaging').html(pagingDiv);
}

//skFramework 페이지있는 callBack
function egovPagingRanderCDC(naviMap){
	var endPage =  parseInt(naviMap.lastPageNoOnPageList),		//종료 페이지
	nextStartTab = parseInt(naviMap.lastPageNoOnPageList+1), // 다음
	pageNo = parseInt(naviMap.currentPageNo), // 현재 페이지
	startPage = parseInt(naviMap.firstPageNoOnPageList),		//시작 페이지
	totalPage = parseInt(naviMap.totalPageCount),
	prevStartTab = parseInt(naviMap.firstPageNoOnPageList-1);
	
	var pagingDiv = "";
	
	console.log(naviMap);
	
	if (totalPage != 0 && totalPage != 1) {
		pagingDiv +="\n<div class='page'>\n";
		
		if (startPage > 1) { 
			pagingDiv += "<a class=\"page_btn first\" href=\"#\"  onclick=\"f_search(1)\";></a>&#160;";
			pagingDiv += "<a class=\"page_btn prev\" href=\"#\"  onclick=\"f_search("+prevStartTab+")\";></a>&#160;";
		}
		for (var i = startPage; i <= endPage; i++) {
			if (i == pageNo) {
				pagingDiv += "<a href=\"#\" onclick=\"f_search("+i+")\";><b>"+ i +"</b></a>";
				
			} else {
				pagingDiv += "<a href=\"#\" onclick=\"f_search("+i+")\";>"+ i +"</a>";
			}
		}
		if (endPage < totalPage) {
			pagingDiv += "<a class=\"page_btn next\" href=\"#\" onclick=\"f_search('"+  nextStartTab +"')\";></a>&#160;";
			pagingDiv += "<a class=\"page_btn end\" href=\"#\"  onclick=\"f_search('"+ totalPage +"')\"></a>&#160;";
		}
		pagingDiv += "</div>\n";
	} else {
		pagingDiv += "&nbsp;";
	}
	console.log(pagingDiv);
	$('#sbGridPaging').html(pagingDiv);
}