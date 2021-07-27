$(function () {
    $("#content").on('click', '#test333', function () {

        $("#content").html("");
        $("#content").append(
            "<div id='messageButton'>" +
                "<input type='button' id='delete' value='删除'>" +
                "<input type='button' id='read' value='标记为已读'>" +
                "<input type='button' id='readAll' value='全部标记为已读'>" +
                "<input type='button' id='viewReceive' value='查看接收'>" +
                "<input type='button' id='viewSend' value='查看发送'><br>" +
            "</div>" +
            "<div id='messageMain'><table id='messageTable'></table></div>" +
            "<div class='lq-page'></div>")
        var pageNum = 1;
        var pageSize = 5;
        var lastPage;
        var receiveId = "10324";
        var sendId = "10324";

        // 初始化页面
        viewReceiveMessages(receiveId, pageNum, pageSize, setSelect);
        var curView = "viewReceiveMessages";

        // 查看发送的消息
        $("#viewSend").click(function(){
            pageNum = 1;
            curView = "viewSendMessages";
            checkAndView(curView);

        })

        // 查看接收的消息
        $("#viewReceive").click(function(){
            // viewReceiveMessages(receiveId, pageNum, pageSize, setSelect);
            pageNum = 1;
            curView = "viewReceiveMessages";
            checkAndView(curView);

        })

        // 点击页码
        $(".lq-page").on('click','.page',function(){
            $(".page.on").attr("class", "page");
            $(this).attr("class", "page on");
            pageNum = parseInt($(this).html());
            checkAndView(curView);
        })

        // 点击首页
        $(".lq-page").on('click','.page-start',function(){
            pageNum = 1;
            $(".page.on").attr("class", "page");
            $(".page-before").next().attr("class", "page on");
            checkAndView(curView);
        })

        // 点击尾页
        $(".lq-page").on('click','.page-end',function(){
            pageNum = lastPage;
            $(".page.on").attr("class", "page");
            $(".page-after").prev().attr("class", "page on");
            checkAndView(curView);
        })

        // 点击下一页
        $(".lq-page").on('click','.page-after',function(){
            var pageOn = $(this).siblings('.on');
            pageNum = parseInt(pageOn.html());
            if(pageNum+1 <= lastPage){
                pageNum++;
                checkAndView(curView);
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
                checkAndView(curView);
                $(".page.on").attr("class", "page");
                pageOn.prev().attr("class", "page on");
            }
        })

        // 删除消息
        $("#messageButton").on('click', '#delete', function(){
            $("input[name='messageCheckbox']:checked").each(function(i){	//遍历
                // arr.push();	//将我们遍历出来的值push到数组中
                deleteMessage($(this).val());
                checkAndView(curView);
                //最后可以提交arr就可以实现将我们选中的checkbox的value值提交
            })
        })

        // 标记为已读
        $("#messageButton").on('click', '#read', function(){
            $("input[name='messageCheckbox']:checked").each(function(i){	//遍历
                if($(this).parent().siblings(".ckeckRead").attr("type") == '0'){
                    readMessage($(this).attr("value"));
                    checkAndView(curView);
                }
            })
        })

        // 全部标记为已读
        $("#messageButton").on('click', '#readAll', function(){
            console.log(111);
            $(".ckeckRead").each(function(){	//遍历
                if($(this).attr("type") == '0'){
                    readMessage($(this).attr("value"));
                    checkAndView(curView);
                }
            })
        })

        // 全选
        $("#messageTable").on('click', '#setCheckBox', function(){
            var flag = $("#setCheckBox").prop("checked");
            $("input[name='messageCheckbox']").each(function(i){	//遍历
                if(flag){
                    $(this).prop("checked", true);
                }else{
                    $(this).prop("checked", false);
                }
            })
        })

        // 获取接收的消息
        function viewReceiveMessages(receiveId, pageNum, pageSize, setSelect){
            $.ajax({
                url:"getReceiveMessages?receiveId=" + receiveId + "&pageNum=" + pageNum + "&pageSize=" + pageSize,
                async: false,
                method: 'post',
                success:function(data) {
                    if(setSelect != null){
                        setSelect(data);
                    }
                    viewReceive(data);
                    lastPage = data.navigateLastPage;
                }
            })
        }

        // 获取发送的消息
        function viewSendMessages(sendId, pageNum, pageSize, setSelect){
            $.ajax({
                url:"getSendMessages?sendId=" + sendId + "&pageNum=" + pageNum + "&pageSize=" + pageSize,
                async: false,
                method: 'post',
                success:function(data) {
                    if(setSelect != null){
                        setSelect(data);
                    }
                    viewSend(data);
                    lastPage = data.navigateLastPage;
                }
            })
        }

        // 确认当前显示的信息 并显示
        function checkAndView(curView){
            if(curView == "viewReceiveMessages"){
                viewReceiveMessages(receiveId, pageNum, pageSize, null)
            }else if(curView == "viewSendMessages"){
                viewSendMessages(sendId, pageNum, pageSize, null);
            }else if(curView == "viewRoomWaterOrder"){
                viewRoomWaterOrder(buildingId, roomId, pageNum, pageSize, null);
            }
        }

        // 删除消息
        function deleteMessage(messageId){
            $.ajax({
                url : 'deleteMessage?messageId=' + messageId,
                async : false,
                method : 'post',
                success : function() {

                }
            })
        }

        // 标记消息
        function readMessage(messageId){
            $.ajax({
                url : 'readMessage?messageId=' + messageId,
                async : false,
                method : 'post',
                success : function() {

                }
            })
        }

        // 渲染数据
        function viewReceive(data){
            $("#messageTable").html("");  // 清空表格
            $("#messageTable").append(
                $("<thead><tr>" +
                    "<td><input type='checkbox' id='setCheckBox'/></td>" +
                    "<td><div class='mail'></div></td>" +
                    "<td>发送人</td>" +
                    "<td>主题</td>" +
                    "<td>内容</td>" +
                    "<td>时间</td>" +
                    "</tr></thead><tbody></tbody>")
            )
            $.each(data.list, function(index, message) {
                var tr = $("<tr><td><input type='checkbox' name='messageCheckbox' value="+ message.messageId + "></td></tr>");
                if(message.isRead == "0"){
                    var td = "<td class='ckeckRead' value="+ message.messageId + " type='0'><div class='cir Ru'></div></td>";
                }else{
                    var td = "<td class='ckeckRead' value="+ message.messageId + " type='1'><div class='cir Rr'></div></td>";
                }
                tr.append(td);
                tr.append(
                    "<td><span class='receiveId'>" + message.sendId + "</span></td>" +
                    "<td><span class='title'>" + message.title + "</span></td>" +
                    "<td><p class='content'>" + message.content + "</p></td>" +
                    "<td><span class='sendTime'>" + message.sendTime + "</span></td>"
                )
                $("#messageTable>tbody").append(tr);
            })
        }

        // 渲染数据
        function viewSend(data){
            $("#messageTable").html("");  // 清空表格
            $("#messageTable").append(
                "<thead><tr>" +
                    "<td><input type='checkbox' id='setCheckBox'/></td>" +
                    "<td><div class='mail'></div></td>" +
                    "<td>接收人</td>" +
                    "<td>主题</td>" +
                    "<td>内容</td>" +
                    "<td>时间</td>" +
                    "</tr></thead><tbody></tbody>"
            )
            $.each(data.list, function(index, message) {
                var tr = $("<tr><td><input type='checkbox' name='messageCheckbox' value="+ message.messageId + "></td></tr>");
                if(message.isRead == "0"){
                    var td = "<td class='ckeckRead' value="+ message.messageId + " type='0'><div class='cir Ru'></div></td>";
                }else{
                    var td = "<td class='ckeckRead' value="+ message.messageId + " type='1'><div class='cir Rr'></div></td>";
                }
                tr.append(td);
                tr.append(
                    "<td><span class='receiveId'>" + message.sendId + "</span></td>" +
                    "<td><span class='title'>" + message.title + "</span></td>" +
                    "<td><p class='content'>" + message.content + "</p></td>" +
                    "<td><span class='sendTime'>" + message.sendTime + "</span></td>"
                )
                $("#messageTable>tbody").append(tr);
            })
        }

        // 设置页码
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