package Vehiculos;

public class Moto extends Vehiculo {

    private int cilindrada;
    //TODO naked,custom,trail,RR,Turismo.
    private String tipo;

    public Moto(String marca, String modelo, String fechaMatriculacion, String fechaEntradaConcesionario, int precio, int peso,String matricula) {
        super(marca, modelo, fechaMatriculacion, fechaEntradaConcesionario, fechaEntradaConcesionario, precio, peso, matricula);
    }

    @Override
    public void setTipodeCarnet(String tipodeCarnet) {
        super.setTipodeCarnet("A");
    }

    @Override
    public void setCombustible(String combustible){
        super.setCombustible("Gasolina");
    }

}
