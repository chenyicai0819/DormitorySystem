$(function () {
    //修改，先获取点击表里选中的内容，把内容添加到表里
    $(".update1").click(function () {

        $(".ser").hide();
        $(".table1").hide();
        $(".form1").show();
        $(".lq-page").hide();
        $(".submit").hide();

        var sId = $(this).parent().parent().find("td:nth-child(1)").text();
        var roleId = $(this).parent().parent().find("td:nth-child(2)").text();
        var buid   = $(this).parent().parent().find("td:nth-child(3)").text();
        var rId    = $(this).parent().parent().find("td:nth-child(4)").text();
        var rBed   = $(this).parent().parent().find("td:nth-child(5)").text();
        var sPwd   = $(this).parent().parent().find("td:nth-child(6)").text();
        var sName  = $(this).parent().parent().find("td:nth-child(7)").text();
        var sSex   = $(this).parent().parent().find("td:nth-child(8)").text();
        var sCollege = $(this).parent().parent().find("td:nth-child(9)").text();
        var sGrade   = $(this).parent().parent().find("td:nth-child(10)").text();
        var sPhone   = $(this).parent().parent().find("td:nth-child(11)").text();

        $("#sId").val(sId);
        $("#roleId").val(roleId);
        $("#buid").val(buid);
        $("#rId").val(rId);
        $("#rBed").val(rBed);
        $("#sPwd").val(sPwd);
        $("#sName").val(sName);
        $("#sSex").val(sSex);
        $("#sCollege").val(sCollege);
        $("#sGrade").val(sGrade);
        $("#sPhone").val(sPhone);
    })
    //把框里的内容传到后台，刷新界面
    $("#bottom1").click(function () {
        $(".ser").show();
        $(".table1").show();
        $(".form1").hide();
        var res1 = $("#sId").val();
        var res2 = $("#roleId").val();
        var res3 = $("#buid").val();
        var res4 = $("#rId").val();
        var res5 = $("#rBed").val();
        var res6 = $("#sName").val();
        var res7 = $("#sSex").val();
        var res8 = $("#sCollege").val();
        var res9 =  $("#sGrade").val();
        var res10 = $("#sPwd").val();
        var res11= $("#sPhone").val();
        $.ajax({
            url: 'updateStudent?sId=' + res1 + '&roleId=' + res2 + '&buid=' + res3+ '&rId='+res4+'&rBed='+res5+
                '&sName='+res6+ '&sSex=' + res7 + '&sCollege=' + res8+ '&sGrade='+res9 + '&sPwd='+res10+'&sPhone='+res11,
            success:function () {
                window.location.reload();
            }
        })
    })
    $("#submit").click(function () {
        console.log("kkkk")
        $(".ser").hide();
        $(".table1").hide();
        $(".form1").hide();
        $(".form2").show();
        $(".submit").hide();
        $(".lq-page").hide();
    })

    $("#bottom2").click(function () {
        $(".ser").show();
        $(".table1").show();
        $(".form1").hide();
        $(".form2").hide();
        $(".submit").show();
        $(".lq-page").show();


        var add1 = $("#sId2").val();
        var add2 = $("#roleId2").val();
        var add3 = $("#buid2").val();
        var add4 = $("#rId2").val();
        var add5 = $("#rBed2").val();
        var add6 = $("#sPwd2").val();
        var add7 = $("#sName2").val();
        var add8 = $("#sSex2").val();
        var add9 = $("#sCollege2").val();
        var add10 =  $("#sGrade2").val();
        var add11= $("#sPhone2").val();
        console.log("shabi"+add1,add2,add3,add4);

        $.ajax({
            url: 'addStudent?sId='+add1+'&roleId='+add2 +'&buid='+add3+'&rId='+add4+'&rBed='+add5+ '&sPwd='+add6+
                '&sName=' + add7 + '&sSex=' + add8+ '&sCollege='+add9 + '&sGrade='+add10+ '&sPhone='+add11,
            success:function () {
                window.location.reload();
            }
        })
    })

    $("#search").click(function () {
        console.log("ssss")
        $("#submit").hide();
        $(".return").show();
        $("#lq-page").toggle();


        var search=$("#text").val();
        var url="searchStudent"
        $.ajax({
            url:url,
            type:'POST',
            data:{sId:search},
            success:function (data){
                $('#table1').html(data);

                //修改操作
                $(".update1").click(function () {
                    $(".submit").hide();
                    $(".ser").hide();
                    $(".table1").hide();
                    $(".form1").show();
                    $(".return").hide();
                    var sId = $(this).parent().parent().find("td:nth-child(1)").text();
                    var roleId = $(this).parent().parent().find("td:nth-child(2)").text();
                    var buid   = $(this).parent().parent().find("td:nth-child(3)").text();
                    var rId    = $(this).parent().parent().find("td:nth-child(4)").text();
                    var rBed   = $(this).parent().parent().find("td:nth-child(5)").text();
                    var sPwd   = $(this).parent().parent().find("td:nth-child(6)").text();
                    var sName  = $(this).parent().parent().find("td:nth-child(7)").text();
                    var sSex   = $(this).parent().parent().find("td:nth-child(8)").text();
                    var sCollege = $(this).parent().parent().find("td:nth-child(9)").text();
                    var sGrade   = $(this).parent().parent().find("td:nth-child(10)").text();
                    var sPhone   = $(this).parent().parent().find("td:nth-child(11)").text();

                    $("#sId").val(sId);
                    $("#roleId").val(roleId);
                    $("#buid").val(buid);
                    $("#rId").val(rId);
                    $("#rBed").val(rBed);
                    $("#sPwd").val(sPwd);
                    $("#sName").val(sName);
                    $("#sSex").val(sSex);
                    $("#sCollege").val(sCollege);
                    $("#sGrade").val(sGrade);
                    $("#sPhone").val(sPhone);

                    $("#bottom1").click(function () {
                        $(".ser").show();
                        $(".table1").show();
                        $(".form1").hide();
                        var res1 = $("#sId").val();
                        var res2 = $("#roleId").val();
                        var res3 = $("#buid").val();
                        var res4 = $("#rId").val();
                        var res5 = $("#rBed").val();
                        var res6 = $("#sName").val();
                        var res7 = $("#sSex").val();
                        var res8 = $("#sCollege").val();
                        var res9 =  $("#sGrade").val();
                        var res10 = $("#sPwd").val();
                        var res11= $("#sPhone").val();
                        $.ajax({
                            url: 'updateDormitory?dId=' + res1 + '&roleId=' + res2 + '&buid=' + res3+ '&dName='+res4+
                                '&dPwd='+res5+'&dPhone='+res6,
                            success:function () {
                                window.location.reload();
                            }
                        })
                    })
                })
                //返回刷新页面
                $("#return").click(function () {
                    window.location.reload();
                })

            }
        })
    })
})