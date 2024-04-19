package com.ms.email.models.entity;



import com.ms.email.models.enums.StatusEmail;
import jakarta.persistence.*;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "emails")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "email_id")
    private UUID emailId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "email_from")
    private String emailFrom;

    @Column(name = "email_to")
    private String emailTo;

    private String subject;

    private String text;

    @Column(name = "send_date_email")
    private LocalDate sendDateEmail;

    @Column(name = "status_email")
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDate sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
