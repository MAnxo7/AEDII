/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solactividad9;

import mapa.*;
import grafo.*;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author estudante
 */
public class Dijkstra {

    public static <E> Map<Vertice<E>, Integer> dijkstra(Grafo<E, Integer> g, Vertice<E> v) {
        final Integer INFINITO = Integer.MAX_VALUE;
        Map<Vertice<E>, Integer> distancia = new HashMap<>();
        Set<Vertice<E>> porVisitar = new HashSet<>();

        Iterator<Vertice<E>> itv = g.vertices();
        while (itv.hasNext()) {
            Vertice<E> vert = itv.next();
            porVisitar.add(vert);
            distancia.insertar(vert, INFINITO);
        }
        distancia.insertar(v, 0);

        while (!porVisitar.isEmpty()) {
            Vertice<E> vMinimo = minimo(porVisitar.iterator(), distancia);
            porVisitar.remove(vMinimo);
            Integer dis_vMin = distancia.get(vMinimo);

            if (!dis_vMin.equals(INFINITO)) {
                Iterator<Arco<E, Integer>> ita = g.arcos();
                while (ita.hasNext()) {
                    Arco<E, Integer> arco = ita.next();

                    if (arco.getOrigen().equals(vMinimo) && porVisitar.contains(arco.getDestino())) {
                        Integer pesoArcoElegido = arco.getEtiqueta();
                        if ((dis_vMin + pesoArcoElegido) < distancia.get(arco.getDestino())) {
                            distancia.insertar(arco.getDestino(), dis_vMin + pesoArcoElegido);
                        }
                    }
                }
            }
        }
        return distancia;
    }

    private static <E> Vertice<E> minimo(Iterator<Vertice<E>> iPorVisitar, Map<Vertice<E>, Integer> distancia) {
        Vertice<E> v, minV = iPorVisitar.next();
        Integer d, minD = distancia.get(minV);

        while (iPorVisitar.hasNext()) {
            v = iPorVisitar.next();
            d = distancia.get(v);

            if (d < minD) {
                minD = d;
                minV = v;
            }
        }
        return minV;
    }

}
