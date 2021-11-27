package org.sindrom.waterline.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Vendor {
    private final String brandName;
    private final WaterlineShape shape;
    private final Map<String, String> elements = new HashMap<>();
    private final List<Coating> coatings = new ArrayList<>();
    private final Map<Coating, List<String>> colors = new HashMap<>();
}
