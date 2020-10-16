package com.test.edii.service;
;
import com.test.edii.assembler.ProvinsiAssembler;
import com.test.edii.model.dto.ProvinceDto;
import com.test.edii.model.entity.Province;
import com.test.edii.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceRepository repository;
    @Autowired
    private ProvinsiAssembler assembler;

    @Override
    public ProvinceDto insertDataProvince(ProvinceDto dto) {
        Province entity = repository.save(assembler.fromDto(dto));
        repository.save(entity);
        return assembler.fromEntity(entity);
    }
}


