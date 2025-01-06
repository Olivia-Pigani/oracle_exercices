module service.impl.email {
    requires service.api;
    provides notif.NotificationService with email.EmailNotification;
}