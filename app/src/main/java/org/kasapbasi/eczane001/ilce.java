package org.kasapbasi.eczane001;

/**
 * Created by mcemkasapbasi on 17.05.2018.
 */

public class ilce {
    private String IlceAdi;
    private String Token;

public ilce(String IlceAdi,String Token, String ID){

    this.ID=ID;
    this.Token=Token;
    this.IlceAdi=IlceAdi;
}
    public String getIlceAdi() {
        return IlceAdi;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return getIlceAdi();
    }

    private String ID;

    public void setIlceAdi(String ilceAdi) {
        IlceAdi = ilceAdi;
    }

    public void setToken(String token) {
        Token = token;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getToken() {
        return Token;
    }
}
