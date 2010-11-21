/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	config.language = 'zh-cn';         
	config.width = 1000;                   //初始化时的宽度
	config.skin='kama';                    //使用的皮肤
	config.tabSpaces = 4;               
	config.resize_maxWidth = 600;             //如果设置了编辑器可以拖拽 这是可以移动的最大宽度
	config.toolbarCanCollapse = false;              //工具栏可以隐藏
	//config.toolbarLocation = 'bottom';              //可选：设置工具栏在整个编辑器的底部bottom
	config.resize_minWidth = 600;                   //如果设置了编辑器可以拖拽 这是可以移动的最小宽度
	config.resize_enabled = false;                  //如果设置了编辑器可以拖拽
	config.protectedSource.push( /<\s*iframe[\s\S]*?>/gi ) ; // <iframe> tags.               //一下是后天验证非法数据
	config.protectedSource.push( /<\s*frameset[\s\S]*?>/gi ) ; // <frameset> tags.
	config.protectedSource.push( /<\s*frame[\s\S]*?>/gi ) ; // <frame> tags.
	config.protectedSource.push( /<\s*script[\s\S]*?\/script\s*>/gi ) ; // <SCRIPT> tags.
	config.protectedSource.push( /<%[\s\S]*?%>/g ) ; // ASP style server side code
	config.protectedSource.push( /<\?[\s\S]*?\?>/g ) ; // PHP style server side code
	config.protectedSource.push( /(<asp:[^\>]+>[\s|\S]*?<\/asp:[^\>]+>)|(<asp:[^\>]+\/>)/gi ) ;
	//config.startupFocus = true;
//	config.smiley_images = ['1.gif','2.gif','3.gif','4.gif','5.gif','6.gif','7.gif','8.gif','9.gif','10.gif','11.gif','12.gif','13.gif','14.gif','15.gif','16.gif',
//
//	'17.gif','18.gif','19.gif','20.gif','21.gif','22.gif','23.gif','24.gif','25.gif','26.gif','27.gif','28.gif','29.gif','30.gif',
//
//	'31.gif','32.gif','33.gif','34.gif','35.gif','36.gif','37.gif','38.gif','39.gif','40.gif','41.gif','42.gif','43.gif','44.gif',
//
//	'45.gif','46.gif',"47.gif",'48.gif','49.gif','50.gif','51.gif','52.gif','53.gif','54.gif','55.gif','56.gif','57.gif','58.gif',
//
//	'59.gif','60.gif','61.gif','62.gif','63.gif','64.gif','65.gif','66.gif','67.gif','68.gif','69.gif','70.gif','71.gif','72.gif'];

	//我设置的表情 对应要把表情文件夹的图像改过来

	//设置编辑器里字体下拉列表里的字体
	config.font_names= '宋体;黑体;楷体_GB2312;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana' ;

	// 设置工具栏里面的工具
	config.toolbar = [
	                  ['Source','-','Preview','-','Templates'],
	                  ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	                  ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	                  ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	                  ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	                  ['Link','Unlink','Anchor'],
	                  ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
	                  '/',
	                  ['Styles','Format','Font','FontSize'],
	              ['TextColor','BGColor']
	              ];
};
	
	//full_function:
//	[
//     ['Source','-','Save','NewPage','Preview','-','Templates'],
//     ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
//     ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
//     ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
//     '/',
//     ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
//     ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
//     ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
//     ['Link','Unlink','Anchor'],
//     ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
//     '/',
//     ['Styles','Format','Font','FontSize'],
// ['TextColor','BGColor']
// ];
