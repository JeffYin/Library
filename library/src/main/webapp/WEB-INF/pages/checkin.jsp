<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.checkout"/></title>
    <meta name="menu" content="checkoutMenu"/>
</head>
 
<div class="span2">
    <h2><fmt:message key='menu.checkin'/></h2>
</div>
<div class="span7">
    <form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
    <form:form commandName="borrowRecord" method="post" action="checkin" id="borrowItemForm"  cssClass="well form-horizontal" >
     
    <div class="control-group">
        <appfuse:label styleClass="control-label" key="item.barcode"/>
        <div class="controls">
            <input type="text" name="itemBarcode" id="itemBarcode" maxlength="32" placeholder="<fmt:message key='webapp.scan.item.barcode'/>" />
            <form:errors path="item.barcode" cssClass="help-inline"/>
        </div>
    </div>

    <div class="control-group">
        <div class="controls" id="divScannedItems">
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
 
    
    
    
    var itemBarcodeScanned = 'itemBarcodeScanned';
    $("#itemBarcode").keypress(function(e) {
    		if(e.keyCode == 13) {
				 barcode = $("#itemBarcode").val();
				 $.ajax({
					    type: "POST",
						url: "scanCheckinItem",
						dataType: "json",
						data: {
							barcode: barcode
							//name_startsWith: request.term
						},
						success: function( data ) {
							var item = data.item;
							var reader = data.reader; 
							
							
							//TODO: display the information. 
							var bibliography = item.bibliography;
							var title = bibliography.title; 
							var barcode = item.barcode; 
							
							//Get Reader Inforamtion
							var readerName = reader.name
							var libraryCardId = reader.cardId
							
							var bookInfoLabel = $("<label />").text("Item Info: "+barcode + ":" +title);
							bookInfoLabel.appendTo("#divScannedItems");
							
							var bookInfoLabel = $("<label />").text("Reader Info: "+libraryCardId+ ":" +readerName);
							bookInfoLabel.appendTo("#divScannedItems");
							
							$("<p>----------------------------------------</p>").appendTo("#divScannedItems");
							
								
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
				            } else if (jqXHR.status == 200) {
				                alert('The item is reported on the book shelf. ');
				            } else {
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
    
    function submit() {
    	$("borrowItemForm").submit(); 
    }

</script>

 