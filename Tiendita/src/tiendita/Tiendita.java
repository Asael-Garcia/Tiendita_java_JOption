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
public class Tiendita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String menu="""
                    1. Agregar producto
                    2. Mostrar total
                    3. Eliminar articulo
                    4. Salir""";
        
      
        String [] nombres_array=new String[10000];
        int [] cantidad_array=new int[10000];
        float []precio_array=new float[10000];
        float dineros=0;
        int contador=0;
        Productos_calculos objeto=new Productos_calculos();
        JOptionPane.showMessageDialog(null,"Bienvenido a la tienda de doña Yola");
        String bandera="s";
        while (bandera=="s"){
            int decicion=Integer.parseInt(JOptionPane.showInputDialog("Elije una de las opciones del menu:\n"+menu));
            switch (decicion) {
                case 1:
                    objeto.pedir_datos();
                    nombres_array[contador]=objeto.getNombre();
                    cantidad_array[contador]=objeto.getCantidad();
                    precio_array[contador]=objeto.getPrecio();
                    dineros+=objeto.resultado();
                    contador++;
                    break;
                case 2:
                    objeto.mostrar_prodcutos(nombres_array, cantidad_array, precio_array);
                    JOptionPane.showMessageDialog(null, "La cuenta final es de: "+dineros);
                    break;
                case 3:
                     dineros=objeto.eliminar_objeto(nombres_array, cantidad_array, precio_array, dineros);
                        if(objeto.getPosicion()==10000){
                            nombres_array[objeto.getPosicion()]=null;
                            cantidad_array[objeto.getPosicion()]=objeto.getCantidadEliminar();
                            precio_array[objeto.getPosicion()]=0;
                        }else{
                            cantidad_array[objeto.getPosicion()]=objeto.getCantidadEliminar();
                        }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Perfecto nos vemos");
                    bandera="a";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, selecciona una de las opciones disponibles ");
                    break;
            }

        }
        
        
    }
    
}
