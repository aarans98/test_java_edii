package com.test.edii.assembler;


public interface InterfaceAssembler <A, B> {

    A fromDto(B dto);

    B fromEntity(A entity);
}
