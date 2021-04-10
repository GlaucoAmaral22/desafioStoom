package com.desafioStoom.repository.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity(name = "endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da rua não pode ser nullo ou vazio.")
    private String streetName;

    @Min(0)
    @Max(99999)
    private Integer number;

    private String complement;

    @NotBlank(message = "Nome do bairro não pode ser nullo ou vazio.")
    private String neighbourhood;

    @NotBlank(message = "Nome da rua não pode ser nullo ou vazio.")
    private String city;

    @NotBlank(message = "Nome do estado não pode ser nullo ou vazio.")
    private String state;

    @NotBlank(message = "Nome do país não pode ser nullo ou vazio.")
    private String country;

    @NotBlank(message = "Codigo Postal não pode ser nullo ou vazio.")
    private String zipcode;

    private Double latitude;
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public EnderecoEntity() {
    }
}
