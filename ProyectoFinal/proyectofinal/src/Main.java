
public class Main {

   
    public static void main(String[] args) {
        InterfazCsv encuesta2021 = new InterfazCsv();
        encuesta2021.Import();
        Region test = new Region("Lochaber");
        test.setP(new Pais(new Indicador("SupportLife",0.345f),
                new Indicador("SupportLife",0.18f),
                new Indicador("SupportLife",0.235f),
                new Indicador("SupportLife",0.367f),
                new Indicador("SupportLife",0.111f), "Howarts"));
        encuesta2021.setRegion(test);
        
        
       encuesta2021.getPromedioRegion();
       encuesta2021.getMasCorrupto();
       encuesta2021.getMasGeneroso();
    }
    
}
