<%@page import="com.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.controllers.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styleIncorrect.css">
</head>
<body>
	<section class="page_404">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 ">
					<div class="col-sm-10 col-sm-offset-1  text-center">
						<div class="four_zero_four_bg">
							<h1 class="text-center ">sign in</h1>


						</div>


						<%
							Object x =(request.getAttribute("type"));
						if(x.equals(-1))
						{
							out.println("<h3>User Not Found</h3>");
							
						}
						else if(x.equals(-2))
						{
							out.println("<h3>Wrong Password</h3>");

						}	
							%>


						<div class="contant_box_404">

							<p>Try again</p>
							<a href="index.html" class="link_404">Go to Home</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
>
</html>