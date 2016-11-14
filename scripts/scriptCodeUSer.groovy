  
import com.sativa.domain.*
  
  
  def listPartners = Partner.createCriteria().list {}

  

def cont = 0;

listPartners.each {Partner p -> 
  
  Date now = p.dateCreated
  String dayString   = now.getAt(Calendar.DATE)
  String monthString = now.getAt(Calendar.MONTH)+1
  String yearString  = now.getAt(Calendar.YEAR)
  yearString 		   = yearString.substring(2)
  dayString   	   = dayString.padLeft(2, '0')
  monthString 	   = monthString.padLeft(2, '0')
  
  String countString = p.code.substring(p.code.size()-3)
 def newcode =dayString+monthString+yearString+countString.padLeft(3,'0')

 new File("/usr/sativaImages/partners/"+p.code+".png").renameTo(new File("/usr/sativaImages/partners/"+newcode+".png"))
  
 	p.code = newcode
  p.save(flush:true)
  
}
