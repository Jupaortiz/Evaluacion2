package org.example;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leaTeclado=new Scanner(System.in);

        //MENU
        System.out.println("*************************");
        System.out.println("PEQUEÑO TEATRO");
        System.out.println("1. Agregar nueva obra");
        System.out.println("2. Buscar todas las obras");
        System.out.println("3. Bucar por nombre");
        System.out.println("4. Modificar (costo)");
        System.out.println("0. Salir");
        System.out.println("*************************");

        //CREANDO MENU DE OPCIONES EN JAVA
        int opcionElegida;

        ArrayList<HashMap<String, Object>>obras=new ArrayList<>();

        do {
            System.out.println("Digita la opcion");
            opcionElegida= leaTeclado.nextInt();

        //LIMPIAR EL BUFFER
        leaTeclado.nextLine();

        if (opcionElegida==1){
            System.out.println("Agregando nueva obra");
            System.out.print("Ingresa el nombre de la obra: ");
            String nombreObra= leaTeclado.nextLine();
            System.out.print("Ingresa el nombre del director de la obra: ");
            String nombreDirector= leaTeclado.nextLine();
            System.out.print("Ingresa el genero de la obra: ");
            String generoObra= leaTeclado.nextLine();
            System.out.print("Ingrese el año de estreno : ");
            int anio=leaTeclado.nextInt();
            System.out.print("Ingrese el mes de estreno: ");
            int mes=leaTeclado.nextInt();
            System.out.print("Ingrese el dia de estreno: ");
            int dia=leaTeclado.nextInt();
            LocalDate fechaFinObra= LocalDate.of(anio,mes,dia);
            System.out.print("Ingrese el costo de la obra: ");
            int costoObra=leaTeclado.nextInt();
            int idObra=new Random().nextInt(5);

            // LLENANDO EL HASHMAP CON LOS DATOS
            HashMap<String, Object>obra = new HashMap<>();
            obra.put("id", idObra);
            obra.put("nombre", nombreObra);
            obra.put("director", nombreDirector);
            obra.put("genero", generoObra);
            obra.put("fechaFin", fechaFinObra);
            obra.put("costo", costoObra);

        //LLENANDO EL AREGLO
        obras.add(obra);
            System.out.println("obra agregada correctamente");

        } else if (opcionElegida==2) {
            System.out.println("Buscar Todos");
            if (obras.isEmpty()){
                System.out.println("No hay obraas registradas");
            }else {
            for (HashMap<String,Object>obraAuxiliar:obras){
                System.out.println(obraAuxiliar);
            }
            }

        } else if (opcionElegida==3) {
            System.out.println("Buscar por nombre");
            System.out.print("Digita el nombre de la obra que deseas buscar: ");
            String nombreObraBuscar= leaTeclado.nextLine();

        //RECORRRER EL AREGLO PARA BUSCARLO

        boolean encontrado=false;
        for (HashMap<String,Object>obraAuxiliar:obras){
            if (nombreObraBuscar.equals(obraAuxiliar.get("nombre"))){
                System.out.println("Obra encontrado"+obraAuxiliar);
                encontrado=true;
            }
            if (!encontrado){
                System.out.println("No se encontro la obra");
            }
        }

        } else if (opcionElegida==4) {
            System.out.println("Modificar costo de la obra");
            System.out.print("Ingrese el nombre de la obra cuyo costo desea modificar: ");
            String nombreAModificar= leaTeclado.nextLine();

            boolean obraEncontrada=false;
        //RECORER EL ARREGLO OBRAS PARA ENCONTRAR LA OBRA A MODIFICAR
        for (HashMap<String,Object>obraAuxiliar:obras){
            if (nombreAModificar.equals(obraAuxiliar.get("nombre"))){
                System.out.println("Obra encontrada "+obraAuxiliar);
                System.out.println("Ingrese el nuevo costo de la obra");
                int nuevoCosto=leaTeclado.nextInt();

        //ACTUALIZAR EL COSTO DE LA OBRA
            obraAuxiliar.put("costo",nuevoCosto);
                System.out.println("Costo de la obra actualizado correctamente.");
                obraEncontrada=true;
                break;
            }
        }if (!obraEncontrada){
                System.out.println("no se encontro una obra con ese noombre.");
            }

        } else if (opcionElegida==0) {
            System.out.println("Saliendo");
        }else {
            System.out.println("Opcion invalida");
        }


        }while (opcionElegida!=0);






    }
}