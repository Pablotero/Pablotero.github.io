package Usuarios;

import javax.swing.JOptionPane;

public class Usuarios extends Exception{
    String email;
    String contrasena;
    int idade;
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Usuarios(String email, String contrasena, int idade) throws Exception{
            this.email = email;
            this.contrasena = contrasena;
            this.idade = idade;
            
            if (comprobacionEmail(email)==false) {
                throw new Exception("El Email introducido es incorrecto");
            }else{
                if ( comprobacionContrasena(contrasena)==false) {
                    throw new Exception("La contraseña no cumple con los parametros exigidos");
                }else{
                    if (comprobacionEdad(idade)==false) {
                        throw new Exception("La edad introducida es inferior a la minima permitida");
                    }else{
                        System.out.println("Usuario guardado correctamente");
                    }
                }
            }
    }

    public boolean comprobacionEmail(String email) throws Exception{

        boolean resultado = false;
        if (email.contains("@")) {
            String cadenaEmail [] = new String[3];
            cadenaEmail = email.split("@");
                    if (1 <= cadenaEmail[0].length() && cadenaEmail[0].length() < 64 && cadenaEmail[1].length() > 4) {
                        System.out.println("Email guardado correctamente");
                        resultado = true;
                    }else{
                        resultado = false;
                    }
        }else{
            resultado = false;
        }
        return resultado;
    }

    public boolean comprobacionContrasena(String contrasena) throws Exception{
        boolean resultado = false;

        if (contrasena.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,}$")) {
            System.out.println("Email guardado correctamente");
            resultado = true;
        }else{
           resultado = false;
        }

        return resultado;
    }

    public boolean comprobacionEdad(int edad) throws Exception{
        if (edad < 18) {
            return false;
        }else{
            System.out.println("Edad de usuario comrpobada exitosamente");
            return true;
        }
    }

    public static void muestraDatos(Usuarios usuario){
        JOptionPane.showMessageDialog(null, "Email: "+usuario.getEmail()+"\n Contraseña: "+usuario.getContrasena()+"\n Edad: "+usuario.getIdade());
    }
}
