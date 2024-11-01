/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.biblioteca.controller;
//import View.ResourcesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.biblioteca.model.ConsultasRecurso;
import org.biblioteca.model.Resources;
import org.biblioteca.view.ResourcesManager;

/**
 *
 * @author Rebe
 */
public class ResourcesController implements ActionListener{
    private final Resources model;
    private final ConsultasRecurso querys; 
    private final ResourcesManager view;

    public ResourcesController(Resources model, ConsultasRecurso querys, ResourcesManager view){
        this.model = model;
        this.querys = querys;
        this.view = view;
        this.view.jButtonSave.addActionListener(this);
        //this.view.jButtonEdit.addActionListener(this);
        //this.view.jButtonDelete.addActionListener(this);
        this.view.jButtonSearch.addActionListener(this);
        this.view.jButtonClean.addActionListener(this);
        this.view.jButtonRefresh.addActionListener(this);     
        start();
    }

    public void start() {
        view.setTitle("Recursos");
        view.setLocationRelativeTo(null);
        fillComboStatus();
        fillComboType();
        refreshTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.jButtonSave) {
            try {
                    model.setCode(Integer.parseInt(view.jTextFieldCode.getText()));
                    model.setTitle(view.jTextFieldTitle.getText());
                    model.setAutor(view.jTextFieldAuthor.getText());                                 
                    model.setStatus(getStatus());
                    model.setType(view.jComboType.getSelectedIndex());
                    if (model.getType() == 0) {
                        JOptionPane.showMessageDialog(null, "Verifique el tipo de Recurso");
                        return;
                    }
                    if (querys.search(model)) {
                        model.setTitle(view.jTextFieldTitle.getText());
                        model.setAutor(view.jTextFieldAuthor.getText());                                 
                        model.setStatus(getStatus());
                        model.setType(view.jComboType.getSelectedIndex());
                        if (querys.save(model)) {
                            JOptionPane.showMessageDialog(null, "Recurso Guardado");
                            refreshTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Guardar");
                        }
                    } else {
                        if (querys.register(model)) {
                            JOptionPane.showMessageDialog(null, "Recurso Registrado");
                            clean();
                            refreshTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Registrar, verifique que este Recurso no existe previamente");
                        }
                    }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El código debe ser un número entero.");
                view.jTextFieldCode.setText("");
                //view.jButtonSave.requestFocus(); // Enfocar
            }
        }

        //if (e.getSource() == view.jButtonEdit) {
            /*
                        model.setCode(Integer.parseInt(view.jTextFieldCode.getText()));
                        model.setTitle(view.jTextFieldTitle.getText());
                        model.setAutor(view.jTextFieldAuthor.getText());  
                        model.setStatus(true);
                        model.setType(0);
            */
        //}

        if (e.getSource() == view.jButtonSearch) {
            model.setCode(Integer.parseInt(view.jTextFieldSearch.getText()));

            if (querys.search(model)) {
                JOptionPane.showMessageDialog(null, "Recurso encontrado");
                view.jTextFieldCode.setText(String.valueOf(model.getCode()));
                view.jTextFieldTitle.setText(model.getTitle());
                view.jTextFieldAuthor.setText(model.getAutor());
                //view.jComboType.setSelectedItem(String.valueOf(model.getType()));
                //view.jToggleButtonDisponible.setText(model.isStatus()? "Enabled" : "Disabled");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el recurso");
            }
        }
        
        if (e.getSource() == view.jButtonClean) {
            clean();
        }

        if (e.getSource() == view.jButtonRefresh) {
            refreshTable();
        }
    }

    public void refreshTable(){
        try {                                
            view.jTableResources.setModel(DataTable.resultSetToTableModel(querys.list()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al refrescar");
            ex.printStackTrace();
        }
    }

    public void clean(){
        view.jTextFieldCode.setText("");
        view.jTextFieldTitle.setText("");
        view.jTextFieldAuthor.setText("");
        view.jComboType.setSelectedIndex(0);
        view.jComboStatus.setSelectedIndex(0);

    }

    public void fillComboType(){
        try {                                       
                ResultSet rs = querys.listTypeResource();
                view.jComboType.addItem("Seleccione");                 
                while (rs.next()) {
                    view.jComboType.addItem(rs.getString("description"));                    
                }                                  
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al llenar los tipos de recursos");
            ex.printStackTrace();
        }
    }

    public void fillComboStatus(){
        view.jComboStatus.addItem("Disponible"); 
        view.jComboStatus.addItem("No Disponible");                
    }

    public boolean getStatus(){
        if (view.jComboStatus.getSelectedIndex() == 0){
            return true;
        };
        return false; 
    }

   
}
