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
                        fieldLabel: 'Sobrenome',
                        name: 'sobrenome',
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
                        fieldLabel: 'RG',
                        afterLabelTextTpl: required,
                        name: 'last',
                        width: 200
                    },
                    {
                        fieldLabel: 'Email',
                        afterLabelTextTpl: required,
                        name: 'email',
                        vtype: 'email',
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
                        xtype: 'datefield',
                        fieldLabel: 'Data de nascimento',
                        afterLabelTextTpl: required,
                        name: 'nascimento',
                        submitFormat: 'Y-m-d',
                        format: 'd/m/Y',
                        margins: '0 30 10 0',
                        width: 150
                    },
                    {
                        xtype: 'checkbox',
                        fieldLabel: 'Mailing',
                        allowBlank: false,
                        name: 'mailing',
                        width: 100
                    },
                    {
                        xtype: 'checkbox',
                        fieldLabel: 'Blacklisted',
                        allowBlank: false,
                        name: 'blacklisted',
                        width: 100
                    },
                    {
                        xtype: 'checkbox',
                        fieldLabel: 'VIP',
                        allowBlank: false,
                        name: 'vip',
                        width: 100
                    },
                    {
                        xtype: 'checkbox',
                        fieldLabel: 'Ativo',
                        allowBlank: false,
                        name: 'ativo',
                        width: 100
                    }
                ]
            },
            {
                xtype: 'tabpanel',
                plain: true,
                activeTab: 0,
                height: 235,
                defaults: {
                    margins: '10 0',
                    bodyPadding: 10
                },
                items: [
                    {
                        title: 'Contato',
                        defaults: {
                            width: 230
                        },
                        defaultType: 'textfield',

                        items: [


                            {
                                fieldLabel: 'Endereço',
                                name: 'endereco',
                                width: 400,
                                allowBlank: false
                            },
                            {
                                fieldLabel: 'Telefone Celular',
                                name: 'telefoneCel'
                            },
                            {
                                fieldLabel: 'Telefone Residencial',
                                name: 'telefoneRes'
                            }
                        ]
                    },
                    {
                        title: 'Dispositivos',
                        defaults: {
                            width: 230
                        },
                        defaultType: 'textfield',

                        items: [

                        ]
                    }
                    /*{
                        cls: 'x-plain',
                        title: 'Biography',
                        layout: 'fit',
                        items: {
                            xtype: 'htmleditor',
                            name: 'bio2',
                            fieldLabel: 'Biography'
                        }
                    }*/
                ]
            }
        ];

    },

    buttons: [
        {
            text: 'Salvar',
            handler: function () {

                var formPanel = this.up('form');

                var form = formPanel.getForm();

                var win = this.up('window')


                if(formPanel.edicao){

                    var cliente = MyApp.stores.ClienteStore.getById(form._record.data.id);

                    cliente.beginEdit();

                    cliente.set(form.getValues());

                    cliente.commit()

                    // MyApp.stores.ItemStore.sync();
                    cliente.save({
                        success: function (item) {
                            console.log(item)

                            Ext.MessageBox.alert('Alterar cliente', 'Alterado com sucesso');


                            form.reset()
                            win.removeAll();
                            win.add(MyApp.views.cliente.ClienteGridPanel);
                            MyApp.stores.ClienteStore.load();


                        }
                    });




                } else{

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

