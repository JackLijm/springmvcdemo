<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <script src="access/js/jquery.js" type="text/javascript"></script>
    <script>
        function req() {
            $.ajax({
                url: "convert",
                data: "1-wangyunfei",
                type: "POST",
                contentType: "application/x-wisely",
                success: function (data) {
                    $("#resp").html(data);
                }
            });
        }
    </script>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="请求"/>
</body>
</html>
