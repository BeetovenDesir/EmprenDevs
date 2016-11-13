app.service('camera',function(){

	this.getOptions = function(){
		var options = {
	        // Some common settings are 20, 50, and 100
	        quality: 50,
	        destinationType: Camera.DestinationType.FILE_URI,
	        // In this app, dynamically set the picture source, Camera or photo gallery
	        sourceType: Camera.PictureSourceType.CAMERA,
	        encodingType: Camera.EncodingType.JPEG,
	        mediaType: Camera.MediaType.PICTURE,
	        allowEdit: false,
	        correctOrientation: true  //Corrects Android orientation quirks
	    };
    	return options;
	}


	this.getPhoto = function(req,res){
		var response = {status:'nok',message:'El dispositivo no está listo'};

		if(!window.device){
			return res(response)
		}

		var options = {
	        // Some common settings are 20, 50, and 100
	        quality: 50,
	        destinationType: Camera.DestinationType.FILE_URI,
	        // In this app, dynamically set the picture source, Camera or photo gallery
	        sourceType: Camera.PictureSourceType.CAMERA,
	        encodingType: Camera.EncodingType.JPEG,
	        mediaType: Camera.MediaType.PICTURE,
	        allowEdit: true,
	        correctOrientation: true  //Corrects Android orientation quirks
	    };

	    navigator.camera.getPicture(
	    	function(imageUri) {
	    	response = {status:'ok',imageUri:imageUri};
	        res(response);

	    }, function(error) {

	    	response = {status:'nok',message:"Unable to obtain picture: " + error+ "app"};
	        res(response);
	    },options);


	}
});