
var prefix = "/waimao/wmInvoiceOrder"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，card：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, card 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'id', 
									title : '主键ID' 
								},
																{
									field : 'invoiceNum', 
									title : '发票号码' 
								},
																{
									field : 'invoiceDate', 
									title : '发票日期' 
								},
																{
									field : 'createDate', 
									title : '制单日期' 
								},
																{
									field : 'reserveInvoiceNum', 
									title : '备单号码' 
								},
																{
									field : 'salerNo', 
									title : '业务员' 
								},
																{
									field : 'exportContractNo', 
									title : '出口合同号' 
								},
																{
									field : 'custOrderNo', 
									title : '客户订单号' 
								},
																{
									field : 'creditCardNo', 
									title : '信用证号' 
								},
																{
									field : 'openDate', 
									title : '开证日期' 
								},
																{
									field : 'loadDate', 
									title : '信用证装期' 
								},
																{
									field : 'validDate', 
									title : '信用证效期' 
								},
																{
									field : 'loadPort', 
									title : '装船港' 
								},
																{
									field : 'isTransfer', 
									title : '允许转船 '
								},
																{
									field : 'isSplit', 
									title : '允许分装 '
								},
																{
									field : 'trasferPort', 
									title : '转船港' 
								},
																{
									field : 'unloadPort', 
									title : '卸货港' 
								},
																{
									field : 'destPort', 
									title : '目的港' 
								},
																{
									field : 'destPlace', 
									title : '最终交货地' 
								},
																{
									field : 'tradeCountry', 
									title : '贸易国' 
								},
																{
									field : 'consumContry', 
									title : '消费国' 
								},
																{
									field : 'settleType', 
									title : '结汇方式' 
								},
																{
									field : 'transportType', 
									title : '运输方式' 
								},
																{
									field : 'payType', 
									title : '运费付款方式' 
								},
																{
									field : 'dealCond', 
									title : '成交条件' 
								},
																{
									field : 'shipName', 
									title : '船名' 
								},
																{
									field : 'voyageNum', 
									title : '航次' 
								},
																{
									field : 'billNo', 
									title : '提单号码' 
								},
																{
									field : 'billDate', 
									title : '提单日期' 
								},
																{
									field : 'billPayDate', 
									title : '议付日期' 
								},
																{
									field : 'billStatus', 
									title : '单证状态' 
								},
																{
									field : 'isSave', 
									title : '是否存档' 
								},
																{
									field : 'billOrigin', 
									title : '提单正本' 
								},

																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}


function  batchExport(){

    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要导出选中的数据");
        return;
    }
    layer.confirm("确认要导出选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['id'];
        });
        window.location.href=prefix + '/batchExport?ids='+ids;
        layer.msg(r.msg);
        reLoad();
        /*$.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchExport',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });*/
    }, function() {

    });
}
function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}