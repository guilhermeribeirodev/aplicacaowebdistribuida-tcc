Ext.define('MyApp.stores.ProdutoStore', {
    extend: 'Ext.data.Store',
    singleton: true,
    requires: ['MyApp.models.Produto'],
    autoLoad: true,
    model: 'MyApp.models.Produto'





});

