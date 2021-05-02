
import java.util.ArrayList;

public class Region {

    private ArrayList<Pais> P;
    private String NombreR;

    public Region(String NombreR) {
        this.NombreR = NombreR;

        P = new ArrayList<Pais>();

    }

    public ArrayList<Pais> getP() {
        return P;
    }

    public void setP(Pais P) {
        this.P.add(P);
    }

    public void setMultiP(ArrayList<Pais> P) {
        for (Pais pais : P) {
            this.P.add(pais);
        }
    }

    public String getNombreR() {
        return NombreR;
    }

    public void setNombreR(String NombreR) {
        this.NombreR = NombreR;
    }
    
    public void getPromedio(){
        float tempS = 0, tempH = 0, tempF = 0, tempG = 0, tempP = 0;
        for (Pais pais : P) {
            tempS += pais.getSocialSupport().getValor();
            tempH += pais.getHealthyLife().getValor();
            tempF += pais.getFreedomChoices().getValor();
            tempG += pais.getGenerosity().getValor();
            tempP += pais.getPercepcup().getValor();
        }
        tempS /= P.size();
        System.out.printf("Promedio de Social Support para la region %s: %.4f\n", this.NombreR, tempS);
        tempH /= P.size();
        System.out.printf("Promedio de Healthy Life para la region %s: %.4f\n", this.NombreR, tempH);
        tempF /= P.size();
        System.out.printf("Promedio de Freedom Choices para la region %s: %.4f\n", this.NombreR, tempF);
        tempG /= P.size();
        System.out.printf("Promedio Generosity para la region %s: %.4f\n", this.NombreR, tempG);
        tempP /= P.size();
        System.out.printf("Promedio Perception of Corruption para la region %s: %.4f\n", this.NombreR, tempP);
        
        System.out.println("\n-----------------------------------------------------------------------------------------------");
    }

}
