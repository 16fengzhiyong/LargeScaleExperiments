package devil.com.largescaleexperiments.entityclass;

public class FirstViewEntityClass {
    private String id;
    private String temperature;
    private String illumination;
    private boolean ifExistence;

    public FirstViewEntityClass(String id, String temperature, String illumination, boolean ifExistence) {
        this.id = id;
        this.temperature = temperature;
        this.illumination = illumination;
        this.ifExistence = ifExistence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIllumination() {
        return illumination;
    }

    public void setIllumination(String illumination) {
        this.illumination = illumination;
    }

    public boolean isIfExistence() {
        return ifExistence;
    }

    public void setIfExistence(boolean ifExistence) {
        this.ifExistence = ifExistence;
    }

    @Override
    public String toString() {
        return "FirstViewEntityClass{" +
                "id='" + id + '\'' +
                ", temperature='" + temperature + '\'' +
                ", illumination='" + illumination + '\'' +
                ", ifExistence=" + ifExistence +
                '}';
    }
}
