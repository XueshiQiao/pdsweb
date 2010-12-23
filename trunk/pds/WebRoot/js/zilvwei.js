
//返回当前日期
function getDatailDate(){	
	 dayObj=new Date(); 
	 monthStr=dayObj.getMonth()+1;
	 var week = "星期";
	 if(dayObj.getDay()==1)
	 {
		week+="一";
	 }
	 if(dayObj.getDay()==2)
	 {
		week+="二";
	 }
	 if(dayObj.getDay()==3)
	 {
		week+="三";
	 }
	 if(dayObj.getDay()==4)
	 {
		week+="四";
	 }
	 if(dayObj.getDay()==5)
	 {
		week+="五";
	 }
	 if(dayObj.getDay()==6)
	 {
		week+="六";
	 }
	 if(dayObj.getDay()==0)
	 {
		week+="日";
	 } 
	 return "今天是"+dayObj.getFullYear()+"年"+monthStr+"月"+dayObj.getDate()+"日"+"  "+week;

}