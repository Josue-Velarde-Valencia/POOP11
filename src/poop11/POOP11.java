/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poop11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author poo08alu44
 */
public class POOP11 {

    public static class Alumno {
        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        int edad;
        int numCuenta;

        public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, int numCuenta) {
            this.nombre = nombre;
            this.apellidoPaterno = apellidoPaterno;
            this.apellidoMaterno = apellidoMaterno;
            this.edad = edad;
            this.numCuenta = numCuenta;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Apellido Paterno: " + apellidoPaterno +
                    ", Apellido Materno: " + apellidoMaterno + ", Edad: " + edad +
                    ", Número de Cuenta: " + numCuenta;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("##########File###########");
        File archivo = new File("archivo.txt");
        System.out.println("Archivo existe: " + archivo.exists());
        if(!archivo.exists()){
            try {
                boolean seCreo = archivo.createNewFile();
                System.out.println("Se creó un archivo: " + seCreo);
                System.out.println("Archivo existe: " + archivo.exists());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        System.out.println("##########FileWriter/Reader##########");
        
        try{    
            System.out.println("#####Lectura desde teclado#####");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba el texto para el archivo.");
            String texto = br.readLine();
            System.out.println("El usuario escribió: " + texto);
            
            System.out.println("#####Escritura del archivo#####");
            FileWriter fw = new FileWriter("archivo.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter impresoraDeArchivos = new PrintWriter(bw);
            impresoraDeArchivos.println(texto);
            
            impresoraDeArchivos.close();
            
            System.out.println("#####Lectura del archivo#####");
            FileReader fr = new FileReader("archivo.txt");
            br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
            
            System.out.println("##########StringTokenizer##########");
            String alumno = "Hector Juan,Jimenez,Maya,320342330,20,8.3";
            System.out.println("Cadena a tokenizar: " + alumno);
            StringTokenizer tokenizador = new StringTokenizer(alumno, ",");
            while(tokenizador.hasMoreTokens()){
                System.out.println(tokenizador.nextToken());
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println("##########Actividad Extra##########");
        try {
            System.out.println("#####Escritura del archivo#####");
            FileWriter fw = new FileWriter("alumnos.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter impresoraDeArchivos = new PrintWriter(bw);

            // Escribir 5 objetos Alumno en el archivo
            for (int i = 0; i < 5; i++) {
                impresoraDeArchivos.println("Rodrigo,Sanchez,Perez,20,1234656,9.9,Copilco 300 Coyoacan");
            }

            impresoraDeArchivos.close();

            System.out.println("#####Lectura del archivo#####");
            FileReader fr = new FileReader("alumnos.csv");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");

            // Lista para almacenar los objetos Alumno
            List<Alumno> listaAlumnos = new ArrayList<>();

            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                // Tokenizar la línea y crear un objeto Alumno
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                String nombre = tokenizador.nextToken();
                String apellidoPaterno = tokenizador.nextToken();
                String apellidoMaterno = tokenizador.nextToken();
                int edad = Integer.parseInt(tokenizador.nextToken());
                int numCuenta = Integer.parseInt(tokenizador.nextToken());

                // Crear objeto Alumno y agregarlo a la lista
                Alumno alumno = new Alumno(nombre, apellidoPaterno, apellidoMaterno, edad, numCuenta);
                listaAlumnos.add(alumno);

                // Leer la siguiente línea
                linea = br.readLine();
            }
            br.close();

            // Imprimir la información de los objetos Alumno en la consola
            for (Alumno alumno : listaAlumnos) {
                System.out.println(alumno);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
