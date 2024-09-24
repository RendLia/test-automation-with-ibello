package ibello.model;

import hu.ibello.data.Model;

@Model
public class Case {

    private Address address;
    private DefaultData defaultData;
    private String id;
    private String status;
    private String responsible;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DefaultData getDefaultData() {
        return defaultData;
    }

    public void setDefaultData(DefaultData defaultData) {
        this.defaultData = defaultData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    @Override
    public String toString() {
        return "Case{" +
                "Casename=" + defaultData.getCasename() +
                '}';
    }
}
