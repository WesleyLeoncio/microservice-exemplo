CREATE TABLE usuarios(
    user_id           UUID         NOT NULL DEFAULT uuid_generate_v4(),
    nome             VARCHAR(100) NOT NULL,
    email            VARCHAR(100) NOT NULL,
    CONSTRAINT pk_user
        PRIMARY KEY (user_id)
);
