$(function(){
     function addPage(current,maxPage){
            //清空容器
            $(".lq-page").html('');
            //1.显示 [首页] [上一页]
            if(current>1){
                $(".lq-page").append('<span class="page-start">首页</span><span class="page-before">上一页</span>');
            }else{
                $(".lq-page").append('<span class="page-before disable">上一页</span>');
            }
            //2.首页 上一页 【...】
            if(current>3 && maxPage>5){
                $(".lq-page").append('<span class="page-ell">...</span>');
            }

            //3.显示页码  首页 上一页 ...  2 3 【4】 5 6 ...  
            var start=current-2
            var end=current+2;
            //特殊的位置：开头位置 current=1 / 2 
            if(current <= 2 ){
                start=1;
                end=maxPage>5?5:maxPage;
            }
            if(current >= maxPage-1){
                start=maxPage-4>0?maxPage-4:1;
                end=maxPage;
            }
            for(;start<=end;start++){
               if(start==current){
                    $(".lq-page").append('<span class="page on">'+start+'</span>');
               }else{
                $(".lq-page").append('<span class="page">'+start+'</span>');
               }
            }

            //4. 显示 首页 上一页 ...  2 3 4 5 6 [...] 控制 
            if(maxPage>5 && current < maxPage-2){
                $(".lq-page").append('<span class="page-ell">...</span>');
            }

            //5.下一页 和 尾页
            if(current<maxPage){
                $(".lq-page").append('<span class="page-after">下一页</span><span class="page-end">尾页</span>');
            }else{
                $(".lq-page").append('<span class="page-after disable">下一页</span>');
            }


     }

     //二、点击事件 ---动态创建的元素---必须通过绑定添加事件
    function addEvent(maxPage){
        $(".lq-page").off('click');
        $(".lq-page").on('click','.page',function(){
            console.log($(this).html());//string 
            var num=parseInt($(this).html());
            getData(num);  
        })

        //2.点击首页
        $(".lq-page").on('click','.page-start',function(){
            getData(1);  
        })
        //3.点击尾页
        $(".lq-page").on('click','.page-end',function(){
            getData(maxPage)
        })

        //4.点击下一页  
        $(".lq-page").on('click','.page-after',function(){
           var num=parseInt($(this).siblings('.on').html());
           num++;
           console.log(num);
           if(num<=maxPage){;
                getData(num)
           } 
        })
        //5.点击上一页
        $(".lq-page").on('click','.page-before',function(){
            var num=parseInt($(this).siblings('.on').html());
            num--;
            console.log(num);
            if(num >= 1){
                getData(num)
            } 
         })
    }


    var allPage=$("#allPage").text();
    addPage(1,allPage);//颜色显示在哪个页面
    addEvent(allPage);
    if (document.title=="Room") {
        function getData(num) {
            console.log(document.title);
            $("#table1").load("pagination?currentPage="+num);
            addPage(num, allPage);
            addEvent(allPage);
        }
    }else if(document.title=="Dormitory"){
        function getData(num) {
            $("#table1").load("pagination1?currentPage="+num);
            addPage(num, allPage);
            addEvent(allPage);
        }
    }else if(document.title=="Student"){
        function getData(num) {
            $("#table1").load("pagination2?pageNum="+num);
            addPage(num, allPage);
            addEvent(allPage);
        }
    }else if(document.title=="dormitoryInf"){
        function getData(num) {
            $("#table1").load("pagination3?pageNum="+num);
            addPage(num, allPage);
            addEvent(allPage);
        }
    }
})
