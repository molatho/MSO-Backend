package de.hsma.stayingalive.dto;

import java.io.Serializable;

/**
 *
 */
public class NutzerDTO implements Serializable {


    private Integer id;
    /**
     * enthält die Persönlichen Personenbezogenen Daten
     */
    private StammdatenDTO persoenlicheDaten;

    /**
     * hält weitere Private Daten
     */
    private PrivateDatenDTO privateDaten;

    /**
     * Hält Medizinisch relevante Daten und Informationen
     */
    private MedizinischeInformationenDTO medizinischeInformationen;


    public StammdatenDTO getPersoenlicheDaten() {
        return persoenlicheDaten;
    }

    public void setPersoenlicheDaten(StammdatenDTO persoenlicheDaten) {
        this.persoenlicheDaten = persoenlicheDaten;
    }

    public PrivateDatenDTO getPrivateDaten() {
        return privateDaten;
    }

    public void setPrivateDaten(PrivateDatenDTO privateDaten) {
        this.privateDaten = privateDaten;
    }

    public MedizinischeInformationenDTO getMedizinischeInformationen() {
        return medizinischeInformationen;
    }

    public void setMedizinischeInformationen(MedizinischeInformationenDTO medizinischeInformationen) {
        this.medizinischeInformationen = medizinischeInformationen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
