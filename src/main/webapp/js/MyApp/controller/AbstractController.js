Ext.define('MyApp.controller.AbstractController', {
    extend: 'Ext.app.Controller',
    requires: [
        'Packt.util.Util'
    ],
    stores: [

        'MyApp.stores.ClienteStore.js',
        'MyApp.stores.ComposicaoStore.js',
        'MyApp.stores.CompraStore.js',
        'MyApp.stores.FracionadoStore.js',
        'MyApp.stores.FuncionarioStore.js',
        'MyApp.stores.InteiroStore.js',
        'MyApp.stores.ItemStore.js',
        'MyApp.stores.PerdaStore.js',
        'MyApp.stores.ProcessadoStore.js',
        'MyApp.stores.ProdutoStore.js',
        'MyApp.stores.UserStore.js'
    ],
    views: [


        'MyApp.views.compra.CompraFormPanel.js',
        'MyApp.views.compra.CompraGridPanel.js',
        'MyApp.views.compra.ItemsCompraGridPanel.js',

        'MyApp.views.configuracao.ConfiguracaoFormPanel.js',

        'MyApp.views.item.ItemFormPanel.js',
        'MyApp.views.item.ItemGridPanel.js',

        'MyApp.views.perda.PerdaFormPanel.js',
        'MyApp.views.perda.PerdaGridPanel.js',

        'MyApp.views.processado.CompraProcessadoGridPanel.js',
        'MyApp.views.processado.ProcessadoFormPanel.js',
        'MyApp.views.processado.ProcessadoGridPanel.js',

        'MyApp.views.produto.ComposicaoFormPanel.js',
        'MyApp.views.produto.ComposicaoGridPanel.js',
        'MyApp.views.produto.FracionadoFormPanel.js',
        'MyApp.views.produto.InteiroFormPanel.js',
        'MyApp.views.produto.InteiroGridPanel.js',
        'MyApp.views.produto.ProdutoFormPanel.js',
        'MyApp.views.produto.ProdutoGridPanel.js'
    ],
    init: function(application) {
        this.control({
        });
    }
});
