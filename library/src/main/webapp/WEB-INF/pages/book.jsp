<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="bookDetail.title"/></title>
    <meta name="menu" content="bookMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-fileupload.min.css'/>" />
    
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-fileupload.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-typeahead.js'/>"></script>
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
            <input type="text" id="publisherName" value="${book.publisher.name}" data-provide="typeahead">
            <form:input path="publisher.id" id="publisherId" maxlength="254" autocomplete="true"/>
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
        $("input[type='text']:visible:enabled:first", document.forms['book']).focus();
               
        $("#publisherName").typeahead({
        	/*
        	source: [
        	            { ID: 1, Name: 'Toronto' },
        	            { ID: 2, Name: 'Montreal' },
        	            { ID: 3, Name: 'New York' },
        	            { ID: 4, Name: 'Buffalo' },
        	            { ID: 5, Name: 'Boston' },
        	            { ID: 6, Name: 'Columbus' },
        	            { ID: 7, Name: 'Dallas' },
        	            { ID: 8, Name: 'Vancouver' },
        	            { ID: 9, Name: 'Seattle' },
        	            { ID: 10, Name: 'Los Angeles' }
        	        ],
        	        display: 'Name',
        	        val: 'ID'
        	  */
        	  
        	  /*
        	 ajax: { url: 'publishers', 
        		 method:'GET',
                 triggerLength: 1 
                 },
                 
                 
             itemSelected:function(item){
            	 alert(item.text +":"+item.val);
             },
             
             display: 'name',
    	     val: 'id'
             */
             
        	 source: function (typeahead, query) {
        	    $.ajax({
        	    	url:'publishers',
        	    	type: 'GET',
        	    	data: 'query=' + query,
        	    	dataType: 'JSON',
        	    	async: false,
        	    	success: function(data) {
        	    		//var item = JSON.parse(data);
        	    		//alert(item.name);
        	    		publisherNames=[]; 
        	    		$.each(data, function(index, data) {
        	    		    console.log(data.name+":"+data.id);
        	    		    publisherNames.push(data.name);
						});
        	    		typeahead.process(publisherNames);
        	    	}
        	    });   
        	 }
                 
        }); 
    });
</script>

 