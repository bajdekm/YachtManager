<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Library</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/messages.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Library/">Library</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/Library/">Book list</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Managing
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#" onclick="returnedBook();">Returned book</a></li>
						</ul></li>
				</ul>
				<form method="post" action="search" class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input name="bookId" type="text" class="form-control" placeholder="Search by id-number">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Account
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="logout">Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- Main container -->
	<div id="main-container" class="col-xs-8 col-xs-offset-2">
		<div id="messages">
		
		</div>
		<table class="table">
			<tr>
				<th>
					#
				</th>
				<th>
					Cover
				</th>
				<th>
					Title
				</th>
				<th>
					Author
				</th>
				<th>
					Status
				</th>
			</tr>
			<c:forEach var="book" items="${books}">
				<tr>
					<td class="book-cover">
						<c:out value="${book.getId()}"/>
					</td>
					<td class="book-cover">
						<img class="thumbnail" src='<c:out value="resources/images/books/${book.getId()}.jpg"/>' width="50">
					</td>
					<td class="book-title">
						<c:out value="${book.getTitle()}"/>
					</td>
					<td class="book-author">
						<c:out value="${book.getAuthor()}"/>
					</td>
					<td class="book-actions">
						<c:if test="${book.isAvailable()}">
							<button onclick="available(<c:out value="${book.getId()}"/>);" class="btn btn-success"><span class="glyphicon glyphicon-ok-circle"></span> Available</button>
						</c:if>
						<c:if test="${!book.isAvailable()}">
							<button onclick="notAvailable();" class="btn btn-danger"><span class="glyphicon glyphicon-remove-circle"></span> Unavailable</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>