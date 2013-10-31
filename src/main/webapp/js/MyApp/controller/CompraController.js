Ext.define('MyApp.controller.CompraController', {
    extend: 'MyApp.controller.AbstractController',

    refs: [
        { ref: 'grid', selector: 'compragrid' },
        { ref: 'form', selector: 'compraform' }
    ],

    init: function() {
        this.control({
            'compraform button[action=edit]': {
                click: this.onEditClick,
                scope: this
            }
        });
    },

    onEditClick: function(btn) {

        console.log(btn)
        this.getForm().setReadOnly(false);
    },

    onSaveClick: function(btn) {
        var form = this.getForm(),
            record = form.getForm().getRecord(),
            grid = this.getGrid(),
            selModel = grid.getSelectionModel();

        form.commit();

        if (form.addMode) {
            grid.store.add(record);
        }

        form.loadRecord(record); //allows form to no longer be dirty
        selModel.deselect(record); //circumvent ExtJS bug
        selModel.select(record); //make sure this record is selected
    },

    onCancelClick: function(btn) {
        var form = this.getForm();
        form.getForm().reset();
        form.unloadRecord();
        form.setReadOnly(true);
        if (form.addMode) {
            form.hide();
        }
    },

    onResetClick: function(btn) {
        this.getForm().getForm().reset();
    },

    onSave: function(form, record, success) {
        if (success) {
            Ext.Msg.alert('Success', 'Company has been updated.');
        } else {
            Ext.Msg.alert('Failure', 'Company has not been updated.');
        }
    }

});