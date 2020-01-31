package com.sdc.aisat.annajijo.blooddonation.my_class;

/**
 * Created by Anna Babu on 2/26/2017.
 */
public class PostRecord {

    String name, email, currentgrp, uid, push;

    int units,volunteer;

    String blood,urgency,country,state,city,hospital,relation,contact,info;

    public PostRecord(String name, String email, String currentgrp, String uid, String push, int units, String blood, String urgency, String country, String state, String city, String hospital, String relation, String contact, String info,int volunteer) {
        this.name = name;
        this.email = email;
        this.currentgrp = currentgrp;
        this.uid = uid;
        this.push = push;
        this.units = units;
        this.blood = blood;
        this.urgency = urgency;
        this.country = country;
        this.state = state;
        this.city = city;
        this.hospital = hospital;
        this.relation = relation;
        this.contact = contact;
        this.info = info;

        this.volunteer=volunteer;


    }

    public int getVolunteer() {
        return volunteer;
    }

    public PostRecord() {
    }

    public void setPush(String push) {
        this.push = push;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentgrp() {
        return currentgrp;
    }

    public String getUid() {
        return uid;
    }

    public String getPush() {
        return push;
    }

    public int getUnits() {
        return units;
    }

    public String getBlood() {
        return blood;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getHospital() {
        return hospital;
    }

    public String getRelation() {
        return relation;
    }

    public String getContact() {
        return contact;
    }

    public String getInfo() {
        return info;
    }
}
