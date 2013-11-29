Ext.define('MyApp.views.cliente.ClienteGridPanel', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.ClienteGridPanel',
    requires: [
        'MyApp.stores.ClienteStore',
        'MyApp.models.Cliente',
        //'Ext.ux.RowExpander',
        'MyApp.views.cliente.ClienteFormPanel'

    ],


    stripeRows: true,
    cls: 'grid-row',
    columnLines: true,
    selType: 'rowmodel',
    height: 200,
    renderTo: document.body,

    emptyText: 'Nenhum cliente encontrado! ',


    initComponent: function () {
        this.store = MyApp.stores.ClienteStore;
        this.columns = this.buildColumns();
        this.callParent();

    },
    buildColumns: function () {
        return [

            { header: 'Nome', dataIndex: 'nome', flex: 1 },

            { header: 'Idade', dataIndex: 'idade', flex: 1 },

            { header: 'Documento', dataIndex: 'documento', flex: 1 },


            { header: 'criacao', dataIndex: 'criacao', width: 200, renderer: Ext.util.Format.dateRenderer('m-d-Y g:i A')},



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

                                title:'Remover cliente',
                                msg: 'Deseja realmente remover este cliente ?',
                                buttonText: {yes: "Remover",cancel: "Cancelar"},
                                fn: function(btn){
                                    console.log('you clicked: ',btn); //you clicked:  yes
                                    if (btn === 'yes') {

                                        var cliente = MyApp.stores.ClienteStore.getAt(rowIndex)

                                        MyApp.stores.ClienteStore.remove(cliente)

                                        MyApp.stores.ClienteStore.sync();
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

    /*plugins: [{
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
