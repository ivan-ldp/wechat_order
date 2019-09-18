$(function () {
    //设置购买数量改变事件
    $("#num").bind("change",function(){
        var num=$(this).val();
        if(num==""||$.trim(num).length==0){
            return;
        }
        var price=$("#price").val();
        var totalPrice=parseInt(num)*parseFloat(price);
        $("#total_price").html(totalPrice.toFixed(2));
    })
    //返回事件
    $("#goBack").bind("click",function(){
        location.href="/goods/test/goodsList";
    })

    $("#buy_button").bind("click",function(){
        var num=$("#num").val();
        //判断数量是否为空或者为0
        if(num==""||$.trim(num).length==0||num=='0'){
            alert("数量不能为空或者为零");
            return;
        }
        $("#form").submit();
    })
})