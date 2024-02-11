package Usuarios;

import javax.swing.JOptionPane;


public class AppUsuario {
    public static void main(String[] args) throws Exception{
        Usuarios arrayUsuarios[] = new Usuarios[5];

        int seleccion;
        int contadorUsuarios = 0;
        
        
        do {
            seleccion = JOptionPane.showOptionDialog(null, "Elige la opción que desees", "Selector de opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Nuevo usuario" 
            ,"Consultar un usuario", "Mostrar todos los usuarios", "Salir"}, null);
            
            switch (seleccion) {
                case 0:
                        try{
                            String Email = JOptionPane.showInputDialog("Introduce el email, este debe seguir este formato: "+"\n x@xxxxx");
                            String contrasena = JOptionPane.showInputDialog("Introduce la contraseña, esta debe contar con al menos una letra, un número y un caracter especial");
                            int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
                            arrayUsuarios [contadorUsuarios] = new Usuarios(Email, contrasena, edad);
                            contadorUsuarios++;
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    break;
            
                case 1:
                    int usuarioComprobacion = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posicion del usuario del cual quieras saber los datos"));   
                    try{
                        arrayUsuarios[usuarioComprobacion].muestraDatos(arrayUsuarios[usuarioComprobacion]);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }   
                    break;
                    
                case 2:
                    for (int i = 0; i < arrayUsuarios.length; i++) {
                        arrayUsuarios[i].muestraDatos(arrayUsuarios[i]);
                    }
                    break;  
                default:
                    break;
            }
        } while (seleccion != 3);
    }
}
