package com.wl.dandan.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Destination {
    private final Integer atlasId;
    private final String title;
    private String overview;
    private List<String> histories = new ArrayList<String>();
    private List<String> informations = new ArrayList<String>();
    private List<String> transportations = new ArrayList<String>();

    public Destination(Integer id, String title) {
        this.atlasId = id;
        this.title = title;
    }

    public Integer getAtlasId() {
        return atlasId;
    }

    public String getTitle() {
        return title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void addHistory(String history){
        this.histories.add(history);
    }

    public void addHistoryOverview(String history){
        this.histories.add(0, history);
    }

    public void addInformation(String information){
        this.informations.add(information);
    }

    public void addTransportation(String transportation){
        this.transportations.add(transportation);
    }

    public String getOverview() {
        return overview;
    }

    public List<String> getHistories() {
        return Collections.unmodifiableList(histories);
    }

    public List<String> getInformations() {
        return Collections.unmodifiableList(informations);
    }

    public List<String> getTransportations() {
        return Collections.unmodifiableList(transportations);
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destination that = (Destination) o;

        if (!atlasId.equals(that.atlasId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return atlasId.hashCode();
    }
}