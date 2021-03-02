package net.dd.controller;

import net.dd.pojo.DdData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Controller
@CrossOrigin
public class ControllerTest {

    @RequestMapping("/test")
    @ResponseBody
    public DdData getJson() {
        return new DdData(1L, 1L, 4423L, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
    }

}
