/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practicagrafos;

import grafo.Arco;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 *
 * @author El admin
 */
public class Practicagrafos {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> g, Vertice<E> v) {
        ArrayList predecesosores = new ArrayList();
        Iterator arcos = g.arcos();
        while (arcos.hasNext()) {
            Arco arco = (Arco) arcos.next();
            if (arco.getDestino().equals(v)) {
                predecesosores.add(arco.getOrigen());
            }
        }
        return predecesosores.iterator();
    }

    public static <E, T> boolean esSumidero(Grafo<E, T> g, Vertice<E> v) {
        Iterator vertices = g.vertices();
        if (g.adyacentes(v).hasNext() || g.esVacio()) {
            return false;
        }
        boolean toRet = true;
        while (vertices.hasNext() && toRet) {
            Vertice vert = (Vertice) vertices.next();
            if (!vert.equals(v)) {
                Iterator ady = g.adyacentes(vert);
                boolean ApuntaASum = false;
                while (ady.hasNext() && !ApuntaASum) {
                    if (ady.next().equals(v)) {
                        ApuntaASum = true;
                    }
                }
                if (!ApuntaASum) {
                    toRet = false;
                }
            }

        }
        return toRet;
    }

    public static <E, T> boolean esRegular(Grafo<E, T> g) {
        if (g.esVacio()) {
            return true;
        }
        Iterator vertices = g.vertices();
        int nady = -1;
        boolean esRegular = true;
        while (vertices.hasNext() && esRegular) {
            Vertice v = (Vertice) vertices.next();
            Iterator adyacentes = g.adyacentes(v);
            int nadyact = 0;
            while (adyacentes.hasNext()) {
                adyacentes.next();
                nadyact++;
            }
            if (nady == -1) {
                nady = nadyact;
            } else if (nady != nadyact) {
                esRegular = false;
            }
        }
        return esRegular;
    }

    public static <E, T> boolean esConectadoDesdeVertice(Grafo<E, T> g, Vertice<E> vInicio) {
        if (g.esVacio()) {
            return false;
        }
        if (!g.estaVertice(vInicio)) {
            return false;
        }
        List<Vertice<E>> visitados = new ArrayList<>();
        Iterator vertices = g.vertices();
        boolean toRet = true;
        while (vertices.hasNext() && toRet) {
            Vertice vert = (Vertice) vertices.next();
            toRet = esAccesible(g, vInicio, vert, visitados);
        }
        return toRet;
    }

    //Lo ideal seria no tener que pasarle una lista, pero para no hacer otro metodo solo sirva para hacer una lista y pasarsela a esta
    //lo dejo así
    private static <E, T> boolean esAccesible(Grafo<E, T> g, Vertice<E> vInicio, Vertice<E> vDestino, List visitados) {
        Iterator adyacentes = g.adyacentes(vInicio);
        boolean toRet = false;
        while (adyacentes.hasNext() && !toRet) {
            Vertice ady = (Vertice) adyacentes.next();
            if (ady.equals(vDestino)) {
                toRet = true;
            } else if (!visitados.contains(ady)) {
                visitados.add(ady);
                toRet = esAccesible(g, ady, vDestino, visitados);
            }
        }
        visitados.clear();
        return toRet;
    }

    public static <E, T> List<Vertice<E>> getOrdenTopologico(Grafo<E, T> g) {
        List<Vertice<E>> toRet = new ArrayList<>();
        Queue<Vertice<E>> colagradocero = new ArrayDeque<>();
        mapa.Map<Vertice<E>, Integer> mapa = new mapa.HashMap<>();
        Iterator<Vertice<E>> vertices = g.vertices();
        while (vertices.hasNext()) {
            Vertice v = vertices.next();
            //Me doy el lujazo de usar mi propia funcion, que paja de programarlo de nuevo aunque fuese más optimo
            Iterator<Vertice<E>> adyacentes = predecesores(g, v);
            int n = 0;
            while (adyacentes.hasNext()) {
                adyacentes.next();
                n++;
            }
            if (n == 0) {
                colagradocero.add(v);
            }
            mapa.insertar(v, n);
        }
        while (!colagradocero.isEmpty()) {
            Vertice<E> vert = colagradocero.poll();
            toRet.add(vert);
            Iterator<Vertice<E>> adyacentes = g.adyacentes(vert);
            while (adyacentes.hasNext()) {
                Vertice<E> ady = adyacentes.next();
                mapa.insertar(ady, mapa.get(ady) - 1);
                if (mapa.get(ady) == 0) {
                    colagradocero.add(ady);
                }
            }
        }
        return toRet;
    }

    public static <E, T> boolean hayCaminoEntreDos(Grafo<E, T> g, Vertice<E> v1, Vertice<E> v2) {
        ArrayList<Vertice<E>> visitados = new ArrayList<>();
        // Y ME DOY EL LUJAZO!!!!
        return esAccesible(g, v1, v2, visitados) || esAccesible(g, v2, v1, visitados);
    }

    public static <E, T> boolean esCiclo(Grafo<E, T> g, List<Vertice<E>> camino) {
        if (g.esVacio()) {
            return false;
        }
        Iterator<Arco<E,T>> arcos;
        boolean encontrando = true;
        List visitados = new ArrayList<>();
        int i = 0;
        while(i < camino.size()-1 && encontrando) {
            encontrando = false;
            arcos = g.arcos();
            while(arcos.hasNext() && !encontrando){
                Arco arco = arcos.next();
                if(arco.getOrigen().equals(camino.get(i)) && arco.getDestino().equals(camino.get(i + 1))){
                    encontrando = true;
                }
            }
            if(visitados.contains(camino.get(i))) encontrando = false;
            else visitados.add(camino.get(i));
            i++;
        }
        return ((i == camino.size()-1) && encontrando);
        
    }
}
