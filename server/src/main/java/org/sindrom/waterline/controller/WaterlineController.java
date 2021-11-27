package org.sindrom.waterline.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wl/api/")
public class WaterlineController {

    @GetMapping("/test")
    public String test() {
        return "TEST";
    }

    public Object calculate() {

    }
}
