import java.util.*;
import Clases.*;

public class Main {
    static List<Eps> lasEps = List.of(new Eps(1,"SURA"), new Eps(2,"COMFENALCO")
            ,new Eps(3,"SANITAS"));
    static List<Enfermedad> enfermedad1 = List.of((new Enfermedad(1,"bronquitis")),
            new Enfermedad(2,"influenza"), new Enfermedad(3,"infeccion"),
            new Enfermedad(4,"cadiopatía"));
    static List<Enfermedad> enfermedad2 = List.of(new Enfermedad(2,"influenza"));
    static List<Enfermedad> enfermedad3 = List.of();
    static List<Enfermedad> enfermedad4 = List.of(new Enfermedad(5,"covid"),
            new Enfermedad(6,"sindrome del sapo"));
    static List<Enfermedad> enfermedad5 = List.of(new Enfermedad(6,"sindrome del sapo"));

    static List<Paciente> pacientes = List.of(
            new Paciente(1, "Sandra","zapato",Regimen.CONTRIBUTIVO,
                    Afiliacion.COTIZANTE,3589870.98,4,enfermedad1,
                    new Eps(1,"SURA")),
            new Paciente(2, "Juancho","panza",Regimen.SUBSIDIADO,
                    Afiliacion.BENEFICIARIO,100000.00,1,enfermedad2,
                    new Eps(3,"SANITAS")),
            new Paciente(3, "Armando","casas",Regimen.CONTRIBUTIVO,
                    Afiliacion.BENEFICIARIO,20000.00,0,enfermedad3,
                    new Eps(2,"COMFENALCO")),
            new Paciente(4, "Adrian","sapito",Regimen.CONTRIBUTIVO,
                    Afiliacion.COTIZANTE,35898700.98,2,enfermedad4,
                    new Eps(1,"SURA")),
            new Paciente(5, "Alejo","cordoba",Regimen.SUBSIDIADO,
                    Afiliacion.BENEFICIARIO,0.00,1,enfermedad5,
                    new Eps(2,"COMFENALCO"))
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Porfavor elija una opción: \n" +
                "1.Agregar paciente \n" +
                "2.Paciente con mayores costos \n" +
                "3.Paciente con mayor número de enfermades \n" +
                "4.Costos por Eps\n" +
                "5.Número de pacientes por Eps \n" +
                "6.Número de pacientes por tipo de afiliación \n" +
                "7.Número de pacientes por tipo de regimen ");
        Integer opcion = Integer.parseInt(input.nextLine());

