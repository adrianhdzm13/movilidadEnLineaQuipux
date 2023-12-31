package co.quipux.models;

import co.quipux.utils.BaseConfig;

public class FineProjectionData extends BaseConfig {

    private String identificacion;


    public FineProjectionData(String identificacion) {
        super(FineProjectionData.class);
        this.identificacion = identificacion;
        BaseConfig.log.info("User information setup ["+this.getClass().getName()+"]");
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

}
