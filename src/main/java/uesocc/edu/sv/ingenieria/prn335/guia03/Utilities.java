/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.guia03;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Luis
 */
@LocalBean
@Dependent
public class Utilities implements Serializable {

    /**
     * Es un metodo que cuenta las primeras 20 letras de un parrafo o texto.
     * @param texto Es una variable String que contiene un texto ya sea parrafo o frase.
     * @return
     */
    public String getResume(String texto) {
        char caracter = ' ';
        String frase = "";

        if (texto == null) {
            return null;
        }
        if (texto == " ") {
            frase = " ";
        }
        if (texto.length() < 20) {
            frase = texto;
        } else {
            for (int i = 0; i < 20; i++) {
                caracter = texto.charAt(i);
                frase += caracter;
            }
        } 
        return frase;
    }

    /**
     * Es un metodo pone en mayuscula la primera letra de cada palabra y las otras minusculas.
     * @param texto Es una variable String que contiene un texto ya sea frase o parrafo
     * @return
     */
    public String capitalizar(String texto) {
        String frase = "";
        if (texto == null) {
            System.out.println("ESTA ES LA VARIABLE QUE IMPRIMI " + texto);
            return null;
        } else {
            int cont = 0;

            char[] caracteres = texto.toCharArray();

            for (int i = 0; i < texto.length(); i++) {
                caracteres[i] = Character.toLowerCase(caracteres[i]);
                if (caracteres[i] == ' ') {
                    caracteres[i + 1] = Character.toLowerCase(caracteres[i + 1]);
                }
            }

            for (int i = 0; i < texto.length(); i++) {
                caracteres[0] = Character.toUpperCase(caracteres[0]);
                if (caracteres[i] == ' ') {
                    int p = i;
                    cont = 0;
                    while (caracteres[(p)] == ' ') {
                        p++;
                        cont += 1;
                    }
                    if (cont >= 2) {
                        continue;
                    } else {
                        caracteres[i + cont] = Character.toUpperCase(caracteres[i + cont]);
                    }
                }
                frase += caracteres[i];
            }
        }
        return frase;
    }

    /**
     * Es un metodo que contabaliza las palabras que se repiten en el texto.
     * @param Cadena Una variable tipo String que contiene texto. 
     * @param frase Una variable tipo String que resive la palabra para contar.
     * @return
     */
    public int contarCoincidencias(String Cadena, String frase) {

        int i = 0, contador = 0;
        if(frase==null){
           return contador;
        } 
        while (i != -1) {
            i = Cadena.indexOf(frase, i);
            if (i != -1) {
                i++;
                contador++;
            }
        }
        return contador;
    }

}
