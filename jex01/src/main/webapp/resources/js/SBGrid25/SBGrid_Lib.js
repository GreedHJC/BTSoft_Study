this.strSBGridPATH = "/resources/js/SBGrid25/";


/*try{
	if (SBpath)
		this.strSBGridPATH = SBpath + 'SBGrid/';
}
catch(e){
	this.strSBGridPATH = './';
}*/
this.strScript = '';
this.strScript +=

/* third-party */
'<script src="' + this.strSBGridPATH + 'js/lib/' 		+ 'json2.js' 											+ '" type="text/javascript"></script>' +
'<script src="' + this.strSBGridPATH + 'js/lib/' 		+ 'underscore-min.js'									+ '" type="text/javascript"></script>' +
'<script src="' + this.strSBGridPATH + 'js/lib/' 		+ 'jquery-1.11.3.min.js' 								+ '" type="text/javascript"></script>' +

/* data-structure */
'<script src="' + this.strSBGridPATH + 'js/lib/ds/' 	+ 'hashtable.js' 										+ '" type="text/javascript"></script>' +
'<script src="' + this.strSBGridPATH + 'js/lib/ds/' 	+ 'hashset.js'											+ '" type="text/javascript"></script>' +
'<script src="' + this.strSBGridPATH + 'js/lib/ds/' 	+ 'SBQueue.js' 											+ '" type="text/javascript"></script>' +
'<script src="' + this.strSBGridPATH + 'js/lib/ds/' 	+ 'SBStack.js' 											+ '" type="text/javascript"></script>' +

/* async module */
'<script src="' + this.strSBGridPATH + 'js/lib/' 		+ 'vkthread.js' 										+ '" type="text/javascript"></script>' +

/* common */
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'poshytip-1.2/tip-darkgray/tip-darkgray.css' 			+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'poshytip-1.2/tip-green/tip-green.css' 				+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'poshytip-1.2/tip-skyblue/tip-skyblue.css' 			+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'poshytip-1.2/tip-twitter/tip-twitter.css' 			+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'poshytip-1.2/tip-violet/tip-violet.css'				+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'poshytip-1.2/tip-yellow/tip-yellow.css'				+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'poshytip-1.2/tip-yellowsimple/tip-yellowsimple.css'	+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'jquery-ui.css'										+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'jquery.scrollbar.css'								+ '" rel="stylesheet" type="text/css">' +
'<link href="'  + this.strSBGridPATH + 'css/plugins/' 	+ 'jquery.contextMenu.css'								+ '" rel="stylesheet" type="text/css">' +

'<script src="' + this.strSBGridPATH + 'js/lib/' 		+ 'deps.js'												+ '" type="text/javascript"></script>';
//'<script src="http://is.cdc.go.kr/ccbase/js/SBGrid25/js/lib/deps.js'												+ '" type="text/javascript"></script>';
document.write(this.strScript);
