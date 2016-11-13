app.service("transfer",function(constante){

	this.uploadFile = function(req,res){
		var options = new FileUploadOptions();
		options.fileKey = "file";
		options.fileName="myphoto.jpg";
	 	options.chunkedMode = false;
        options.mimeType = "image/jpg";
        options.headers = {
                   Connection: "close"
                 };

		var ft = new FileTransfer();
		var div = document.getElementById("progress");
		var porcentage = 0;
		ft.onprogress = function(progressEvent) {
		    if (progressEvent.lengthComputable) {
		    	porcentage = (progressEvent.loaded / progressEvent.total);
		        div.innerHTML = porcentage+"%";
		    } else {
		        loadingStatus.increment();
		         div.innerHTML = porcentage++;
		    }
		};
		
		ft.upload(req, encodeURI(constante.urlUpLoad()),
			function(r){
				res({status:"ok", message:r.response});
			},function(error){
				console.log("Error Upload: "+JSON.stringify(error));
				res({status:'nok',message:'No fue posible reconocer la imagen, error'});
			}, options);
	}
})