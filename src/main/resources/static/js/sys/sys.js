$(function () {

$("#user").blur(function () {
    checkAdminName()
})

})

//验证用户名称-----》begin
function checkAdminName() {
    var AdminName=$("#user").value
    $.ajax({
        url: '/checkAdminName',
        data: {
            AdminName: AdminName
        },
        dataType: 'JSON',
        type: 'POST',
        success: function (e) {
            //根据返回值是否等于0  做出不同的提示
        }
    })
}
//    验证用户名称-----》end
//验证密码信息------>begin
function checkPassword() {

}