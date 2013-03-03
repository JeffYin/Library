<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookList.title"/></title>
    <meta name="menu" content="bookMenu"/>
</head>
<div class="span10 offset1">
    <h2><fmt:message key='bookList.heading'/></h2>
    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/book'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn" href="<c:url value='/mainMenu'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
    
  
     <div class="container row">
        <ul class="thumbnails">
	    <c:forEach items="${bookList}" var="book">
	  		<li class="span3">
			    <a href="book?id=${book.id}" class="thumbnail">
			      <img src="<c:url value='/bibliography/cover/${book.id}'/>" alt="">
				    <h4 align="center">${book.title}</h4>
				    <h4 align="center">${book.author} - ${book.publisher}</h4>
					<p>${book.briefIntroduction}</p>
				</a>
		   </li>
	    </c:forEach>
	    </ul>
	  </div>
   
</div>