import java.util.Iterator;

public class main {

    public static void main(String[] args) {
        // Neue Liste erstellen
        LinkedList tolleListe = new LinkedList();

        // Mit Dummy Daten füllen
        // eins bis zehn, Liste zeigt damit aktuell auf den letzten Eintrag
        seedData(tolleListe);

        // Löschen des letzten Eintrages
        tolleListe.remove();


        // Daten der Liste von Anfang ausgeben
        writeData(tolleListe);


        // Wieder an den Anfang der Liste gehen
        // Und ersten Eintrag Löschen
        tolleListe.ersterverketteteListe();
        tolleListe.remove();

        // Erstes Element ausgeben
        tolleListe.get();

        System.exit(0);
    }


    private static void writeData(LinkedList lList) {
        // An den Anfang der Liste gehen
        lList.ersterverketteteListe();

        // Ersten Einrtag ausgeben und
        // Iterieren für den Rest
        System.out.println(lList.getAktuelleDaten());
        for (Iterator iterator = lList; iterator.hasNext(); ) {
            lList.next();
            System.out.println(lList.getAktuelleDaten());
        }

    }


    private static LinkedList seedData(LinkedList lList) {
        // Dummy Daten
        lList.add("Eins");
        lList.add("Zwei");
        lList.add("Drei");
        lList.add("Vier");
        lList.add("Fünf");
        lList.add("Sechs");
        lList.add("Sieben");
        lList.add("Acht");
        lList.add("Neun");
        lList.add("Zehn");

        return lList;
    }

}