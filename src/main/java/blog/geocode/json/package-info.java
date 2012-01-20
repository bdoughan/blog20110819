@XmlSchema(
    namespace="http://earth.google.com/kml/2.0",
    elementFormDefault=XmlNsForm.QUALIFIED,
    xmlns={
        @XmlNs(prefix="ns",
            namespaceURI="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    }
)
@XmlAccessorType(XmlAccessType.FIELD)
package blog.geocode.json;
 
import javax.xml.bind.annotation.*;