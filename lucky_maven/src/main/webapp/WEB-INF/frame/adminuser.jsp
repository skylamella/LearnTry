<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/ui/locale/easyui-lang-zh_CN.js"></script>
<script>
//点击提交按钮触发该方法提交表单
function submitForm(){
// submit the form    
$('#ff').submit();  
}

		$(function(){
			//-------------------------------------------------------------------------
			$('#w').window('close'); //页面加载完成,确保窗口关闭
			//-------------------------------------------------------------------------
			$('#ff').form({    
			    url:'${pageContext.request.contextPath}/aj/getUserList',    
			    onSubmit: function(){    
			        // do some check    
			        // return false to prevent submit; 
			        return true;//让表单直接提交
			    },    
			    success:function(data){ //提交成功后调用的方法  
			    	$('#w').window('close');//提交成功关闭窗口
			    	$('#test').datagrid('reload'); //提交成功,重新加载列表数据   
			    	$('#ff').form('clear');//提交成功后,清空表单
			    }    
			});  
		
			
			//--------------------------------------------------------------------------
			$('#test').datagrid({
				title:'用户列表', //表格标题
				singleSelect:true, //只允许单选
				iconCls:'icon-tip',//表格标题图标
				nowrap: true,//某列数据较长时,是否需要换行
				striped: true,//是否隔行变色
				collapsible:false,//是否可以折叠表格
				url:'${pageContext.request.contextPath}/frame/getUserList.xhtml',//指定表格数据加载的路径
				sortName: 'user_id',//指定可以使用哪列进行排序
				sortOrder: 'asc',//指定默认排序规则 asc/desc
				remoteSort: false,//是否支持远程
				idField:'user_id', //那一列是id列
				frozenColumns:[[
	                {field:'ck',checkbox:true},
	                {title:'用户id',field:'user_id',width:80,sortable:true}
				]],
				columns:[[
					{field:'user_name',title:'员工姓名',width:120},
					{field:'user_email',title:'员工邮箱',width:220},
					{field:'user_chk_text',title:'是否锁定账号',width:220},
					{field:'user_admin_text',title:'是否拥有管理员权限',width:220}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{ //配置工具栏
					id:'btnadd',
					text:'添加员工',
					iconCls:'icon-add',
					handler:function(){
						$('#btnsave').linkbutton('enable');
						//打开前清空表单
						$('#ff').form('clear');
						//打开表单窗口
						$('#w').window('open');
					}
				},{
					id:'btncut',
					text:'修改员工',
					iconCls:'icon-cut',
					handler:function(){
						$('#btnsave').linkbutton('enable');
						//获得被选中的用户的id
						var user_id = getSelected();
						
						if(!user_id){
							alert("请选择用户!");
							return;
						}
						//根据id回显数据
						$('#ff').form('load','${pageContext.request.contextPath}/UserAction_toEdit?user_id='+user_id);
						//清空密码输入框
						
						//打开编辑窗口
						$('#w').window('open');
					
					}
				},'-',{
					id:'btnsave',
					text:'删除员工',
					disabled:false, //禁用属性
					iconCls:'icon-save',
					handler:function(){
						$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
						//获得被选中的用户id
						//获得被选中的用户的id
						var user_id = getSelected();
						//判断id不能为空
						if(!user_id){
							alert("请选择用户!");
							return;
						}
						//调用ajax异步发送请求删除用户
						$.get("${pageContext.request.contextPath}/UserAction_delete?user_id="+user_id, function(data){
								//删除成功后,刷新列表
							 $('#test').datagrid('reload'); //提交成功,重新加载列表数据   
							});
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh:function(){
					alert('before refresh');
				}
			});
		});
		function resize(){
			$('#test').datagrid('resize', {
				width:700,
				height:400
			});
		}
		//获得被选中的
		function getSelected(){
			var selected = $('#test').datagrid('getSelected');
			if (selected){
				return selected.user_id;
			}
		}
		function getSelections(){
			var ids = [];
			var rows = $('#test').datagrid('getSelections');
			for(var i=0;i<rows.length;i++){
				ids.push(rows[i].code);
			}
			alert(ids.join(':'));
		}
		function clearSelections(){
			$('#test').datagrid('clearSelections');
		}
		function selectRow(){
			$('#test').datagrid('selectRow',2);
		}
		function selectRecord(){
			$('#test').datagrid('selectRecord','002');
		}
		function unselectRow(){
			$('#test').datagrid('unselectRow',2);
		}
		function mergeCells(){
			$('#test').datagrid('mergeCells',{
				index:2,
				field:'addr',
				rowspan:2,
				colspan:2
			});
		}
		function query(){
			//重新加载数据
			$('#test').datagrid('reload');
		}
	</script>
</head>
<body>
<div class="easyui-panel">
<form id="searchForm">
     <table cellpadding="5">
     	<tr>
     		<td>员工邮箱：</td>
     		<td><input id="searchText" name="searchText" /></td>
     		<td><button type="button" id="btnSearch" onclick="query()">查询</button></td>
     	</tr>
     </table>
</form>
</div>
<table id="test"></table>

<div id="w" class="easyui-window" title="添加员工" iconCls="icon-save" 
	style="width: 300px;height: 220px" data-options="closed:true">
	<form id="ff" method="post" novalidate>
		  <table cellpadding="5">
		  	<tr>
		  		<td>员工姓名:</td>
		  		<td><input class="easyui-validatebox" type="text" name="user.user_name" required="true"></input></td>
		  	</tr>
		  	<tr>
		  		<td>员工邮箱:</td>
		  		<td><input class="easyui-validatebox" type="text" name="user.user_email" required="true"></input></td>
		  	</tr>
		  	<tr>
		  		<td>管理员权限:</td>
		  		<td><input class="easyui-validatebox" type="text" name="user.user_admin" required="true"></input></td>
		  	</tr>
		  	<tr>
		  		<td>初始密码:</td>
		  		<td><input class="easyui-validatebox" type="text" name="user.user_pwd" required="true"></input></td>
		  	</tr>
		  	<tr>
		  		<td colspan="2">
		  			<button id="customerBtn" style="margin-left: 45%;" type="button" onclick="submitForm()">保存</button>
		  		</td>
		  	</tr>
		  </table>
	</form>
</div>
</body>
</html>