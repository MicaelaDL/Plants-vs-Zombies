
package plantasvszombies;

import java.util.Scanner;


public class PlantasVsZombies {

    public static void main(String[] args) {
        //Menú inicial 
        String opcion;
        Scanner read = new Scanner(System.in);
        System.out.println("Bienvenido a Plantas vs Zombies");
        
        //ver si dejar esto segun rta de profe
        boolean flag=true;
        while (flag){
            System.out.println("Si desea jugar presione 1");
            System.out.println("Si desea ver 50 movimientos presione 2");
            opcion = read.nextLine();
            try {
                int opcionInt=Integer.parseInt(opcion);
                switch(opcionInt){
                    case 1: System.out.println("Eligió jugar");
                        flag=false;
                        break;
                    case 2: System.out.println("Eligió ver 50 movimientos");
                        flag=false;
                        break;
                    default: System.out.println("No eligió una opción correcta");
                        break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Debe ingresar un número");
            }
        }
        
        //una vez que empiece borrar lo anterior
        
        
        //Modelado del juego con el usuario participando
        
        
        
        //agregar el bucle principal + contador para movimientos 
        
        System.out.println("Reglas: "); //fijarse de usar archivo? 
        Tablero T = new Tablero(); //tablero vacío 
        T.mostrarTablero();
        
        boolean comprarFlag;
        //si tiene menos de 25 soles no puede comprar
        comprarFlag = T.getSoles()>=25;
        //bucle de compra
        
        while (comprarFlag){
        //agregar opcion para cancelar, volver a elegir coordenada, salir del menu de compra
        //en el primer turno solo puede comprar girasoles
            System.out.println("Tiene: " + T.getSoles() + " soles disponibles para comprar");
            System.out.println("Si desea comprar ingrese S o s. Si desea continuar sin comprar apriete cualquier letra");
            String compra = read.nextLine();
            switch (compra) {
                case "S": flag=true; //para iniciar el bucle de compra
                    break;
                case "s": flag=true;
                    break;
                default: flag=false;
                    break;
            }
            //poner opcion de ver que hace cada una? 
            while (flag){
                try {
                System.out.println("Ingrese el número correspondiente a la planta que desea comprar");
                System.out.println("1: Girasol - Costo: 50 soles" + "\n2: Lanzaguisantes - Costo: 100 soles" 
                    + "\n3: Repetidora - Costo: 200 soles" + "\n4: Hielaguisantes - Costo: 175 soles" + 
                    "\n5: Nuez - Costo: 50 soles" + "\n6: Patatapum - Costo: 25 soles" + "\n7: Petacereza - Costo: 150 soles");
                String planta = read.nextLine();
                    switch(planta){
                        case "1": 
                            if (T.getSoles()<50){
                                System.out.println("No le alcanza para comprar un Girasol");
                            }
                            else {
                                String fila="";
                                String columna="";
                                System.out.println("Eligió el Girasol");
                                T.setSoles(T.getSoles()-50);
                                //corroborar que ingresa bien la fila
                                boolean filaFlag = true;
                                while (filaFlag){
                                    System.out.println("Ingrese la fila del girasol (fila= de 1 a 5)");
                                    fila = read.nextLine(); 
                                    try {
                                        int filaInt = Integer.parseInt(fila);
                                        switch (filaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el girasol en la fila: " + filaInt);
                                                filaFlag=false;
                                                break;
                                            default: System.out.println("Fila inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 5");
                                    }
                                }
                                //corroborar que ingrese bien la columna
                                boolean columnaFlag = true;
                                while (columnaFlag){
                                    System.out.println("Ingrese la columna del girasol (columna= del 1 al 10)");
                                    columna = read.nextLine();
                                    try {
                                        int columnaInt = Integer.parseInt(columna);
                                        switch (columnaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el girasol en la columna: " + columnaInt);
                                                columnaFlag=false;
                                                break;
                                            default: System.out.println("Columna inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 10");
                                    }
                                }
                                Girasol g = new Girasol(Integer.parseInt(fila)-1,Integer.parseInt(columna)-1);
                                //agregar planta al tablero
                                T.plantar(g);
                                System.out.println("ID de la planta: G");
                            }
                            break;

                        case "2": 
                            if (T.getSoles()<100) {
                                System.out.println("No le alcanza para comprar el Lanzaguisantes");
                            }
                            else {
                                String fila="";
                                String columna="";
                                System.out.println("Eligió el Lanzaguisantes");
                                T.setSoles(T.getSoles()-100);
                                //corroborar que ingresa bien la fila
                                boolean filaFlag = true;
                                while (filaFlag){
                                    System.out.println("Ingrese la fila del Lanzaguisantes (fila= de 1 a 5)");
                                    fila = read.nextLine();
                                    try {
                                        int filaInt = Integer.parseInt(fila);
                                        switch (filaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Lanzaguisantes en la fila: " + filaInt);
                                                filaFlag=false;
                                                break;
                                            default: System.out.println("Fila inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 5");
                                    }
                                }
                                //corroborar que ingrese bien la columna
                                boolean columnaFlag = true;
                                while (columnaFlag){
                                    System.out.println("Ingrese la columna del Lanzaguisantes (columna= del 1 al 10)");
                                    columna = read.nextLine();
                                    try {
                                        int columnaInt = Integer.parseInt(columna);
                                        switch (columnaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Lanzaguisantes en la columna: " + columnaInt);
                                                columnaFlag=false;
                                                break;
                                            default: System.out.println("Columna inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 10");
                                    }
                                }
                                Lanzaguisantes l = new Lanzaguisantes(Integer.parseInt(fila),Integer.parseInt(columna));
                                //agregar planta al tablero
                                T.plantar(l);
                                System.out.println("ID de la planta: L");
                            }
                            break;

                        case "3": 
                            if (T.getSoles()<200) {
                                System.out.println("No le alcanza para comprar la Repetidora");
                            }
                            else {
                                String fila="";
                                String columna="";
                                System.out.println("Eligió la Repetidora");
                                T.setSoles(T.getSoles()-200);
                                 //corroborar que ingresa bien la fila
                                boolean filaFlag = true;
                                while (filaFlag){
                                    System.out.println("Ingrese la fila del Repetidora (fila= de 1 a 5)");
                                    fila = read.nextLine();
                                    try {
                                        int filaInt = Integer.parseInt(fila);
                                        switch (filaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Repetidora en la fila: " + filaInt);
                                                filaFlag=false;
                                                break;
                                            default: System.out.println("Fila inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 5");
                                    }
                                }
                                //corroborar que ingrese bien la columna
                                boolean columnaFlag = true;
                                while (columnaFlag){
                                    System.out.println("Ingrese la columna del Repetidora (columna= del 1 al 10)");
                                    columna = read.nextLine();
                                    try {
                                        int columnaInt = Integer.parseInt(columna);
                                        switch (columnaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Repetidora en la columna: " + columnaInt);
                                                columnaFlag=false;
                                                break;
                                            default: System.out.println("Columna inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 10");
                                    }
                                }
                                Repetidora r = new Repetidora(Integer.parseInt(fila),Integer.parseInt(columna));
                                //agregar planta al tablero
                                T.plantar(r);
                                System.out.println("ID de la planta: R");
                            }
                            break;

                        case "4": 
                            if (T.getSoles()<175) {
                                System.out.println("No le alcanza para comprar el Hielaguisantes");
                            } 
                            else {
                                String fila="";
                                String columna="";
                                System.out.println("Eligió el Hielaguisantes");
                                T.setSoles(T.getSoles()-175);
                                 //corroborar que ingresa bien la fila
                                boolean filaFlag = true;
                                while (filaFlag){
                                    System.out.println("Ingrese la fila del Hielaguisantes (fila= de 1 a 5)");
                                    fila = read.nextLine();
                                    try {
                                        int filaInt = Integer.parseInt(fila);
                                        switch (filaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Hielaguisantes en la fila: " + filaInt);
                                                filaFlag=false;
                                                break;
                                            default: System.out.println("Fila inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 5");
                                    }
                                }
                                //corroborar que ingrese bien la columna
                                boolean columnaFlag = true;
                                while (columnaFlag){
                                    System.out.println("Ingrese la columna del Hielaguisantes (columna= del 1 al 10)");
                                    columna = read.nextLine();
                                    try {
                                        int columnaInt = Integer.parseInt(columna);
                                        switch (columnaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Hielaguisantes en la columna: " + columnaInt);
                                                columnaFlag=false;
                                                break;
                                            default: System.out.println("Columna inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 10");
                                    }
                                }
                                Hielaguisantes h = new Hielaguisantes(Integer.parseInt(fila),Integer.parseInt(columna));
                                //agregar planta al tablero
                                T.plantar(h);
                                System.out.println("ID de la planta: H");
                            }
                            break;

                        case "5": 
                            if (T.getSoles()<100) {
                                System.out.println("No le alcanza para comprar la Nuez");
                            }
                            else {
                                String fila="";
                                String columna="";
                                System.out.println("Eligió la Nuez");
                                T.setSoles(T.getSoles()-50);
                                 //corroborar que ingresa bien la fila
                                boolean filaFlag = true;
                                while (filaFlag){
                                    System.out.println("Ingrese la fila del Nuez (fila= de 1 a 5)");
                                    fila = read.nextLine();
                                    try {
                                        int filaInt = Integer.parseInt(fila);
                                        switch (filaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Nuez en la fila: " + filaInt);
                                                filaFlag=false;
                                                break;
                                            default: System.out.println("Fila inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 5");
                                    }
                                }
                                //corroborar que ingrese bien la columna
                                boolean columnaFlag = true;
                                while (columnaFlag){
                                    System.out.println("Ingrese la columna del Nuez (columna= del 1 al 10)");
                                    columna = read.nextLine();
                                    try {
                                        int columnaInt = Integer.parseInt(columna);
                                        switch (columnaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Nuez en la columna: " + columnaInt);
                                                columnaFlag=false;
                                                break;
                                            default: System.out.println("Columna inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 10");
                                    }
                                }
                                Nuez n = new Nuez(Integer.parseInt(fila),Integer.parseInt(columna));
                                //agregar planta al tablero
                                T.plantar(n);
                                System.out.println("ID de la planta: N");
                            }
                            break;

                        case "6": 
                            if (T.getSoles()<100) {
                                System.out.println("No le alcanza para comprar el Patatapum");
                            }
                            else {
                                String fila="";
                                String columna="";
                                System.out.println("Eligió el Patatapum");
                                T.setSoles(T.getSoles()-25);
                                 //corroborar que ingresa bien la fila
                                boolean filaFlag = true;
                                while (filaFlag){
                                    System.out.println("Ingrese la fila del Patatapum (fila= de 1 a 5)");
                                    fila = read.nextLine();
                                    try {
                                        int filaInt = Integer.parseInt(fila);
                                        switch (filaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Patatapum en la fila: " + filaInt);
                                                filaFlag=false;
                                                break;
                                            default: System.out.println("Fila inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 5");
                                    }
                                }
                                //corroborar que ingrese bien la columna
                                boolean columnaFlag = true;
                                while (columnaFlag){
                                    System.out.println("Ingrese la columna del Patatapum (columna= del 1 al 10)");
                                    columna = read.nextLine();
                                    try {
                                        int columnaInt = Integer.parseInt(columna);
                                        switch (columnaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Patatapum en la columna: " + columnaInt);
                                                columnaFlag=false;
                                                break;
                                            default: System.out.println("Columna inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 10");
                                    }
                                }
                                Patatapum pt = new Patatapum(Integer.parseInt(fila),Integer.parseInt(columna));
                                //agregar planta al tablero
                                T.plantar(pt);
                                System.out.println("ID de la planta: T");
                            }
                            break;

                        case "7": 
                            if (T.getSoles()<100) {
                                System.out.println("No le alcanza para comprar la Petacereza");
                            }   
                            else {
                                String fila="";
                                String columna="";
                                System.out.println("Eligió la Petacereza");
                                T.setSoles(T.getSoles()-150);
                                 //corroborar que ingresa bien la fila
                                boolean filaFlag = true;
                                while (filaFlag){
                                    System.out.println("Ingrese la fila del Petacereza (fila= de 1 a 5)");
                                    fila = read.nextLine();
                                    try {
                                        int filaInt = Integer.parseInt(fila);
                                        switch (filaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Petacereza en la fila: " + filaInt);
                                                filaFlag=false;
                                                break;
                                            default: System.out.println("Fila inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 5");
                                    }
                                }
                                //corroborar que ingrese bien la columna
                                boolean columnaFlag = true;
                                while (columnaFlag){
                                    System.out.println("Ingrese la columna del Petacereza (columna= del 1 al 10)");
                                    columna = read.nextLine();
                                    try {
                                        int columnaInt = Integer.parseInt(columna);
                                        switch (columnaInt){
                                            case 1,2,3,4,5: System.out.println("Colocará el Petacereza en la columna: " + columnaInt);
                                                columnaFlag=false;
                                                break;
                                            default: System.out.println("Columna inexistente, ingrese de nuevo");
                                                break;
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número del 1 al 10");
                                    }
                                }
                                Petacereza p = new Petacereza(Integer.parseInt(fila),Integer.parseInt(columna));
                                //agregar planta al tablero
                                T.plantar(p);
                                System.out.println("ID de la planta: P");
                            }
                            break;

                        default: System.out.println("No eligió una opción correcta");
                            break;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Debe ingresar un número");
                }
                if (T.getSoles()<25){
                    System.out.println("Se quedó sin soles, pasará a la fase de ataque");
                }
                else {
                    System.out.println("Desea seguir comprando? Ingrese");
                    String rta=read.nextLine();
                }

            }
        }

        
    T.mostrarTablero();
    }
}