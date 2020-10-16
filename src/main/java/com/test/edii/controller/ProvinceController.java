package com.test.edii.controller;

import com.test.edii.assembler.ProvinsiAssembler;
import com.test.edii.configuration.DefaultResponse;
import com.test.edii.model.dto.ProvinceDto;
import com.test.edii.model.entity.Province;
import com.test.edii.repository.ProvinceRepository;
import com.test.edii.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceRepository repository;
    @Autowired
    private ProvinceService service;
    @Autowired
    private ProvinsiAssembler assembler;

    // http://localhost:8080/1
    @GetMapping
    public DefaultResponse get() {
        List<Province> provinceList = repository.findAll();
        List<ProvinceDto> provinceDtoList = provinceList.stream().map(provinsi -> assembler.fromEntity(provinsi))
                .collect(Collectors.toList());
        return DefaultResponse.ok(provinceDtoList);
    }

    // http://localhost:1515/province/1
    @GetMapping("/{id}")
    public DefaultResponse get(@PathVariable String id) {
        ProvinceDto provinceDto = assembler.fromEntity(repository.findById(id).get());
        return DefaultResponse.ok(provinceDto);
    }

    /*Insert Data*/
    @PostMapping
    public DefaultResponse insert(@RequestBody ProvinceDto dto) {
        Province province = assembler.fromDto(dto);
        repository.save(province);
        return DefaultResponse.ok(dto);
    }

    /*Put Mapping*/
    @PutMapping("/{id}")
    public DefaultResponse update(@RequestBody ProvinceDto dto, @PathVariable String id) {
        return DefaultResponse.ok(service.insertDataProvince(dto));
    }

    /*Delete*/
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
