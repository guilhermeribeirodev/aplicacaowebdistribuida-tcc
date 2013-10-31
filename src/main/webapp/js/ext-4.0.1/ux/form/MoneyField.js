Ext.define('Ext.ux.form.MoneyField', {
	extend: 'Ext.form.field.Text',
	alias: ['widget.moneyfield'],
	autocomplete: 'off',
	allowNegative: false,
	format: 'BRL',
	currency: 'R$',
	showCurrency: true,
	KEY_RANGES : { padnum: [96, 105], numeric: [48, 57] },
	initComponent: function() {
		if (this.allowZero == false) {
			this.validator = function(value) {
                        return this.getValue() == 0 ? 'Valor Inv&aacute;lido' : true;
            }
		}
        this.callParent();
    },
  	initEvents: function() {	
		this.callParent();
		if (!this.readOnly) {			
			this.inputEl.on('keyup', this.mapCurrency, this); 
			this.inputEl.on('keydown',this.stopEventFunction, this);
			this.inputEl.on('keypress', this.stopEventFunction, this);
		}
		this.inputEl.setStyle({ 
			textAlign : 'right' 
		});
	},
	clear: function() {
		if (this.getValue() == 0.00) {
			this.setValue('');
		}
	},	
	setValue: function(value) {		
		if (Ext.isDefined(value) && Ext.isNumber(value)) {
			value = Ext.util.Format.number(value, '0.000,00/i');
		}
		this.callParent([value]);
	},
	getValue: function() {
		var value = this.callParent();
		if (!Ext.isEmpty(value)) {
			return parseFloat(value.replace(/\./g, '').replace(/,/g, '.'));
		}
		else {
			return undefined;
		}
	},
	getSubmitValue: function() {
		return this.getValue();
	},
	isInRange: function(charCode, range) { 
		return charCode >= range[0] && charCode <= range[1]; 
	},	
	formatCurrency: function(evt, floatPoint, decimalSep, thousandSep) {		
		floatPoint  = !isNaN(floatPoint) ? Math.abs(floatPoint) : 2;
		thousandSep = typeof thousandSep != 'string' ? ',' : thousandSep;
		decimalSep  = typeof decimalSep != 'string' ? '.' : decimalSep;
		var key = evt.getKey();
		if (this.isInRange(key, this.KEY_RANGES['padnum'])) { 
			key -= 48; 
		}
		this.sign = (this.allowNegative && (key == 45 || key == 109)) ? '-' : (key == 43 || key == 107 || key == 16) ? '' : this.sign;	
		var character = (this.isInRange(key, this.KEY_RANGES['numeric']) ? String.fromCharCode(key) : '');	    
		var field = this.inputEl.dom;
		var value = (field.value.replace(/\D/g, '').replace(/^0+/g, '') + character).replace(/\D/g, '');
		var length = value.length;																				
		if (character == '' && length > 0 && key == 8) {
			length--;
			value = value.substr(0,length);
			evt.stopEvent();
		}	
		if(field.maxLength + 1 && length >= field.maxLength) return false;
		length <= floatPoint && (value = new Array(floatPoint - length + 2).join('0') + value);
		for(var i = (length = (value = value.split('')).length) - floatPoint; (i -= 3) > 0; value[i - 1] += thousandSep);
		floatPoint && floatPoint < length && (value[length - ++floatPoint] += decimalSep);
		field.value = (this.showCurrency && this.currencyPosition == 'left' ? this.currency : '' ) +
		(this.sign ? this.sign : '') + value.join('') + (this.showCurrency && this.currencyPosition != 'left' ? this.currency : '' );            
	},
	mapCurrency: function(evt) {
		switch (this.format) {
			case 'BRL':
				this.currency = '';
				this.currencyPosition = 'left';
				this.formatCurrency(evt, 2,',','.'); 
				break;
			case 'EUR':
				this.currency = ' �';
				this.currencyPosition = 'right';
				this.formatCurrency(evt, 2,',','.'); 
				break;
			case 'USD':
				this.currencyPosition = 'left';
				this.currency = '$';
				this.formatCurrency(evt, 2); 
				break;
			default: 
				this.formatCurrency(evt, 2); 
		} 
	},
	stopEventFunction: function(evt) {
		var key = evt.getKey();
		if (this.isInRange(key, this.KEY_RANGES['padnum'])) { 
			key -= 48; 
		}
		if ((( key>=41 && key<=122 ) || key==32 || key==8 || key>186) && (!evt.altKey && !evt.ctrlKey) ) {
			evt.stopEvent(); 
		}
	},
	getCharForCode: function(keyCode){
		var chr = '';
		switch(keyCode) {
			case 48: case 96:
				chr = '0';
				break;			
			case 49: case 97:
				chr = '1';
				break;			
			case 50: case 98:
				chr = '2';
				break;			
			case 51: case 99:
				chr = '3';
				break;			
			case 52: case 100:
				chr = '4';
				break;			
			case 53: case 101:
				chr = '5';
				break;			
			case 54: case 102:
				chr = '6';
				break;			
			case 55: case 103:
				chr = '7';
				break;			
			case 56: case 104:
				chr = '8';
				break;			
			case 57: case 105:
				chr = '9';
				break;			
			case 45: case 189: case 109:
				chr = '-';
				break;			
			case 43: case 107: case 187:
				chr = '+';
				break;			
			default:
				chr = String.fromCharCode(keyCode);
				break;
		}		
		return chr;
	}
});
