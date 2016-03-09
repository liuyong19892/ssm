<!DOCTYPE html>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="utf-8">
        <title>Home</title>
		<link href="<c:url value='/resources/css/kendo.common.min.css'/>" rel="stylesheet" />
		<link href="<c:url value='/resources/css/kendo.default.min.css'/>" rel="stylesheet" />
		
		<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
		<script src="<c:url value='/resources/js/kendo.all.min.js' />"></script>
</head>
<body>

<div id="example">
    <div id="grid"></div>
    <script>
        $(document).ready(function () {
            $("#grid").kendoGrid({
                dataSource: {
                    type: "odata",
                    transport: {
                        read: "rest/user/list/gson"
                    },
                    pageSize: 20
                },
                height: 550,
                groupable: true,
                sortable: true,
                pageable: {
                    refresh: true,
                    pageSizes: true,
                    buttonCount: 5
                },
                columns: [{
                    field: "name",
                    title: "Name",
                    width: 240
                }, {
                    field: "standard",
                    title: "Standard"
                }, {
                    field: "age",
                    title: "Age"
                }, {
                    field: "sex",
                    width: 150
                }]
            });
        });
    </script>
</div>

</body>
</html>