package ibello.model;

import hu.ibello.data.Model;

import java.time.LocalDate;

@Model
public class DefaultData {

    private String casename;
    private LocalDate validity;
    private String person;

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
