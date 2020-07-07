/**
 * 
 */

$(document).ready(function() {
	$('.delete-cloth').on('click', function (){
		/*<![CDATA[*/
	    var path = /*[[@{/}]]*/'remove';
	    /*]]>*/
		
		var id=$(this).attr('id');
		
		bootbox.confirm({
			message: "Are you sure to remove this cloth? It can't be undone.",
			buttons: {
				cancel: {
					label:'<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label:'<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(confirmed) {
				if(confirmed) {
					$.post(path, {'id':id}, function(res) {
						location.reload();
					});
				}
			}
		});
	});
	
	
	

	
	$('#deleteSelected').click(function() {
		var idList= $('.checkboxCloth');
		var clothIdList=[];
		for (var i = 0; i < idList.length; i++) {
			if(idList[i].checked==true) {
				clothIdList.push(idList[i]['id'])
			}
		}
		
		console.log(clothIdList);
		
		/*<![CDATA[*/
	    var path = /*[[@{/}]]*/'removeList';
	    /*]]>*/
	    
	    bootbox.confirm({
			message: "Are you sure to remove all selected cloths? It can't be undone.",
			buttons: {
				cancel: {
					label:'<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label:'<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(confirmed) {
				if(confirmed) {
					$.ajax({
						type: 'POST',
						url: path,
						data: JSON.stringify(clothIdList),
						contentType: "application/json",
						success: function(res) {
							console.log(res); 
							location.reload()
							},
						error: function(res){
							console.log(res); 
							location.reload();
							}
					});
				}
			}
		});
	});
	
	$("#selectAllCloths").click(function() {
		if($(this).prop("checked")==true) {
			$(".checkboxCloth").prop("checked",true);
		} else if ($(this).prop("checked")==false) {
			$(".checkboxCloth").prop("checked",false);
		}
	})
});