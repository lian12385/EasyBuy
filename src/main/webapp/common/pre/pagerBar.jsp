<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<div class="pages">
    <c:if test="${pager.totalPages>=1}">
        <a href="${ctx}/${pager.url}&pageIndex=1" class="p_pre">首页</a>
        <c:if test="${pager.pageIndex>1}">
            <a href="${ctx}/${pager.url}&pageIndex=${pager.pageIndex-1}" class="p_pre">上一页</a>
        </c:if>
        <c:forEach  var="temp" begin="${pager.pageIndex>3?pager.pageIndex-3:1}" end="${pager.totalPages-pager.pageIndex>3?pager.pageIndex+3:pager.totalPages}" step="1">
            <c:if test="${pager.pageIndex==temp}">
                <a href="${ctx}/${pager.url}&pageIndex=${temp}" class="cur">${temp}</a>
            </c:if>
            <c:if test="${pager.pageIndex!=temp}">
                <a href="${ctx}/${pager.url}&pageIndex=${temp}">${temp}</a>
            </c:if>
        </c:forEach>
        <c:if test="${pager.pageIndex<pager.totalPages}">
            <a href="${ctx}/${pager.url}&pageIndex=${pager.pageIndex+1}" class="p_pre">下一页</a>
        </c:if>
        <a href="${ctx}/${pager.url}&pageIndex=${pager.totalPages}" class="p_pre">尾页</a>
    </c:if>
    <c:if test="${pager.totalPages==0}">
        暂无记录
    </c:if>
</div>