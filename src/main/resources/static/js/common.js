
/*
查看我的文稿
 */
function selectMyArticle(userId) {
    $.ajax({
        contentType: "application/json;charset=UTF-8",
        type: "get",
        url: "/system/article/user/" + userId,
        dataType: "json",
        success: function (data) {
            console.log(data)
            if("success" === data.status){
                window.location.href = "/system/myArticle";
            }else {
                window.location.href = "/system/articleMarket";
            }
        }
    })
}