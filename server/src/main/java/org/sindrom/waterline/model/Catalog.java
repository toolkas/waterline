package org.sindrom.waterline.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Catalog {
    private final List<Vendor> vendors = new ArrayList<>();

    public Catalog() {

    }

    public List<Vendor> findByShape(WaterlineShape shape) {
        return vendors.stream().filter(vendor -> shape == vendor.getShape()).collect(Collectors.toList());
    }
}
