package co.quipux.models;

import co.quipux.utils.BaseConfig;

public class LastStepData extends BaseConfig {

    private String createYourUTestpassword;
    private String confirmPassword;

    public LastStepData(String createYourUTestpassword, String confirmPassword) {
        super(LastStepData.class);
        this.createYourUTestpassword = createYourUTestpassword;
        this.confirmPassword = confirmPassword;
        BaseConfig.log.info("User information setup ["+this.getClass().getName()+"]");
    }

    public String getCreateYourUTestpassword() {
        return createYourUTestpassword;
    }

    public void setCreateYourUTestpassword(String createYourUTestpassword) {
        this.createYourUTestpassword = createYourUTestpassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
