package com.ordersphere.ordersphere.general;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class GeneralService<R> {

    protected static final Logger logger = LoggerFactory.getLogger(GeneralService.class);

    protected R repository;

    @Autowired
    protected PasswordEncoder passwordEncoder;  // @Autowired ile alıyoruz

    @Autowired
    protected ModelMapper modelMapper;  // ModelMapper da burada otomatik enjekte edilecek

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
