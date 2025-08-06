package com.matos.curso.infrastructure.client.usernotificate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "NotificationClient", url = "https://mocki.io/v1/e3788e09-7cf4-4f31-8c8e-a57ebe0f30ba")
public interface NotificationClient {

    @GetMapping
    NotificateResponse notificate();
}
