package eu.ppf.requester.entities;

import eu.ppf.requester.utils.Converter;

public class CompanyEntity {
    private String name;
    private String catchPhrase;
    private String bs;

    public CompanyEntity() {
    }

    public CompanyEntity(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return new Converter<CompanyEntity>().convertToJson(this);
    }
}
