Ext.define('MyApp.stores.ClienteStore', {
    extend: 'Ext.data.Store',
    singleton: true,
    requires: ['MyApp.models.Cliente'],
    autoLoad: true,
    model: 'MyApp.models.Cliente'





});

