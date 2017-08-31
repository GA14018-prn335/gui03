/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.guia03;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Luis
 */
@RunWith(Arquillian.class)
public class UtilitiesTest {

    @Deployment
    public static WebArchive desplegar() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class).addClass(Utilities.class).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }

    @Inject
    private Utilities utilities;

    @Test
    public void probarMetodogetResume() {
        String frase = "Bienvenidos a la mat";
        String fraseCompleta = "Bienvenidos a la materia de Programación 3 Ciclo II 2017.";
        String resultado = utilities.getResume(fraseCompleta);
        Assert.assertEquals(frase, resultado);
    }
    
    @Test
    public void probarMetodogetResume1() {
        String frase = "Hola Mundo!";
        String fraseCompleta = "Hola Mundo!";
        String resultado = utilities.getResume(fraseCompleta);
        Assert.assertEquals(frase, resultado);
    }

    @Test
    public void probarMetodogetResume2() {
        String frase = null;
        String fraseCompleta = null;
        String resultado = utilities.getResume(fraseCompleta);
        Assert.assertEquals(frase, resultado);
    }
    
    @Test
    public void probarMetodoCapitalizar() {
        String frase = "Pruebas De Unidad Con Junit & Arquillian";
        String texto = "prueBas de UNIDAD con JUnit & arQuillian";
        String resultado = utilities.capitalizar(texto);
        Assert.assertEquals(frase, resultado);
    }

    @Test
    public void probarMetodoCapitalizar1() {
        String frase = "";
        String texto = "";
        String resultado = utilities.capitalizar(texto);
        Assert.assertEquals(frase, resultado);
    }
    
    @Test
    public void probarMetodoCapitalizar2(){
        String frase = null ;
        String texto = null;
        String resultado = utilities.capitalizar(texto);
        Assert.assertEquals(frase, resultado);
    }
    
    @Test
    public void probarMetodoContar() {
        int fraseEsperada = 1;
        String frase = "2017";
        String Cadena = "Bienvenidos a la materia de Programación 3 Ciclo II 2017.";
        int resultado = utilities.contarCoincidencias(Cadena, frase);
        Assert.assertEquals(fraseEsperada, resultado);
    }
    
    @Test
    public void probarMetodoContar1() {
        int fraseEsperada = 2;
        String frase = "MA";
        String Cadena = "Bienvenidos a la materia de Programación 3 Ciclo II 2017.";
        int resultado = utilities.contarCoincidencias(Cadena, frase);
        Assert.assertEquals(fraseEsperada, resultado);
    }
    
    @Test
    public void probarMetodoContar2() {
        int fraseEsperada = 0;
        String frase = null;
        String Cadena = "bienvenido";
        int resultado = utilities.contarCoincidencias(Cadena, frase);
        Assert.assertEquals(fraseEsperada, resultado);
    }

}
