package LibreriaAD;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.TreeSet;
import java.util.Map.Entry;


import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LibreriaListasDinamicas {
	
	/*
	 * -No duplicados
	 * HashSet
	 * TreeSet
	 * HashMap
	 * TreeMap
	 * -Ordenados (implementa Cloneable)
	 * Siempre que hay compare, hay 
	 * implementacion de 
	 * 
	 * -Duplicados
	 * ArrayList
	 * LinkedList
	 * Queue
	 * 
	 * herencia -> Extends
	 * Abstract 
	 * atributos y metodos, no constructores
	 * interfaces -> Implements
	 * Interface
	 * métodos sin cuerpo
	 * palabra Default, no constructores
	 */
	
	/*
	 * Devuelve un HashSet de un Array de cadenas
	 */
	public static Set<String> devuelveSetDesordenado(String[] cadenas){		
		Set<String> colecCadenas = new HashSet<String>(){};		
		for (int i = 0; i < cadenas.length; i++) {
			colecCadenas.add(cadenas[i]);
		}		
		return colecCadenas;		
	}
	
	/*
	 * Devuelve un TreeSet de un Array de cadenas
	 */
	public static Set<String> devuelveSetOrdenado(String[] cadenas){		
		Set<String> colecCadenas = new TreeSet<String>();		
		for (int i = 0; i < cadenas.length; i++) {
			colecCadenas.add(cadenas[i]);
		}		
		return colecCadenas;		
	}
	
	/*
	 * Devuelve un ArrayList de un array de cadenas
	 */
	public static List<String> devuelveListDesordenado(String[] cadenas){		
		List<String> listaCadenas = new ArrayList<String>();		
		for (int i = 0; i < cadenas.length; i++) {
			listaCadenas.add(cadenas[i]);
		}		
		return listaCadenas;		
	}
	
	/*
	 * Devuelve un LinkedList de un array de cadenas
	 */
	public static List<String> devuelveListOrdenado1(String[] cadenas){		
		List<String> listaCadenas = new LinkedList<String>();		
		for (int i = 0; i < cadenas.length; i++) {
			listaCadenas.add(cadenas[i]);
		}		
		return listaCadenas;		
	}
	
	/*
	 * Devuelve un Queue de un array de cadenas
	 */
	public static Queue<String> devuelveListOrdenado2(String[] cadenas){		
		Queue<String> listaCadenas = new LinkedList<String>();		
		for (int i = 0; i < cadenas.length; i++) {
			listaCadenas.add(cadenas[i]);
		}		
		return listaCadenas;		
	}
	
	/*
	 * Devuelve una cola de un Array de cadenas
	 */
	public static Queue<String> devuelveCola(String[] cadenas){
		Queue<String> cola = new LinkedList<String>();
		for (int i = 0; i < cadenas.length; i++) {
			cola.add(cadenas[i]);
		}		
		return cola;
	}
	
	/*
	 * Devuelve un HashMap de clave Integer y valor String de un par de Arrays
	 */
	public static Map<Integer, String> devuevleHashMap (int[] keys, String[] valores){
		Map<Integer, String> mapaHash = new HashMap<Integer, String>();
		for (int i = 0; i < keys.length; i++) {
			mapaHash.put(keys[i], valores[i]);
		}
		return mapaHash;		
	}
	
	/*
	 * Devuelve un TreehMap de clave Integer y valor String de un par de Arrays
	 */
	public static Map<Integer, String> devuevleTreeMap (int[] keys, String[] valores){
		Map<Integer, String> mapaHash = new TreeMap<Integer, String>();
		for (int i = 0; i < keys.length; i++) {
			mapaHash.put(keys[i], valores[i]);
		}
		return mapaHash;		
	}
	
	/*
	 * Borra numeros de posiciones pares de una lista
	 */
	public static List<Integer> borraNum(List<Integer> lista) {		
		for (int i = 0; i<lista.size();i++) {
			if(i%2==0) {
				lista.remove(i);
			}
		}
		return lista;
	}
	
	/*
	 * Obtiene la moda de una lista de números
	 */
	public static List<Integer> obtieneListaModa1(List<Integer> listaElementos){
		int maximasRepeticiones = 2;
		HashSet<Integer> aux = new HashSet<Integer>();
		if(!listaElementos.isEmpty()) {
			for (int i = 0; i < listaElementos.size(); i++) {
				int repeticiones=0;
				for (int j = 0; j < listaElementos.size(); j++) {
					if(listaElementos.get(i) == listaElementos.get(j)) {
						repeticiones++;
						if(repeticiones>maximasRepeticiones) {
							aux.clear();
							aux.add(listaElementos.get(i));
							maximasRepeticiones = repeticiones;
						}else if(repeticiones==maximasRepeticiones) {
							aux.add(listaElementos.get(i));
							maximasRepeticiones = repeticiones;
						}
					}
				}
			}
			List<Integer> moda= new ArrayList<Integer>();
			moda.addAll(aux);
			return moda;
		}
		List<Integer> sinModa= new ArrayList<Integer>();
		sinModa.add(0);
		return sinModa;
	}
	
	/*
	 * Devuelve lista de moda de una lista de números usando mapas
	 */
	public static List<Integer> obtieneListaModa2(List<Integer> listaElementos){
		
		List<Integer> listaRetornoIntegers = new ArrayList<Integer>();
		
		Map<Integer,Integer> listaElementos2 = new HashMap<Integer,Integer>();
	
		for (Integer entero: listaElementos) {
			if (listaElementos2.containsKey(entero)) {
				listaElementos2.put(entero, listaElementos.get(entero)+1);
			}else {
				listaElementos2.put(entero, 1);
			}
		}
		
		int max =  Collections.max(listaElementos2.values());

		for(Entry<Integer, Integer> entry: listaElementos2.entrySet()) {
			if(entry.getValue() == max) {
				listaRetornoIntegers.add(entry.getKey());
			}
		}
	
		return listaRetornoIntegers;
		
	}
	
	/*
	 * Realiza búsquedas binarias en listas
	 */
	private static int busquedaBinaria(List<Integer> vector,int posInicial, int posFinal, int elemento) {
        //Método para realizar busquedas binarias en vectores de enteros
        //Devuelve -1 y si no encuentra el elemento dentro del array
    	if (posInicial>=0 && posInicial<=posFinal && posFinal>=0) {
            int mitad = ((posFinal - posInicial)/2) +posInicial;   		
            if (vector.get(mitad) > elemento) {
                return busquedaBinaria(vector, posInicial, mitad-1, elemento);	
            }else if (vector.get(mitad) < elemento) {
    		return busquedaBinaria(vector, mitad+1, posFinal, elemento);
            }else {
    		return vector.get(mitad);
            }
        }	
    	return -1;
    }
	
	 /*
	  * Llena de numeros aleatorios una lista
	  */
	private static long aletorio(List<Integer> vector){
        //LLena un array de números aleatorios de 0 a 1000
		long lamitad = 0; 
        Random r = new Random();
        for(int i=0; i<100000; i++){
            vector.add(r.nextInt(9999));
            if(i == 50000) {
            	vector.add(r.nextInt(9999));
            	lamitad = System.currentTimeMillis();
            	
            }
        }
        return lamitad;
    }
	
	/*
	 * Requiere método tiempoInicial()
	 * Devuelve el tiempo en milisegundos transcurridos desde 
	 * tiempoInicial() hasta tiempo Final
	 */
	private static void tiempoFinal(long ini) {
		long fin = System.currentTimeMillis();
		System.out.println("Tiempo: " + (fin-ini));
	}
	
	/*
	 * Devuelve el tiempo antes de comenzar una tarea
	 */
	private static long tiampoInicial() {
		long ini = System.currentTimeMillis();
		return ini;
	}
	
	/*
	 * Método para tratamiento de colas
	 */
	private static void tratamientoCola(Queue<String> cola) {
		while(!cola.isEmpty()) {
			System.out.println("Vamos a tratar al Cliente: " + cola.poll());
		}
	}
	
	/*
	 * Devuelve un map con las cadenas y el numero de veces que se repite en la lista
	 */
	public static Map<String,Integer> retornaMapAsociado(List<String> listaStr){		
		Map<String,Integer> mapaAsociado = new HashMap<>();
		for (String lista : listaStr) {
			if (mapaAsociado.containsKey(lista)) {
				mapaAsociado.put(lista, mapaAsociado.get(lista) + 1);
			} else {
				mapaAsociado.put(lista, 1);
			}
		}
		return mapaAsociado;		
	}
	
	/*
	 * Coloca en la posicion 0 de una lista el elemento menor
	 * de la misma
	 */
	public static void intercambioPos(List<Integer> arrayUno) {
		Integer menorElemento = Collections.min(arrayUno);
		int pos = arrayUno.indexOf(menorElemento);
		Collections.swap(arrayUno, pos, 0);
		System.out.println(arrayUno);
	}
	
	/*
	 * Devuelve el número de elementos únicos de una lista
	 */
	public static int countUnique(List<Integer> listaEnteros) {		
		HashSet<Integer> lista = new HashSet<Integer>();		
		lista.addAll(listaEnteros);
		return lista.size();		
	}
	
	/*
	 * Retorna longitud de la cadena mas larga de una lista
	 */
	public static int maxLength(Set<String> setStrs) {
		String varAux = "";
		if(setStrs.isEmpty()) {
			return 0;
		}else {
			for(String i: setStrs) {
				if(i.length()>varAux.length()) {
					varAux=i;
				}
			}
			return varAux.length();
		}
	}
	
	/*
	 * Devuelve el último valor iterado sin repeticiones
	 */
	public static Map<String,Integer> reverse(Map<Integer, String> mapStr){		
		Map<String,Integer> mapStr2 = new HashMap<>();
		int aux = 0;		
		for(Entry<Integer, String> entry: mapStr.entrySet()) {			
			mapStr2.put(entry.getValue(), entry.getKey());
		}
		return mapStr2;	
	}
	
	/*
	 * Retorna elementos sin repetición de una lista
	 */
	public static Set<Integer> retornaElementosSinRepeticion(Collection<Integer> listaElementos) {
		return new TreeSet<>(listaElementos);
	}
	
	/*
	 * Repite cadenas de una lista dada
	 */
	public static void doubleList(ArrayList<String> frase) {	
		for(int i = frase.size()-1; i>=0; i--) {
			frase.add(i,frase.get(i));
		}
		System.out.println(frase);	
	}
	
	/*
	 * Elimina Duplicados de una lista
	 */
	public static ArrayList<String> eliminaDuplicados(ArrayList<String> frase){		
	    LinkedHashSet<String> hs = new LinkedHashSet<>();
	    hs.addAll(frase);
	    frase.clear();
	    frase.addAll(hs);		
		return frase;	
	}
	
	/*
	 * Devuelve una colección de cadenas suyo valor en el mapa es par
	 */
	public static Set<String> listaAsociadaNumeroPar(Map<String, Integer> map){		
		Set<String> pares = new HashSet<>();		
		for(Entry<String, Integer> entry: map.entrySet()) {
			if(entry.getValue()%2 == 0) {
				pares.add(entry.getKey());
			}
		}		
		return pares;		
	}
	
	/*
	 * Devuelve la misma lista de ArrayList pero sin elementos repetidos
	 */
	public static ArrayList<String> eliminaDuplicados(List<String> listaCadenaList){
		
		Set<String> dupliSet = new HashSet<String>(listaCadenaList);
		listaCadenaList.clear();
		listaCadenaList = new ArrayList<String>(dupliSet);
		
		return (ArrayList<String>) listaCadenaList;
	}
	
	/*
	 * Cuenta el numero de veces que aparece una palabra en una lista
	 * (Serviria para decir cuantas veces se repite una palabra en un texto)
	 */
	public static Map<String,Integer> retornaMapAsociado1(List<String> listaStr){		
		Map<String, Integer> mapAux = new HashMap<String, Integer>();
		int cont = 0;
		for (String string : listaStr) {			
			if (listaStr.contains(string)) {
				mapAux.put(string, cont++);
			}else {
				mapAux.put(string, 1);
			}
		}
		return mapAux;		
	}
	/*
	/*
	 * Aplicar compareTo con 3 atributos
	 
	public int compareTo(Municipio o) {
		// TODO Auto-generated method stub
		int comparacion = this.provincia.compareTo(o.provincia);
		if (comparacion != 0)
			return comparacion;
		else {
			int comparacionMunicipio = this.municipio.compareTo(o.municipio);
			
			if (comparacionMunicipio == 0) {
				return anoCenso - o.anoCenso;
			}
			return comparacionMunicipio;
		}
	}
	
	/*
	 * Aplicar compareTo con 1 atributo
	 
	public int compareTo(Municipio o) {
		// TODO Auto-generated method stub
		int comparacion = this.provincia.compareTo(o.provincia);		
		return comparacion;		
	}
	
	/*
	 * Ejemplo de CompareTo con Object y orden descendente
	 
	public int compareTo(Object persona) {
		return -this.apellido.compareTo(((Persona)persona).getApellido());
	}
	
	/*
	 * Otro ejemplo de compare
	 
	public int compare(Integer s1, Integer s2) {
		
		return s2.compareTo(s1);
	}
	
	/*
	 * Implementación de comparator en un TreeSet
	 
	private static TreeSet<Integer> comparatorMetodo1() {
		TreeSet<Integer> listaNumero = new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer s1, Integer s2) {
				
				return s2.compareTo(s1);
			}
		});
		return listaNumero;
	}
	
	/*
	 * Ejemplo de Equals
	 
	public boolean equals(Object obj) {
		if(
			(obj == null) &&
			(obj instanceof Persona) &&	
			(((Persona)obj).id == this.id) &&
			(((Persona)obj).nombre.equals(this.nombre)) &&
			(((Persona)obj).apellido.equals(this.apellido)) 
				) {
			return true;
		}
		return false;
	}
	
	/*
	 * Otro ejemplo de Equals
	 
	public boolean equals(Object obj) {
		if ((obj instanceof Articulo) && 
				((Articulo)obj).ref.equals(this.ref) && 
				((Articulo)obj).nombre.equals(this.nombre)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Ejemplo de HashCode
	 
	public int hashCode() {
		return Object.hashCode();
	}
	*/
}
