app.controller("home",function($scope,camera,speaker,transfer){
	$scope.trucho = "auto";
	$scope.trunchar = function(name){
		$scope.trucho = name;

	}

	$scope.sacarFoto = function(){
		var containerResult = document.getElementById("resut-image");
		camera.getPhoto(null,function(response){
			console.log(JSON.stringify(response));
			if(response.status == 'ok'){
				  var img = '<img src="'+response.imageUri+'">';	
				   containerResult.innerHTML = img;
				   if($scope.trucho!= "auto"){
				   		var message = '';
				   		if($scope.trucho == 'cristian'){
				   			message = 'Este es Cristian, está sospechando que las aclaraciones no son de la AI';
				   		}

				   		if($scope.trucho == 'pablo'){
				   			message = 'Este es Pablo, está despeinado';
				   		}

				   		if($scope.trucho == 'beethoven'){
				   			message = 'Este es Beethoven, no es músico clasico';
				   		}

				   		if($scope.trucho == 'falconiere'){
				   			message = 'Este es Falconiere, está haciendo una demo';
				   		}

				   		speaker.talk({text:message},
							   	function(response){

							});

				   	return;
				   }

				   transfer.uploadFile(response.imageUri,function(res){

				   		if(res.status == "ok"){
				   			var json = JSON.parse(res.message);
				   			var message = json.message;
				   			 speaker.talk({text:message},
							   	function(response){

							});

				   		}else{

				   			var message = res.message;
				   			 speaker.talk({text:message},
							   	function(response){

							});
				   		}

				   		 
				   });


				   	 
			}
		});
	}
});