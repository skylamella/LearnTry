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
	function submitForm() {
		// submit the form   
		var updid = $('#updId').val();
		var upload = $("#upload").val();
		if (updid == null || updid == "") {
			if (upload == null || upload == "") {
				msgShow('系统提示', '请选择头像！', 'warning');
				return;
			}
		}
		$('#ff').submit();
	}

	function chk(fil) {
		var fileSize = fil[0].size;
		alert(fil[0].size);
		var size = fileSize / 1024;
		if (size > 2000) {
			return 0;
		}
		return 0;
	}
	$(function() {
		$("#upload").change(function() {
			var fil = this.files;
			if (fil.length != 1) {
				if (chk(fil) != 1) {
					msgShow('系统提示', '选择的图片超过2M，请重试！', 'warning');
					$("#upload").val("");
				}
			} else {
				msgShow('系统提示', '选择的图片数量超过上限，请选择一张图片！', 'warning');
				$("#upload").val("");
			}
		});
		//-------------------------------------------------------------------------
		$('#w').window('close'); //页面加载完成,确保窗口关闭
		//-------------------------------------------------------------------------
		$('#ff').form({
			url : '${pageContext.request.contextPath}/frame/userAdd.xhtml',
			onSubmit : function() {

				return true;//让表单直接提交
			},
			success : function(data) { //提交成功后调用的方法  
				$('#w').window('close');//提交成功关闭窗口
				$('#test').datagrid('reload'); //提交成功,重新加载列表数据   
				$('#ff').form('clear');//提交成功后,清空表单
			}
		});

		//--------------------------------------------------------------------------
		$('#test').datagrid({
			title : '用户列表', //表格标题
			singleSelect : true, //只允许单选
			iconCls : 'icon-tip',//表格标题图标
			nowrap : true,//某列数据较长时,是否需要换行
			striped : true,//是否隔行变色
			collapsible : false,//是否可以折叠表格
			url : '${pageContext.request.contextPath}/frame/getUserList.xhtml',//指定表格数据加载的路径
			sortName : 'user_id',//指定可以使用哪列进行排序
			sortOrder : 'asc',//指定默认排序规则 asc/desc
			remoteSort : false,//是否支持远程
			idField : 'user_id', //那一列是id列
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				title : '用户id',
				field : 'user_id',
				width : 80,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'user_name',
				title : '员工姓名',
				width : 120
			}, {
				field : 'user_email',
				title : '员工邮箱',
				width : 220
			}, {
				field : 'user_chk_text',
				title : '是否锁定账号',
				width : 220
			}, {
				field : 'user_admin_text',
				title : '是否拥有管理员权限',
				width : 220
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ { //配置工具栏
				id : 'btnadd',
				text : '添加员工',
				iconCls : 'icon-add',
				handler : function() {
					$('#btnsave').linkbutton('enable');
					//打开前清空表单
					$('#ff').form('clear');
					//打开表单窗口
					$('#w').window({
						title : '添加员工',
						iconCls : 'icon-add'
					});
					$('#w').window('open');
				}
			}, {
				id : 'btncut',
				text : '修改员工',
				iconCls : 'icon-cut',
				handler : function() {
					$('#btnsave').linkbutton('enable');
					//获得被选中的用户的id
					var user_id = getSelected();

					if (!user_id) {
						msgShow('系统提示', '请选择用户！', 'warning');
						return;
					}
					//根据id回显数据
					$('#ff').form('load', '${pageContext.request.contextPath}/frame/userSearch.xhtml?user.user_id=' + user_id);
					//清空密码输入框
					$('#ff').form('clear');
					//打开编辑窗口
					$('#w').window({
						title : '修改员工',
						iconCls : 'icon-cut'
					});
					$('#w').window('open');

				}
			}, '-', {
				id : 'btnsave',
				text : '锁定账号',
				disabled : false, //禁用属性
				iconCls : 'icon-cancel',
				handler : function() {
					$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
					//获得被选中的用户id
					//获得被选中的用户的id
					var user_id = getSelected();
					//判断id不能为空
					if (!user_id) {
						msgShow('系统提示', '请选择用户！', 'warning');
						return;
					}
					var chkText = getSelectedChk();
					if (chkText != "正常账号") {
						msgShow('系统提示', '该用户账号已经被锁定！', 'warning');
						return;
					}
					//调用ajax异步发送请求锁定用户
					$.get("${pageContext.request.contextPath}/frame/userDel.xhtml?user.user_id=" + user_id, function(data) {
						//锁定成功后,刷新列表
						if (data.code == "success") {
							msgShow('系统提示', '账号锁定成功！', 'warning');
							$('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						} else {
							msgShow('系统提示', '账号锁定失败，请重试！', 'warning');
						}
					});
				}
			}, {
				id : 'btnredel',
				text : '解锁账号',
				disabled : false, //禁用属性
				iconCls : 'icon-ok',
				handler : function() {
					$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
					//获得被选中的用户id
					//获得被选中的用户的id
					var user_id = getSelected();
					//判断id不能为空
					if (!user_id) {
						msgShow('系统提示', '请选择用户！', 'warning');
						return;
					}
					var chkText = getSelectedChk();
					if (chkText != "锁定（冻结）账号") {
						msgShow('系统提示', '该用户账号为正常账号！', 'warning');
						return;
					}
					//调用ajax异步发送请求解锁用户
					$.get("${pageContext.request.contextPath}/frame/userReDel.xhtml?user.user_id=" + user_id, function(data) {
						//解锁成功后,刷新列表
						if (data.code == "success") {
							msgShow('系统提示', '账号解锁成功！', 'warning');
							$('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						} else {
							msgShow('系统提示', '账号解锁失败，请重试！', 'warning');
						}
					});
				}
			} ]
		});
		var p = $('#test').datagrid('getPager');
		$(p).pagination({
			onBeforeRefresh : function() {
				alert('before refresh');
			}
		});
	});
	function resize() {
		$('#test').datagrid('resize', {
			width : 700,
			height : 400
		});
	}
	//获得被选中的
	function getSelected() {
		var selected = $('#test').datagrid('getSelected');
		if (selected) {
			return selected.user_id;
		}
	}
	function getSelectedChk() {
		var selected = $('#test').datagrid('getSelected');
		if (selected) {
			return selected.user_chk_text;
		}
	}
	function getSelections() {
		var ids = [];
		var rows = $('#test').datagrid('getSelections');
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].code);
		}
		alert(ids.join(':'));
	}
	function clearSelections() {
		$('#test').datagrid('clearSelections');
	}
	function selectRow() {
		$('#test').datagrid('selectRow', 2);
	}
	function selectRecord() {
		$('#test').datagrid('selectRecord', '002');
	}
	function unselectRow() {
		$('#test').datagrid('unselectRow', 2);
	}
	function mergeCells() {
		$('#test').datagrid('mergeCells', {
			index : 2,
			field : 'addr',
			rowspan : 2,
			colspan : 2
		});
	}
	function msgShow(title, msgString, msgType) {
		$.messager.alert(title, msgString, msgType);
	}
	function query() {
		var searchText = $('#searchText').val();
		$('#test').datagrid({
			title : '用户列表', //表格标题
			singleSelect : true, //只允许单选
			iconCls : 'icon-tip',//表格标题图标
			nowrap : true,//某列数据较长时,是否需要换行
			striped : true,//是否隔行变色
			collapsible : false,//是否可以折叠表格
			url : '${pageContext.request.contextPath}/frame/getUserList.xhtml?searchText=' + searchText,//指定表格数据加载的路径
			sortName : 'user_id',//指定可以使用哪列进行排序
			sortOrder : 'asc',//指定默认排序规则 asc/desc
			remoteSort : false,//是否支持远程
			idField : 'user_id', //那一列是id列
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				title : '用户id',
				field : 'user_id',
				width : 80,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'user_name',
				title : '员工姓名',
				width : 120
			}, {
				field : 'user_email',
				title : '员工邮箱',
				width : 220
			}, {
				field : 'user_chk_text',
				title : '是否锁定账号',
				width : 220
			}, {
				field : 'user_admin_text',
				title : '是否拥有管理员权限',
				width : 220
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ { //配置工具栏
				id : 'btnadd',
				text : '添加员工',
				iconCls : 'icon-add',
				handler : function() {
					$('#btnsave').linkbutton('enable');
					//打开前清空表单
					$('#ff').form('clear');
					//打开表单窗口
					$('#w').window({
						title : '添加员工',
						iconCls : 'icon-add'
					});
					$('#w').window('open');
				}
			}, {
				id : 'btncut',
				text : '修改员工',
				iconCls : 'icon-cut',
				handler : function() {
					$('#btnsave').linkbutton('enable');
					//获得被选中的用户的id
					var user_id = getSelected();

					if (!user_id) {
						msgShow('系统提示', '请选择用户！', 'warning');
						return;
					}
					//根据id回显数据
					$('#ff').form('load', '${pageContext.request.contextPath}/frame/userSearch.xhtml?user.user_id=' + user_id);
					//清空密码输入框
					$('#ff').form('clear');
					$('#w').window({
						title : '修改员工',
						iconCls : 'icon-cut'
					});
					//打开编辑窗口
					$('#w').window('open');

				}
			}, '-', {
				id : 'btnsave',
				text : '锁定账号',
				disabled : false, //禁用属性
				iconCls : 'icon-cancel',
				handler : function() {
					$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
					//获得被选中的用户id
					//获得被选中的用户的id
					var user_id = getSelected();
					//判断id不能为空
					if (!user_id) {
						msgShow('系统提示', '请选择用户！', 'warning');
						return;
					}
					var chkText = getSelectedChk();
					if (chkText != "正常账号") {
						msgShow('系统提示', '该用户账号已经被锁定！', 'warning');
						return;
					}
					//调用ajax异步发送请求锁定用户
					$.get("${pageContext.request.contextPath}/frame/userDel.xhtml?user.user_id=" + user_id, function(data) {
						//锁定成功后,刷新列表
						if (data.code == "success") {
							msgShow('系统提示', '账号锁定成功！', 'warning');
							$('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						} else {
							msgShow('系统提示', '账号锁定失败，请重试！', 'warning');
						}
					});
				}
			}, {
				id : 'btnredel',
				text : '解锁账号',
				disabled : false, //禁用属性
				iconCls : 'icon-ok',
				handler : function() {
					$('#btnsave').linkbutton('enable');//点击后按钮是否可以继续点击
					//获得被选中的用户id
					//获得被选中的用户的id
					var user_id = getSelected();
					//判断id不能为空
					if (!user_id) {
						msgShow('系统提示', '请选择用户！', 'warning');
						return;
					}
					var chkText = getSelectedChk();
					if (chkText != "锁定（冻结）账号") {
						msgShow('系统提示', '该用户账号为正常账号！', 'warning');
						return;
					}
					//调用ajax异步发送请求解锁用户
					$.get("${pageContext.request.contextPath}/frame/userReDel.xhtml?user.user_id=" + user_id, function(data) {
						//解锁成功后,刷新列表
						if (data.code == "success") {
							msgShow('系统提示', '账号解锁成功！', 'warning');
							$('#test').datagrid('reload'); //提交成功,重新加载列表数据   
						} else {
							msgShow('系统提示', '账号解锁失败，请重试！', 'warning');
						}
					});
				}
			} ]
		});
		var p = $('#test').datagrid('getPager');
		$(p).pagination({
			onBeforeRefresh : function() {
				alert('before refresh');
			}
		});
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

	<div id="w" class="easyui-window" title="添加员工" iconCls="icon-save" style="width: 300px; height: 250px" data-options="closed:true">
		<form id="ff" method="post" enctype="multipart/form-data">
			<input class="easyui-validatebox" type="hidden" id="updId" name="user.user_id" required="true"></input>
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
					<!-- <td><input class="easyui-validatebox" type="text" name="user.user_admin" required="true"></input></td> -->
					<td><select class="easyui-validatebox" name="upload" style="width: 173px;" required="true">
							<option value="1">有管理员权限</option>
							<option value="0" selected="selected">无管理员权限</option>
					</select></td>
				</tr>
				<tr>
					<td>初始密码:</td>
					<td><input class="easyui-validatebox" type="text" name="user.user_pwd" required="true"></input></td>
				</tr>
				<tr>
					<td>头像:</td>
					<td><input type="file" id="upload" name="upload" style="width: 173px;" accept="image/*"></input></td>
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