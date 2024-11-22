/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.solactividad6.Map;
import java.util.Iterator;
/**
 *
 * @author estudante
 */
public interface Map<K, V> {

    public int tamaño();
//Produce: devuelve el número de pares <clave, valor> del map

    public V get(K clave);
//Produce: devuelve el valor asociado a la clave que se pasa como parámetro o null cuando
//la clave no existe
public void insertar (K clave, V valor) throws NullPointerException;
//Modifica: this
//Produce: Si clave es null lanza NullPointerException; en otro caso inserta el par <clave,
//valor> en el map. Si la clave ya existe en el map, reemplaza el valor viejo por el nuevo
//valor que se pasa como parámetro.

    public V eliminar(K clave);
//Modifica: this
//Produce: elimina la clave del map y su valor asociado, el cual se retorna. Si la clave no
//existe devuelve null.

    public Iterator<K> getClaves();
//Produce: devuelve un iterador sobre las claves del map

    public Iterator<V> getValores();
//Produce: devuelve un iterador sobre los valores del map
    public interface Par<K,V>{
        K getClave();
        V getValor();
        void setValor(V nuevo);
    }
}
