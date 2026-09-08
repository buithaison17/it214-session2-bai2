package com.example.bai2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    /**
     * Xử lý message được ESB định tuyến tới NotificationService.
     */
    public void handle(String operation, String payload) {

        System.out.println(
                "[NotificationService] Received message"
        );

        System.out.println(
                "[NotificationService] Operation: " + operation
        );

        System.out.println(
                "[NotificationService] Payload: " + payload
        );

        if ("notifyOverdue".equals(operation)) {
            notifyOverdue(payload);
        } else {
            System.out.println(
                    "[NotificationService] Unsupported operation: "
                            + operation
            );
        }
    }

    /**
     * Thực hiện nghiệp vụ thông báo sách quá hạn.
     */
    private void notifyOverdue(String payload) {

        System.out.println(
                "[NotificationService] Processing overdue notification..."
        );

        // Trong hệ thống thực tế:
        // - Parse payload
        // - Tìm thông tin member
        // - Tìm thông tin book
        // - Gửi email/SMS/push notification

        System.out.println(
                "[NotificationService] Notification sent successfully!"
        );
    }
}
