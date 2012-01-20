package blog.geocode.json;
 
import javax.xml.bind.annotation.XmlType;
import org.eclipse.persistence.oxm.annotations.XmlPath;
 
@XmlType(propOrder={"country", "state", "city", "street", "postalCode"})
public class Address {
 
    @XmlPath("Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:Locality/ns:Thoroughfare/ns:ThoroughfareName/text()")
    private String street;
 
    @XmlPath("Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:Locality/ns:LocalityName/text()")
    private String city;
 
    @XmlPath("Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:AdministrativeAreaName/text()")
    private String state;
 
    @XmlPath("Placemark/ns:AddressDetails/ns:Country/ns:CountryNameCode/text()")
    private String country;
 
    @XmlPath("Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:Locality/ns:PostalCode/ns:PostalCodeNumber/text()")
    private String postalCode;
 
}