package com.example.budget.converter;

import com.example.budget.model.Client;
import com.example.budget.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.lang.annotation.Annotation;

public class ClientConverter implements Converter<String, Client> {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client convert(String source) {
        return clientRepository.getReferenceById(Long.parseLong(source));
    }
}
