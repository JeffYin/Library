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
    
    
    <table class="table table-hover table-striped ">
        <thead>
                <tr>
                  <th>#</th>
                  <th><fmt:message key="reader.name"/></th>
                  <th><fmt:message key="reader.cardId"/></th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${readerList}" var="reader" varStatus="status">
                 <tr>
                   <td>${status.index}</td>
                   <td>${reader.name}</td>
                   <td>${reader.cardId}</td>
                 </tr>
               </c:forEach>
              </tbody>     
     </table>
</div>