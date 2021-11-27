package org.sindrom.waterline.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class HouseWaterline {
    // справочники
    private String brand;
    private Coating coating;
    private String color;

    // Данные
    private WaterlineShape shape;
    private int perimeter;
    private int insideCornersCount;
    private int outsideCornersCount;
    private int gutterPlugsCount;
    private int funnelPlugsCount;
    private double height;
    private boolean hasEave;

    private List<Position> positions;

    public void calculate(Catalog catalog) {
        this.positions = new ArrayList<>();

        List<Vendor> vendors = catalog.findByShape(shape);
        Vendor vendor = vendors.stream().filter(v -> Objects.equals(v.getBrandName(), brand)).findAny().get();

        for(Map.Entry<String, String> entry: vendor.getElements().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            Position position = new Position(shape, vendor, key, value);
            position.count(catalog);

            positions.add(position);
        }
    }
}
