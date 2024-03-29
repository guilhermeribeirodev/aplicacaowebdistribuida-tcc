Ext.define('MyApp.models.Cliente', {
    extend    : 'Ext.data.Model',

    fields   : [


        'nome',
        'documento',
        'idade',
        { name:'criacao', type: 'date', dateFormat: 'm-d-Y g:i A'}



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
