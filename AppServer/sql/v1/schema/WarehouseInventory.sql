DROP TABLE IF EXISTS`WarehouseInventories`;

CREATE TABLE `WarehouseInventories` (
	id INT AUTO_INCREMENT PRIMARY KEY,
	warehouseId VARCHAR(20) NOT NULL,
	itemId CHAR(6),
	quantity SMALLINT
);