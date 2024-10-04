package antoniocostantini;

import antoniocostantini.entities.*;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class  Application {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        List<Gioco> listaGiochi = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if(rand.nextBoolean()){
                String titolo = faker.book().title();
                String[] piattaforme = {"playstation","Xbox","Nintendo","SEGA"};
                Generi[] generi = Generi.values();
                Videogioco vid = new Videogioco(titolo,generi[rand.nextInt(generi.length)], rand.nextDouble(200) + 1,piattaforme[rand.nextInt(piattaforme.length)], rand.nextInt(40) + 1, rand.nextInt(1950, 2025));
                listaGiochi.add(vid);
            } else {
                String titolo = faker.book().title();
                GiocoDaTavolo gioco = new GiocoDaTavolo(titolo, rand.nextInt(-2000,2025), rand.nextDouble(200) + 1, rand.nextInt(2, 11), rand.nextInt(20,500));
                listaGiochi.add(gioco);
            }
        }

        listaGiochi.forEach(g -> { if(g instanceof Videogioco videogame){
            System.out.println(videogame);
        } else if (g instanceof GiocoDaTavolo gioco){
            System.out.println(gioco);
        }
        });

        Collezione lista = new Collezione(listaGiochi);

            Videogioco g = new Videogioco(faker.book().title(),Generi.ARACDE,23.44, "Ps4", 5,2020);
        lista.addGioco(g);

        System.out.println(lista);

        System.out.println("Inserisci id");
        int id = Integer.parseInt(sc.nextLine());
        Gioco gioco = lista.getGiocoById(id);
        System.out.println(gioco);

        System.out.println("Inserisci il prezzo");
        int prezzo = Integer.parseInt(sc.nextLine());
        List<Gioco> pricelist = lista.getGiochiByPrice(prezzo);
        System.out.println(pricelist);

        System.out.println("Inserisci il numero di giocatori");
        int numero = Integer.parseInt(sc.nextLine());
        List<Gioco> numList = lista.getGiochiBynumeroGiocatori(numero);
        System.out.println(numList);

        System.out.println("Inserisci l'id dell'elemento che vuoi eliminare");
        int id2 = Integer.parseInt(sc.nextLine());
        lista.deleteById( id2);
        System.out.println(lista);

        System.out.println("Inserisci l'id dell'elemento che vuoi modificare");
        int id3 = Integer.parseInt(sc.nextLine());
        lista.update( gioco, id3);
        System.out.println(lista);

        lista.Stats();


    }
}
