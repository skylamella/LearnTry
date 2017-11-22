<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/themes/demo.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.1.2.6.min.js"></script>
<script>
	$(function() {
		$('#tt').datagrid({
			url : 'datagrid_data2.json',
			title : 'DataGrid - ContextMenu',
			width : 700,
			height : 'auto',
			fitColumns : true,
			columns : [ [ {
				field : 'itemid',
				title : 'Item ID',
				width : 80
			}, {
				field : 'productid',
				title : 'Product ID',
				width : 120
			}, {
				field : 'listprice',
				title : 'List Price',
				width : 80,
				align : 'right'
			}, {
				field : 'unitcost',
				title : 'Unit Cost',
				width : 80,
				align : 'right'
			}, {
				field : 'attr1',
				title : 'Attribute',
				width : 250
			}, {
				field : 'status',
				title : 'Status',
				width : 60,
				align : 'center'
			} ] ],
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
				if (!$('#tmenu').length) {
					createColumnMenu();
				}
				$('#tmenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});

	function createColumnMenu() {
		var tmenu = $('<div id="tmenu" style="width:100px;"></div>').appendTo('body');
		var fields = $('#tt').datagrid('getColumnFields');
		for (var i = 0; i < fields.length; i++) {
			$('<div iconCls="icon-ok"/>').html(fields[i]).appendTo(tmenu);
		}
		tmenu.menu({
			onClick : function(item) {
				if (item.iconCls == 'icon-ok') {
					$('#tt').datagrid('hideColumn', item.text);
					tmenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					$('#tt').datagrid('showColumn', item.text);
					tmenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
	}
</script>
</head>
<body>
	修改员工信息
	<table id="tt"></table>
</body>
</html>