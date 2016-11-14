import com.sativa.domain.Partner
import com.sativa.domain.Role
import com.sativa.domain.PartnerRole
import com.sativa.domain.Genetic
import com.sativa.domain.GeneticOrders
import com.sativa.domain.GeneticType

import com.sativa.enums.PartnerStatusEnum
class BootStrap {

   def init = { servletContext ->
   	 TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
/*
     def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_PARTNER').save(flush: true)
      def sellerRole = new Role(authority: 'ROLE_SELLER').save(flush: true)
      def testUser
      try {
         testUser = new Partner(username: 'me', password: 'password', code:"001", firstname:"pedro", lastname:"garcia", phone:"6666666", address:"calle anonimo 123 Barcelona", identificationNumber:"38879780M", status:PartnerStatusEnum.PARTNER_STATUS__ACTIVED)
         if (!testUser.validate()) println "eroress "+testUser.errors
         testUser.save(flush: true)
         testUser.encodePassword()

      }
      catch(all){
         println "all "+all.getMessage()
         println "aaaaaaa "+all.dump()
      }

        PartnerRole.create testUser, adminRole, true
      PartnerRole.create testUser, userRole, true
      PartnerRole.create testUser, sellerRole, true
      PartnerRole.create testUser, userRole, true

        def geneticType = new GeneticType(name:"TIPO1", price:1.34, grams:0.80, color:"#088A08")
      geneticType.save(flush:true)
*/
      Date.metaClass.'static'.fromISO = { String date ->
            if (!date) return null
            try {
                return new java.sql.Timestamp(javax.xml.bind.DatatypeConverter.parseDateTime(date).getTimeInMillis())
            }
            catch(IllegalArgumentException iae) {
                log.error "Invalid date input. Must be a String with format 'yyyy-MM-dd'T'HH:mm:ssZ'"
                return null
            }
        }
   }
}