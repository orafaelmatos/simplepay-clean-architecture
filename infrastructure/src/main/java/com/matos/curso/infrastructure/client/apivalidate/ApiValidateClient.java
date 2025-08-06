package com.matos.curso.infrastructure.client.apivalidate;

import com.matos.curso.infrastructure.client.apivalidate.response.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidateClient", url = "https://mocki.io/v1/d8127427-fd7e-48d3-8739-e728939d71fb")
public interface ApiValidateClient {

    @GetMapping
    ApiValidateResponse validate();
}
