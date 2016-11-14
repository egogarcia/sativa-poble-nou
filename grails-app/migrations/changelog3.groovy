databaseChangeLog = {

	changeSet(author: "userpc (generated)", id: "1431102918111-1") {
		dropColumn(columnName: "number", tableName: "guest_historic")
	}
}
