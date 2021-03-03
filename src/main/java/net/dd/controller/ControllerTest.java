package net.dd.controller;

import net.dd.pojo.DdData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;


@Controller
@CrossOrigin
public class ControllerTest {

    @RequestMapping("/test")
    @ResponseBody
    public DdData getJson() {
        return new DdData(1L, 1, 4423L, LocalDateTime.now(), LocalDateTime.now());
    }

}
