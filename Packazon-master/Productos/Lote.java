package Productos;

import java.util.*;

public class Lote {
    private boolean fragil;
    private boolean alim;
    private boolean std;

    private List <Producto> prods = new ArrayList<Producto>();

    public Lote() {
        this.alim = false;
        this.fragil = false;
        this.std = false;
    }

}
