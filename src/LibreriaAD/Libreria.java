/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibreriaAD;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;




/**
 *
 * @author pietrodeocre
 */
public class Libreria {
    
    private static void raizDeN(int a){
        // Definimos que si a es menor o igual a 0 de error de lo contrario muesre la raiz
        System.out.print((a<=0)?"Error":"La raiz del número es "+Math.sqrt(a));
    }
    
    private static void multiYSumaDeTresNum (int a, int b, int c){
        //Definimos que si a es menor que 0 se multipliquen y si no se sumen
        System.out.print((a<0)?"El producto de dichos números es:"+(a*b*c):"La suma de dichos números es:"+(a+b+c));
    }
    
    private static void sumaImparesYPares(int a){
        //Desde el numero que digamos hasta 100 este método muestra la suma de los números pares
        //Y la suma de los números de los impares
        int b=0;
        int c=0;
        //Definimos el bucle
        while (a<100){
            //Aumentamos el contador hasta llegar a 100
            ++a;
            //Imprimirmos contador 
            System.out.println("Mostramos la cuenta: "+ a);
            if (a%2 == 0){
                //Si a es par lo sumamos en la variable b
                b+=a;
            }else{
                //Si a es impar lo sumamos en la variable c
                c+=a;
            }
        }
        //Imprimirmos la suma de numero pares y al de numeros impares
        System.out.println("Los números pares sumados: "+ b);
        System.out.println("Los números impares sumados: "+ c);
    }
    
    private static void tablaMultiplicarDeNumero(int num){
        //Muestra la tabla de multiplicar del número entregado pro el parámetro
        int a = 0;
        while (a<=10){
            System.out.println(num +" * "+ a +" = "+ (num*a));
            ++a;
        }
    }
    
    private static void numeroMayorDeTres(int a, int b, int c){
        //Definimos método para que indique cual de los tres numeros es mayor o si no hay diferencia
        System.out.println("El mayor entre "+a+", "+b+" y "+c+" es "+((a==b || a==c || b==c)?"no hay diferencia":((a>b && a>c)?a:(b>c && b>a)?b:c)));
    }
    
    private static void divisionEntreMenor(int a, int b){
        //Dados dos números se divide siemrpe el mayor entre el menor.
        System.out.println("La división del mayor entre el menor es "+ a +" y "+ b +" es "+((a==b)?1:((a>b)?(a/b):(b/a))));
    }
    
    private static void notaMediaDeNAlumnos(int alumnos, double nota1, double nota2){
        //Pregunta el número de alumnos y dos notas de cada uno
        int contador = 1;
	while (contador<=alumnos) {
            //Indica la media de las dos notas del alumno 
            System.out.println("La nota del alumno "+contador+" es "+((nota1*0.6)+(nota2*0.4)));
            ++contador;
        }
    }
    
    private static void parImparMasCuantos(int a){
        //Indica un número de 0 a 100
        //El método nos muestra desde ese número hasta 100 
        //Cual es par y cual impar
        //Finalmente indica cuantos números hay de cada tipo
        int b=0; 
        int c=0;
        while (a<100){
            //Aumentamos el contador
            ++a;
            if (a%2 == 0){
                System.out.println("Este número es par: "+ a);
                ++b;
            }else{
                System.out.println("Este número es impar: "+ a);
                ++c;
            }
        }
        System.out.println("Número total de números pares: "+ b);
        System.out.println("Número total de números impares: "+ c);
    }
    
    private static void mayorQue(int a, int b){
        //Indica cual es mayor de dos números
        if (a==b){
            System.out.println("Los números "+ a +" y "+ b +" son iguales");
        }else if (a>b){
            System.out.println("El "+ a +" es mayor");
        } else {
            System.out.println("El "+ b +" es mayor");
        }
    }
    
    private static void sumaPares(int a){
        //Indica la suma de numeros pares desde 0 hasta el número dado
        int b=0;
        int c=0;
        while(b<=a){
            if (b%2 == 0){
                c=c+b;
                 
            }
            ++b;
        }
        System.out.print("La suma de los números pares es: "+c);
    }
    
    private static void mayorDeTres(int a, int b, int c){
        //Indica el mayor de tres números o ninguno si todos son iguales
        System.out.print("El mayor de los tres es "+((a==b && b==c)?"Ninguno":(a>b && a>c)?a:(b>a && b>c)?b:c));
    }
    
    private static void media(){
        //Indica la media de los números que nos pida hasta que pongamos un número negativo
        Scanner sc = new Scanner(System.in);
        int contador, sumador, numerouno;
        //Asignar variables
        contador=0;
        sumador=0;
        //Definimos Condiciones
        do {
            //Pedimos número
            System.out.print("Escribe un numero: ");
            numerouno = sc.nextInt();
            if (numerouno>=0){
                //Realizamos operaciones
                contador++;
                sumador += numerouno;
            }
        } while (numerouno>=0);
        System.out.println("La media es: "+(sumador/contador));
    }
    
