var required = '<span style="color:#ff0000;font-weight:bold" data-qtip="Required">*</span>';
Ext.define('MyApp.views.cliente.ClienteFormPanel', {
    extend: 'Ext.form.Panel',
    alias: 'widget.ClienteFormPanel',

    id: 'clienteForm',
    bodyStyle: 'padding: 10px; background-color: #DCE5F0; border-left: none;',


    defaults: {

        labelWidth: 150
    },

    edicao: false,

    initComponent: function () {
        this.items = this.buildItems();

        this.callParent();
    },
    buildItems: function () {
        return [

            {

                xtype: 'fieldcontainer',
                layout: 'hbox',
                defaultType: 'textfield',
                fieldDefaults: {
                    labelAlign: 'top',
                    margins: '0 10 10 0'
                },
                items: [
                    {
                        fieldLabel: 'Nome',
                        afterLabelTextTpl: required,
                        name: 'nome',
                        flex: 1
                    },
                    {
                        fieldLabel: 'Documento',
                        name: 'documento',
                        flex: 1
                    }
                ]
            },
            {
                xtype: 'fieldcontainer',
                layout: 'hbox',
                defaultType: 'textfield',
                fieldDefaults: {
                    labelAlign: 'top',
                    margins: '0 10 10 0'
                },
                items: [
                    {
                        fieldLabel: 'Idade',
                        afterLabelTextTpl: required,
                        name: 'idade',
                        flex: 1

                    }

                ]
            }
        ]


    },

    buttons: [
        {
            text: 'Salvar',
            handler: function () {

                var formPanel = this.up('form');

                var form = formPanel.getForm();

                var win = this.up('window')



                var cliente = Ext.create('MyApp.models.Cliente', form.getFieldValues());

                cliente.save({
                    success: function (cliente) {
                        console.log(cliente)

                        Ext.MessageBox.alert('Adiconar cliente', 'Adicionado com sucesso');


                        form.reset()
                        win.removeAll();
                        win.add(MyApp.views.cliente.ClienteGridPanel);
                        MyApp.stores.ClienteStore.load();


                    }
                });

            }
        },
        {
            text: 'Cancelar',
            handler: function () {


                this.up('form').getForm().reset();

                var win = this.up('window')

                win.removeAll();
                win.add(MyApp.views.cliente.ClienteGridPanel);
                MyApp.stores.ClienteStore.load();


            }
        }
    ]
});

