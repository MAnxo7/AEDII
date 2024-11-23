
package com.mycompany.practicagrafos;

import lista.Lista;
import grafo.*;
import grafo.ListaAdyacencia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class PracticagrafosTest {
    
    private static Grafo<String, Integer> g; 
    private static final Grafo<String, Integer> gVacio = new ListaAdyacencia<>();
    private static Grafo<String, Integer> grafo; 
    private static Grafo<String, Integer> grafoConexo;
    private static Grafo<String, Integer> grafoOrdenTopologico1, grafoOrdenTopologico2;

    private static final Vertice<String> v1 = new Vertice<>("Coruña");
    private static final Vertice<String> v2 = new Vertice<>("Lugo");
    private static final Vertice<String> v3 = new Vertice<>("Ourense");
    private static final Vertice<String> v4 = new Vertice<>("Pontevedra");
    
    private static final Vertice<String> va = new Vertice<>("7");
    private static final Vertice<String> vb = new Vertice<>("5");
    private static final Vertice<String> vc = new Vertice<>("3");
    private static final Vertice<String> vd = new Vertice<>("11");
    private static final Vertice<String> ve = new Vertice<>("8");
    private static final Vertice<String> vf = new Vertice<>("2");
    private static final Vertice<String> vg = new Vertice<>("9");
    private static final Vertice<String> vh = new Vertice<>("10");
    

    private static void rellenarGrafoG(){
        g = new ListaAdyacencia<>();
        g.insertarArco(new Arco<>(v2, v1, 10));
        g.insertarArco(new Arco<>(v1, v3, 20));
        g.insertarArco(new Arco<>(v2, v4, 115));
        g.insertarArco(new Arco<>(v3, v4, 100));
        g.insertarArco(new Arco<>(v2, v3, 100));
        g.insertarArco(new Arco<>(v4, v2, 120));
        g.insertarArco(new Arco<>(v4, v3, 120));
        
        grafo = new ListaAdyacencia<>();
        grafo.insertarArco(new Arco<>(va, vd, 0));
        grafo.insertarArco(new Arco<>(va, ve, 0));
        grafo.insertarArco(new Arco<>(vb, vd, 0));
        grafo.insertarArco(new Arco<>(vc, ve, 0));
        grafo.insertarArco(new Arco<>(vc, vh, 0));
        grafo.insertarArco(new Arco<>(vd, vf, 0));
        grafo.insertarArco(new Arco<>(vd, vg, 0));
        grafo.insertarArco(new Arco<>(vd, vh, 0));
        grafo.insertarArco(new Arco<>(ve, vf, 0));
        
        grafoConexo = new ListaAdyacencia<>();
        grafoConexo.insertarArco(new Arco<>(v1, v2, 10));
        grafoConexo.insertarArco(new Arco<>(v2, v1, 10));
        grafoConexo.insertarArco(new Arco<>(v1, v4, 115));
        grafoConexo.insertarArco(new Arco<>(v4, v1, 115));
        grafoConexo.insertarArco(new Arco<>(v2, v3, 100));
        grafoConexo.insertarArco(new Arco<>(v3, v2, 100));
        grafoConexo.insertarArco(new Arco<>(v3, v4, 120));
        grafoConexo.insertarArco(new Arco<>(v4, v3, 120));
        
        grafoOrdenTopologico1 = new ListaAdyacencia<>();
        grafoOrdenTopologico1.insertarArco(new Arco<>(v2, v1, 10));
        grafoOrdenTopologico1.insertarArco(new Arco<>(v2, v4, 10));
        grafoOrdenTopologico1.insertarArco(new Arco<>(v1, v4, 115));
        grafoOrdenTopologico1.insertarArco(new Arco<>(v1, v3, 115));
        grafoOrdenTopologico1.insertarArco(new Arco<>(v3, v4, 100));
        
        grafoOrdenTopologico2 = new ListaAdyacencia<>();
        grafoOrdenTopologico2.insertarArco(new Arco<>(v3, v1, 10));
        grafoOrdenTopologico2.insertarArco(new Arco<>(v3, v2, 10));
        grafoOrdenTopologico2.insertarArco(new Arco<>(v3, v4, 115));
        grafoOrdenTopologico2.insertarArco(new Arco<>(v2, v4, 115));
        
        
        
    }
   
    @Before
    public void setUp() throws Exception {
            rellenarGrafoG();
    }
    
   
    /**
     * Test of predecesores method, of class SolActividad7.
     */
    @Test
    public void testPredecesores1() {
        System.out.println("Test predecesores");
        Iterator<Vertice<String>> itPred = Practicagrafos.predecesores(g, v4);
        List<String> result = new ArrayList<>();
        while (itPred.hasNext()) {
            result.add(itPred.next().getEtiqueta());
        }
        List<String> expResult = new ArrayList<>();
        expResult.add("Lugo");
        expResult.add("Ourense");
        assertArrayEquals(expResult.toArray(), result.toArray());
    }
    public void testPredecesores2() {
        System.out.println("Test 2 predecesores");
        Iterator<Vertice<String>> itPred = Practicagrafos.predecesores(g, v4);
        List<String> result = new ArrayList<>();
        while (itPred.hasNext()) {
            result.add(itPred.next().getEtiqueta());
        }
        List<String> expResult = new ArrayList<>();
        expResult.add("Lugo");
        expResult.add("Ourense");
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    /**
     * Test of sumidero method, of class solActividad7.
     */
    @Test
    public void testSumideroVacio() {
        System.out.println("Test grafo vacío esSumidero");
        boolean result = Practicagrafos.esSumidero(gVacio, v3);
        assertFalse(result);
    }
    @Test
    public void testNoSumidero() {
        System.out.println("Test No esSumidero");
        boolean result = Practicagrafos.esSumidero(g, v3);
        assertFalse(result);
    }
    @Test
    public void testSumidero() {
        System.out.println("Test esSumidero");
        g.eliminarArco(new Arco<>(v3,v4, 100));
        boolean result = Practicagrafos.esSumidero(g,v3);
        assertTrue(result);
    }

    /**
     * Test of regular method, of class solActividad7.
     */
    @Test
    public void testVacioRegular() {
        System.out.println("Test grafo vacío esRegular");
        boolean expResult = true;
        boolean result = Practicagrafos.esRegular(gVacio);
        assertEquals(expResult, result);
    }
    @Test
    public void testNORegular() {
        System.out.println("Test No esRegular");
        boolean expResult = false;
        boolean result = Practicagrafos.esRegular(g);
        assertEquals(expResult, result);
    }
    @Test
    public void testSiRegular() {
        System.out.println("Test esRegular");
        g.eliminarArco(new Arco<>(v2,v4, 115));
	g.insertarArco(new Arco<>(v1, v4, 200));
	g.insertarArco(new Arco<>(v3, v1, 120));
        boolean expResult = true;
        boolean result = Practicagrafos.esRegular(g);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of esConectadoDesdeVertice method, of class solActividad7.
     */
    @Test
    public void testEsConectadoDesdeVertice() {
        System.out.println("esConectadoDesdeVertice, grafo vacio");
        boolean expResult = false;
        boolean result = Practicagrafos.esConectadoDesdeVertice(gVacio, v1);
        assertEquals(expResult, result);   
    }
    
    @Test
    public void testEsConectadoDesdeVertice2() {
        System.out.println("esConectadoDesdeVertice grafo v1");
        g.eliminarArco(new Arco<>(v4,v2,120));
        boolean expResult = false;
        boolean result = Practicagrafos.esConectadoDesdeVertice(g, v1);
        assertEquals(expResult, result);   
    }
    
    @Test
    public void testEsConectadoDesdeVertice3() {
        System.out.println("esConectadoDesdeVertice grafo v1");
        boolean expResult = true;
        boolean result = Practicagrafos.esConectadoDesdeVertice(g, v1);
        assertEquals(expResult, result);   
    }
    
    
    /**
     * Test of hayCaminoEntreDos method, of class solActividad7.
     */
    @Test
    public void testHayCaminoEntreDos() {
        System.out.println("hayCaminoEntreDos");
        boolean expResult = false;
        boolean result = Practicagrafos.hayCaminoEntreDos(gVacio, v1, v2);
        assertEquals(expResult, result);   
    }

    /**
     * Test of getOrdenTopologico method, of class solActividad7.
     */
    @Test
    public void testgetOrdenTopologicoVacio() {
        System.out.println("getOrdenTopologico en gVacio");
        List<Vertice<String>> expResult = List.of();
        List<Vertice<String>> result = Practicagrafos.getOrdenTopologico(gVacio);
        assertTrue(expResult.equals(result));   
    }
    @Test
    public void testgetOrdenTopologico() {
        System.out.println("getOrdenTopologico en grafo ");
        List<Vertice<String>> expResult = List.of(v2, v1, v3, v4);
        List<Vertice<String>> result = Practicagrafos.getOrdenTopologico(grafoOrdenTopologico1);
        assertTrue(expResult.equals(result));   
    }
    @Test
    public void testgetOrdenTopologico2() {
        System.out.println("getOrdenTopologico en grafo ");
        List<Vertice<String>> expResult1 = List.of(v3, v1, v2, v4);
        List<Vertice<String>> expResult2 = List.of(v3, v2, v1, v4);
        List<Vertice<String>> expResult3 = List.of(v3, v2, v4, v1);
        List<Vertice<String>> result = Practicagrafos.getOrdenTopologico(grafoOrdenTopologico2);
        System.out.println(result);
        assertTrue(expResult1.equals(result) || expResult2.equals(result) || expResult3.equals(result));   
    }
    

    /**
     * Test of esCiclo method, of class solActividad7.
     */
    @Test
    public void testEsCicloFalse() {
        System.out.println("Test esCiclo");
        List<Vertice<String>> camino = new ArrayList<>();
        camino.add(v1);
        camino.add(v2);
        boolean expResult = false;
        boolean result = Practicagrafos.esCiclo(gVacio, camino);
        assertEquals(expResult, result);   
    }
    
    @Test
    public void testEsCicloTrue() {
        System.out.println("Test 2 esCiclo");
        List<Vertice<String>> camino = new ArrayList<>();
        camino.add(v2);
        camino.add(v3);
        camino.add(v4);
        camino.add(v2);
        boolean expResult = true;
        boolean result = Practicagrafos.esCiclo(g, camino);
        assertEquals(expResult, result);   
    }
    @Test
    public void testEsCicloTrue2() {
        System.out.println("Test 3 esCiclo");
        List<Vertice<String>> camino = new ArrayList<>();
        camino.add(v4);
        camino.add(v3);
        camino.add(v4);
        boolean expResult = true;
        boolean result = Practicagrafos.esCiclo(g, camino);
        assertEquals(expResult, result);   
    }
    @Test
    public void testEsCicloTrue3() {
        System.out.println("Test 4 esCiclo");
        List<Vertice<String>> camino = new ArrayList<>();
        camino.add(v2);
        camino.add(v1);
        camino.add(v3);
        camino.add(v4);
        camino.add(v2);
        boolean expResult = true;
        boolean result = Practicagrafos.esCiclo(g, camino);
        assertEquals(expResult, result);   
    }
    @Test
    public void testEsCicloFalse2() {
        System.out.println("Test 5 esCiclo");
        List<Vertice<String>> camino = new ArrayList<>();
        camino.add(v1);
        camino.add(v3);
        camino.add(v4);
        camino.add(v3);
        camino.add(v4);
        camino.add(v2);
        camino.add(v1);
        
        boolean expResult = false;
        boolean result = Practicagrafos.esCiclo(g, camino);
        assertEquals(expResult, result);   
    }

    
    
    
}
