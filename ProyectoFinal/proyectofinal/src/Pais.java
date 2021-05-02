
import java.util.ArrayList;


public class Pais {
    private Indicador  SocialSupport, 
                       HealthyLife, 
                       FreedomChoices, 
                       Generosity, 
                       Percepcup; 

        private String NombreP;
    
    public Pais(Indicador SocialSupport, Indicador HealthyLife, Indicador FreedomChoices, Indicador Generosity, Indicador Percepcup, String NombreP) {
        this.SocialSupport = SocialSupport;
        this.HealthyLife = HealthyLife;
        this.FreedomChoices = FreedomChoices;
        this.Generosity = Generosity;
        this.Percepcup = Percepcup;
        this.NombreP = NombreP;
    }
    public Indicador getSocialSupport() {
        return SocialSupport;
    }

    public void setSocialSupport(Indicador SocialSupport) {
        this.SocialSupport = SocialSupport;
    }

    public Indicador getHealthyLife() {
        return HealthyLife;
    }

    public void setHealthyLife(Indicador HealthyLife) {
        this.HealthyLife = HealthyLife;
    }

    public Indicador getFreedomChoices() {
        return FreedomChoices;
    }

    public void setFreedomChoices(Indicador FreedomChoices) {
        this.FreedomChoices = FreedomChoices;
    }

    public Indicador getGenerosity() {
        return Generosity;
    }

    public void setGenerosity(Indicador Generosity) {
        this.Generosity = Generosity;
    }

    public Indicador getPercepcup() {
        return Percepcup;
    }

    public void setPercepcup(Indicador Percepcup) {
        this.Percepcup = Percepcup;
    }
 
    public Pais(String NombreP) {
        
        this.NombreP = NombreP;
    }
    
    public String getNombreP() {
        return NombreP;
    }

    public void setNombreP(String NombreP) {
        this.NombreP = NombreP;
    }

  
    
    
    
}
