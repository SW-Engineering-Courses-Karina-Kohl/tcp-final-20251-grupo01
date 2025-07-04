package br.ufrgs.inf.tcp.tcheorganiza.model.courses;

import androidx.annotation.NonNull;

public class Teacher {

    private String name;
    private String email;
    private Office office;

    // CONSTUCTORS =========================================================

    public Teacher(String name, String email, Office office) {
        this.name = name;
        this.email = email;
        this.office = office;
    }

    @NonNull
    @Override
    public String toString(){
        return name;
    }
    // SETTERS =========================================================

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        this.email = email;
    }

    public void setOffice(Office office) {
        if (office == null) {
            throw new IllegalArgumentException("Office cannot be null");
        }
        this.office = office;
    }

    // GETTERS =========================================================

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Office getOffice() {
        return office;
    }

}