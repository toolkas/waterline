package org.sindrom.waterline.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Position {
    private final WaterlineShape shape;
    private final Vendor vendor;
    private final String name;
    private final String value;
    private int count;

    public int count(Catalog catalog, int perimeter, int insideCornersCount, int outsideCornersCount, int gutterPlugsCount, int funnelPlugsCount, boolean hasEave) {
        int jelob_count = 0;
        if (value.indexOf("Кронштейн желоба") > -1 || value.indexOf("Держатель желоба") > -1 || value.indexOf("Крюк") > -1 ) {
            return ( (int) Math.round(perimeter/0.85));
        } else if (value.indexOf("Желоб") > -1) {
            jelob_count = Math.round(perimeter/3);
        } else if (value.indexOf("внутрен") > -1  && value.indexOf("Уг") > -1) {
            return Math.round(insideCornersCount);
        } else if (value.indexOf("наружн") > -1 && value.indexOf("Уг") > -1) {
            return Math.round(outsideCornersCount);
        } else if (value.indexOf("Заглушка") > -1) {
            if ( value.indexOf("левая") > -1 || value.indexOf("правая") > -1 ) {
                return gutterPlugsCount / 2;
            } else {
                return gutterPlugsCount;
            };
        } else if (value.indexOf("Воронка") > -1) {
            return funnelPlugsCount;
        } else if (value.indexOf("Колено трубы") > -1) {
            if(hasEave && shape == WaterlineShape.CIRCLE) {
                return 2 * funnelPlugsCount;
            } else {
                return 1 * funnelPlugsCount;
            };
        } else if (value.indexOf("Колено сливное") > -1 || value.indexOf("Колено стока") > -1 || value.indexOf("Наконечник трубы") > -1) {
            return funnelPlugsCount;
        };

        if (name.indexOf('Соединитель желоба') > -1 && name.indexOf('труб') == -1) {
            return parseInt(temp_data.jelob_count) + ((main_data.kvu + main_data.knu) * 2);
        };

        if (value.indexOf('Труба') > -1  && value.indexOf('3м') > -1 && value.indexOf('соед') == -1 || value.indexOf('Водосточная труба') > -1) {
            temp_data.truba_3m =  Math.round(main_data.height / 3);
            return temp_data.truba_3m*main_data.kv;
        } else if (value.indexOf('Труба') > -1  && value.indexOf('1м') > -1 || value.indexOf('соед') > -1) {
            if (main_data.height % 3 == 1) {
                temp_data.truba_1m = Math.round( main_data.height % 3 );
            } else {
                temp_data.truba_1m = 0;
            };
            return temp_data.truba_1m*main_data.kv;
        } else if (value.indexOf('Кронштейн трубы') > -1 || value.indexOf('Хомут') > -1) {
            return (temp_data.truba_3m + temp_data.truba_1m * 3);
        };

        return 0;
    }
}
