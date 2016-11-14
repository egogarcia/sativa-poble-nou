databaseChangeLog = {

	changeSet(author: "userpc (generated)", id: "1434308208158-1") {
		modifyDataType(columnName: "num_invitations", newDataType: "bigint", tableName: "partner")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-2") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "num_invitations", tableName: "partner")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-3") {
		dropIndex(indexName: "comment_id", tableName: "wp_commentmeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-4") {
		dropIndex(indexName: "meta_key", tableName: "wp_commentmeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-5") {
		dropIndex(indexName: "comment_approved_date_gmt", tableName: "wp_comments")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-6") {
		dropIndex(indexName: "comment_author_email", tableName: "wp_comments")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-7") {
		dropIndex(indexName: "comment_date_gmt", tableName: "wp_comments")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-8") {
		dropIndex(indexName: "comment_parent", tableName: "wp_comments")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-9") {
		dropIndex(indexName: "comment_post_ID", tableName: "wp_comments")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-10") {
		dropIndex(indexName: "code", tableName: "wp_gmp_modules")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-11") {
		dropIndex(indexName: "code", tableName: "wp_gmp_options")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-12") {
		dropIndex(indexName: "code", tableName: "wp_gmp_usage_stat")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-13") {
		dropIndex(indexName: "link_visible", tableName: "wp_links")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-14") {
		dropIndex(indexName: "extras_post_id_key", tableName: "wp_ngg_album")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-15") {
		dropIndex(indexName: "extras_post_id_key", tableName: "wp_ngg_gallery")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-16") {
		dropIndex(indexName: "extras_post_id_key", tableName: "wp_ngg_pictures")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-17") {
		dropIndex(indexName: "option_name", tableName: "wp_options")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-18") {
		dropIndex(indexName: "meta_key", tableName: "wp_postmeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-19") {
		dropIndex(indexName: "post_id", tableName: "wp_postmeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-20") {
		dropIndex(indexName: "post_author", tableName: "wp_posts")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-21") {
		dropIndex(indexName: "post_name", tableName: "wp_posts")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-22") {
		dropIndex(indexName: "post_parent", tableName: "wp_posts")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-23") {
		dropIndex(indexName: "type_status_date", tableName: "wp_posts")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-24") {
		dropIndex(indexName: "term_taxonomy_id", tableName: "wp_term_relationships")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-25") {
		dropIndex(indexName: "taxonomy", tableName: "wp_term_taxonomy")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-26") {
		dropIndex(indexName: "term_id_taxonomy", tableName: "wp_term_taxonomy")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-27") {
		dropIndex(indexName: "name", tableName: "wp_terms")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-28") {
		dropIndex(indexName: "slug", tableName: "wp_terms")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-29") {
		dropIndex(indexName: "meta_key", tableName: "wp_usermeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-30") {
		dropIndex(indexName: "user_id", tableName: "wp_usermeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-31") {
		dropIndex(indexName: "user_login_key", tableName: "wp_users")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-32") {
		dropIndex(indexName: "user_nicename", tableName: "wp_users")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-33") {
		dropTable(tableName: "wp_commentmeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-34") {
		dropTable(tableName: "wp_comments")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-35") {
		dropTable(tableName: "wp_g_circles")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-36") {
		dropTable(tableName: "wp_g_maps")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-37") {
		dropTable(tableName: "wp_g_markers")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-38") {
		dropTable(tableName: "wp_g_polygones")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-39") {
		dropTable(tableName: "wp_g_polylines")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-40") {
		dropTable(tableName: "wp_gmp_icons")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-41") {
		dropTable(tableName: "wp_gmp_maps")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-42") {
		dropTable(tableName: "wp_gmp_marker_groups")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-43") {
		dropTable(tableName: "wp_gmp_markers")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-44") {
		dropTable(tableName: "wp_gmp_modules")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-45") {
		dropTable(tableName: "wp_gmp_modules_type")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-46") {
		dropTable(tableName: "wp_gmp_options")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-47") {
		dropTable(tableName: "wp_gmp_options_categories")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-48") {
		dropTable(tableName: "wp_gmp_usage_stat")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-49") {
		dropTable(tableName: "wp_huge_it_videogallery_galleries")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-50") {
		dropTable(tableName: "wp_huge_it_videogallery_videos")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-51") {
		dropTable(tableName: "wp_hugeit_lightbox")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-52") {
		dropTable(tableName: "wp_links")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-53") {
		dropTable(tableName: "wp_ngg_album")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-54") {
		dropTable(tableName: "wp_ngg_gallery")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-55") {
		dropTable(tableName: "wp_ngg_pictures")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-56") {
		dropTable(tableName: "wp_options")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-57") {
		dropTable(tableName: "wp_postmeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-58") {
		dropTable(tableName: "wp_posts")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-59") {
		dropTable(tableName: "wp_term_relationships")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-60") {
		dropTable(tableName: "wp_term_taxonomy")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-61") {
		dropTable(tableName: "wp_terms")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-62") {
		dropTable(tableName: "wp_usermeta")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-63") {
		dropTable(tableName: "wp_users")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-64") {
		dropTable(tableName: "wp_wpgmza")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-65") {
		dropTable(tableName: "wp_wpgmza_categories")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-66") {
		dropTable(tableName: "wp_wpgmza_category_maps")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-67") {
		dropTable(tableName: "wp_wpgmza_maps")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-68") {
		dropTable(tableName: "wp_wpgmza_polygon")
	}

	changeSet(author: "userpc (generated)", id: "1434308208158-69") {
		dropTable(tableName: "wp_wpgmza_polylines")
	}
}
