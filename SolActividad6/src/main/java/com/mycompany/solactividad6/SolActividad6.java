/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.solactividad6;

import com.mycompany.solactividad6.Map.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author estudante
 */
import com.mycompany.solactividad6.Map.Map;

public class SolActividad6 {

    public static void main(String[] args) {

    }

    public static List<String> getRecomendaciones(Map<String, List<String>> sistema, String pelicula) {
        ArrayList<String> coin = new ArrayList<>();
        List<String> peliculas;
        var usuarios = sistema.getClaves();
        HashMap<String, Integer> peliculasmap = new HashMap<>();
        
        //Busca los usuarios que coinciden con la pelicula y los añade a una lista
        while (usuarios.hasNext()) {
            String usuario = usuarios.next();
            peliculas = sistema.get(usuario);
            if (peliculas.contains(pelicula)) {
                for (String peli : peliculas) {
                    Integer n = peliculasmap.get(peli);
                    if (n == null) {
                        n = 0;
                    }
                    peliculasmap.insertar(peli, ++n);
                }
            }
        }
        
        //Obtiene el numero maximo de recomendaciones que tiene una pelicula
        int nmax = 0;
        var peliculas2 = peliculasmap.getClaves();
        while (peliculas2.hasNext()) {
            String peli = peliculas2.next();
            if (peliculasmap.get(peli) > nmax) {
                nmax = peliculasmap.get(peli);
            }
        }
        //Crea la lista de recomendaciones que coinciden con el nmax;     
        List<String> recomendaciones = new ArrayList<>();
        peliculas2 = peliculasmap.getClaves();
        while (peliculas2.hasNext()) {
            String peli = peliculas2.next();
            System.out.println("nmax=" + nmax + " pelicula:" + peli + " nrecomendaciones=" + peliculasmap.get(peli));
            if (peliculasmap.get(peli) == nmax && !peli.equals(pelicula)) {
                recomendaciones.add(peli);
            }
        }
        return recomendaciones;

    }
}
