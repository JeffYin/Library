<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="reader.detail.title"/></title>
    <meta name="menu" content="readerMenu"/>
    
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-typeahead.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-datepicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap.2.3.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-confirm.js'/>"></script>
</head>
 
<div class="span2">
    <h2><fmt:message key='reader.detail.title'/></h2>
</div>
<div class="span7">
    <form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
    <form:form commandName="reader" method="post" action="reader" id="reader"
               cssClass="well form-horizontal" enctype="multipart/form-data">
    <form:hidden path="id"/>
     
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="reader.name"/>
        <div class="controls">
            <form:input path="name" id="name" maxlength="50"/>
            <form:errors path="name" cssClass="help-inline"/>
        </div>
    </div>
    
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="reader.cardId"/>
        <div class="controls">
            <form:input path="cardId" id="cardId" maxlength="50"/>
            <form:errors path="cardId" cssClass="help-inline"/>
        </div>
    </div>
    
    
   
    <div class="form-actions">
        <button type="submit" class="btn btn-primary" name="save">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
   
        <c:if test="${not empty reader.id}">
          <button type="submit" class="btn" name="delete">
              <i class="icon-trash"></i> <fmt:message key="button.delete"/>
          </button>
        </c:if>
        <button type="submit" class="btn" name="cancel">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
   
     <div id="confirmDiv" >
   
     </div> 
    </form:form>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['reader']).focus();
               
     
	    $('.date').datepicker({
	    	format:"yyyy-mm-dd"
	    }); 
	    
    }
   
    
</script>

 