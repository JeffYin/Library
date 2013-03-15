<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="readerList.title"/></title>
    <meta name="menu" content="readMenu"/>
</head>
<div class="span10 offset1">
    <h2><fmt:message key='readerList.heading'/></h2>
    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/reader'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn" href="<c:url value='/mainMenu'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
    
  
     <div class="container row">
        <ul class="thumbnails">
	    <c:forEach items="${readerList}" var="book">
	  		<li class="span3">
			    <a href="book?id=${reader.id}" class="thumbnail">
				    <h4 align="center">${reader.cardId}</h4>
				    <h4 align="center">${reader.name}</h4>
				</a>
		   </li>
	    </c:forEach>
	    </ul>
	  </div>
   
</div>