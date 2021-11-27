package org.sindrom.waterline.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Coating {
    POLIESTER("Полиэстер"),
    GRANIT("Granite"),
    PURMAN("PURMAN®");

    private final String name;
}
