package com.wl.dandan.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taxonomy {
    private final Integer id;
    private String name;

    private Taxonomy parent;
    private List<Taxonomy> children = new ArrayList<Taxonomy>();

    public Taxonomy(Integer id) {
        this.id = id;
    }

    public void attachToParent(Taxonomy parentTaxonomy){
        this.setParent(parentTaxonomy);
        parent.children.add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setParent(Taxonomy parent) {
        this.parent = parent;
    }

    public Taxonomy getParent() {
        return parent;
    }

    public Boolean hasChildren(){
        return null != children && !children.isEmpty();
    }

    public List<Taxonomy> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Taxonomy that = (Taxonomy) o;

        if (!id.equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
