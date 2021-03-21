/*
 * Uversidad Central del Ecuador 
 * Facultad de Ingenieria y CIencias aplicadas
 * Ingenieria en Sistemas de Informacion
 * Algoritmos
 * Grupo 9 
 * Integrantes: 
 *       - Bolaños Josue
 *       - Espinosa David
 *       - Teran Edgar
 * Este es un juego que implementa el algoritmo del camino mas corto
 */

package listas;

import java.util.HashMap;

/**
 *
 * @author Grupo 9
 */

public class ListaPersonajes {

    private final HashMap<String, String[]> lista = new HashMap<>();
    private static final String AMOR[] = {" Buen dia vecinirijillo", "Es un dia hermoso", "Te vez bien amigo"};
    private static final String CALAVERA[] = {"Forastero!!!!", "Crees en los fantasmas???", "Hoy es un gran dia para morir"};
    private static final String VOLCAN[] = {"Cuidado las rocas", "Ese volcan no descansa....", "Entrre las rocas hay tesoros...!!!"};
    private static final String CIRCO[] = {"Quieres un globo???", "Quiero una entrada VIP", "Se feliz amigo..."};
    private static final String DULCE[] = {"No te comas las paredes....", "mmmmm... rosquillas...", "Comi muchos dulces..."};
    private static final String PLAYA[] = {"Creo que me broncie demasiado", "Vamos nadar viejo...", "Vamos dos que tres...."};
    private static final String SELVA[] = {"Cuidado los animales", "Todo es tranquilidad...", "En excelente lugar de aventuras...."};
    private static final String RUINA[] = {"Vivir aqui es un reto...", "Encontrare el tesoro...", "Todo ha cambiado..."};
    private static final String DESIERTO[] = {"Hace calor...", "Necesito una cantina...", "Bienvenido forastero!!!!"};
    private static final String FLOR[] = {"Aqui encontraras flores exoticas", "Bienvenido a un buen lugar", "Paz y tranquilidad"};
    private static final String MILITAR[] = {"Que haces soldado...!!!!!!", "Tener una medalla es un honor...", "A marchar recluta...."};

    public ListaPersonajes() {
        lista.put("amor", AMOR);
        lista.put("calavera", CALAVERA);
        lista.put("volcan", VOLCAN);
        lista.put("circo", CIRCO);
        lista.put("dulce", DULCE);
        lista.put("playa", PLAYA);
        lista.put("selva", SELVA);
        lista.put("ruina", RUINA);
        lista.put("desierto", DESIERTO);
        lista.put("flor", FLOR);
        lista.put("militar", MILITAR);
    }
    
    public String getFrase(String ubicacion, int tile){
        String[] list = lista.get(ubicacion);
        String retorno = "";
        if(tile==63){
            retorno = list[0];
        }else if(tile==64){
            retorno = list[1];
        }else if(tile==65){
            retorno = list[2];
        }
        return retorno;
    }
}
