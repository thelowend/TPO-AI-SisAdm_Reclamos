package Vistas;

import Model.Factura;

import java.util.ArrayList;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class ReclamoFacturacionView extends ReclamoView {
    private ArrayList<FacturaView> facturas;


    public ReclamoFacturacionView(){
        facturas = new ArrayList<FacturaView>();
    }

    public ArrayList<FacturaView> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<FacturaView> facturas) {
        this.facturas = facturas;
    }
}
