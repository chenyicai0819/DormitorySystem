$(function () {
    $("#content").on('click', '#test222', function () {

        $("#content").html("");
        $("#content").append(
            "<div id='waterStateMain'><table id='waterStateTable'></table></div>" +
            "<div class='lq-page'></div>"
        );
        var pageNum = 1;
        var pageSize = 5;
        var lastPage;

        viewAllWaterState(pageNum, pageSize, setSelect);    // 显示水的状态信息

        // 更新&确定监听器
        $("#waterStateTable").on("click", ".button1", function(){
            var value = $(this).attr("value");
            var td = $(this).parent().prevAll();
            if(value == "更新"){
                td.children(".number").attr("readonly", false);
                $(this).attr("value", "确定");
            }else if(value == "确定"){
                td.children(".number").attr("readonly", true);
                var number = td.children(".number").attr("value");  // 获取更新前的数据
                var buildingId = td.children(".buildingId").val();
                // 如果数据有变化 更新数据
                if(number != td.children(".number").val()){
                    updataWaterState(buildingId, td.children(".number").val())
                }
                $(this).attr("value", "更新");
            }
        })

        // 点击页码
        $(".lq-page").on('click','.page',function(){
            $(".page.on").attr("class", "page");
            $(this).attr("class", "page on");
            pageNum = parseInt($(this).html());
            viewAllWaterState(pageNum, pageSize);
        })

        // 点击首页
        $(".lq-page").on('click','.page-start',function(){
            pageNum = 1;
            $(".page.on").attr("class", "page");
            $(".page-before").next().attr("class", "page on");
            viewAllWaterState(pageNum, pageSize);
        })

        // 点击尾页
        $(".lq-page").on('click','.page-end',function(){
            pageNum = lastPage;
            $(".page.on").attr("class", "page");
            $(".page-after").prev().attr("class", "page on");
            viewAllWaterState(pageNum, pageSize);
        })

        // 点击下一页
        $(".lq-page").on('click','.page-after',function(){
            var pageOn = $(this).siblings('.on');
            pageNum = parseInt(pageOn.html());
            if(pageNum+1 <= lastPage){
                pageNum++;
                viewAllWaterState(pageNum, pageSize);
                $(".page.on").attr("class", "page");
                pageOn.next().attr("class", "page on");
            }
        })

        // 点击上一页
        $(".lq-page").on('click','.page-before',function(){
            var pageOn = $(this).siblings('.on');
            pageNum = parseInt(pageOn.html());
            if(pageNum-1 >= 1){
                pageNum--;
                viewAllWaterState(pageNum, pageSize);
                $(".page.on").attr("class", "page");
                pageOn.prev().attr("class", "page on");
            }
        })

        // 确认所有提交监听器
        $("#confirmAll").click(function(){
            $.each($(".button1"), function(index, button){
                var td = $(this).parent().prevAll();
                if(button.getAttribute("value") == "确定"){
                    button.setAttribute("value", "更新");
                    td.find("input").attr("readonly", true);
                    var buildingId = td.children(".buildingId").val();
                    var number = td.children(".number").val();
                    updataWaterState(buildingId, number)
                }
            })
        })

        // 显示所有楼栋水状态信息
        function viewAllWaterState(pageNum, pageSize, setSelect) {
            $("#table>tbody").html("");  // 清空表格
            $.ajax({
                url:"getAllWaterState?pageNum=" + pageNum + "&pageSize=" + pageSize,
                async: false,
                method: 'post',
                success:function(data) {
                    if(setSelect != null){
                        setSelect(data);
                    }
                    view(data);
                    lastPage = data.navigateLastPage;
                }
            })
        }

        // 提交单条数据更新
        function updataWaterState(buildingId, number){
            $.ajax({
                url : "updataWaterState?buildingId=" + buildingId + "&number=" + number,
                type : "post",
                success : function(){
                    alert("更新成功");
                }
            })
        }

        function view(data){
            $("#waterStateTable").html("");
            $("#waterStateTable").append(
                $("<thead><tr><td></td><td>楼栋</td><td>数量</td></tr></thead><tbody></tbody>")
            )
            $.each(data.list, function(index, water) {
                var tr = $("<tr>"
                    + "<td> <input type='hidden' class='buildingId' name='buildingId' value='" + water.buildingId + "'></td>"
                    + "<td>#" + water.buildingId + "</td>"
                    + "<td> <input type='text' class='number' name='number' value='" + water.number + "'readonly=\"true\"></td>"
                    + "<td> <input type='button' class='button1' value='更新' id='" + water.buildingId + "'></td>"
                    // + "<td> <input type='button' class='button2' value='删除' id='" + water.buildingId + "'></td>"
                    + "</tr>");
                $("#waterStateTable>tbody").append(tr);
            })
        }

        function setSelect(data){
            $(".lq-page").html("");  // 清空
            var pages = data.navigatepageNums;
            if(pages.length >= 2){
                $(".lq-page").append('<span class="page-start">首页</span>');
                $(".lq-page").append('<span class="page-before">上一页</span>');
                $.each(pages, function(index, page) {
                    if(index == 0){
                        var span = $("<span class=\"page on\">"+ page +"</span>");
                    }else {
                        var span = $("<span class=\"page\">"+ page +"</span>")
                    }
                    $(".lq-page").append(span);
                })
                $(".lq-page").append('<span class="page-after">下一页</span><span class="page-end">尾页</span>');
            }
        }
    })
})






