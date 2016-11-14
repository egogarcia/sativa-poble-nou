package com.sativa.domain

import org.apache.commons.lang.builder.HashCodeBuilder

class PartnerRole implements Serializable {

	private static final long serialVersionUID = 1

	Partner partner
	Role role

	boolean equals(other) {
		if (!(other instanceof PartnerRole)) {
			return false
		}

		other.partner?.id == partner?.id &&
		other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (partner) builder.append(partner.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static PartnerRole get(long partnerId, long roleId) {
		PartnerRole.where {
			partner == Partner.load(partnerId) &&
			role == Role.load(roleId)
		}.get()
	}

	static boolean exists(long partnerId, long roleId) {
		PartnerRole.where {
			partner == Partner.load(partnerId) &&
			role == Role.load(roleId)
		}.count() > 0
	}

	static PartnerRole create(Partner partner, Role role, boolean flush = false) {
		def instance = new PartnerRole(partner: partner, role: role)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Partner u, Role r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = PartnerRole.where {
			partner == Partner.load(u.id) &&
			role == Role.load(r.id)
		}.deleteAll()

		if (flush) { PartnerRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(Partner u, boolean flush = false) {
		if (u == null) return

		PartnerRole.where {
			partner == Partner.load(u.id)
		}.deleteAll()

		if (flush) { PartnerRole.withSession { it.flush() } }
	}

	static void removeAll(Role r, boolean flush = false) {
		if (r == null) return

		PartnerRole.where {
			role == Role.load(r.id)
		}.deleteAll()

		if (flush) { PartnerRole.withSession { it.flush() } }
	}

	static constraints = {
		role validator: { Role r, PartnerRole ur ->
			if (ur.partner == null) return
			boolean existing = false
			PartnerRole.withNewSession {
				existing = PartnerRole.exists(ur.partner.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['role', 'partner']
		version false
	}
}
