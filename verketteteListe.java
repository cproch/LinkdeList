public class verketteteListe {

    private verketteteListe successor = null;
    private verketteteListe predessor = null;
    private Object data = null;

    public verketteteListe(verketteteListe successor, verketteteListe predessor, Object data) {
        this.successor = successor;
        this.predessor = predessor;
        this.data = data;
    }


    public verketteteListe getSuccessor() {
        return this.successor;
    }

    public verketteteListe getPredessor() {
        return this.predessor;
    }

    public Object getData() {
        return this.data;
    }

    public void setSuccessor(verketteteListe knoten) {
        this.successor = knoten;
    }

    public void setPredessor(verketteteListe knoten) {
        this.predessor = knoten;
    }

}

