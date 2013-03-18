<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.checkout"/></title>
    <meta name="menu" content="checkoutMenu"/>
    
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap.2.3.1.js'/>"></script>
</head>
 
<div class="span2">
    <h2><fmt:message key='menu.checkout'/></h2>
</div>
<div class="span7">
    <form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
    <form:form commandName="borrowRecord" method="post" action="checkout" id="borrowItemForm"  cssClass="well form-horizontal" >
     
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="reader.cardId"/>
        <div class="controls">
            <input type="text" name="reader.cardId" id="cardId" maxlength="50" placeholder="<fmt:message key='webapp.scan.librarycard'/>"/>
            <form:errors path="reader.cardId" cssClass="help-inline"/>
        </div>
    </div>

    <div class="control-group">
        <appfuse:label styleClass="control-label" key="item.barcode"/>
        <div class="controls">
            <input type="text" name="item.barcode" id="cardId" maxlength="32" placeholder="<fmt:message key='webapp.scan.item.barcode'/>" />
            <form:errors path="item.barcode" cssClass="help-inline"/>
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

 