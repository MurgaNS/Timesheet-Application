ALTER TABLE client
    ADD is_deleted BOOLEAN DEFAULT FALSE
        AFTER country_id;