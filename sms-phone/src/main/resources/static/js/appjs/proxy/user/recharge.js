// 以下为官方示例
$().ready(function() {
});

$.validator.setDefaults({
	submitHandler : function() {
        recharge();
	}
});
function recharge() {
    layer.confirm('确定要充值吗？', {
        btn : [ '确定', '取消' ]
    },function() {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/proxy/user/rechargeAmt",
            data: $('#signupForm').serialize(),// 你的formid
            async: false,
            error: function (request) {
                alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg(data.msg);
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);

                } else {
                    parent.layer.msg(data.msg);
                }

            }
        });
     })

}
