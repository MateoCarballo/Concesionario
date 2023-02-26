package EjercicioAlumnos;

import Utilidades.Enumeracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainAlumnos {
    public static int id=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean continuar=true;

        Centro iesdeTeis= new Centro("Instituto de Educación Secundaria y Formación Profesional",
                "Público","36018173","Avenida de Galicia, 101. Vigo (Pontevedra)","36216");

        rellenarCentro(iesdeTeis);

        while (continuar){
            System.out.println("""
                                PROGAMA PARA GESTIONAR NOTAS ALUMNOS
               
                                        1.VER ALUMNOS DEL CENTRO.
                                        2.VER MATERIAS DEL CENTRO.
                                        3.VER ALUMNOS POR MATERIA.
                                        4.MOSTRAR TODOS LOS DATOS DE UN ALUMNO(ID).
                                        5.MOSTRAR ESTADISTICAS DE UNA MATERIA(NOMBRE).
                                        6.AÑADIR NOTA ALUMNO.
                                        7.BORRAR NOTA ALUMNO.
                                        8.VER SUSPENSOS POR MATERIA.
                                        9.SALIR.
                                        
                """);
            switch(Integer.parseInt(br.readLine())){
                case 1->System.out.println(iesdeTeis.alumnosCentro.toString());
                case 2->System.out.println(iesdeTeis.materiasCentro.toString());
                case 3->verAlumnosporMateria(iesdeTeis);
                case 4->mostrarDatosAlumno(iesdeTeis);
                case 5->mosstrarEstadisticasMateria(iesdeTeis);
                case 6->añadirNota(iesdeTeis);
                case 7->borrarNota(iesdeTeis);
                case 8->verSuspensosMateria(iesdeTeis);
                case 9->{
                    continuar=false;
                }
            }
        }
    }

    private static void mosstrarEstadisticasMateria(Centro miCentro) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre de la materia?");
        String entradaTeclado= br.readLine();
        for (int i = 0; i < miCentro.materiasCentro.size(); i++) {
            if(miCentro.materiasCentro.get(i).getNombreMateria().equalsIgnoreCase(entradaTeclado)){
                System.out.print("La nota media de los alumnos es -> ");
                System.out.println(miCentro.materiasCentro.get(i).notaMediaMateria());
                System.out.print("La nota mas alta es -> ");
                System.out.println(miCentro.materiasCentro.get(i).getNotaAlta());
                System.out.print("La nota mas baja es -> ");
                System.out.println(miCentro.materiasCentro.get(i).getNotaBaja());
            }
        }

    }

    private static void mostrarDatosAlumno(Centro miCentro) {
    }

    private static void verSuspensosMateria(Centro miCentro) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre de la materia/id?"+"\n");
        String entradaTeclado=br.readLine();

        for (int i = 0; i <miCentro.materiasCentro.size() ; i++) {
            if(entradaTeclado.equalsIgnoreCase(miCentro.materiasCentro.get(i).getNombreMateria())){
                System.out.println("Alumnos suspensos en la materia -> "+ entradaTeclado+"\n");

            for (int j = 0; j < miCentro.materiasCentro.get(i).alumnosMateria.size(); j++) {
                if(miCentro.materiasCentro.get(i).alumnosMateria.get(j).getNota()<5){

                    System.out.println(miCentro.materiasCentro.get(i).alumnosMateria.get(j).getNombre()+" "+
                            miCentro.materiasCentro.get(i).alumnosMateria.get(j).getApellido1()+" "+
                            miCentro.materiasCentro.get(i).alumnosMateria.get(j).getApellido2());
                }
            }

            }
        }
    }


    public static void verAlumnosporMateria(Centro miCentro)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre de la materia/id?"+"\n");
        String entradaTeclado=br.readLine();
        for (int i = 0; i <miCentro.materiasCentro.size() ; i++) {
            if(entradaTeclado.equalsIgnoreCase(miCentro.materiasCentro.get(i).getNombreMateria())){
                System.out.println("Alumnos de la materia "+entradaTeclado);
                System.out.println(miCentro.materiasCentro.get(i).alumnosMateria.toString());
            }

    }
}
        public static void añadirNota(Centro miCentro)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Materia?");
            String materia= br.readLine();
            System.out.println("Nombre?");
            String nombre= br.readLine();
            System.out.println("Primer apellido?");
            String ap1= br.readLine();
            System.out.println("Segundo apellido?");
            String ap2= br.readLine();
            System.out.println("Nota?");
            String nota = br.readLine();

            for (int i = 0; i <miCentro.materiasCentro.size() ; i++) {
                if(miCentro.materiasCentro.get(i).getNombreMateria().equalsIgnoreCase(materia)){
                    for (int j = 0; j <miCentro.materiasCentro.get(i).alumnosMateria.size() ; j++) {

                        if(miCentro.materiasCentro.get(i).alumnosMateria.get(i).getNombre().equalsIgnoreCase(nombre)
                                &&miCentro.materiasCentro.get(i).alumnosMateria.get(i).getApellido1().equalsIgnoreCase(ap1)
                                &&miCentro.materiasCentro.get(i).alumnosMateria.get(i).getApellido2().equalsIgnoreCase(ap2)){

                            miCentro.materiasCentro.get(i).alumnosMateria.get(i).setNota(Integer.parseInt(nota));

                        }
                    }
                }
            }

        }

    public static void borrarNota(Centro miCentro)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Materia?");
        String materia= br.readLine();
        System.out.println("Nombre?");
        String nombre= br.readLine();
        System.out.println("Primer apellido?");
        String ap1= br.readLine();
        System.out.println("Segundo apellido?");
        String ap2= br.readLine();


        for (int i = 0; i <miCentro.materiasCentro.size() ; i++) {
            if(miCentro.materiasCentro.get(i).getNombreMateria().equalsIgnoreCase(materia)){
                for (int j = 0; j <miCentro.materiasCentro.get(i).alumnosMateria.size() ; j++) {

                    if(miCentro.materiasCentro.get(i).alumnosMateria.get(i).getNombre().equalsIgnoreCase(nombre)
                            &&miCentro.materiasCentro.get(i).alumnosMateria.get(i).getApellido1().equalsIgnoreCase(ap1)
                            &&miCentro.materiasCentro.get(i).alumnosMateria.get(i).getApellido2().equalsIgnoreCase(ap2)){

                        miCentro.materiasCentro.get(i).alumnosMateria.get(i).setNota(-1);
                        System.out.println("Nota borrada con exito");
                    }else{
                        System.out.println("Alumno no encontrado");
                    }
                }
            }
        }

    }

    public static int numAleatorioEntero(int limInferior, int limSuperior){
        int aleatorio = (int)(Math.random()*(limSuperior-limInferior+1)+limInferior);
        return aleatorio;
    }
    public static void rellenarCentro( Centro miCentro) {
        int cantidadAlumnos = 0;
        boolean alumnoValido=true;

            /*
            Matriz para gastar id consumidos y volver a buscar
            otro alumno para completar los alumnos que cursen la materia
            ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
             */



        //RELLENAR LOS ALUMNOS DEL CENTRO
        cantidadAlumnos = numAleatorioEntero(50, 200);

        for (int i = 0; i < cantidadAlumnos; i++) {
            miCentro.alumnosCentro.add(new Alumno(id,
                    Enumeracion.nombres[numAleatorioEntero(0, 9)],
                    Enumeracion.apellidos[numAleatorioEntero(0, 9)],
                    Enumeracion.apellidos[numAleatorioEntero(0, 9)]));
            id += 1;
        }

        // RELLENAR LAS MATERIAS DEL CENTRO
        for (int i = 0; i < Enumeracion.materias.length; i++) {

            miCentro.materiasCentro.add(new Materia(Enumeracion.materias[i]));

            cantidadAlumnos = numAleatorioEntero(1, 15);

            int [] alumnosGastados= new int[cantidadAlumnos];

            for (int j = 0; j < cantidadAlumnos; j++) {

                //1. Coger alumno aleatorio entre todos los que tiene el centro
                Alumno miCandidato;
                do {
                    miCandidato = miCentro.alumnosCentro.get(numAleatorioEntero(0, miCentro.alumnosCentro.size()-1));


                //2. Asegurar que no hemos cogido un alumno que ya está matriculado en la materia
                    for (int k = 0; k < alumnosGastados.length; k++) {
                        if (miCandidato.getId() == alumnosGastados[k]) {
                            alumnoValido = false;
                        }else{
                            alumnoValido=true;
                            alumnosGastados[k]=miCandidato.getId();
                        }
                    }
                } while (!alumnoValido);

                //3. Añadir al alumno a la materia
                miCentro.materiasCentro.get(i).alumnosMateria.add(miCandidato);
            }

            //4. Vaciar la matriz de consumidos
            for (int n = 0; n < alumnosGastados.length; n++) {
                alumnosGastados[n]=0;
            }
        }

        //Rellenar las notas de los alumnos creados automaticamente

        for (int i = 0; i < miCentro.materiasCentro.size(); i++) {
            for (int j = 0; j <miCentro.materiasCentro.get(i).alumnosMateria.size(); j++) {
                miCentro.materiasCentro.get(i).alumnosMateria.get(j).setNota(numAleatorioEntero(0,10));
            }
        }

    }
}
