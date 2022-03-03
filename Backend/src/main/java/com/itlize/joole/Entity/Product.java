package com.itlize.joole.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;


    private String manufacturer;
    private String series;
    private String model;
    private String useType;
    private String application;
    private String mountingLocation;
    private String accessories;
    private String modelYear;
    private String airflow;
    private String powerMax;
    private String powerMin;
    private String operatingVoltageMax;
    private String operatingVoltageMin;
    private String fanSpeedMax;
    private String fanSpeedMin;
    private String numberOfFanSpeeds;
    private String soundAtMaxSpeed;
    private String fanSweepDiameter;
    private String heightMin;
    private String heightMax;
    private String weight;

    @ElementCollection
    private List<String> productDetails;

    @ElementCollection
    private List<String> productDocumentation;  // add the link of the file as string here

    @ElementCollection
    private Map<String, String> contact; //store as key-value pair

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProjectProduct> projectProductList;

    public Product() {
    }

    public Product(Long id, String manufacturer, String series,
                   String model, String useType, String application, String mountingLocation, String accessories, String modelYear, String airflow, String powerMax,
                   String powerMin, String operatingVoltageMax, String operatingVoltageMin, String fanSpeedMax, String fanSpeedMin,
                   String numberOfFanSpeeds, String soundAtMaxSpeed, String fanSweepDiameter, String heightMin, String heightMax, String weight,
                   List<String> productDetails, List<String> productDocumentation, Map<String, String> contact) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.series = series;
        this.model = model;
        this.useType = useType;
        this.application = application;
        this.mountingLocation = mountingLocation;
        this.accessories = accessories;
        this.modelYear = modelYear;
        this.airflow = airflow;
        this.powerMax = powerMax;
        this.powerMin = powerMin;
        this.operatingVoltageMax = operatingVoltageMax;
        this.operatingVoltageMin = operatingVoltageMin;
        this.fanSpeedMax = fanSpeedMax;
        this.fanSpeedMin = fanSpeedMin;
        this.numberOfFanSpeeds = numberOfFanSpeeds;
        this.soundAtMaxSpeed = soundAtMaxSpeed;
        this.fanSweepDiameter = fanSweepDiameter;
        this.heightMin = heightMin;
        this.heightMax = heightMax;
        this.weight = weight;
        this.productDetails = productDetails;
        this.productDocumentation = productDocumentation;
        this.contact = contact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getType() {
        return useType;
    }

    public void setType(String useType) {
        this.useType = useType;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMountingLocation() {
        return mountingLocation;
    }

    public void setMountingLocation(String mountingLocation) {
        this.mountingLocation = mountingLocation;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getAirflow() {
        return airflow;
    }

    public void setAirflow(String airflow) {
        this.airflow = airflow;
    }

    public String getPowerMax() {
        return powerMax;
    }

    public void setPowerMax(String powerMax) {
        this.powerMax = powerMax;
    }

    public String getPowerMin() {
        return powerMin;
    }

    public void setPowerMin(String powerMin) {
        this.powerMin = powerMin;
    }

    public String getOperatingVoltageMax() {
        return operatingVoltageMax;
    }

    public void setOperatingVoltageMax(String operatingVoltageMax) {
        this.operatingVoltageMax = operatingVoltageMax;
    }

    public String getOperatingVoltageMin() {
        return operatingVoltageMin;
    }

    public void setOperatingVoltageMin(String operatingVoltageMin) {
        this.operatingVoltageMin = operatingVoltageMin;
    }

    public String getFanSpeedMax() {
        return fanSpeedMax;
    }

    public void setFanSpeedMax(String fanSpeedMax) {
        this.fanSpeedMax = fanSpeedMax;
    }

    public String getFanSpeedMin() {
        return fanSpeedMin;
    }

    public void setFanSpeedMin(String fanSpeedMin) {
        this.fanSpeedMin = fanSpeedMin;
    }

    public String getNumberOfFanSpeeds() {
        return numberOfFanSpeeds;
    }

    public void setNumberOfFanSpeeds(String numberOfFanSpeeds) {
        this.numberOfFanSpeeds = numberOfFanSpeeds;
    }

    public String getSoundAtMaxSpeed() {
        return soundAtMaxSpeed;
    }

    public void setSoundAtMaxSpeed(String soundAtMaxSpeed) {
        this.soundAtMaxSpeed = soundAtMaxSpeed;
    }

    public String getFanSweepDiameter() {
        return fanSweepDiameter;
    }

    public void setFanSweepDiameter(String fanSweepDiameter) {
        this.fanSweepDiameter = fanSweepDiameter;
    }

    public String getHeightMin() {
        return heightMin;
    }

    public void setHeightMin(String heightMin) {
        this.heightMin = heightMin;
    }

    public String getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(String heightMax) {
        this.heightMax = heightMax;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<String> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<String> productDetails) {
        this.productDetails = productDetails;
    }

    public List<String> getProductDocumentation() {
        return productDocumentation;
    }

    public void setProductDocumentation(List<String> productDocumentation) {
        this.productDocumentation = productDocumentation;
    }

    public Map<String, String> getContact() {
        return contact;
    }

    public void setContact(Map<String, String> contact) {
        this.contact = contact;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public List<ProjectProduct> getProjectProductList() {
        return projectProductList;
    }

    public void setProjectProductList(List<ProjectProduct> projectProductList) {
        this.projectProductList = projectProductList;
    }
}
