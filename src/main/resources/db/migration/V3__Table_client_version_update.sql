ALTER TABLE client
    ADD version INT NOT NULL
        AFTER is_deleted;