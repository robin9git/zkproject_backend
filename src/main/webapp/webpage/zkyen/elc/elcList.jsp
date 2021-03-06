<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="fList" title="文件下载" actionUrl="zkyenelcController.do?datagrid" idField="id" fit="true" sortName="creatDate" sortOrder="desc">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="栏目" field="menu" dictionary="zkyMenu"></t:dgCol>
	<t:dgCol title="年份" field="year" query="true" sortable="fasle" width="5"></t:dgCol>
	<t:dgCol title="标题1" field="title1" query="true" sortable="fasle" width="8"></t:dgCol>
	<t:dgCol title="标题2" field="title2" sortable="fasle" width="8"></t:dgCol>
	<t:dgCol title="图片" field="picSrc" sortable="fasle" width="8"></t:dgCol>
	<t:dgCol title="附件" field="fileSrc" sortable="fasle" width="8"></t:dgCol>
	<t:dgCol title="描述" field="des" sortable="fasle" width="15"></t:dgCol>
	<t:dgCol title="创建时间" field="creatDate" formatter="yyyy-MM-dd hh:mm:ss" sortable="true" width="8"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
<%-- 	<t:dgDefOpt url="commonController.do?viewFile&fileid={id}&subclassname={subclassname}" title="下载"></t:dgDefOpt> --%>
<%-- 	<t:dgOpenOpt width="800" height="700" url="elcController.do?openViewFile&fileid={id}&subclassname={subclassname}" title="预览"></t:dgOpenOpt> --%>
	<t:dgDelOpt url="zkyenelcController.do?del&id={id}" title="删除"></t:dgDelOpt>
	<t:dgToolBar title="附件录入" icon="icon-add" funname="add" url="zkyenelcController.do?addFiles" height="600"></t:dgToolBar>
	<t:dgToolBar title="附件编辑" icon="icon-add" funname="update" url="zkyenelcController.do?addFiles" height="600"></t:dgToolBar>
</t:datagrid>