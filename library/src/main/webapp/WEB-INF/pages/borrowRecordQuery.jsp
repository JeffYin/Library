<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="borrowRecord.query"/></title>
    <meta name="menu" content="borrowRecordQueryMenu"/>
    
       <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-datepicker.js'/>"></script>
</head>
 
<div class="span2">
    <h2><fmt:message key='borrowRecord.query'/></h2>
</div>
<div class="span7">
    <form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
    <form:form commandName="form" method="post" action="overDueBookQuery" id="borrowRecordForm"  cssClass="well form-horizontal" >
     
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="borrowRecord.dueDate"/>
        <div class="controls">
            
             <div id="borrowDateStart" class="input-append date">
			 <form:input path="borrowDateStart" id="borrowDateStart" placeholder="YYYY-MM-DD"/>
			    <span class="add-on">
			      <i class="icon-calendar"></i>
			    </span>
			 </div>
             <form:errors path="borrowDateStart" cssClass="help-inline"/>
        </div>
    </div>

    </form:form>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['reader']).focus();
     
	    $('.date').datepicker({
	    	format:"yyyy-mm-dd"
	    }); 
    });   
 
    
    
   
</script>

 