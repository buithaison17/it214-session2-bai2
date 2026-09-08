package com.example.bai2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EsbSimulator {
    private final NotificationService notificationService;

    /**
     * Định tuyến message tới service tương ứng.
     */
    public void routeMessage(
            String toService,
            String operation,
            String payload
    ) {

        System.out.println("[ESB] Routing message...");
        System.out.println("[ESB] Target service: " + toService);
        System.out.println("[ESB] Operation: " + operation);

        if ("NotificationService".equals(toService)) {

            System.out.println(
                    "[ESB] Routing to NotificationService"
            );

            notificationService.handle(
                    operation,
                    payload
            );

        } else {

            /*
             * Service không tồn tại.
             *
             * Không được để message biến mất âm thầm.
             */
            System.out.println(
                    "[ESB][WARN] Routing failed!"
            );

            System.out.println(
                    "[ESB][WARN] Unknown target service: "
                            + toService
            );

            System.out.println(
                    "[ESB][WARN] Message was not delivered."
            );
        }
    }
}
