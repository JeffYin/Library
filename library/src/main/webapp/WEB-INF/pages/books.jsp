<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookList.title"/></title>
    <meta name="menu" content="bookMenu"/>
</head>
<div class="span10">
    <h2><fmt:message key='bookList.heading'/></h2>
    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/book'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a class="btn" href="<c:url value='/mainMenu'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
    
    <div class="container row">
        <ul class="thumbnails">
		  <li class="span4">
		    <a href="#" class="thumbnail">
		      <img src="<c:url value='/bibliography/cover/1'/>" alt="">
		    </a>
		    <p>A Good Book</p>
		  </li>
		  
		  <li class="span4">
		    <a href="#" class="thumbnail">
		      <img src="http://thumb10.shutterstock.com/thumb_small/449008/449008,1297430316,3/stock-photo-sad-child-looking-out-of-the-window-71121943.jpg/300x200" alt="">
		    </a>
		    <p>A Good Book</p>
		  </li>
		  
		  <li class="span4">
		    <a href="#" class="thumbnail">
		      <img src="http://thumb10.shutterstock.com/thumb_small/449008/449008,1297430316,3/stock-photo-sad-child-looking-out-of-the-window-71121943.jpg/300x200" alt="">
		    </a>
		    <p>A Good Book</p>
		  </li>
		  
		  
		</ul>  
       
    </div>
    <display:table name="bookList" class="table table-condensed table-striped table-hover" requestURI="" id="bookList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="book" media="html"
            paramId="id" paramProperty="id" titleKey="book.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="book.id"/>
        <display:column property="title" sortable="true" titleKey="title"/>
        <display:column property="author" sortable="true" titleKey="author"/>
        
        <display:setProperty name="paging.banner.item_name"><fmt:message key="bookList.book"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="bookList.books"/></display:setProperty>
        <display:setProperty name="export.excel.filename"><fmt:message key="bookList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="bookList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="bookList.title"/>.pdf</display:setProperty>
    </display:table>
</div>