if (!window.File || !window.FileReader || !window.FileList || !window.Blob) {
	alert('The File APIs are not fully supported in this browser.');
}
var XMLFile;
var courses = [];

function handleFileSelection(evt){
	var files = evt.target.files;
	var found = false;
	var i = 0;
	while(i<files.length && !found){
	    //TODO : Tester si le fichier est bien un fichier xml (on ne prendra que le premier trouvé si selection multiple)
		XMLFile = files[i];
		found = true;
		i++;
	}
}
$('#uploadXML').on('change', handleFileSelection);

function htmlEntities(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '\"');
}

function deleteCourse(name){
	$.ajax({
		url:"http://localhost:8080/ProjectCDM/rest/CDM/courses/"+name,
		type:'DELETE',
		success:function(data){
			$("#annees").empty();
			buildList();
		}
	});
}

function buildList(){
	$.ajax({
			url:"http://localhost:8080/ProjectCDM/rest/CDM/program",
			dataType:'json',
			type:'GET',
			success:function(data){
				for(var index in data.subProgram){
					$('#annees').append("<li class='annee'>"+data.subProgram[index].programName.text+"</li>"+"<ul id='annee"+index+"'></ul>");
				}
			}	
		});
		
		$.ajax({
			url:"http://localhost:8080/ProjectCDM/rest/CDM/courses",
			dataType:'json',
			type:'GET',
			success:function(data){
				for(var index in data){
					if(typeof data[index].courseDescription.subBlock.refCourse !== 'undefined'){
						courses.push({id:data[index].id,name:data[index].courseName.text,year:data[index].level-1});
						/*var num = data[index].level-1;
						$("#cours"+num).append('<li>'+ data[index].courseName.text +'<button type="button" class="btn btn-default" onclick="deleteCourse(\''+data[index].id+'\');">Delete</button></li><ul id="'+data[index].id+'"></ul>');*/

					}
				}
				courses.forEach(function(subCourse){
					$.ajax({
						url:"http://localhost:8080/ProjectCDM/rest/CDM/courses/"+subCourse.id,
						dataType:'json',
						type:'GET',
						success:function(data){
							if(data.length > 0){
								$("#annee"+subCourse.year).append("<li class='parcours'>"+subCourse.name+"</li><ul id='"+subCourse.id+"'></ul>");	
							
								data.forEach(function(course){
									if(course.courseDescription.subBlock.refCourse){
										$("#"+subCourse.id).append("<li class='UC'>"+course.courseName.text+"</li>");
									}else{
										$("#"+subCourse.id).append("<li>"+course.courseName.text+"</li>");
									}
								});
							}
						}
					});
				});
				
			}
		});
}


$("#submitXML").on("click",function(){
	if(typeof XMLFile != 'undefined'){
		var reader = new FileReader();
		reader.readAsText(XMLFile);
		reader.onload = function(evt){
			$.post('http://localhost:8080/enssat/rest/cdms',evt.target.result,'text/plain');
		};
		$("#submitXML").hide();
		buildList();	
	}
});
