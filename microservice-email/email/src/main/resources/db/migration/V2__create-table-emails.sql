CREATE TABLE emails(
    email_id           UUID         NOT NULL DEFAULT uuid_generate_v4(),
    user_id            UUID         NOT NULL,
    email_from         VARCHAR(100) NOT NULL,
    email_to           VARCHAR(100) NOT NULL,
    subject            VARCHAR(100) NOT NULL,
    text               TEXT NOT NULL,
    send_date_email    DATE NOT NULL,
    status_email       VARCHAR(20) NOT NULL,
    CONSTRAINT pk_user
        PRIMARY KEY (email_id)
);
