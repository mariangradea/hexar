INSERT INTO accounts (id, balance) VALUES (1001, 100);
INSERT INTO accounts (id, balance) VALUES (1002, 100);
INSERT INTO transactions (id, source_account_id, target_account_id, amount, timestamp) VALUES (1, 1001, 1002, 10, CURRENT_TIMESTAMP());
INSERT INTO transactions (id, source_account_id, target_account_id, amount, timestamp) VALUES (2, 1002, 1001, 5, CURRENT_TIMESTAMP());
