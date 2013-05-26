<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="borrowRecord.overDueQuery"/></title>
    <meta name="menu" content="bookOverdueQueryMenu"/>
</head>
 
 
<div class="span10 offset1">
    <h2><fmt:message key='borrowRecord.overDueQuery'/></h2>
     <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/book'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.print"/></a>
    </div>
    
    <table class="table table-hover">
       <thead>
          <tr>
            <th><fmt:message key="item.barcode"/></th>
            <th><fmt:message key="book.title"/></th>
			<th><fmt:message key="borrowRecord.borrowDate"/></th>
			<th><fmt:message key="borrowRecord.dueDate"/></th>
			<th><fmt:message key="reader.name"/></th>
			<th><fmt:message key="reader.cardId"/></th>
          </tr>
       </thead>
         <c:forEach items="${overDueRecordList}" var="record">
          <tr>
            <td>${record.item.barcode}</td>
            <td>${record.item.bibliography.title}</td>
            <td>${record.borrowDate}</td>
            <td>${record.dueDate}</td>
            <td>${record.reader.name}</td>
            <td>${record.reader.cardId}</td>
          </tr>
          </c:forEach>
       <tbody>
       
       </tbody>
    </table>
</div>  

 