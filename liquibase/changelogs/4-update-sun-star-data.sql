--liquibase formatted sql

--changeset Mihaly Verhas:4
UPDATE planets SET temperature = 5778, color = 'YELLOW' WHERE id = 1;
