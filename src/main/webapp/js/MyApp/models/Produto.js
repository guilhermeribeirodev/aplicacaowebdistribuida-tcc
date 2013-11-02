Ext.define('MyApp.models.Produto', {
    extend    : 'Ext.data.Model',

    fields   : [


        'nome',
        'valor',
        'serie'



    ],

    proxy: {
        type: 'rest',
        url : '/produtos'

    },

    reader: {
        type: 'json',
        root: 'data'
    },

    writer: {
        type: 'json'
    }



});
