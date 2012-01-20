package blog.geocode.json;
 
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;
 
public class Demo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Address.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
        // XML
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("http://maps.google.com/maps/geo?q=1600+Amphitheatre+Parkway,+Mountain+View,+CA&output=xml&sensor=false&key=YOUR_KEY_HERE");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr.nextTag(); // Advance to kml tag
        xsr.nextTag(); // Advance to Response tag
        JAXBElement<Address> addressFromXML = unmarshaller.unmarshal(xsr, Address.class);
        marshaller.marshal(addressFromXML, System.out);
 
        // JSON
        unmarshaller.setProperty("eclipselink.media-type", "application/json");
        StreamSource json = new StreamSource("http://maps.google.com/maps/geo?q=1600+Amphitheatre+Parkway,+Mountain+View,+CA&output=json&sensor=false&key=YOUR_KEY_HERE");
        JAXBElement<Address> addressFromJSON = unmarshaller.unmarshal(json, Address.class);
        marshaller.setProperty("eclipselink.media-type", "application/json");
        marshaller.marshal(addressFromJSON, System.out);
    }
 
}