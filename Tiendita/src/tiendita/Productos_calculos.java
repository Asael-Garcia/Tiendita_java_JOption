/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import javax.swing.JOptionPane;

/**
 *
 * @author asael
 */
public class Productos_calculos {
   public String nombre;
    public int cantidad;
    public float precio;
    
    
    public void pedir_datos(){
        String nombre=JOptionPane.showInputDialog("Nombre del articulo a ingresar: ");
        int cantidad=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de "+ nombre + " a ingresar:"));
        float precio=Float.parseFloat(JOptionPane.showInputDialog("Precio de "+ nombre +" c/u"));
        asignar_nombres(nombre, cantidad, precio);
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public float getPrecio(){
        return this.precio;
    }
    
    
    public void mostrar_prodcutos(String nombres_array[],int cantidad_array[], float  precio_array[]){
    String salida="";
    for (int i=0; i<1000;i++){
        if (nombres_array[i]!=null && cantidad_array[i]!=0){
            salida+="Producto: "+ nombres_array[i]+" con la cantidad "+cantidad_array[i]+" y el precio c/u "+precio_array[i]+"\n";
        }
    }
    JOptionPane.showMessageDialog(null,salida);
    }
    
    
    public int posicion;
    public int cantidad_restante;
    
    public int getCantidadEliminar(){
        return this.cantidad_restante;
    }
    
    public int getPosicion(){
       return this.posicion; 
    }
    
    public float eliminar_objeto(String nombres_array[],int cantidad_array[], float  precio_array[],float dineros){
        int verificacion=1;
        float dineros_final=dineros;
        String eliminar=JOptionPane.showInputDialog(null, "¿Que producto deseass eliminar?");
        int cantidad_eliminar=Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que cantidad de "+eliminar+" deseass eliminar?"));
        for (int i=0;i<10000;i++){
            if (eliminar.equals(nombres_array[i]) && cantidad_eliminar<=cantidad_array[i]){
                dineros=dineros-(cantidad_eliminar*precio_array[i]);
                verificacion=2;
                this.posicion=i;
                this.cantidad_restante=cantidad_array[i]-cantidad_eliminar;
                
            }
        }
        String mensaje="";
        if (verificacion==2){
            mensaje="Producto eliminado\n Cantidad anterior de: " +dineros_final +"\nCantidad actual: "+dineros;
        }
        else{
            mensaje= "Producto no encontrado o la cantidad de productos a retirar excede la cantidad que hay";
            this.posicion=10000;
            this.cantidad_restante=0;
        }
        JOptionPane.showMessageDialog(null,mensaje);
        return dineros;
    }
    
    public void asignar_nombres(String nombre, int cantidad, float precio){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precio=precio;
    }
    public float resultado(){
        float resultado=this.cantidad*this.precio;
        return resultado;
    }    
}