    private static boolean impar(int numero){
        //Devuelve true si es impar y false si es par  
        return numero%2!=0;
    }
    
    private static boolean par(int numero){
        //Devuelve true si es par y false si es impar
        return numero%2==0;
    }
    
    private static void aciertaNumero(){
        //Juego para acertar un número aleatorio 
        Scanner sc = new Scanner(System.in);
        int num_secreto = (int) (Math.random()*1000);
        int num_introducido;
        boolean acierto = false;
        do {
            System.out.print("Escribe un número: ");
            num_introducido = sc.nextInt();
            if (num_introducido == num_secreto){
                System.out.print("Acertaste!!!!");
                acierto=true;
            }else if (num_introducido > num_secreto){
                System.out.println("Menor!");
            }else{
                System.out.println("Mayor!");
            }
        }while (num_introducido != num_secreto);
    }
    
    private static int factorial(int num){
        //Indica y devuelve el factorial del número pasado por parámetro
        int sum=0;
        int cont=0;
        while(cont<num){
            cont++;
            sum*=cont;
        }
        System.out.println("El factorial del número es: "+sum);
        return sum;
        
    }
    
    private static void productoDeImpares(int numero){
        //Indica el producto de números impares hasta el número indicado en el parámetro
        int cont, num;
        //Asignamos valores a variables
        cont=0;
        num=1;
        //Definimos bucle
        while(cont<numero){
            cont++;
            if (cont%2!=0){
                num*=cont;
                System.out.print((cont!=(numero-1))?cont+"*":cont);
            }
        }
        System.out.println("="+num);
    }
    
    private static void cuentaAtras(int num){
        //Cuenta atras desde cien, contando de parametro num en parametro num
        int x = 100;
	do {
            System.out.println(x);
            x -=num;
        } while(x>num);
    }
    
    private static void arrayRectangulo(int dimX, int dimY){
        //Crea un rectangulo de la dimensiones indicadas por parametros
        //Recorre el array mostrando numeros en forma diagonal 
        int a[][] = new int[dimX][dimY];
        
        for (int cnt = 0, 
                 total = dimX * dimY,
                 x = 0,
                 y = 0;
             cnt < total; 
             cnt++) {

            a[x][y] = cnt;

            // mover en diagonal dirección noreste.
            x--;
            y++;

            // si quedó fuera de los límites del rectángulo,
            // mover al comienzo de la próxima fila en diagonal.
            if (x < 0 || x >= dimX || y < 0 || y >= dimY) {
                y++;
                int delta = Math.min(y, dimX - x - 1);
                x += delta;
                y -= delta;
            }
        }

        for(int x = 0; x < dimX; x++) {
            for(int y = 0; y < dimY; y++) {
                if (y != 0) {
                    System.out.print("\t");
                }
                System.out.print(a[x][y]);
            }
            System.out.println();
        }
    }
    
    private static void positivoNegativo(int num){
        //Indica si un número es positivo o negativo
        System.out.println("El número es "+((num>0)?"positivo":"negativo"));
    }
    
    private static void cuadradoDeN(int num){
        //Muestra el cuadrado de un número
        System.out.println("El cuadrado del número es "+(num*num));
    }
    
    private static void numeroNumeros(int[] array){
        //Pide un array de números hasta para mostrar el número de enteros que contiene
        int numerodos = 0;
        int[] numerouno = array;
        // Declaramos condicion 
        do {
            for (int i = 0; i < numerouno.length; i++) {
                if (numerouno[i]>0){
                    numerodos++;
                }
            }        
        } while(numerodos>numerouno.length);
        System.out.println("El número de enteros del array es " + numerodos);
    }
    
