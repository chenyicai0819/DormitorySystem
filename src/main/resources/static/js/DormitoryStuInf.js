$(function () {
    //修改，先获取点击表里选中的内容，把内容添加到表里
    $(".update1").click(function () {

        $(".ser").hide();
        $(".table1").hide();
        $(".form1").show();


        var buid   = $(this).parent().parent().find("td:nth-child(1)").text();
        var rId    = $(this).parent().parent().find("td:nth-child(2)").text();
        var rBed   = $(this).parent().parent().find("td:nth-child(3)").text();
        var sId = $(this).parent().parent().find("td:nth-child(4)").text();
        var sName  = $(this).parent().parent().find("td:nth-child(5)").text();
        var sCollege = $(this).parent().parent().find("td:nth-child(6)").text();
        var sGrade   = $(this).parent().parent().find("td:nth-child(7)").text();
        var sPhone   = $(this).parent().parent().find("td:nth-child(8)").text();

        $("#sId").val(sId);
        $("#buid").val(buid);
        $("#rId").val(rId);
        $("#rBed").val(rBed);
        $("#sName").val(sName);
        $("#sCollege").val(sCollege);
        $("#sGrade").val(sGrade);
        $("#sPhone").val(sPhone);
    })
    //把框里的内容传到后台，刷新界面
    $("#bottom1").click(function () {
        $(".ser").show();
        $(".table1").show();
        $(".form1").hide();

        var res1 = $("#buid").val();
        var res2 = $("#rId").val();
        var res3 = $("#rBed").val();
        var res4 = $("#sId").val();
        var res5 = $("#sName").val();
        var res6 = $("#sCollege").val();
        var res7 =  $("#sGrade").val();
        var res8= $("#sPhone").val();
        $.ajax({
            url: 'updateStuInf?buid=' + res1 + '&rId=' + res2 + '&rBed=' + res3+ '&sId='+res4+'&sName='+res5+
                '&sCollege='+res6+ '&sGrade=' + res7 + '&sPhone=' + res8,
            success:function () {
                window.location.reload();
            }
        })
    })
    // $("#submit").click(function () {
    //     console.log("kkkk")
    //     $(".ser").hide();
    //     $(".table1").hide();
    //     $(".form1").hide();
    //     $(".form2").show();
    //     $(".submit").hide();
    // })

    // $("#bottom2").click(function () {
    //     $(".ser").show();
    //     $(".table1").show();
    //     $(".form1").hide();
    //     $(".form2").hide();
    //
    //     var add1 = $("#buid2").val();
    //     var add2 = $("#rId2").val();
    //     var add3 = $("#rBed2").val();
    //     var add4 = $("#sId2").val();
    //     var add5 = $("#sName2").val();
    //     var add6 = $("#sCollege2").val();
    //     var add7 =  $("#sGrade2").val();
    //     var add8= $("#sPhone2").val();
    //     console.log("shabi"+add1,add2,add3,add4);
    //
    //     $.ajax({
    //         url: 'addStuInf?buid='+add1+'&rId='+add2 +'&rBed='+add3+'&sId='+add4+'&sName='+add5+ '&sCollege='+add6+
    //             '&sGrade=' + add7 + '&sPhone=' + add8,
    //         success:function () {
    //             window.location.reload();
    //         }
    //     })
    // })
    $("#search").click(function () {
        console.log("ssss")
        $("#submit").hide();
        $(".return").show();
        var search=$("#text").val();
        var url="search"
        $.ajax({
            url:url,
            type:'POST',
            data:{buid:search},
            success:function (data){
                $('#table1').html(data);
                //修改操作

                $(".update1").click(function () {
                    $(".submit").hide();
                    $(".ser").hide();
                    $(".table1").hide();
                    $(".form1").show();
                    $(".return").hide();
                    var buid   = $(this).parent().parent().find("td:nth-child(1)").text();
                    var rId    = $(this).parent().parent().find("td:nth-child(2)").text();
                    var rBed   = $(this).parent().parent().find("td:nth-child(3)").text();
                    var sId = $(this).parent().parent().find("td:nth-child(4)").text();
                    var sName  = $(this).parent().parent().find("td:nth-child(5)").text();
                    var sCollege = $(this).parent().parent().find("td:nth-child(6)").text();
                    var sGrade   = $(this).parent().parent().find("td:nth-child(7)").text();
                    var sPhone   = $(this).parent().parent().find("td:nth-child(8)").text();

                    $("#sId").val(sId);
                    $("#buid").val(buid);
                    $("#rId").val(rId);
                    $("#rBed").val(rBed);
                    $("#sName").val(sName);
                    $("#sCollege").val(sCollege);
                    $("#sGrade").val(sGrade);
                    $("#sPhone").val(sPhone);
                })
                //返回刷新页面
                $("#return").click(function () {
                    window.location.reload();
                })


                $("#bottom1").click(function () {
                    $(".ser").show();
                    $(".table1").show();
                    $(".form1").hide();
                    var res1 = $("#buid").val();
                    var res2 = $("#rId").val();
                    var res3 = $("#rBed").val();
                    var res4 = $("#sId").val();
                    var res5 = $("#sName").val();
                    var res6 = $("#sCollege").val();
                    var res7 =  $("#sGrade").val();
                    var res8= $("#sPhone").val();
                    $.ajax({
                        url: 'updateStuInf?buid=' + res1 + '&rId=' + res2 + '&rBed=' + res3+ '&sId='+res4+'&sName='+res5+
                            '&sCollege='+res6+ '&sGrade=' + res7 + '&sPhone=' + res8,
                        success:function () {
                            window.location.reload();
                        }
                    })
                })
            }
        })
    })
})