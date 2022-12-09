package com.mycompany.gestorarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorArchivos {

    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
         
        int condicion = 0;
        int opcion;   
        String nombreRutaArchivo = null;
        
        while (condicion != -1) {
            
            System.out.println("1: Crear archivo");
            System.out.println("2: Eliminar archivo");
            System.out.println("3: Escribir archivo");
            System.out.println("4: Mostrar archivos");
            System.out.println("5: Leer archivo");
            System.out.println("6: Salir");
            System.out.println("Ingrese una opcion:");
            
            opcion = reader.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del archivo");
                    nombreRutaArchivo = reader.next();
                    nombreRutaArchivo = "archivos/" + nombreRutaArchivo + ".txt";
                    File rutaCreacion = new File(nombreRutaArchivo);
                    try {
                        rutaCreacion.createNewFile();
                        System.out.println("El archivo fue creado correctamente");
                    } catch (IOException e) {
                        System.out.println("Ocurrio un error al crear el archivo");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del archivo a eliminar");
                    nombreRutaArchivo = reader.next();
                    nombreRutaArchivo = "archivos/" + nombreRutaArchivo + ".txt";
                    File rutaEliminar = new File(nombreRutaArchivo);
                    
                    rutaEliminar.delete();
                    break;
                case 3:
                    Archivo accede_es = new Archivo();
                    
                    System.out.println("Ingrese el nombre del archivo a escribir");
                    nombreRutaArchivo = reader.next();
                    nombreRutaArchivo = "archivos/" + nombreRutaArchivo + ".txt";
                    
                    accede_es.escribir(nombreRutaArchivo);
                    
                    break;
                case 4:
                    File ruta = new File("archivos");
                    String[] nombres_archivos = ruta.list();

                    for (String nombre_archivo : nombres_archivos) {
                        System.out.println(nombre_archivo);
                    }
                    break;
                case 5:
                    Archivo accede_leer = new Archivo();
                    
                    System.out.println("Ingrese el nombre del archivo a leer");
                    nombreRutaArchivo = reader.next();
                    nombreRutaArchivo = "archivos/" + nombreRutaArchivo + ".txt";
                    
                    accede_leer.leer(nombreRutaArchivo);
                    break;
                case 6:
                    condicion = -1;
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}

class Archivo {
        
    public void escribir(String rutaArchivo) {

        String frase = null;
        Scanner reader = new Scanner(System.in);

        System.out.println("Ingrese el texto a escribir:");
        frase = reader.nextLine();

        try {
            FileWriter escritura = new FileWriter(rutaArchivo);

            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }

            escritura.close();
        } catch (IOException e) {
        }

    }
    
    public void leer(String rutaArchivo) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
         File archivo = new File (rutaArchivo);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
    }
}