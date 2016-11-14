databaseChangeLog = {

	changeSet(author: "userpc (generated)", id: "1431178057473-1") {
		addForeignKeyConstraint(baseColumnNames: "friend_id", baseTableName: "guest_historic", constraintName: "FK3559C2E67D0DDED", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "partner", referencesUniqueColumn: "false")
	}
}
