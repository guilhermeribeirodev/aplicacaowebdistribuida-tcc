Ext.define('MyApp.views.produto.ProdutoGridPanel', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.ProdutoGridPanel',
    requires: [
        'MyApp.stores.ProdutoStore',
        'MyApp.models.Produto'

    ],


    stripeRows: true,
    cls: 'grid-row',
    columnLines: true,
    selType: 'rowmodel',

    renderTo: document.body,

    emptyText: 'Nenhum produto encontrado! ',


    initComponent: function () {
        this.store = MyApp.stores.ProdutoStore;
        this.columns = this.buildColumns();
        this.callParent();

    },
    buildColumns: function () {
        return [

            { header: 'Nome', dataIndex: 'nome', flex: 1 },

            { header: 'Valor', dataIndex: 'valor', flex: 1 },

            { header: 'Serie', dataIndex: 'serie', flex: 1 },



            {
                xtype: 'actioncolumn',
                width: 60,
                align: 'center',
                sortable: false,
                menuDisabled: true,
                header: 'Excluir',
                items: [
                    { icon: 'img/trash.png',
                        handler: function (grid, rowIndex, colIndex) {


                            Ext.MessageBox.confirm({

                                title:'Remover produto',
                                msg: 'Deseja realmente remover este produto ?',
                                buttonText: {yes: "Remover",cancel: "Cancelar"},
                                fn: function(btn){
                                    console.log('you clicked: ',btn); //you clicked:  yes
                                    if (btn === 'yes') {

                                        var produto = MyApp.stores.ProdutoStore.getAt(rowIndex)

                                        MyApp.stores.ProdutoStore.remove(produto)

                                        MyApp.stores.ProdutoStore.sync();
                                    }
                                    else {
                                        return;
                                    }
                                }


                            });


                        }
                    }
                ]
            }
        ]

    },

   /* plugins: [{
        ptype: 'rowexpander',
        rowBodyTpl : [


            '<p><b>Nome:</b> {nome}</p>'

            ]

        }


    ],
*/
    listeners: {
        selectionchange: function(model, records) {





        }
    }


});
