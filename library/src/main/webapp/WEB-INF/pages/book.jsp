<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookDetail.title"/></title>
    <meta name="menu" content="bookMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-fileupload.min.css'/>" />
    
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-fileupload.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-typeahead.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-datepicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/jquery.price_format.1.7.js'/>"></script>
</head>
 
<div class="span2">
    <h2><fmt:message key='bookDetail.heading'/></h2>
</div>
<div class="span7">
    <form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
    <form:form commandName="book" method="post" action="book" id="book"
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
            <form:input path="publisher" id="publisher" maxlength="254" autocomplete="true"/>
             <form:errors path="publisher" cssClass="help-inline"/>
        </div>
    </div>

    <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.publishedDate"/>
        <div class="controls">
            <div id="datetimepicker1" class="input-append date">
			     <form:input path="publishedDate" id="publishedDate" placeholder="YYYY-MM-DD"/>
			    <span class="add-on">
			      <i class="icon-calendar"></i>
			    </span>
			 </div>
             <form:errors path="publishedDate" cssClass="help-inline"/>
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
             <form:textarea path="briefIntroduction" id="briefIntroduction" maxlength="4098" rows="6"/>
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
        $("input[type='text']:visible:enabled:first", document.forms['book']).focus();
               
        $("#publisher").typeahead({
        	 source: function (typeahead, query) {
        	    $.ajax({
        	    	url:'publishers',
        	    	type: 'GET',
        	    	data: 'query=' + query,
        	    	dataType: 'JSON',
        	    	async: false,
        	    	success: function(data) {
        	    		typeahead.process(data);
        	    	}
        	    });   
        	 } ,
        	
        	 property:'name' /* The publisher name should be displayed */
        }); 
    });
    
    $('.date').datepicker({
    	format:"yyyy-mm-dd"
    }); 
    
    $('#price').priceFormat({
        prefix: '',
        thousandsSeparator: ''
    });
</script>

 