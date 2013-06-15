package com.shoureken.euvejo.data;

public class Actor extends Entity{

    private static final long serialVersionUID = 9084496017655495401L;
    private int id;
    private String name;
    private String role;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }
}
