package controller;

import model.Animal;
import model.Cliente;
import javax.swing.JTable;
import javax.swing.JTextField;
import view.GenericTableModel;;

public class Controller {
    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;

    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }
    
    public static void setTextFields(JTextField cliente, JTextField animal) {
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
    }
    
    public static Cliente getClienteSelecionado () {
        return clienteSelecionado;
    }
    
    public static void setSelected(Object selected) {
        if (selected instanceof Cliente) {
            clienteSelecionado = (Cliente) selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionado = null;
            animalSelecionadoTextField.setText("");
            return;
        }
        if (selected instanceof Animal) {
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
        }
    }
}
