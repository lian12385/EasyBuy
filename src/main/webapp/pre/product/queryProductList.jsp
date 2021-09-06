<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <%@ include file="/common/pre/link.jsp" %>
    <script type="text/javascript" src="${ctx}/statics/js/common/n_nav.js"></script>
    <script src="${ctx}/statics/js/cart/cart.js"></script>
    <title>易买网</title>
</head>
<body>
<%@ include file="/common/pre/header.jsp" %>
<!--Begin Header Begin-->
<div id="searchBar">
    <%@ include file="/common/pre/searchBar.jsp" %>
</div>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <%@ include file="/common/pre/categoryBar.jsp" %>
        <!--End 商品分类详情 End-->
    </div>
</div>
<!--End Menu End-->
<div class="i_bg">
    <!--Begin 筛选条件 Begin-->
    <!--End 筛选条件 End-->
    <div class="content mar_20">
        <div id="favoriteList">
        </div>
        <div class="l_list">
            <div class="list_t">
                <span class="fr">共发现${pager.totalCount}件</span>
            </div>
            <div class="list_c">
                <ul class="cate_list">
                    <c:forEach items="${pager.records}" var="temp">
                        <li>
                            <div class="img">
                                <a href="${ctx}/Product/queryProductDeatil?id=${temp.id}" target="_blank">
                                    <img src="${ctx}/files/${temp.fileName}" width="210" height="185"/>
                                </a>
                            </div>
                            <div class="price">
                                <font>￥<span>${temp.price}</span></font>
                            </div>
                            <div class="name"><a href="${ctx}/Product/queryProductDeatil?id=${temp.id}">${temp.name}</a></div>
                            <div class="carbg">
                                <a href="javascript:void(0);" class="ss" onclick="addFavorite('${temp.id}')">收藏</a>
                                <a href="javascript:void(0);" class="j_car" onclick="addCartByParam('${temp.id}',1);">加入购物车</a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <%@ include file="/common/pre/pagerBar.jsp" %>
            </div>
        </div>
    </div>
    <script>
        favoriteList();
    </script>
    <%@ include file="/common/pre/footer.jsp" %>
</div>
</body>
</html>
