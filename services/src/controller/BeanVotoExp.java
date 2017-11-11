
package controller;

import view.ExpectativaJpa;
import view.ResExpectativaJpa;
import model.Expectativa;
import model.ResExpectativa;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;


@Named(value = "beanVoto")
@SessionScoped
public class BeanVotoExp implements Serializable {

    @EJB
    private ResExpectativaJpa resExpecativaController;
    @EJB
    private ExpectativaJpa expectativaController;

    public BeanVotoExp() {
    }
    //Se guardan los opt_text de la encuesta
    private List<SelectItem> opciones = new ArrayList<SelectItem>();
    private ArrayList<String> nomOpciones = new ArrayList<String>();
    private ArrayList<Integer> votos = new ArrayList<Integer>();
    private ArrayList<Integer> numeroOpcion = new ArrayList<Integer>();
    private ArrayList<Float> porcVotos = new ArrayList<Float>();
    //Se guardan las encuestas
    private List<SelectItem> encuestas = new ArrayList<SelectItem>();
    
    
    private String detalle;
    private long opcionElegida;
    private int numEncuesta;
    private String mensaje = "";

    

    @PostConstruct
    public void inicializar() {
        listarEncuestas();
    }
    
    public void listarEncuestas(){        
        List<Preguntas> listaEncuesta = expectativaController.listarEncuestas();
        for(Preguntas p:listaEncuesta){
            encuestas.add(new SelectItem(p.getResp_id()));
        }
    }
    
   

    public void obtenerDatosOpciones(){        
        opciones.clear();
        votos.clear();
        numeroOpcion.clear();
        nomOpciones.clear();
        List<ResPreguntas> listaOpciones = resExpectativaController.obtenerOpcionesEncuesta(numEncuesta);        
        for (ResExpectativa po : listaOpciones) {                                                
            opciones.add(new SelectItem(po.getresp_id(),(String) po.getOptText()));
            nomOpciones.add(po.getOptText());
            votos.add(po.getResp_escogida());
            numeroOpcion.add(po.get resp_preid());
        }
    }
    
    public void calcularPorcentajes(){        
        porcVotos.clear();
        long cantidad = resExpectativaController.obtenerCantidadVotos(numEncuesta);      
        for(Integer v:votos){
            float f = ((float)v/cantidad)*100;
            porcVotos.add(f);            
        }        
    }
    
    public String sumarVoto(){
        Integer opcion = Integer.parseInt(opcionElegida+"");
        resExpectativaController.sumarVoto(opcion);
        obtenerDatosOpciones();
        calcularPorcentajes();
        return "resultado";
    }
    
    public String irAEncuesta(){
        String ir = mostrarEncuestaSeleccionada();
        obtenerDatosOpciones();
        return ir;
    }
    
    public String irIndex(){
        return "index";
    }
    
    //Metodos geter and setter
    

    public List<SelectItem> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<SelectItem> opciones) {
        this.opciones = opciones;
    }

    public ArrayList<Integer> getVotos() {
        return votos;
    }

    public void setVotos(ArrayList<Integer> votos) {
        this.votos = votos;
    }

    public ArrayList<Integer> getNumeroOpcion() {
        return numeroOpcion;
    }

    public void setNumeroOpcion(ArrayList<Integer> numeroOpcion) {
        this.numeroOpcion = numeroOpcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public long getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(long opcionElegida) {
        this.opcionElegida = opcionElegida;
    }

    public ArrayList<String> getNomOpciones() {
        return nomOpciones;
    }

    public void setNomOpciones(ArrayList<String> nomOpciones) {
        this.nomOpciones = nomOpciones;
    }

    public ArrayList<Float> getPorcVotos() {
        return porcVotos;
    }

    public void setPorcVotos(ArrayList<Float> porcVotos) {
        this.porcVotos = porcVotos;
    }

    public List<SelectItem> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<SelectItem> encuestas) {
        this.encuestas = encuestas;
    }

    public int getNumEncuesta() {
        return numEncuesta;
    }

    public void setNumEncuesta(int numEncuesta) {
        this.numEncuesta = numEncuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