        switch (opcion){
            case 1:{
                agregarPaciente();
                break;
            }
            case 2:{
                pacienteMayoresCostos();
                break;
            }
            case 3:{
                pacienteMasEnfermedades();
                break;
            }
            case 4:{
                costosPorEps();
                break;
            }
            case 5:{
                numeroPacientesPorEps();
                break;
            }
            case 6:{
                numeroPacientesTipoAfiliacion();
                break;
            }
            case 7:{
                numeroPacientesTipoRegimen();
                break;
            }
            default: {
                System.out.println("Opcion incorrecta");
            }
        }

    }

    public static void agregarPaciente(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre del paciente: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese apellido del paciente: ");
        String apellido = input.nextLine();

        System.out.println("Ingrese el id del paciente: ");
        Integer id = Integer.parseInt(input.nextLine());

        System.out.println("Ingrese el tipo de afiliación del paciente \n" +
                "(Digite 0 ó 1 -> 0:COTIZANTE, 1:BENEFICIARIO) : ");
        Integer afiliacion = Integer.parseInt(input.nextLine());
        Afiliacion afi;
        if (afiliacion==0){
            afi= Afiliacion.COTIZANTE;
        }
        else{
            afi= Afiliacion.BENEFICIARIO;
        }

        System.out.println("Ingrese el tipo de regimen del paciente \n" +
                "(Digite 0 ó 1 -> 0:CONTRIBUTIVO, 1:SUBSIDIADO) : ");
        Integer regimen = Integer.parseInt(input.nextLine());
        Regimen reg;
        if (regimen==0){
            reg= Regimen.CONTRIBUTIVO;
        }
        else{
            reg= Regimen.SUBSIDIADO;
        }


        System.out.println("Ingrese los costos de tratamiento del paciente: ");
        Double costos = Double.parseDouble(input.nextLine());

        System.out.println("Ingrese el número de enfermedades del paciente: ");
        Integer numEnfermedades = Integer.parseInt(input.nextLine());

        List<Enfermedad> enfermedades= new ArrayList<>();
        for (int i=0; i==numEnfermedades; i++){
            System.out.println("Ingrese el id de la enfemedad: ");
            Integer idEnfermedad = Integer.parseInt(input.nextLine());

            System.out.println("Ingrese nombre de la enfermedad: ");
            String nombreEnfermedad = input.nextLine();
            Enfermedad enfermedad= new Enfermedad(idEnfermedad,nombreEnfermedad);
            enfermedades.add(enfermedad);
        }
        System.out.println("Ingrese el ID de la Eps del paciente: ");
        Integer idEps = Integer.parseInt(input.nextLine());

        System.out.println("Ingrese el nombre de la Eps del paciente: ");
        String nombreEps = input.nextLine();
        Eps eps = new Eps(idEps,nombreEps);

        Paciente paciente = new Paciente(id,nombre,apellido,reg,afi,costos,numEnfermedades,enfermedades, eps);
        pacientes.add(paciente);
    }
    public static void pacienteMayoresCostos(){
        Double mayorCosto=0.0;
        for(Paciente paciente:pacientes){
            if(paciente.costos>mayorCosto){
                mayorCosto=paciente.costos;
            }
        }
        for(Paciente paciente:pacientes){
            if(paciente.costos==mayorCosto){
                System.out.println(paciente);
            }
        }
    }
    public static void pacienteMasEnfermedades(){
        Integer mayorEnfermedades=0;
        for(Paciente paciente:pacientes){
            if(paciente.numEnfermedades>mayorEnfermedades){
                mayorEnfermedades=paciente.numEnfermedades;
            }
        }
        for(Paciente paciente:pacientes){
            if(paciente.numEnfermedades==mayorEnfermedades){
                System.out.println(paciente);
            }
        }
    }
    public static void costosPorEps(){
        Double mayor=0.0;
        String nombreMayor="";
        for(Eps eps:lasEps){
            Double cost=0.0;
            for(Paciente paciente:pacientes){
                if(paciente.eps.idEps == eps.idEps){
                    cost+=paciente.costos;
            if(cost>mayor){
                mayor=cost;
                nombreMayor= eps.nombre;
                    }
                }
            }
            System.out.println("los costos de la Eps"+eps.nombre+"son: "+ cost);
        }
        System.out.println("la EPS con mayores costos es: "+nombreMayor+" con unos costos de: "+ mayor);
    }

    public static void numeroPacientesPorEps(){
        Integer contmayor=0;
        String nombreMayor="";
        for(Eps eps:lasEps){
            Integer cont=0;
            for(Paciente paciente:pacientes){
                if(paciente.eps.idEps== eps.idEps){
                    cont+=1;
                    }
                }
            if(cont>contmayor){
                contmayor=cont;
                nombreMayor=eps.nombre;
            }
            System.out.println("la eps "+eps.nombre+"tiene un total de : "+ cont+ " pacientes");
        }
        System.out.println("la EPS con mayor nùmero de pacientes es: "+nombreMayor+"con un total de pacientes de de: "+ contmayor);
    }

    public static void numeroPacientesTipoAfiliacion(){
        Integer contcoti=0;
        Integer contbene=0;
        for(Paciente paciente:pacientes){
            if(paciente.afiliacion==Afiliacion.BENEFICIARIO){
                contbene++;
            }
            else{
                contcoti++;
            }
        }
        System.out.println("El número de pacientes con tipo de afiliación cotizante es: "+ contcoti);
        System.out.println("El número de pacientes con tipo de afiliación beneficiario es: "+ contbene);
    }

    public static void numeroPacientesTipoRegimen(){
        Integer contsubsi=0;
        Integer contcontri=0;
        for(Paciente paciente:pacientes){
            if(paciente.regimen==Regimen.SUBSIDIADO){
                contsubsi++;
            }
            else{
                contcontri++;
            }
        }
        System.out.println("El número de pacientes con tipo de regimen subsidiado es: "+ contsubsi);
        System.out.println("El número de pacientes con tipo de regimen cotributivo es: "+ contcontri);
    }
}