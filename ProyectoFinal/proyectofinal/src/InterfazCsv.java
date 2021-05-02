
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InterfazCsv {

    private ArrayList<Region> regiones;

    public InterfazCsv() {
        regiones = new ArrayList<>();
    }

    public void Import() {
        //Utilizaremos el bloque Try- catch para asi evitar errores 
        try {
              //Se crea un CSVReader para que se lea el documento 
            CsvReader leerListaP = new CsvReader("C:\\Users\\marce\\Desktop\\UNAH Paola\\ProyectoFinal\\proyectofinal\\world-happiness-report-2021.csv");
            leerListaP.readHeaders();// Este metodo se encarga de recorrer el archivo csv
            String CountryName, RegionalIndicator, SocialSupport, HealthyLife, FreedomChoices, Generosity, Percepcup;
            //Recorremos el archivo mediante un bucle de repeticion while 
            while (leerListaP.readRecord()) {
                //Creamos una validacion para que verifique si es la primera lectura o no 
                if (leerListaP.getColumnCount() > 7) {
                    CountryName = leerListaP.get(0);
                    RegionalIndicator = leerListaP.get(1);
                    SocialSupport = leerListaP.get(7);
                    HealthyLife = leerListaP.get(8);
                    FreedomChoices = leerListaP.get(9);
                    Generosity = leerListaP.get(10);
                    Percepcup = leerListaP.get(11);
                } else {
                    CountryName = leerListaP.get(0);
                    RegionalIndicator = leerListaP.get(1);
                    SocialSupport = leerListaP.get(2);
                    HealthyLife = leerListaP.get(3);
                    FreedomChoices = leerListaP.get(4);
                    Generosity = leerListaP.get(5);
                    Percepcup = leerListaP.get(6);
                }

                
                //Una variables del tipo temp con atributo int llamando a ala funcion regionExistente y poniendole como parametro el regionalindicato
                //Este metodo lo que hace es añadir los datos solcitados al documento y con el Float.parseFloat covierte los datos string a datos flotantes 
                int temp = regionExiste(RegionalIndicator);
                if (temp == -1) {
                    regiones.add(new Region(RegionalIndicator));
                    regiones.get(regiones.size() - 1).setP(new Pais(new Indicador("SocialSupport", Float.parseFloat(SocialSupport)),
                            new Indicador("HealthyLife", Float.parseFloat(HealthyLife)),
                            new Indicador("FreedomChoices", Float.parseFloat(FreedomChoices)),
                            new Indicador("Generosity", Float.parseFloat(Generosity)),
                            new Indicador("Percecup", Float.parseFloat(Percepcup)),
                            CountryName));

                } else {
                    regiones.get(temp).setP(new Pais(new Indicador("SocialSupport", Float.parseFloat(SocialSupport)),
                            new Indicador("HealthyLife", Float.parseFloat(HealthyLife)),
                            new Indicador("FreedomChoices", Float.parseFloat(FreedomChoices)),
                            new Indicador("Generosity", Float.parseFloat(Generosity)),
                            new Indicador("Percecup", Float.parseFloat(Percepcup)),
                            CountryName));
                }

            }
            leerListaP.close();
            // Atraves de un For each o mejorado recorreremos la lista

            for (Region region : regiones) {
                for (Pais pais : region.getP()) {
                    System.out.println(pais.getNombreP() + ","
                            + pais.getSocialSupport().getValor() + ","
                            + pais.getHealthyLife().getValor() + ","
                            + pais.getFreedomChoices().getValor() + ","
                            + pais.getGenerosity().getValor() + ","
                            + pais.getPercepcup().getValor() + ","
                            + region.getNombreR());
                }
            }
            Export(null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Crearemos el metodo Export que exportara  paises

    public void Export(Region temp) {
        boolean flag;
        flag = temp != null;
        // Crearemos una varible ExitArchive tipo String apuntanddo al nombre del archivo 
        String ExitArchive = "C:\\Users\\marce\\Desktop\\UNAH Paola\\ProyectoFinal\\proyectofinal\\world-happiness-report-2021.csv";
        boolean x = new File(ExitArchive).exists();
        //El metodo exists(); verifica si el archivo existe Jumpei
        try {
            CsvWriter exit = new CsvWriter(new FileWriter(ExitArchive, flag), ',');

            // Se traen dos parametos un temporal de tipo regio, el flag es para borrar o concatener solo el final , pero si el objeto es nulo tiene que volver a escribir todo 
            if (temp == null) {
                exit.write("Country Name");
                exit.write("Regional Indicator");
                exit.write("Social Support");
                exit.write("Healthy life expectancy");
                exit.write("Freedom To make life choices");
                exit.write("Generosity");
                exit.write("Percepctions of Corruption");
                exit.endRecord();
                for (Region region : regiones) {
                    for (Pais pais : region.getP()) {
                        exit.write(pais.getNombreP());
                        exit.write(region.getNombreR());
                        exit.write(String.valueOf(pais.getSocialSupport().getValor()));
                        exit.write(String.valueOf(pais.getHealthyLife().getValor()));
                        exit.write(String.valueOf(pais.getFreedomChoices().getValor()));
                        exit.write(String.valueOf(pais.getGenerosity().getValor()));
                        exit.write(String.valueOf(pais.getPercepcup().getValor()));
                        // invocaremos el Metodo endRecord(); para dejar de escribir 
                        exit.endRecord();
                    }
                }
            } else {

                for (Pais pais : temp.getP()) {
                    exit.write(pais.getNombreP());
                    exit.write(temp.getNombreR());
                    exit.write(String.valueOf(pais.getSocialSupport().getValor()));
                    exit.write(String.valueOf(pais.getHealthyLife().getValor()));
                    exit.write(String.valueOf(pais.getFreedomChoices().getValor()));
                    exit.write(String.valueOf(pais.getGenerosity().getValor()));
                    exit.write(String.valueOf(pais.getPercepcup().getValor()));
                    // invocaremos el Metodo endRecord(); para dejar de escribir 
                    exit.endRecord();
                }

            }

            exit.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//settea una region manualmente para ingreso de paises

    public void setRegion(Region r) {
        int temp = regionExiste(r.getNombreR());
        if (temp == -1) {
            this.regiones.add(r);
            Export(r);
        } else {
            this.regiones.get(temp).setMultiP(r.getP());//para que usuario  pueda meter mas de un mas pais en una region existente 
            Export(null);
        }

    }

    private int regionExiste(String tempNombre) {// Este metodo comprueba si ya se tiene registrada la  region 
        for (int i = 0; i < regiones.size(); i++) {
            if (regiones.get(i).getNombreR().equals(tempNombre)) {
                return i;// Devuelve la posicion 
            }
        }
        return -1;// Devuelve un dato interpretable de la no existencia de una region 
    }

    public void getPromedioRegion() {//Ayuda a calcular el promedio 
        for (Region region : regiones) {
            region.getPromedio();
        }
    }

    public void getMasCorrupto() {//DEtermina el pais mas corrupto
        float temp = 0;
        String nombre = "";
        for (Region region : regiones) {
            for (Pais pais : region.getP()) {
                if (temp < pais.getPercepcup().getValor()) {
                    temp = pais.getPercepcup().getValor();
                    nombre = pais.getNombreP();
                }
            }
        }
        System.out.printf("\nEl pais ´mas corrupto es: %s con %.4f", nombre, temp);
    }

    public void getMasGeneroso() {// Determina el mas mas generoso
        float temp = 0;
        String nombre = "";
        for (Region region : regiones) {
            for (Pais pais : region.getP()) {
                if (temp < pais.getGenerosity().getValor()) {
                    temp = pais.getGenerosity().getValor();
                    nombre = pais.getNombreP();
                }
            }
        }
        System.out.printf("\nEl pais mas generoso es: %s con %.4f", nombre, temp);
    }

}
