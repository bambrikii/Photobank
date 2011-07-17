/*
	SlideItMoo v1.0 - Image slider
	(c) 2007-2008 Constantin Boiangiu <http://www.php-help.ro>
	MIT-style license.
*/
var SlideItMoo = new Class({

	initialize: function(options){
		this.options = $extend({
			showControls: 1,
			autoSlide: 0,
			transition: Fx.Transitions.linear,
			currentElement: 0,
			thumbsContainer: 'thumbs',
			elementScrolled: 'thumb_container',
			overallContainer: 'gallery_container',
			containerSize: 850
		},options || {});

		this.images = $(this.options.thumbsContainer).getElements('a');

		this.setContainersSize();

		this.myFx = new Fx.Scroll(this.options.elementScrolled,{ transition: this.options.transition });

		// adds the forward-backward buttons
		this.fwd = this.addControlers('addfwd');
		this.bkwd = this.addControlers('addbkwd');
		this.forward();
		this.backward();
		if( this.getTailWidth() > this.options.containerSize ){

			/* if autoSlide is not set, scoll on mouse wheel */
			if( !this.options.autoSlide ){
				$(this.options.thumbsContainer).addEvent('mousewheel', function(ev){
					new Event(ev).stop();
					ev.wheel < 0 ? this.fwd.fireEvent('click') : this.bkwd.fireEvent('click');
				}.bind(this));
			}
			else{
				this.startIt = function(){ this.fwd.fireEvent('click') }.bind(this);
				this.autoSlide = this.startIt.periodical(this.options.autoSlide, this);
				this.images.addEvents({
					'mouseover':function(){
						$clear(this.autoSlide);
					}.bind(this),
					'mouseout':function(){
						this.autoSlide = this.startIt.periodical(this.options.autoSlide, this);
					}.bind(this)
				})
			}
		};

		if( this.options.currentElement!==0 ){
			this.options.currentElement-=1;
			this.slide(1);
		}
	},

	getTailWidth: function(){
		var n = 0;
		for(var i = this.options.currentElement; i < this.images.length; i++){
			n += this.images[i].getSize().x + 5 /* image padding, border, ... should be calculated automatically */;
		}
		return n;
	},

	setContainersSize: function(){
		$(this.options.overallContainer).set({
			styles:{
				'width': this.options.containerSize
			}
		});
		$(this.options.elementScrolled).set({
			styles:{
				'width': this.options.containerSize
			}
		});
	},

	forward: function(){
		this.fwd.addEvent('click',function(){
			this.slide(1);
		}.bind(this));
	},

	backward: function(){
		this.bkwd.addEvent('click',function(){
			this.slide(-1);
		}.bind(this))
	},

	addControlers: function(cssClass){
		element = new Element('div',{
			'class': cssClass,
			styles:{
				'display': this.options.showControls ? '' : 'none'
			}
		}).injectInside($(this.options.overallContainer));
		return element;
	},

	slide: function(step){
		if (this.options.autoSlide
				&& this.options.currentElement >= this.images.length) {
			this.options.currentElement = -1;
		}

//alert(document.title + " - " + this.options.currentElement + " " + this.images.length + " " + step + " " + this.options.containerSize + " " + this.getTailWidth());

		var nextElem	= this.options.currentElement + step;
		if(nextElem >= 0 && nextElem <= this.images.length ){
			if(
					(step < 0)
					|| (step > 0 && this.options.containerSize < (this.getTailWidth() ) )
			){
				this.options.currentElement = nextElem;
			}
		}
		this.myFx.toElement(this.images[this.options.currentElement]);
	}
})