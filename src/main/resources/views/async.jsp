<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <script src="access/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
        deferred();
        function deferred(){
            $.get('defer',function (data) {
               console.log(data);
               deferred();
            })
        }
    </script>
</head>
<body>
<div id="msgFromPush"></div>
</body>
</html>
