app.service("speaker",function(){

	this.talk = function(req,res){
    // or with more options
    TTS.speak({
            text:req.text,
            locale: 'es-ES',
            rate: 1
        }, function () {
            
        }, function (reason) {

        });
	}


})