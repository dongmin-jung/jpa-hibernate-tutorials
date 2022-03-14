DROP TRIGGER IF EXISTS update_avg_rating_and_num_orders_after_history_insert;
DELIMITER $$
CREATE TRIGGER update_avg_rating_and_num_orders_after_history_insert
AFTER INSERT ON history
FOR EACH ROW
BEGIN
UPDATE tastezips SET avg_rating = (SELECT AVG(rating) FROM history WHERE tastezip_id = NEW.tastezip_id) WHERE id = NEW.tastezip_id;
UPDATE tastezips SET num_orders = (SELECT COUNT(id) FROM history WHERE tastezip_id = NEW.tastezip_id)  WHERE id = NEW.tastezip_id;
-- UPDATE tastezips SET rank = (SELECT aaa FROM history WHERE aaa) WHERE id = NEW.tastezip_id;
END; $$
DELIMITER ;

DROP TRIGGER IF EXISTS update_avg_rating_and_num_orders_after_history_update;
DELIMITER $$
CREATE TRIGGER update_avg_rating_and_num_orders_after_history_update
AFTER UPDATE ON history
FOR EACH ROW
BEGIN
UPDATE tastezips SET avg_rating=(SELECT AVG(rating) FROM history WHERE tastezip_id = NEW.tastezip_id) WHERE id = NEW.tastezip_id;
UPDATE tastezips SET num_orders=(SELECT COUNT(id) FROM history WHERE tastezip_id = NEW.tastezip_id)  WHERE id = NEW.tastezip_id;
-- UPDATE tastezips SET rank=(SELECT aaa FROM history WHERE aaa) WHERE id = NEW.tastezip_id;
END; $$
DELIMITER ;

DROP TRIGGER IF EXISTS update_avg_rating_and_num_orders_after_history_delete;
DELIMITER $$
CREATE TRIGGER update_avg_rating_and_num_orders_after_history_delete
AFTER DELETE ON history
FOR EACH ROW
BEGIN
UPDATE tastezips SET avg_rating=(SELECT AVG(rating) FROM history WHERE tastezip_id = OLD.tastezip_id) WHERE id = OLD.tastezip_id;
UPDATE tastezips SET num_orders=(SELECT COUNT(id) FROM history WHERE tastezip_id = OLD.tastezip_id)  WHERE id = OLD.tastezip_id;
-- UPDATE tastezips SET rank=(SELECT aaa FROM history WHERE aaa) WHERE id = OLD.tastezip_id;
END; $$
DELIMITER ;