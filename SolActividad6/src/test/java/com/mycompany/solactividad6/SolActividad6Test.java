package com.mycompany.solactividad6;


import com.mycompany.solactividad6.Map.HashMap;
import com.mycompany.solactividad6.Map.Map;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolActividad6Test {

    public SolActividad6Test() {
    }

    /**
     * Test of getRecomendaciones method, of class SistemaDeRecomendacion.
     */
    @Test
    public void testGetRecomendaciones() {
        System.out.println("getRecomendaciones");
        Map<String, List<String>> sistema = new HashMap<>();
        sistema.insertar("usuario1", List.of("Matrix", "Inception", "Interstellar", "Avatar"));
        sistema.insertar("usuario2", List.of("Terminator", "Avatar", "Matrix", "Batman"));
        sistema.insertar("usuario3", List.of("Passengers ", "Avatar", "Oblivion", "Virtuosity"));
        sistema.insertar("usuario4", List.of("Braveheart", "Centurion", "Dunkerque"));

        String pelicula = "Matrix";
        List<String> expResult = List.of("Avatar");
        List<String> result = SolActividad6.getRecomendaciones(sistema, pelicula);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRecomendaciones2() {
        System.out.println("getRecomendaciones");
        Map<String, List<String>> sistema = new HashMap<>();
        sistema.insertar("usuario1", List.of("Matrix", "Inception", "Interstellar", "Avatar", "Batman"));
        sistema.insertar("usuario2", List.of("Terminator", "Avatar", "Matrix", "Batman"));
        sistema.insertar("usuario3", List.of("Passengers ", "Avatar", "Oblivion", "Virtuosity"));
        sistema.insertar("usuario4", List.of("Braveheart", "Centurion", "Dunkerque"));

        String pelicula = "Matrix";
        List<String> expResult = List.of("Avatar", "Batman");
        List<String> result = SolActividad6.getRecomendaciones(sistema, pelicula);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRecomendaciones3() {
        System.out.println("getRecomendaciones");
        Map<String, List<String>> sistema = new HashMap<>();
        sistema.insertar("usuario1", List.of("Matrix", "Inception", "Interstellar", "Avatar", "Batman"));
        sistema.insertar("usuario2", List.of("Terminator", "Avatar", "Matrix", "Batman"));
        sistema.insertar("usuario3", List.of("Passengers ", "Avatar", "Oblivion", "Virtuosity"));
        sistema.insertar("usuario4", List.of("Braveheart", "Centurion", "Dunkerque"));

        String pelicula = "Braveheart";
        List<String> expResult = List.of("Dunkerque", "Centurion");
        List<String> result = SolActividad6.getRecomendaciones(sistema, pelicula);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRecomendaciones4() {
        System.out.println("getRecomendaciones");
        Map<String, List<String>> sistema = new HashMap<>();
        sistema.insertar("usuario1", List.of("Matrix", "Inception", "Interstellar", "Avatar", "Batman"));
        sistema.insertar("usuario2", List.of("Terminator", "Avatar", "Matrix", "Batman"));
        sistema.insertar("usuario3", List.of("Passengers ", "Avatar", "Oblivion", "Virtuosity"));
        sistema.insertar("usuario4", List.of("Braveheart", "Centurion", "Dunkerque"));

        String pelicula = "Robocop";
        List<String> expResult = new LinkedList<>();
        List<String> result = SolActividad6.getRecomendaciones(sistema, pelicula);
        assertEquals(expResult, result);
    }

}