    private static boolean esPrimo(int numero){
        //Revisa si un numero entero es primo o no.
        //Si es par no es primo
        int contador=2;
        boolean primo=true;
        if (numero%2==0){
            primo = false;
            return primo;
        }
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
            primo = false;
            contador++;
        }
        return primo;
    }
    
    private static int potencia(int base, int exponente){
        //Eleva un número a otro
        int potencia = 1;
        for(int i = 0; i<exponente;i++){
            potencia *= base;
        }
        System.out.println("El resultado es: "+potencia);
        return potencia;
    }
    
    private static void tablaMultiplicar() {
        // Tablas de multiplicar desde 0 a 10
        int acumulado;
        acumulado = 0;
        //Definimos la iteracion
        for (int contadorInicio=1;contadorInicio<=11; contadorInicio++){
            //Con este bucle for creamos el primer numero a multiplicar
            for (int contadorTabla=0;contadorTabla<=10; contadorTabla++){
                //Con este bucle for creamos el numero por el cual se multiplica y mostramos el resultado
                System.out.println(acumulado+"*"+contadorTabla+"="+(acumulado*contadorTabla));
            }
            acumulado++;
        }
    }
    
    private static void primosHasta(int cuentaHasta){
        //Nos muestra los números primos desde 0 hasta el número pasado por parámetro 
        int secuencia, primo;
        secuencia=1;
        primo=0;
        //Comenzamos iteración
        while(secuencia<=cuentaHasta){
            int sumador=0;//aquí guardamos por cuantos números es divisible el número iterado
            for (int division=1; division<=secuencia; division++){
                if (secuencia%division==0){
                    ++sumador;//Si el numero es divisible por 0 se suma aqui
                }
            }
            if (sumador==2){
                primo++;//Si el numero solo es divisible 2 veces es por que es primo
                //Se divide por 1 y por el mismo, es decir 2 veces.
                //System.out.println(secuencia);
            }
            ++secuencia;//Aumentamos la secuencia para pasar al siguiente número
        }
        System.out.println("Los números primos son: "+primo);
    }
    
    private static void notaAlumno(int nota){
        //Método que devuelve si un alumno aprueba o no segun su nota.
        int suspenso=0;
        int aprobado=0;
        int condicion=0;
        int cont = 0;
        do{
            if(nota<4){
                suspenso++;
            } 
            if(nota==4){
                condicion++;
            }
            if (nota>=5){
                aprobado++;
            }
            cont++;
        }while(cont<=6);
        System.out.println("Aprobados: "+aprobado);
        System.out.println("Condicionados : "+condicion);
        System.out.println("Suspendidos: "+suspenso);
    }
    
    private static void divsiblePor3(int num){
        if (num%3 == 0){ //Si el número dividido por 3 tiene resto 0, es múltiplo
                System.out.println("Este un número: "+num+", es múltiplo de tres.");
            }
    }
    
    private static void sueldoMasGrande(double sueldo){
        //Indica cual es el mayor de entre 10 sueldos
        int sueldos = 10;
        int cont=1;
        double sueldoMax=0;
        do {
            if (sueldo>sueldoMax){
                sueldoMax=sueldo;
            }
            cont++;
        }while(cont>=sueldos);
        System.out.print("El sueldo mas alto es:  "+sueldoMax);
    }
    
    private static void rombo(){
        //Dibuja un rombo mediante anidamiento de for (pero sin anidar)
        int i;
        int j;
        String k= " ";
        String h = "*";
        
               
        for (i=0; i<1; i++){
            System.out.println(k+k+k+h);
        }
        for (i=1; i<=1; i++){
            System.out.println(k+k+h+h+h);
        }
        for (i=1; i<=1; i++){
            System.out.println(k+h+h+h+h+h);
        }
        for (i=1; i<=1; i++){
            System.out.println(k+k+h+h+h);
        }
        for (i=0; i<1; i++){
            System.out.println(k+k+k+h);
        }
    }
    
    private static int numeroCifrasDos(long b){
        //Devuelve el numero de cifras de un número dado
        int cont=0;
        do{
            b=b/10;
            ++cont;
        }while(b>=1);
        return cont;
    }
     
    private static double tuDescuento(double precioAntes, double precioActual){
        //Muestra y devuelve el descuento aplicado a un producto, dandole 
        //El precio anterior y el actual
        double descuento=100-(100*precioActual/precioAntes);
        System.out.println("El descuento es: "+ descuento +"%");
        return descuento;
    }
    
    private static double centrigradosAFarenheit(double num){
        //Devuelve el valor de grados Centigrados por parametro en grados Farenheit
        double respuesta;
	respuesta = (1.8)*num+32;
	return respuesta;
    }
    
    private static double farenheitACentigrados(double num){
        //Devuelve el valor de grados Farenheit por parametro en grados Centigrados
        double respuesta;
	respuesta = (num-32)/1.8;
	return respuesta;    
    }
    
    private static boolean Descompuesto(int num){
        //Devuelve true o false si le damos un número de 5 cifras que sea capicua
        boolean capicua;
        int decenaMillar, millar, centena, decena, unidad;
        decenaMillar= num/10000;
        millar = (num/1000)-(decenaMillar*10);
        centena = (num/100)-(decenaMillar*100)-(millar*10);
        decena = (num/10)-(decenaMillar*1000)-(millar*100)-(centena*10);
        unidad = (num%10);
        if(millar==decena && decenaMillar == unidad){
           return capicua=true;
        }else{
           return capicua=false;
        } 
    }
    
    private static int combinatoria(int n, int r){
        //Veduelve r posibles combinaciones de n, siendo estos dos numeros dados
        if( r == 0 || r == n){
            return 1;}
        if( r > n){
            return 0;}
        int a , b;
        a = combinatoria ( n - 1 , r -1 );
        b = combinatoria ( n - 1 , r );
        return a + b;    
    }
    
    private static void esPar(int num){
        //Indica que un número es par
        if(num%2==0){
            System.out.println(num +" es par.");
        }  
    }
    
    private static void Impares(int num){
        //Indica que un número es impar
        if(num%2!=0){
                System.out.println(num +" es impar.");
            }
    }
    
    private static void trianguloDeN (int num){
        //Crea un triangulo de tantas filas como el número dado y compuesto por
        //números que van desde cero hasta el número dado
        int aux;
            for (int i=1;i<=num;i++){
                aux=i;
                for (int j=0;j<i;j++){
                    System.out.print(aux);
                }
            System.out.println("");
        }
    }
    
    private void multiploDeCinco(int num){
        //Indica si un número es multiplo de 5
        if(num%5!=0){
                System.out.println(num+" es multiplo de cinco.");
            }
    }
    
    private static double millasAMetros(double millas) {
        //Pasa las millas a metros
        double metros;
        return metros = millas*1852;
    }
    
    private static double millasAKilometros(double millas){
        //Pasa los metos a millas
        double metros;
        return metros = millas*1.8;
    }
    
    private static void numeroAmstrom(int elNum){
        //Indica si un número es de Amstrom o no 
        if((elNum/100)==0 || (elNum/10)==0){
            System.out.print("El número debe ser de tres cifras! ");
        }
        int centenas = (elNum/100);
        int decenas = (elNum/10)-(centenas*10);
        int unidades = (elNum%10);
        int sumaNum = (int)(Math.pow(centenas, 3))+(int)(Math.pow(decenas, 3))+(int)(Math.pow(unidades, 3));
        System.out.println(centenas+"+"+decenas+"+"+unidades+"="+sumaNum);
        int cont = 0, producto = 1;
        System.out.println("El número "+((elNum==sumaNum)?"si es Amstrom":"no es Amstrom"));
    }
    
    private static int sumaDosDigitos(int numero){
        //Devuelve la suma de los digitos del número pasado por parámetro
        if (numero == 0){
            return numero;
        }else{
            return sumaDosDigitos(numero/10)+(numero%10);
        }
    }
    
    private static int euclides(int n, int m){
        //Devuelve el numero de euclides dados dos números por parametro 
        if (m==0) {
            return n;
        }else{    
            return euclides(m,n%m);
        }
    }
    
    private static int MultiplicacionEnteros (int primerNumero, int segundoNumero){
        //Multiplica y devuelve dos números enteros
        if (segundoNumero == 1){
            return primerNumero;
        }else{
            return primerNumero+MultiplicacionEnteros(primerNumero, --segundoNumero);
        }
    }
    
    private static void fibonacci(int limite){
        //Imprime la secuencia hasta el número dado por parámetro
        for(int i = 0; i<limite; i++){
           System.out.print(funcionFibonacci(i) + ", ");
        }
    }
    
    private static int funcionFibonacci(int num){
        //Devuelve la secuencia de fibonacci
        if(num == 0 || num==1)
            return num;
        else
            return funcionFibonacci(num-1) + funcionFibonacci(num-2);
    }
    
    private static int multiplicacion(int num1, int num2){
        //Multiplicación de dos números en recursiva
        if (num1== 0 || num2 == 0){
            return 0;
        }else{
            return num1+multiplicacion(num1, --num2);
        }
    }
    
    private static int potenciaR(int base, int exp){
        //Metodo recursivo de potencias
        if (exp==1){
            return base;
        }else{
            return base*potencia(base, --exp);
        }
    }
    
    private static int factorialR(int numero){
        //Método recursivo que realiza el factorial de un número
        if (numero==1){
            return 1;
            
        }else {
            return numero*factorial(--numero);
        }
    }
    
    private static int sumaHastaN (int n){
        //Método recursivo que realiza la suma de todos los números hasta n
        if (n==0){
            return 0;
        }else{
            return n+sumaHastaN(--n);
        }
    }
    
    private static void ordena(int[] numero){
        //Ordena de menor a mayor un array de enteros
        int i, j, aux;
        for(i = 0; i<numero.length-1; i++){
            for(j=0; j<numero.length-i-1; j++){
                if(numero[j+1]<numero[j]){
                    aux=numero[j+1];
                    numero[j+1]=numero[j];
                    numero[j] = aux;
                }
            }
        }
    }
    
    private static void alatorio(int[] vector){
        //LLena un array de números aleatorios de 0 a 1000
        Random r = new Random();
        for(int i=0; i<vector.length; i++){
            vector[i] = r.nextInt(999);
  
        }
    }
    
    private static int busquedaBinaria(int []vector,int posInicial, int posFinal, int elemento) {
        //Método para realizar busquedas binarias en vectores de enteros
        //Devuelve -1 y si no encuentra el elemento dentro del array
    	if (posInicial>=0 && posInicial<=posFinal && posFinal>=0) {
            int mitad = ((posFinal - posInicial)/2) +posInicial;   		
            if (vector[mitad] > elemento) {
                return busquedaBinaria(vector, posInicial, mitad-1, elemento);	
            }else if (vector[mitad] < elemento) {
    		return busquedaBinaria(vector, mitad+1, posFinal, elemento);
            }else {
    		return vector[mitad];
            }
        }	
    	return -1;
    }
    
    private static int[] maximo(int[] vector){
        //Devuelve un array con los ultimos 10 elementos de un array de 1000
        //Si previamente se ha ordenado de menor a mayor pueden sacarse los 10 mayores
        int[] maximo = new int[10];
        int cont=0;
        for (int i=0; i<(vector.length);i++){
            if(i>990){
            maximo[cont] = vector[i];
            cont++;
            }
        }
        System.out.println(cont);
        return maximo;
    }
    
    private static void ordeacionInsercion(int[] array){
        //Sistema de ordenación por inserción
        int j;
        for (int i = 1; i<array.length; i++){
            int a= array[i];
            for(j=i-1; j>0 && array[j]>a; j--){
                array[j+1] = array[j];
            }
            array[j+1]=a;
        }
    }
    
    private static int busquedaSecuencial(int []vector,int dato){
        //Busqueda secuencial 1 a 1, devuelve la posicion del elemento 
        //si lo encuentra y -1 si no lo encuentra
        int posicion = -1;
         for(int i = 0; i < vector.length; i++){//recorremos todo el arreglo
             if(vector[i] == dato){//comparamos el elemento en el arreglo con el buscado
           posicion = i;//Si es verdadero guardamos la posicion
           return posicion;
           //break;//Para el ciclo
          }
        }
        return posicion;
    }
    
    private static int encontrarMaximo(int[] numero){
        //Encuentra el maximo en un array
        int maximo = numero[0];
        
        for (int i = 1; i<numero.length; i++ ){
            if (numero[0] >maximo){
                maximo = numero[i];
            }
        }
        return maximo;
    }
    
    private static int encontrarMinimo(int[] numero){
        //Encuentra el mínimo de un array
        int minimo = numero[0];
        
        for (int i = 1; i<numero.length; i++ ){
            if (numero[0] <minimo){
                minimo = numero[i];
            }
        }
        return minimo;
    }
    
    private static char[] alfabeto(){
        //Devuelve un array con las letras del alfabeto en mayusculas
        //Primero lo hice a la vieja usanza, un array con el alfabeto
        char[] s = new char[26];/* = {'A','B','C','D','E','F','G','H','I','J','K',
            'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};*/
        //Descubrí que los char si les ponemos un número casteando a char 
        //nos muestra una letra, por su código numérico, con lo cual 
        //podemos generar el array automaticamente o no usar ni array.
        for (int i=0;i<26;i++){
            //Casteando a char un int para meterlo en su hueco del array
            s[i] = (char) ('A'+i);
        }
        //Devolvemos un array con el alfabeto completo 
        return s;
    }
    
    //Creamos un array constante con todas las letras posibles
    private static final char[] LETRA = {'T','R','W','A','G','M','Y','F','P','D',
        'X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private static char getLetraDni(int numDni) {
        //Junto con el método anterior devuelve la letra de cualquier número de DNI
	return LETRA[numDni%23];
    }
    
    private static boolean compara1(char[] comp){
        //Este método compara elementos del array (si dos son iguales)=true
        for(int i=0; i<comp.length; i++){
            for (int j=i+1; j<comp.length; j++){
                
                    if (comp[i] == comp[j]){
                        return true;
                    }
            }
        }
        return false;
    }
    
    private static boolean compara(char[] comp){
        //Este método compara elementos del array (si tres son iguales)=true
        for(int i=0; i<comp.length; i++){
            for (int j=i+1; j<comp.length; j++){
                for (int x=j+1; x<comp.length; x++){
                    if (comp[i] == comp[j] && comp[j] == comp[x]){
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }
    
    private static int buscarCadena(String cadena, String subcadena){
        //Este método devuelve el número de veces que se repite una subcadea en una cadena
        int cont = 0, indice = 0;
        
        //Devuelve -1 cuando no encuentra la subcadena 
        while((indice = cadena.indexOf(subcadena, indice)) != -1) {
            
            //Creamos una subcadena desde la siguiente posicion a 
            //la cadena encontrada anteriormente
            indice += subcadena.length() - 1;
            cont++;
        }
        //Retorna el número de veces que se repite subcadena en cadena.
        return cont;
    }
    
    private static String invertir(String frase){
        //Devuelve un string con la palabra invertida desde la mitad de la misma
        //Creamos un String para contener la inversión
        String fraseDos = "";
        for(int i=(frase.length())-2; i>=0; i--){
            char caracter = frase.charAt(i);
            fraseDos += caracter;
        }
        return "La cadena '"+frase+"' despues del método es "+frase+fraseDos+".";
    }
    
    private static void cuentaVocales(String frase){
        //Muestra el número de vocales de una frase
        int contador=0;
        for(int i=0; i<frase.length(); i++){
            char caracter = frase.charAt(i);
            if (caracter == 'o' || caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'u'){
                contador++;       
            }
        }
        System.out.println("La cadena '"+frase+"' tiene "+contador+" caracteres.");
    }
    
    private static int[][] invertirMatriz(int[][] matriz){
        //Invierte por filas una matriz bidimensional
        int [][] matrizInversa = new int [matriz.length][matriz[0].length];
        for (int i=0; i<matriz.length; i++){
            int cont = 0;
            for(int j = (matriz[i].length)-1; j>=0; j--){
                matrizInversa[i][cont] = matriz[i][j];
                cont++;
            }           
        }
        return matrizInversa;
    }
    
    private static String invertirCadena(String frase){
        //Devuelve una frase alreves
        String fraseDos = "";
        for(int i=(frase.length()-1); i>=0; i--){
            char caracter = frase.charAt(i);
            fraseDos += caracter;
        }
        return fraseDos;
    }
    
    private static double calculaMediaVector(double[] vector){
        //Dado un vector de decimales, devuelve la media de los valores
        int numeroSumas = 0;
        double sumaElementos =0;
        for (int i=0; i<vector.length; i++){
            if(vector[i] != 0){
                sumaElementos = sumaElementos + vector[i];
            }            
        }
        return sumaElementos/vector.length;
    }
    
    private static boolean compruebaNumeroArray(int numero, int[] arrayEnteros){
        //Devuelve true si el número existe en el array de enteros
        for(int i=0; i<arrayEnteros.length; i++){
            if (numero == arrayEnteros[i]){
                return true;
            }
        }
        return false; 
    }
    
    private static int borrarElemento(int num, int[] array){
    /*
    Este Metodo es el encargado de borrar un elemento del array
    Solo recorre el array hasta que encuentra la posicion 
    que le indicamos, cuando llega a esta, la iguala a cero
    Además devuelve 0 si la borra y si no devuelve -1.
    */
        try{
            for (int i=0; i<array.length; i++){
                if (array[i] == array[num]){
                    array[i] = 0;
                    return 0;
                } 
            }   
        }catch (Exception e){
            return -1;
        }
        return -1;
    }
    
    private static void encuentra(int[] numero, int num){
        //Este método busca un valor dado en un array
        for (int i=0; i<numero.length; i++){
            if(numero[i] == num){
                
            }
        }
    }
    
    private static void mostrar(int[][] matriz){
        //Este método muestra nuestra matríz de manera ordenada
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print("- " + matriz[i][j] + " ");
            }
            System.out.print("\n"); 
        }   
    }
    
    private static int[] sumarOrdenar(int[][] matriz) {
        //Sumaremos las filas de una matriz y devolveremos un array con los resultados
        int[] mem = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            mem[i]=0;
            for (int j = 0; j < matriz[i].length; j++) {
                mem[i] = mem[i] + matriz[i][j];
            }
        }
        return mem;
    }
    
    private static void repetidos(StringBuffer stb){
        //Elimuna las vocales de un StringBuffer y lo muestra
        for(int i=0; i<stb.length(); i++){
            if(stb.charAt(i) == 'a' ||
                    stb.charAt(i) == 'e' ||
                    stb.charAt(i) == 'i' ||
                    stb.charAt(i) == 'o' ||
                    stb.charAt(i) == 'u' ||
                    stb.charAt(i) == 'A' ||
                    stb.charAt(i) == 'E' ||
                    stb.charAt(i) == 'I' ||
                    stb.charAt(i) == 'O' ||
                    stb.charAt(i) == 'U'
                    ){
                stb.deleteCharAt(i);
            }
        }
        System.out.println(stb);
    }
    
    private static boolean esCapicua(int num){
        //Devuelve true o false si el número es capicua usando StringBuffer
        boolean esCapicua = false;       
        StringBuffer str = new StringBuffer(String.valueOf(num));       
        if (str.reverse().toString().equals(String.valueOf(num))){
            esCapicua = true;            
        }
        return esCapicua;      
    }
    
    private static long tiempoInicial(){
        //Devuelve el tiempo inicial desde el 1 de enero de 1970 en milisegundos
        long tiempoIncialuno = System.currentTimeMillis();
        return tiempoIncialuno;
    }
    
    private static long tiempoFinal(){
        //Devuelve el tiempo final desde el 1 de enero de 1970 en milisegundos
        long tiempoFinaluno = System.currentTimeMillis();
        return tiempoFinaluno;
    }
    
    
    private static boolean eliminaElementoArray(int[] array, int elemento){
        //Elimina elementos de un array
        for (int x = 0; x < 10; x++) {
            if(array[x] == elemento){
                array[x] = 0;
                for (int j = x; j < (array.length)-1; j++) {
                    array[j] = array[j+1];
                }
                array[array.length-1] = 0;       
                return true;
            }                    
        }
        return false;
    }
    
    private static int[] copiaArraySin(int []array){
        //Copia un array 
        int []array2 = new int[array.length];        
        for (int i = 0; i < array.length-1; i++) {
            array2[i] = array[i];
        }       
        return array2;
    }
    
    private static int[] copiaArrayCon(int []array){
        //Copia un array con Arrays.copyOf
        int[] array2 = new int[array.length];
        array2 = Arrays.copyOf(array, array.length);
        return array2;
    }
    
    private static boolean insertaElementoArray(String [] array, String elemento, int posicion){
        //Devuelve true si consigue añadir elemento al array y false si está la posicion ocupada
        if(posicion<array.length){
            if (array[posicion] == null){
                Arrays.fill(array, posicion, posicion+1, elemento);
                return true;
            }
        }        
        return false;
    }
    
    private static int[] mayorMenorInt (int[] array){
        //Ordena un array de int de mayor a menor
        Arrays.sort(array);
        return array; 
    }
    
    private static String[] mayorMenorString (String[] array){
        //Ordena un array de String de mayor a menor
        Arrays.sort(array);
        return array;
    }
    
    private static void mayorMenorString (Object[] array){
        //Muestra el mayor y el menor de un array de objetos
        Arrays.sort(array); 
        System.out.println(array[0]);
        System.out.println(array[array.length-1]);
    }

    private static Object[] reverseElementosArrayParaCualquierTipo(Object []array){
        //devuelve un array de lo que sea del revés
        Object[] arrayTemporal = new Object[(array.length)];
        int contC = 0;
        for (int y=(array.length)-1; y>=0; y--) {
                arrayTemporal[contC] = array[y];
                contC++;
            } 
        return arrayTemporal;        
    }
    
    private static int[] reverseElementosArray(int []array){
        //devuelve un array de enteros del revés
        int[] arrayTemporal = new int[(array.length)];
        int contC = 0;
        for (int y=(array.length)-1; y>=0; y--) {
                arrayTemporal[contC] = array[y];
                contC++;
            } 
        return arrayTemporal;       
    }
    
    private static void escribeElementosRepetidosArray(String[] array){
        //Comparamos el segundo con el primero, el tercero con el segundo y sucesivamente
        Arrays.sort(array);
        //Solo funciona si esta ordenado
        for(int i = 1; i < array.length; i++) { // recorremos todo el array
            if(array[i].equals(array[i-1])) { // Comparamos si i es igual a su anterior
                System.out.println("Se repite el num: " + array[i]); // mostramos en pantalla
            }
        }         
    }
        
    private static void escribeElementosRepetidosArraySinOrden(String[] array){
        //Muestra y Comparamos el segundo con el primero, el tercero con el segundo y sucesivamente
        for(int i = 0; i < array.length; i++) { // recorremos todo el array
            for (int j = i+1; j < array.length; j++) {
                if(array[i].equals(array[j])) { // Comparamos si i es igual a su anterior
                    System.out.println("Se repite el num: " + array[i]); // mostramos en pantalla
                }
            }
        }         
    }
    
    private static String[] llenaArrayCadena(String[] array){
        //Rellenamos un array de cadenas 
        for (int i = 0; i < array.length; i++) {
            Random r = new Random();            
            array[i] = "Hola"+i+r.nextInt(100);
        }        
        return array;        
    }
    
    private static String[] escribeElementosRepetidosArraySinOrdenDevuelve(String[] array){
        //Devuelve y Comparamos el segundo con el primero, el tercero con el segundo y sucesivamente
        String[] cad = new String[array.length];        
        for(int i = 0; i < array.length; i++) { // recorremos todo el array
            for (int j = i+1; j < array.length; j++) {
                if(array[i].equals(array[j])) { // Comparamos si i es igual a su anterior
                    cad[i] = array[i];                    
                }
            }
        } 
        return cad;        
    }   
    
    private int compareTo(Object obj){
        //Método que devuelve un array comparando sus elementos y ordenado
        int Object = 0;
        //return this.id-obj.id;
        //Ordena crecientemente
        //return -this.id-obj.id;
        //Ordena decrecientemente
        return Object;
    }
    
    public int comparteTo(Object obj){
        int Object = 0;
        //Método que devuelve un array comparando sus elementos y ordenado
        //return this.nombre.compareTo(obj.getNombre());
        //Por orden alfabetico creciente
        //return -this.nombre.compareTo(obj.getNombre());
        //Por orden alfabetico decreciente
        return Object;
    }
    
    private static boolean diagonal(int [][]matriz){
        //Devuelve true si la matriz es diagonal, es decir
        //son todo ceros menos la linea diagonal
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(i!=j){
                    if(matriz[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static boolean triangularBajo(int [][]matriz){
        //Devuelve true su la matriz tiene a cero las posiciones por encima de la diagonal
        if(matriz.length == matriz[0].length){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if(i<j){
                        if(matriz[i][j]!=0){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    private static boolean simetricMatriz(int[][] matriz){
        //devuelve true si la matriz es simetrica
        boolean esSimetrica = false;
        if (matriz.length == matriz[0].length){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if ( matriz[i][j] != matriz[j][i]){
                        return false;
                    }
                }
            }
            return true;
        }
        return esSimetrica;
    }
    
    public static void lideres(int[] array) {
        //Muestra lso números del array que despues de ellos
        //No tienen ninguno mayor que ellos mismos.
        boolean esta= false;
        for (int i = 0; i < array.length-1; i++) {
            esta=true;
            for (int j = i+1; j < array.length; j++) {
                if(array[i]<=array[j]){
                    esta = false;
                }
            }
            if(esta){
            System.out.println(array[i]+ " es lider");
            } 
        }   
    }
    
    private static void segregaVector(int[] array, int posicion){
        //Pone todas las posiciones antes del número dado a cero
        //Pone todas las posiciones despues del número dado a 1
        //deja la posicion indicada por el número con su valor original
        for (int i = 0; i < array.length; i++) {
            if(i < posicion){
                array[i] = 0;
            }else if(i==posicion){
                array[i]=array[i];
            }else if(i>posicion){
                array[i]=1;
            }
            System.out.println(array[i]);
        }
    }
    
    private static int[] separeElementos(int[] n){
        //devuelve el array dado ordenando los pares primero y los impares depsues
        int[] par = new int[n.length];
        int[] impar = new int[n.length];
        int i;
        int pares = 0;
        int impares = 0;   
        for (i = 0; i < n.length; i++) {
            // Separa los números metiendo los pares en un array
            // y los impares en otro.
            if (n[i] % 2 == 0) {
                par[pares++] = n[i];
            } else {
                impar[impares++] = n[i];
            }
        }       
        // Mete los pares en las primeras posiciones
        // del array original.
        for (i = 0; i < pares; i++) {
            n[i] = par[i];
        }   
        // Mete los impares en los huecos que quedan.
        for (i = pares; i < n.length; i++) {
            n[i] = impar[i - pares];
        }
        // Muestra el resultado.
        System.out.println("Array con los pares al principio:");
        for (i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }        
        return n;
    }
    
    private static int[] reemplazaMayor(int[] array){
        //Reemplaza todas las posiciones menos la primera por el número mayor del array
        int j;
        int f = 0;
        for (int i = 1; i<array.length; i++){
            int a= array[i];
            for(j=i-1; j>0 && array[j]>a; j--){
                array[j+1] = array[j];
                f=array[j];
            }
            array[j+1]=a;
        }
        //System.out.println(f);
        for (int i = 1; i < array.length; i++) {
            array[i] = f;
        }
        return array;
    }
    
    private static int mediaEnterosMenosMayorYMenor (int[]array){
        //Devuelve la media de un array sin contar el primer puesto y el ultimo
        int media = 0;
        int resp;
        int j;
        for (int i = 1; i<array.length; i++){
            int a= array[i];
            for(j=i-1; j>0 && array[j]>a; j--){
                array[j+1] = array[j];
                   
            }
            array[j+1]=a;
        }
        for (int i = 1; i < array.length-1; i++) {
            media = media + array[i];
            //System.out.println(media);
        }
        resp = media/((array.length)-2);
        return resp;
    }
    
    private static void masPequeMasGrande(int[] array){
        //Muestra el mas pequeño y mas grande del array dado por parametro
        int grande=0;
        int peque=0;
        int j;
        for (int i = 1; i<array.length; i++){
            int a= array[i];
            for(j=i-1; j>0 && array[j]>a; j--){
                array[j+1] = array[j];
                grande = array[j];   
            }
            array[j+1]=a;
        }
        peque = array[0];
        System.out.println("El más pequeño es " + peque + " y el más grande es " + grande);
    }
    
    //Muestra y dos matrices simetricas son iguales
    public static boolean matrizSimetricaIgual(int[][] matriz) {
		boolean dist = true;
		boolean dist2 = false;
		int valor1 = matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (valor1 != matriz[i][j]) {
					dist = false;
				}
				if (matriz.length == matriz[0].length) {
					dist2 = true;
				}
			}
		}
		boolean resp = (((dist) && (dist2)) ? true : false);
		return resp;
	}
	
    //Comprueba si todos los numeros de un array son diferentes
	public static boolean todosDistintos(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length-1; j++) {
				if (array[i] == array[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Comprueba si todos los numeros de un array son iguales
	public static boolean todosIguales(int[] array) {
		
		for (int i = 1; i < array.length; i++) {
			if (array[0] != array[i]) {
				return false;
			}
		}
		return true;
	}
}
