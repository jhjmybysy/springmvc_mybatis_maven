<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>

</head>
<body>

	<form id="itemForm"
		action="${pageContext.request.contextPath}/users/editUsersSubmit.action"
		method="post">
		<input type="hidden" name="id" value="${user.id}" /> 修改用户信息：
		<table width="100%" border=1>
			<tr>
				<td>用户id</td>
				<td><input type="text" name="id" value="${user.id}" /></td>
			</tr>
			<tr>
				<td>用户名称</td>
				<td><input type="text" name="userName" value="${user.userName}" /></td>
			</tr>
			<tr>
				<td>用户年龄</td>
				<td><input type="text" name="age" value="${user.age}" /></td>
			</tr>
			<tr>
				<td>用户生日</td>
				<td><input type="text" name="birthday"
					value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>