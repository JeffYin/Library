<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookDetail.title"/></title>
    <meta name="menu" content="bookMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-fileupload.min.css'/>" />
    
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-fileupload.min.js'/>"></script>
</head>
 
<div class="span2">
    <h2><fmt:message key='bookDetail.heading'/></h2>
</div>
<div class="span7">
    <form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
    <form:form commandName="book" method="post" action="bookform" id="bookForm"
               cssClass="well form-horizontal" enctype="multipart/form-data">
    <form:hidden path="id"/>
     
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.title"/>
        <div class="controls">
            <form:input path="title" id="title" maxlength="50"/>
            <form:errors path="title" cssClass="help-inline"/>
        </div>
    </div>
    
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.callNumber"/>
        <div class="controls">
            <form:input path="callNumber" id="callNumber" maxlength="50"/>
            <form:errors path="callNumber" cssClass="help-inline"/>
        </div>
    </div>
    
    
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.author"/>
        <div class="controls">
            <form:input path="author" id="author" maxlength="50"/>
            <form:errors path="author" cssClass="help-inline"/>
        </div>
    </div>

    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.publisher"/>
        <div class="controls">
            <form:input path="publisher.id" id="publisher" maxlength="254"/>
             <form:errors path="publisher.id" cssClass="help-inline"/>
        </div>
    </div>
    
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.publishedVersion"/>
        <div class="controls">
            <form:input path="publishedVersion" id="publishedVersion" maxlength="4098"/>
          
             <form:errors path="publishedVersion" cssClass="help-inline"/>
        </div>
    </div>
    
    <!--  -->
    
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.price"/>
        <div class="controls">
            <form:input path="price" id="price" maxlength="4098"/>
             <form:errors path="price" cssClass="help-inline"/>
        </div>
    </div>

   
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.briefIntroduction"/>
        <div class="controls">
            <form:textarea path="briefIntroduction" id="briefIntroduction" maxlength="4098"/>
             <form:errors path="briefIntroduction" cssClass="help-inline"/>
        </div>
    </div>
    
    <div class="fileupload fileupload-new" data-provides="fileupload">
	  <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img  src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" /></div>
	  <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
	  <div>
	    <span class="btn btn-file"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input type="file" name="file" id="file"/></span>
	    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
	    <button onclick="alert($('#coverImg').attr('src'))">Test</button>
	  </div>
	</div>

    <div class="form-actions">
        <button type="submit" class="btn btn-primary" name="save">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty book.id}">
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
        $("input[type='text']:visible:enabled:first", document.forms['bookForm']).focus();
        $("#price").inputmask({
        	mask:"999.99"
        });
    });
</script>

 