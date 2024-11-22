
package com.mycompany.solactividad6.Map;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashMapTest {

@Rule
    public final ExpectedException exception = ExpectedException.none();
    
/**
     * Test of HashMap method, of class HashMap.
     */

@Test(expected = IllegalArgumentException.class)
public void testIllegalCapacity() {
    System.out.println("Test 'HashMap' con capacidad negativa");
    Map hashMap = new HashMap(-5);
}

/**
     * Test of tamaño method, of class HashMap.
     */
    
@Test
public void testTamañoVacio() {
    System.out.println("Test 'tamaño' con HashMap vacío");
    Map instance = new HashMap();
    int expResult = 0;
    int result = instance.tamaño();
    assertEquals(expResult, result);
}

@Test
public void testTamaño() {
    System.out.println("Test 'tamaño' con valor 2");
    Map<String,String> instance = new HashMap<>();
    instance.insertar("c1", "v1");
    instance.insertar("c2", "v2");
    int expResult = 2;
    int result = instance.tamaño();
    assertEquals(expResult, result);
}

/**
     * Test of get method, of class HashMap.
     */

@Test
public void testGetAndInsertar() {
    System.out.println("Test 'get' e 'insertar' correctos");
    String clave = "clave1";
    String valor = "valor1";
    Map<String, String> instance = new HashMap<>();
    instance.insertar(clave, valor);
    instance.insertar("c2", "v2");
    String expResult = valor;
    String result = instance.get(clave);
    assertEquals(expResult, result);
}

@Test
public void testGetNonExistent() {
    System.out.println("Test 'get' si clave no existe");
    Map<String, String> instance = new HashMap<>();
    instance.insertar("c2", "v2");
    String expResult = null;
    String result = instance.get("clave1");
    assertEquals(expResult, result);
}
@Test
public void testGetClaveNull() {
    System.out.println("Test 'get' si clave null");
    Map<String, String> instance = new HashMap<>();
    instance.insertar("c2", "v2");
    String expResult = null;
    String result = instance.get(null);
    assertEquals(expResult, result);
}
@Test
public void testGetNull() {
    System.out.println("Test 'get' si clave es null");
    Map<String, String> instance = new HashMap<>();
    instance.insertar("c1", "v1");
    String expResult = null;
    String result = instance.get(null);
    assertEquals(expResult, result);
}
@Test
public void testGetValorNull() {
    System.out.println("Test 'get' si valor null");
    Map<String, String> instance = new HashMap<>();
    String clave = "clave1";
    String valor = null;
    instance.insertar(clave, valor);
    String expResult = null;
    String result = instance.get(clave);
    assertEquals(expResult, result);
}

/**
     * Test of insertar method, of class HashMap.
     */

@Test(expected = NullPointerException.class)
public void testInsertarClaveNull() {
    System.out.println("Test 'insertar' si clave es null");
    Map<String, String> instance = new HashMap<>();
    instance.insertar(null, "v1");
}
@Test
public void testInsertarValorNull() {
    System.out.println("Test 'insertar' si valor es null");
    Map<String, String> instance = new HashMap<>();
    instance.insertar("c1", null);
    instance.insertar("c1", "v1");
    String expResult = "v1";
    String result = instance.get("c1");
    assertEquals(expResult, result);    
}

/**
     * Test of eliminar method, of class HashMap.
     */

@Test
public void testEliminar() {
    System.out.println("Test 'eliminar' clave existente");
    String clave = "c2";
    String valor = "v2";
    Map<String, String> instance = new HashMap<>();
    instance.insertar(clave, valor);
    String expResult = valor;
    String result = instance.eliminar(clave);
    assertEquals(expResult, result);
}

@Test
public void testEliminarNonExistent() {
    System.out.println("Test 'eliminar' clave no existente");
    String clave = "c2";
    Map<String, String> instance = new HashMap<>();
    String expResult = null;
    String result = instance.eliminar(clave);
    assertEquals(expResult, result);
}

@Test
public void testEliminarClaveNull() {
    System.out.println("Test 'eliminar' si clave es null");
    Map<String, String> instance = new HashMap<>();
    instance.insertar("c1", "v1");
    String expResult = null;
    String result = instance.eliminar(null);
    assertEquals(expResult, result);
}

@Test
public void testEliminarValorNull() {
    System.out.println("Test 'eliminar' si valor es null");
    Map<String, String> instance = new HashMap<>();
    instance.insertar("c1", null);
    String expResult = null;
    String result = instance.eliminar("c1");
    assertEquals(expResult, result);
}

/**
     * Test of getValores() method, of class HashMap.
     */

@Test
public void testGetValores() {
    System.out.println("Test 'getValores' ");
    Map<String, String> instance = new HashMap<>();
    String v1 = "v1";
    String v2 = "v2";
    String v3 = "v3";
    instance.insertar("c1", v1);
    instance.insertar("c2", v2);
    instance.insertar("c3", v3);
    List<String> expResult = new ArrayList<>();
    expResult.add(v1);
    expResult.add(v2);
    expResult.add(v3);
    Iterator<String> it = instance.getValores();
    List<String> result = new ArrayList<>();
    while (it.hasNext()) {
        result.add(it.next());
    }
    assertTrue(expResult.equals(result));
}

/**
     * Test of getClaves method, of class HashMap.
     */

@Test
public void testGetClaves() {
    System.out.println("Test 'getClaves' ");
    Map<String, String> instance = new HashMap<>();
    String c1 = "c1";
    String c2 = "c2";
    String c3 = "c3";
    instance.insertar(c1, "v1");
    instance.insertar(c2, "v2");
    instance.insertar(c3, "v3");
    
    Set<String> expResult = new HashSet<>();
    expResult.add(c1);
    expResult.add(c2);
    expResult.add(c3);
    
    Set<String> result = new HashSet<>();
    Iterator<String> it = instance.getClaves();
    while (it.hasNext()) {
        result.add(it.next());
    }
    
    assertTrue(expResult.equals(result));
}    
}
