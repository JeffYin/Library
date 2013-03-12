<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="bookDetail.title"/></title>
    <meta name="menu" content="bookMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-fileupload.min.css'/>" />
    
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-fileupload.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-typeahead.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-datepicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/jquery.price_format.1.7.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap.2.3.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap-confirm.js'/>"></script>
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

	 <div class="control-group">
        <appfuse:label styleClass="control-label" key="book.tags"/>
        <div class="controls">
            <c:forEach items="${tags}" var="tag" varStatus="status">
            
             <c:if test="${jfn:contains(book.tags, tag) }">
                <c:set var="spanClasses">btn btn-success btn-large</c:set>
                <c:set var="tagValue">${tag.name}</c:set>
             </c:if>
             
              <c:if  test="${not jfn:contains(book.tags, tag) }">
                <c:set var="spanClasses">btn btn-large</c:set>
                <c:set var="tagValue"></c:set>
              </c:if>
             
			   <span id="${tag.id}"  class="${spanClasses}" onclick="toggle(this, 'btn-success')">${tag.name}</span>
			   <input id="tag_${tag.id}" type="hidden" name="bookTags" value="${tagValue}" />

			</c:forEach>
        </div>
    </div>
    
    
	 <div class="control-group">
        <appfuse:label styleClass="control-label" key="item.barcode"/>
        <div class="controls" id="divForBarcodes">
             <input id="barcodeIndex" type="hidden" value="${fn:length(book.items)}">
            <c:forEach items="${book.items}" var="item" varStatus="status">
               <input id="tempItems[${status.index}].barcode" name="tempItems[${status.index}].barcode" value="${item.barcode}" placeholder="Scan Barcode" />
               <input id="tempItems[${status.index}].id" type="hidden" name="tempItems[${status.index}].id" value="${item.id}" />
               <a id="barcodeAnchor_${status.index}" href="javascript:removeBarcode(${status.index})"><i class="icon-large icon-trash"></i></a>
			</c:forEach>
			<a id="newBarcodeAnchor" class="btn btn-default" href="javascript:addBarcode()"><i class="icon-plus-sign icon-large"></i><i class="icon-barcode icon-large"></i><fmt:message key="webapp.new"/></a>
        </div>
    </div>
    
     
    <div class="fileupload fileupload-new" data-provides="fileupload">
	  <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img  src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" /></div>
	  <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
	  <div>
	    <span class="btn btn-file"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input type="file" name="file" id="file"/></span>
	    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
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
   
     <div id="confirmDiv" >
   
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
    
    var toggle= function(tagEl, classNameStr) {
    	$(tagEl).toggleClass(classNameStr); 
        var input = document.getElementById('tag_'+tagEl.id);
        if(tagEl.className.indexOf(classNameStr) > -1) {
            input.value = $(tagEl).text();
        } else {
            input.value = '';
        }
    }
    
    function addBarcode() {
    	//$("#divForBarcodes")
    	var nextIndex = parseInt($("#barcodeIndex").val())+1; 
    	$("<input id='tempItems["+nextIndex+"].barcode' name='tempItems["+nextIndex+"].barcode' value='' placeholder='Scan Barcode'/>").insertBefore($("#newBarcodeAnchor")); 
        $("<input id='tempItems["+nextIndex+"].id' type='hidden' name='tempItems["+nextIndex+"].id' value='' />").insertBefore($("#newBarcodeAnchor"));
        $("<a id='barcodeAnchor_"+nextIndex+"' href='javascript:removeBarcode("+nextIndex+")'><i class='icon-large icon-trash'></i></a>").insertBefore($("#newBarcodeAnchor"));
        $("#barcodeIndex").val(nextIndex); 
    }

    function removeBarcode(barcodeIndex) {
    	//$("#divForBarcodes")
    	
    	var barcodeBarcodeInputId="#tempItems\\["+barcodeIndex+"\\]\\.barcode";
    	var barcodeIdInputId="#tempItems\\["+barcodeIndex+"\\]\\.id";
    	
    	var barcode = $(barcodeBarcodeInputId).val();
    	barcode =$.trim(barcode);
    	if (barcode!="") {
    		$("#confirmDiv").confirmModal({
    			heading:'<fmt:message key="webapp.confirm" />',
    			body:'<fmt:message key="item.barcode.confirmDelete"/>',
    			callback: function() {
    				$(barcodeBarcodeInputId).remove(); 
    		    	$(barcodeIdInputId).remove(); 
    		    	
    		    	$("#barcodeAnchor_"+barcodeIndex).remove(); 
    			 }
    		});
    	} else {
    		$(barcodeBarcodeInputId).remove(); 
	    	$(barcodeIdInputId).remove(); 
	    	
	    	$("#barcodeAnchor_"+barcodeIndex).remove(); 
    	}
    	
    }
    
    
    
</script>

 