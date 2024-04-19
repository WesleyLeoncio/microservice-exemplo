package com.ms.email.models.mapper;

import com.ms.email.models.entity.Email;
import com.ms.email.models.request.EmailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmailMapper {
    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    Email emailRequestToEmail(EmailRequest emailRequest);
}
