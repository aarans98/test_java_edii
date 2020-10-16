package com.test.edii.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "t_province")
public class Province {
    @Id
    @Column(name = "kdprov", length = 25)
    private String kodeProvince;

    @Column(name = "nmprov")
    private String namaProvince;

}
