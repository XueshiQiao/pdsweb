	var url = "listArticles?artPageNo=";
	
	//注：须在后面定义url
	
	//转向某一页
	function turnToPageByPageNo(pageNo){
		if(pageNo == false){
		}else{
			alert(url+pageNo);
			window.location=url+pageNo; 
		}
	}
	//转向第一页
	function turnToFirstPage(){
		if(getCurrentPageNo() != 1){
			turnToPageByPageNo(1);
		}
	}
	//跳到前一页
	function turnToPrePage(){
		var currentPageNo = getCurrentPageNo();
		if(currentPageNo == "undefined" || currentPageNo <= 1 || isNaN(currentPageNo)){
			return false;
		}else{
			turnToPageByPageNo(currentPageNo-1);
		}
	}
	//跳到下一页
	function turnToNextPage(){
		var currentPageNo = getCurrentPageNo();
		var pageCount = getPageCount();
		if(currentPageNo == "undefined" || pageCount == "undefined" || isNaN(currentPageNo) || currentPageNo >= pageCount){
			return false;
		}else{
			turnToPageByPageNo(currentPageNo+1);
		}
	}
	//转到最后一页
	function turnToLastPage(){
		if(getCurrentPageNo() != getPageCount()){
			turnToPageByPageNo(getPageCount());
		}
	}
	
	//得到当前页码
	function getCurrentPageNo(){
		return parseInt($("#currentPageNo").text()); 
	}
	//得到总页数
	function getPageCount(){
		return parseInt($("#pageCount").text());
	}

		//转向用户输入的那一页
		function turnToPage(){
			var pageNo = getInputPageNo();
			
			if(!pageNo){
				return false;
			}else{
				window.location=url+pageNo; 
			}
		}
	
	//得到用户输入的要转向的页数
	function getInputPageNo(){
		var value = $("#pageNo").val();
		if(value == "" || value == "undefined" || isNaN(value) || value < 0 ){
			return false;
		} else{
			return value;
		}
	}