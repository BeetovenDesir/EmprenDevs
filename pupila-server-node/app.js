var express = require("express");
var fileUpload = require('express-fileupload');
var watson = require('watson-developer-cloud');
var VisualRecognitionV3 = require('watson-developer-cloud/visual-recognition/v3');
var LanguageTranslatorV2 = require('watson-developer-cloud/language-translator/v2');
var fs = require('fs');
var app = express();

app.use(fileUpload());

var visual_recognition = watson.visual_recognition({
  api_key: '4995c43d330ff8aec9abe341eabbec1405aeebae',
  version: 'v3',
  version_date: '2016-05-20'
});

var language_translator =  new LanguageTranslatorV2({
  username: '03b42a86-8da2-43d6-ac3a-461b81a6948a',
  password: '8aOV6NmiSaZE',
  url: 'https://gateway.watsonplatform.net/language-translator/api/'
});

var json_return  = {"status":"nok","message":"No fue posible reconocer la imagen,server"};
function traducir(texto,callbak){
	  language_translator.translate(
	  	{text: texto, source : 'en', target: 'es' },
     	function (err, translation) {
	    if (err){
    		callbak(json_return);
	      	console.log('error:', err);
	    }else{
	      callbak(translation);
	      console.log(JSON.stringify(translation, null, 2));
  			}
		}
	  
	);
}


app.post("/upload",function(req,res){
	var sampleFile;
 	
 	
    if (!req.files) {
    	console.log('No files were uploaded.');
        res.send(json_return);
        return;
    }
 
    sampleFile = req.files.file;

    sampleFile.mv(__dirname+'/upload/filename.jpg', function(err) {
        if (err) {
        	res.send(json_return);
        }
        else {
        	var params = {
  				images_file: fs.createReadStream(__dirname+'/upload/filename.jpg')
			};

			visual_recognition.classify(params,
			  function(err, response) {
			    if (err){
			    res.send(json_return);
			      console.log(err);
			    }
			    else{
			    	
			    	if(response.images.length > 0 
			    		&& response.images[0].classifiers.length > 0
			    		&& response.images[0].classifiers[0].classes[0].class.length > 0){
			    		var name =  response.images[0].classifiers[0].classes[0].class;
			    		console.log('nombre para traducir: '+name);
			    		json_return = {"status":"ok","message":"Esto es un o una: "+ name};
			    		//res.send(json_return);
			    		var sendM = res;
			    		traducir(name,function(traducido){
			    			console.log("Nombre traducido: "+JSON.stringify(traducido, null, 2));
			    			json_return = {"status":"ok","message":"Esto es un o una: "+ traducido.translations[0].translation};
			    			sendM.send(json_return);
			    		})

					}else{
						res.send(json_return);
					}

			      console.log(JSON.stringify(response, null, 2));
			  }
		  });

        	json_return  = {"status":"ok","message":"es una persona"};
        	
            
        }
    });
});


app.listen("3000","10.10.11.118",function(req,res){
	console.log("olá");
});