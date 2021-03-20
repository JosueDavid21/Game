package control;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;


public class Grafo {

    char[] nodos;  // Letras de identificacion de nodo
    int[][] grafo;  // Matriz de distancias entre nodos
    String rutaMasCorta;                           // distancia mas corta
    int longitudMasCorta = Integer.MAX_VALUE;   // ruta mas corta
    List<Nodo> listos = null;

    // construye el grafo con la serie de identificadores de nodo en una cadena
    public Grafo(String serieNodos) {
        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }

    // asigna el tamano de la arista entre dos nodos
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2] = distancia;
        grafo[n2][n1] = distancia;
    }

    // retorna la posicion en el arreglo de un nodo especifico
    public int posicionNodo(char nodo) {
        for (int i = 0; i < nodos.length; i++) {
            if (nodos[i] == nodo) {
                return i;
            }
        }
        return -1;
    }
    char arregloruta[];
int distanciatotal;
public int facil;
   public     int medio;
   public     int dificil;
    // encuentra la ruta mas corta desde un nodo origen a un nodo destino
    public String encontrarRutaMinimaDijkstra(char inicio, char fin) {
        // calcula la ruta mas corta del inicio a los demas
        encontrarRutaMinimaDijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        if (!listos.contains(tmp)) {
            System.out.println("Error, nodo no alcanzable");
            return "Bye";
        }
        tmp = listos.get(listos.indexOf(tmp));
        int distancia = tmp.distancia;
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<Nodo> pila = new Stack<Nodo>();
        while (tmp != null) {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = "";
        // recorre la pila para armar la ruta en el orden correcto
        char da[] = new char[pila.size()];
        int u = 0;
        while (!pila.isEmpty()) {
            da[u] = pila.pop().id;
            u++;

        }
        arregloruta = da;
        distanciatotal=distancia;
        return distancia + " KM Recorridos | La Mejor Ruta es: " + Arrays.toString(rutaisla(arregloruta));

    }

    // encuentra la ruta mas corta desde el nodo inicial a todos los demas
    public void encontrarRutaMinimaDijkstra(char inicio) {
        Queue<Nodo> cola = new PriorityQueue<Nodo>(); // cola de prioridad
        Nodo ni = new Nodo(inicio);          // nodo inicial

        listos = new LinkedList<Nodo>();// lista de nodos ya revisados
        cola.add(ni);                   // Agregar nodo inicial a la cola de prioridad
        while (!cola.isEmpty()) {        // mientras que la cola no esta vacia
            Nodo tmp = cola.poll();     // saca el primer elemento
            listos.add(tmp);            // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);
            for (int j = 0; j < grafo[p].length; j++) {  // revisa los nodos hijos del nodo tmp
                if (grafo[p][j] == 0) {
                    continue;        // si no hay conexion no lo evalua
                }
                if (estaTerminado(j)) {
                    continue;      // si ya fue agregado a la lista de terminados
                }
                Nodo nod = new Nodo(nodos[j], tmp.distancia + grafo[p][j], tmp);
                // si no esta en la cola de prioridad, lo agrega
                if (!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                // si ya esta¡ en la cola de prioridad actualiza la distancia menor
                for (Nodo x : cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if (x.id == nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod);  // agrega el nodo con la nueva distancia
                        break;          // no sigue revisando
                    }
                }
            }
        }
    }

    // verifica si un nodo ya esta en lista de terminados
    public boolean estaTerminado(int j) {
        Nodo tmp = new Nodo(nodos[j]);
        return listos.contains(tmp);
    }
public void iniciargrafo(Grafo g) {
        g.agregarRuta('a', 'b',5 );
        g.agregarRuta('a', 'c',7 );
        g.agregarRuta('a', 'd',7 );
        g.agregarRuta('b', 'c',5 );
        g.agregarRuta('b', 'd',2 );
        g.agregarRuta('c', 'e',10 );
        g.agregarRuta('c', 'f',10 );
        g.agregarRuta('d', 'e',4 );
        g.agregarRuta('d', 'g',4 );
        g.agregarRuta('e', 'f',6 );
        g.agregarRuta('e', 'g',6 );
        g.agregarRuta('f', 'h',3 );
        g.agregarRuta('f', 'i',3 );
        g.agregarRuta('g', 'h',9 );
        g.agregarRuta('g', 'k',9 );
        g.agregarRuta('h', 'i',1 );
        g.agregarRuta('h', 'j',8 );
        g.agregarRuta('h', 'k',8 );
        g.agregarRuta('i', 'j',2 );
        g.agregarRuta('j', 'k',4 );
        
    }
    public String[] rutaisla(char isla[]) {
        String islas[] = {
            /*a*/"volcan",
            /*b*/"desierto",
             /*c*/"flor",
             /*d*/"amor",
             /*e*/"calavera",
             /*f*/"circo",
             /*g*/"militar",
             /*h*/"ruina",
             /*i*/"selva",
             /*j*/"playa",
             /*k*/"dulce"};
        char islaschar[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        String recorridoislas[] = new String[isla.length];
//        System.out.println("arregloruta"+Arrays.toString(arregloruta));
        for (int i = 0; i < isla.length; i++) {
            for (int j = 0; j < islaschar.length; j++) {
                if (isla[i] == islaschar[j]) {
                    recorridoislas[i] = islas[j];
                }
            }

        }

        return recorridoislas;
    }
    public char String_char(String nombre_isla) {
char char_isla=' ';
switch (nombre_isla){
    case"volcan":{
        char_isla='a';
        break;
    }case"desierto":{
        char_isla='b';
        break;
    }
    case"flor":{
        char_isla='c';
        break;
    }
    case"amor":{
        char_isla='d';
        break;
    }
    case"calavera":{
        char_isla='e';
        break;
    }
    case"circo":{
        char_isla='f';
        break;
    }
    case"militar":{
        char_isla='g';
        break;
    }
    case"ruina":{
        char_isla='h';
        break;
    }
    case"selva":{
        char_isla='i';
        break;
    }
    case"playa":{
        char_isla='j';
        break;
    }
    case"dulce":{
        char_isla='k';
        break;
    }
    
    
}
        return char_isla;
    }


    // evaluar la longitud de una ruta
    public int evaluar(Stack<Integer> resultado) {
        int resp = 0;
        int[] r = new int[resultado.size()];
        int i = 0;
        for (int x : resultado) {
            r[i++] = x;
        }
        for (i = 1; i < r.length; i++) {
            resp += grafo[r[i]][r[i - 1]];
        }
        return resp;
    }
public String [] rutaDificultad(char inicio,String dificultad){
    String ruta[]=null;
    String rutafinal[]=null;
    Grafo g = new Grafo("abcdefghijk");
        g.iniciargrafo(g);
        String rutafacil[]=null;
        String rutamedio[]=null;
        String rutadificl[]=null;
        
    for (int i = 0; i < 11; i++) {
        
       String respuesta= g.encontrarRutaMinimaDijkstra(inicio, g.nodos[i]);
       ruta=g.rutaisla(g.arregloruta);
            if (ruta.length<=2) {
                rutafacil=ruta;
                facil=g.distanciatotal;
                
        }else if(ruta.length==3  ){
            rutamedio=ruta;
            medio=g.distanciatotal;
        }
            else if(ruta.length>5 || ruta.length>=4 ){
           rutadificl=ruta;
           dificil=g.distanciatotal;
        }
        }
switch (dificultad.toLowerCase().trim()){
    case "facil":{
//        System.out.println(facil);
        rutafinal=rutafacil;
        break;
    }
    case "medio":{
        rutafinal=rutamedio;
//        System.out.println(medio);
        break;
        
    }
    case "dificil":{
        rutafinal=rutadificl;
//        System.out.println(dificil);
        break;
    }
}    

    return rutafinal;
}
    

    public static void main(String[] args) {
        Grafo g = new Grafo("abcdefghijk");
        g.iniciargrafo(g);
        
        char inicio = 'c';//isla inicial 
        
        char fin = 'e';
        System.out.println("RUTAS POSIBLES DESDE "+inicio+" hacia las demas islas");
//        String respuesta=g.encontrarRutaMinimaDijkstra(inicio, fin);
//            System.out.println(respuesta);
//        for (int i = 0; i < 11; i++) {
//            String respuesta=g.encontrarRutaMinimaDijkstra(inicio, g.nodos[i]);
//            System.out.println(respuesta);
//        }
//    }
//String []da={"facil","medio","dificil"};
//for (int i = 0; i < 3; i++) {
//            System.out.println(Arrays.toString(g.rutaDificultad(inicio, da[i])));
//            
//        }
System.out.println(Arrays.toString(g.rutaDificultad(inicio,"difiCil")));
System.out.println(g.dificil);
//System.out.println(g.facil);
//            System.out.println(g.medio);
//            System.out.println(g.dificil);
    }
    
    

}
