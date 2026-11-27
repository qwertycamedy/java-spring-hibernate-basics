package com.qwertycamedy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "building_number", nullable = false)
    private int buildingNumber;

    @Column(name = "apartment_number", nullable = false)
    private int apartmentNumber;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {
    }

    public Address(String street, int buildingNumber, int apartmentNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "\n id=" + id +
                "\n street=" + street +
                "\n buildingNumber=" + buildingNumber +
                "\n apartmentNumber=" + apartmentNumber +
                "\n student=" + student.getFirstName() + " " + student.getLastName() +
                "\n}";
    }
}
