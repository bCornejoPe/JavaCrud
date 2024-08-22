/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Vista.frmProductos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Estudiante
 */
public class ctrlProductos implements MouseListener{
    //1-Llamar a las otras capas (Modelo, Vista)
    private frmProductos vista;
    private Producto modelo;
    
    //2-Crear el constructor de la clase

    public ctrlProductos(frmProductos Vista, Producto Modelo ) {
        this.vista = Vista;
        this.modelo = Modelo;
        
        
        vista.jtbProductos.addMouseListener(this);
        vista.btnGuardar.addMouseListener(this);
        
        //Para mostrar los datos
        modelo.Mostrar(vista.jtbProductos);
        
       vista.btnEliminar.addMouseListener(this);
       vista.btnActualizar.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
   if (e.getSource() == vista.btnGuardar){
   modelo.setNombre(vista.txtNombre.getText());
   modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
   modelo.setCategoria(vista.txtcategoria.getText());
   modelo.Guardar();
   
   
   modelo.Mostrar(vista.jtbProductos);
   
   vista.txtNombre.setText("");
   vista.txtPrecio.setText("");
   vista.txtcategoria.setText("");
   }
   if(e.getSource()== vista.btnEliminar){
       modelo.Eliminar(vista.jtbProductos);
       modelo.Mostrar(vista.jtbProductos);
       
   }
   
   if (e.getSource()== vista.jtbProductos){
     modelo.cargarDatosTabla(vista);
   }
   
   if (e.getSource()== vista.btnActualizar){
    modelo.setNombre(vista.txtNombre.getText());
    modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
    modelo.setCategoria(vista.txtcategoria.getText());
    
    modelo.Actualizar(vista.jtbProductos);
    modelo.Mostrar(vista.jtbProductos);
   }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
