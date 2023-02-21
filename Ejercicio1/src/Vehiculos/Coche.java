package Vehiculos;

public class Coche extends Vehiculo {
    byte numerodePuertas;

    public Coche(String marca, String modelo, String combustible, String fechaMatriculacion,
                 String fechaEntradaConcesionario, int precio, int peso,String matricula) {
        super(marca, modelo, combustible, fechaMatriculacion,
                fechaEntradaConcesionario, precio, peso, matricula);
    }

    @Override
    public void setTipodeCarnet(String tipodeCarnet) {
        super.setTipodeCarnet("B");
    }

    public void setNumerodePuertas(byte numerodePuertas) {

        this.numerodePuertas = numerodePuertas;
    }

}