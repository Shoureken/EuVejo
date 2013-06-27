package com.shoureken.euvejo.data;

public class Language extends Entity{

    private static final long serialVersionUID = -6993701377288170019L;
    private Integer id;
    private String name;
    private String abbreviation;
    
    

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * @param abbreviation the abbreviation to set
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
	return "Language [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + "]";
    }
}
