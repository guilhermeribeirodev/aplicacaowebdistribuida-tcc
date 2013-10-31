Ext.define('MyApp.models.Cliente', {
    extend    : 'Ext.data.Model',

    fields   : [


        'nome',
        'documento',
        'idade'



    ],

    proxy: {
        type: 'rest',
        url : '/clientes'

    },

    reader: {
        type: 'json',
        root: 'data'
    },

    writer: {
        type: 'json'
    }



});
