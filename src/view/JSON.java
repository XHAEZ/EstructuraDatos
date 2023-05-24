/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author cobos
 */
public class JSON {

    private static String DIRDATA = "data";
    private String fullpath;
    private String nombreArchivo;
    private File file;
    private Gson gson;

    public JSON(String nombreArchivo) {
        fullpath = DIRDATA + File.separatorChar + nombreArchivo + ".json";
        file = new File(fullpath);
        gson = new Gson();
    }

    /*
    Metodo creado para crear un archivo json y a este agregarle los datos que desemos
     */
    public <T> boolean guardar(T objeto) {
        try {
            String json = gson.toJson(objeto);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(json);
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("ok");
            return true;
        } catch (Exception e) {
            System.out.println("xdjson: " + e.getMessage());
            return false;
        }
    }

    public <T> T cargar(Class<T> clazz) {
        T objeto = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            objeto = gson.fromJson(bufferedReader, clazz);
        } catch (Exception e) {
            System.out.println("xdjson: " + e.getMessage());
        }
        return objeto;
    }

    public String getFullpath() {
        return fullpath;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.fullpath = DIRDATA + File.separatorChar + this.nombreArchivo + ".json";
        this.file = new File(fullpath);
    }

}
