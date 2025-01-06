package email;

import notif.NotificationService;

public class EmailNotification implements NotificationService {
    @Override
    public String sendNotification(String name) {
        return "email notification";
    }
}
