#!/bin/sh

createDB(){
	echo "Creating database SuperK"

	mysql -u root -proot -e "create database IF NOT EXISTS SuperK"; 
}

createTables(){
	echo "Creating Tables"

	cd ../schema
	pwd
	            
	mysql -u root -proot SuperK < Item.sql
	mysql -u root -proot SuperK < ItemType.sql
	mysql -u root -proot SuperK < Stock.sql
	mysql -u root -proot SuperK < StoreInventory.sql
	mysql -u root -proot SuperK < Store.sql
	mysql -u root -proot SuperK < WarehouseInventory.sql
	mysql -u root -proot SuperK < Warehouse.sql

	echo "\nCreated Tables\n"
}


createDummyData(){
	echo "\nCreating Data"

	cd ../data
	pwd
	            
	mysql -u root -proot SuperK < Item.sql
	mysql -u root -proot SuperK < ItemType.sql
	mysql -u root -proot SuperK < Stock.sql
	mysql -u root -proot SuperK < StoreInventory.sql
	mysql -u root -proot SuperK < Store.sql
	mysql -u root -proot SuperK < WarehouseInventory.sql
	mysql -u root -proot SuperK < Warehouse.sql

	echo "\nCreated Data\n"
}





createDB
createTables
createDummyData

echo "\n\nYour DB setup is complete :)"