<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ThTShoes</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
	<div class="login-container">
		<section class="login-section">
			<div class="container login-container">
				<div class="MuiBox-root css-1c8iigh">
					<div
						class="MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-mhc70k-MuiGrid-root">
						<img src="<%=request.getContextPath()%>/asssets/logo.svg"
							class='logo' />
						<div
							class="MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-1csrc3m-MuiGrid-root">
							<h1 class="login-title">
								<%
								if (request.getAttribute("lableSuccess") != null) {
									out.print(request.getAttribute("lableSuccess"));
								} else {
									out.print(request.getAttribute("lableError"));
								}
								%>
							</h1>
						</div>
						<div
							class="MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-1idn90j-MuiGrid-root">
							<a href="#"
								class="MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-1fu7jd5-MuiButtonBase-root-MuiButton-root"
								tabindex="0" type="button"> TRỞ VỀ TRANG CHỦ<span
								class="MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
