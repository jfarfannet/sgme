/*
 * Creado por ebc erick benites erickpm (01-03-2015): http://learn.jquery.com/plugins/basic-plugin-creation/
 * Generador de sprites.png: http://preloaders.net/en/popular (escoger APNG (de dimension 'NxN' sino declarar settings.frames) con javascript y solo considerar el sprites.png )
 * De preferencia una imagen que r
 */
(function ( $ ) {

    $.fn.preloader = function( options ) {
        
        var element = this;
        
        var settings = $.extend({
            src: 'sprites.png', 
            frames: false,
            speed: false,
            width: false, 
            height: false,
            center: true
        }, options );
        
        var genImage = new Image();
        genImage.onload=function (){
            
            var frames = (settings.frames)?settings.frames:genImage.width/genImage.height;
            var width = (settings.width)?settings.width:genImage.width/frames;
            var height = (settings.height)?settings.height:genImage.height;
            var speed = (settings.speed)?settings.speed:frames;
            
            var slide = 0;
            
            element.css('width', width+'px');
            element.css('height', height+'px');
            element.css('background-image', 'url('+settings.src+')');
            
            if(settings.center){
            	element.css('position', 'fixed');
            	element.css('left', '50%');
            	element.css('top', '50%');
            	element.css('marginLeft', -1*(width/2) + 'px');
            	element.css('marginTop', -1*(height/2) + 'px'); 
            }
            
            if(!$(element).parent().length){
            	$(document.body).append(element);
            }
            
            var timer = setInterval(function(){
                element.css('background-position', (-slide)+'px 0');
                slide += width;
                if(slide >=  frames*width)
                    slide = 0;
                // Limpiar el intervalo cuando se elimina el loader con .remove()
                if(element.parent().length === 0)
                    clearInterval(timer);
            }, 1000/speed);
            
            genImage = null;
            
        };
        genImage.onerror=function(){
            if(console) console.log('No se pudo cargar el preloader');
        };
        genImage.src=settings.src;
        
        return this;
    }

}( jQuery ));

$(function(){
	//How to use:
	//var loader = $('<div/>').preloader({src:'/campus/img/preloaders/sprites.png'});	// SI: WITDH/HEIGHT != FRAMES => INDICAR: {settings.frames: x}
	//loader.remove();
});