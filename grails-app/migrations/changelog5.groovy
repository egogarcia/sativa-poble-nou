databaseChangeLog = {

	changeSet(author: "userpc (generated)", id: "1431104941594-1") {
		modifyDataType(columnName: "num_invitations", newDataType: "bigint", tableName: "partner")
	}

	changeSet(author: "userpc (generated)", id: "1431104941594-2") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "num_invitations", tableName: "partner")
	}

	changeSet(author: "userpc (generated)", id: "1431104941594-3") {
		dropForeignKeyConstraint(baseTableName: "partner", baseTableSchemaName: "sativaBD", constraintName: "FKD0BCDCC87D0DDED")
	}

	changeSet(author: "userpc (generated)", id: "1431104941594-5") {
		createIndex(indexName: "FK3559C2E67D0DDED", tableName: "guest_historic") {
			column(name: "friend_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1431104941594-6") {
		dropColumn(columnName: "friend_id", tableName: "partner")
	}

	changeSet(author: "userpc (generated)", id: "1431104941594-4") {
		addForeignKeyConstraint(baseColumnNames: "friend_id", baseTableName: "guest_historic", constraintName: "FK3559C2E67D0DDED", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "partner", referencesUniqueColumn: "false")
	}
}
