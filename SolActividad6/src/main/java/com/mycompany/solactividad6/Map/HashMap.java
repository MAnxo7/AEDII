/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.solactividad6.Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author estudante
 */
public class HashMap<K, V> implements Map<K, V> {

    private static final int CAPACIDADxDEFECTO = 50;
    private int capacidad;
    private int numElems;
    private List<Map.Par<K, V>>[] datos;

    public HashMap(int cap) throws IllegalArgumentException {
        if (cap <= 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.capacidad = cap;
        numElems = 0;
        datos = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            datos[i] = new LinkedList<>();
        }
    }

    public HashMap() {
        this(CAPACIDADxDEFECTO);
    }

    private int funcionHash(K clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    static class HashPar<K, V> implements Map.Par<K, V> {

        private K clave;
        private V valor;

        public HashPar(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public K getClave() {
            return clave;
        }

        public V getValor() {
            return valor;
        }

        public void setValor(V valor) {
            this.valor = valor;
        }

    }

    @Override
    public int tamaño() {
        return numElems;
    }

    @Override
    public V get(K clave) {
        if (clave == null) {
            return null;
        }
        int ind = funcionHash(clave);
        var list = datos[ind];
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < list.size()) {
            if (list.get(i).getClave().equals(clave)) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (encontrado) {
            return list.get(i).getValor();
        } else {
            return null;
        }

    }

    @Override
    public void insertar(K clave, V valor) throws NullPointerException {
        if (clave == null) {
            throw new NullPointerException("No se puede insertar un elemento null");
        }
        Par aIns = new HashPar(clave, valor);
        int ind = funcionHash(clave);
        var list = datos[ind];
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < list.size()) {
            if (list.get(i).getClave().equals(clave)) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if(encontrado){
            list.set(i, aIns);
        } else {
            list.add(aIns);
            numElems++;
        }
    }

    @Override
    public V eliminar(K clave) {
        if (clave == null) {
            return null;
        }
        int ind = funcionHash(clave);
        var list = datos[ind];
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < list.size()) {
            if (list.get(i).getClave().equals(clave)) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (encontrado) {
            numElems--;
            return list.remove(i).getValor();
        } else {
            return null;
        }
    }

    @Override
    public Iterator<K> getClaves() {
        List claves = new LinkedList();
        for (List list : datos) {
            for (Object par : list) {
                HashPar hpar = (HashPar) par;
                claves.add(hpar.getClave());
            }
        }
        return claves.iterator();
    }

    @Override
    public Iterator<V> getValores() {
        List valores = new LinkedList();
        for (List list : datos) {
            for (Object par : list) {
                HashPar hpar = (HashPar) par;
                valores.add(hpar.getValor());
            }
        }
        return valores.iterator();
    }
}
