package com.shoureken.euvejo.data;

public class Actor extends Entity{

    private static final long serialVersionUID = 9084496017655495401L;
    private Integer id;
    private String name;
    private String role;
    private String urlImage;
    

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
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
    
    /**
     * @return the urlImage
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @param urlImage the urlImage to set
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Actor [id=" + id + ", name=" + name + ", role=" + role + ", urlImage=" + urlImage + "]";
    }
}
