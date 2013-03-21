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
    <form:form commandName="borrowRecord" method="get" action="checkout" id="borrowItemForm"  cssClass="well form-horizontal" >
     
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
            <input type="text" name="itemBarcode" id="itemBarcode" maxlength="32" placeholder="<fmt:message key='webapp.scan.item.barcode'/>" />
            <form:errors path="item.barcode" cssClass="help-inline"/>
        </div>
    </div>

    
    
    
   
    <div class="form-actions">
        <button type="button" class="btn" name="save">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
   
        <c:if test="${not empty reader.id}">
          <button type="button" class="btn" name="delete">
              <i class="icon-trash"></i> <fmt:message key="button.delete"/>
          </button>
        </c:if>
        <button type="button" class="btn" name="cancel">
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
    });   
 
    
    var itemBarcodeScanned = 'itemBarcodeScanned';
    $("#itemBarcode").keypress(function(e) {
    		if(e.keyCode == 13) {
				 barcode = $("#itemBarcode").val();
				 $.ajax({
					    type: "POST",
						url: "scanItem",
						dataType: "json",
						data: {
							barcode: barcode
							//name_startsWith: request.term
						},
						success: function( data ) {
							var item = data;
							var barcode = item.barcode;

							if (!itemScanned(barcode)) {
								var tr = $("<tr></tr>");

								var inputBarcode = $("<input type='text'>").attr('name', itemBarcodeScanned);
								inputBarcode.val(barcode).appendTo($("<td></td>").html(barcode).appendTo(tr));
								$("<td></td>").html(item.name).appendTo(tr);
								$("<td>Delete</td>").appendTo(tr);
								tr.appendTo("#itemBody");
							}
							$("#itemBarcode").val("");

							},


						error: function(jqXHR, exception) {
				            if (jqXHR.status === 0) {
				                alert('Not connect.\n Verify Network.');
				            } else if (jqXHR.status == 700) {
				                alert('The barcode is NOT found.');
				            } else if (jqXHR.status == 710) {
				                alert('More than one materials are found.');
				            } else if (jqXHR.status == 720) {
				                alert('The material has been reported lost.');
				            } else if (jqXHR.status == 730) {
				                alert('The material is not checked in yet');
				            }else {
				            	alert(jqXHR.responseText);
				            }
				            $("#itemBarcode").val("");
				        }

					});

				 e.stopPropagation();
	    			return false;
    		}
    	});
   
    //Check if the material barcode is scaned or not. 
    function itemScanned(barcode){
   	 var scanned = false; 
   	 $(":input[name='itemBarcodeScanned']").each(function() {
   		 if ($(this).val()==barcode) {
   			 scanned = true; 
   			 return false;
   		 }
   	 });
   	 
   	 return scanned;
    }
    

</script>

 