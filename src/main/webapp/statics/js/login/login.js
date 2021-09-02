var jq = jQuery.noConflict();
//登录的方法
function login(){
    var loginName=jq("#loginName").val();
    var password=jq("#password").val();
    jq.ajax({
        url:contextPath+"/User/Login",
        type:"post",
        data:{loginName:loginName,password:password},
        success:function(result){
            if(result.code==200){
                //window.location.href=contextPath+"/Home?action=index";
               window.location.href=contextPath+"/User/page/index";
            }else{
                showMessage(result.msg)
            }
        },
        dataType:"json"
    });
}