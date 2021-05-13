package net.dd.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SomeSignDto implements Serializable {
    private int id;
    private long stunum;
    private String stuname;
    private long signid;
    private String stusignstate;
    private Date signtime;
    private String values;
}
