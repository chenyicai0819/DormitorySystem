
$(function () {
    //点击修改显示修改界面并获取数值
    $(".update1").click(function () {
        $(".ser").hide();
        $(".table1").hide();
        $(".form1").show();
        $(".submit").hide();
        $(".lq-page").hide();

        var dId = $(this).parent().parent().find("td:nth-child(1)").text();
        var roleId = $(this).parent().parent().find("td:nth-child(2)").text();
        var buid = $(this).parent().parent().find("td:nth-child(3)").text();
        var dName = $(this).parent().parent().find("td:nth-child(4)").text();
        var dPwd = $(this).parent().parent().find("td:nth-child(5)").text();
        var dPhone = $(this).parent().parent().find("td:nth-child(6)").text();
        $("#dId").val(dId);
        $("#roleId").val(roleId);
        $("#buid").val(buid);
        $("#dName").val(dName);
        $("#dPwd").val(dPwd);
        $("#dPhone").val(dPhone);
    })
    //点击确定，把框内的内容传到后台，刷新页面
    $("#bottom1").click(function () {
        $(".ser").show();
        $(".table1").show();
        $(".form1").hide();
        var res1 = $("#dId").val();
        var res2 = $("#roleId").val();
        var res3 = $("#buid").val();
        var res4 = $("#dName").val();
        var res5 = $("#dPwd").val();
        var res6 = $("#dPhone").val();
        // $.ajax({
        //     url: 'updateDormitory?dId=' + res1 + '&roleId=' + res2 + '&buid=' + res3+ '&dName='+res4+
        //         '&dPwd='+res5+'&dPhone='+res6,
        //     success:function () {
        //         window.location.reload();
        //     }
        // })
        $.ajax({
            url:"updateDormitory",
            type:'POST',
            data:{dId:res1,roleId:res2,buid:res3,dName:res4,dPwd:res5,dPhone:res6},
            success:function (data) {
                window.location.reload();
            }
        })
    })
        //添加
    $(".submit").click(function () {
        console.log("kkk")
        $(".ser").hide();
        $(".table1").hide();
        $(".form1").hide();
        $(".form2").show();
        $(".lq-page").hide();
        $("#submit").hide();
    })
    //确定后获取输入框里的值并传到后台，刷新界面
    $("#bottom2").click(function () {
        $(".ser").show();

        $(".table1").show();
        $(".form1").hide();
        $(".form2").hide();
        var add1 = $("#dId2").val();
        var add2 = $("#roleId2").val();
        var add3 = $("#buid2").val();
        var add4 = $("#dName2").val();
        var add5 = $("#dPwd2").val();
        var add6 = $("#dPhone2").val();
        $.ajax({
            url: 'addDormitory?dId=' + add1 + '&roleId=' + add2 + '&buid=' + add3+ '&dName='+add4+'&dPwd='+add5+
                '&dPhone='+add6,
            success:function () {
                window.location.reload();
            }
        })
    })

        //搜索，先获取框里的数据，把数据传入后台，进行搜索，局部刷新表格的内容
        $("#search").click(function () {
            console.log("ssss")
            $("#submit").hide();
            $(".return").show();
            $(".lq-page").hide();
            var search=$("#text").val();
            var url="searchDormitory"
            $.ajax({
                url:url,
                type:'POST',
                data:{dId:search},
                success:function (data){
                    $('#table1').html(data);
                    //修改操作
                    $(".update1").click(function () {
                        $(".ser").hide();
                        $(".table1").hide();
                        $(".form1").show();
                        $(".return").hide();
                        $(".submit").hide();
                        var dId = $(this).parent().parent().find("td:nth-child(1)").text();
                        var roleId = $(this).parent().parent().find("td:nth-child(2)").text();
                        var buid = $(this).parent().parent().find("td:nth-child(3)").text();
                        var dName = $(this).parent().parent().find("td:nth-child(4)").text();
                        var dPwd = $(this).parent().parent().find("td:nth-child(5)").text();
                        var dPhone = $(this).parent().parent().find("td:nth-child(6)").text();
                        $("#dId").val(dId);
                        $("#roleId").val(roleId);
                        $("#buid").val(buid);
                        $("#dName").val(dName);
                        $("#dPwd").val(dPwd);
                        $("#dPhone").val(dPhone);
                    })
                    $("#return").click(function () {
                        window.location.reload();
                    })

                    $("#bottom1").click(function () {
                        $(".ser").show();
                        $(".table1").show();
                        $(".form1").hide();
                        var res1 = $("#dId").val();
                        var res2 = $("#roleId").val();
                        var res3 = $("#buid").val();
                        var res4 = $("#dName").val();
                        var res5 = $("#dPwd").val();
                        var res6 = $("#dPhone").val();
                        $.ajax({
                            url: 'updateDormitory?dId=' + res1 + '&roleId=' + res2 + '&buid=' + res3+ '&dName='+res4+
                                '&dPwd='+res5+'&dPhone='+res6,
                            success:function () {
                                window.location.reload();
                            }
                        })
                    })
                }
            })
        })
})

