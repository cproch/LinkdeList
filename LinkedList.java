import java.util.Iterator;

class LinkedList implements Iterable<Object>, Iterator<Object> {

    private verketteteListe aktuellerverketteteListe = null;
    private verketteteListe letzterverketteteListe = null;
    private verketteteListe ersterverketteteListe = null;

    public void add(Object data) {
        //Die Liste ist leer
        if (aktuellerverketteteListe == null) {
            aktuellerverketteteListe = new verketteteListe(null, null, data);
            ersterverketteteListe = aktuellerverketteteListe;
        } else {
            //An der verketteteListe hinten anhängen
            if (aktuellerverketteteListe.getSuccessor() == null) {
                aktuellerverketteteListe.setSuccessor(new verketteteListe(null, aktuellerverketteteListe, data));
                letzterverketteteListe = aktuellerverketteteListe.getSuccessor();
                aktuellerverketteteListe = letzterverketteteListe;
            } else {
                //Zwischen exisiterenden verketteten Listen einfügen
                verketteteListe tempSuccessor = aktuellerverketteteListe.getSuccessor();
                aktuellerverketteteListe.setSuccessor(new verketteteListe(tempSuccessor, aktuellerverketteteListe, data));
                tempSuccessor.setPredessor(aktuellerverketteteListe.getSuccessor());
                aktuellerverketteteListe = aktuellerverketteteListe.getSuccessor();
            }
        }
    }

    public verketteteListe next() {
        if (aktuellerverketteteListe.getSuccessor() != null) {
            aktuellerverketteteListe = aktuellerverketteteListe.getSuccessor();
        } else {
            System.out.println("Letzte verketteteListe erreicht");
        }
        return aktuellerverketteteListe;
    }

    public Iterator<Object> iterator() {
        return this;
    }

    public boolean hasNext() {
        if (aktuellerverketteteListe.getSuccessor() == null) {
            return false;
        } else {
            return true;
        }
    }


    public void get(){
        System.out.println("Erster Eintrag ist: "+ersterverketteteListe.getData());

    }

    public void remove() {
        /*
        *
        *Sollte nur das erste Element löschen und zurückgeben
        *Statt dessen löscht es nun ein beliebiges Element
        *
        */

        //Erstes Element löschen
        if (aktuellerverketteteListe == ersterverketteteListe) {
            System.out.println("Erstes Element gelöscht: "+aktuellerverketteteListe.getData());
            ersterverketteteListe = aktuellerverketteteListe.getSuccessor();
            ersterverketteteListe.setPredessor(null);
            aktuellerverketteteListe = ersterverketteteListe;
        } else {
            //letztes Element löschen
            if (aktuellerverketteteListe.getSuccessor() == null) {
                System.out.println("Letztes Element gelöscht: "+aktuellerverketteteListe.getData());
                aktuellerverketteteListe = aktuellerverketteteListe.getPredessor();
                aktuellerverketteteListe.setSuccessor(null);
                letzterverketteteListe = aktuellerverketteteListe;
            } else {
                //zwischen zwei Elementen löschen
                verketteteListe tempSuccessor = aktuellerverketteteListe.getSuccessor();
                verketteteListe tempPredessor = aktuellerverketteteListe.getPredessor();
                aktuellerverketteteListe = tempPredessor;
                aktuellerverketteteListe.setSuccessor(tempSuccessor);
                tempSuccessor.setPredessor(aktuellerverketteteListe);
            }
        }
    }

    public void ersterverketteteListe() {
        aktuellerverketteteListe = ersterverketteteListe;
    }

    public Object getAktuelleDaten() {
        return aktuellerverketteteListe.getData();
    }

}