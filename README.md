Binding to JSON & XML - Geocode Example 
=======================================

This is the complete source code for the following blog post:

* http://blog.bdoughan.com/2011/08/binding-to-json-xml-geocode-example.html

Summary
-------

In EclipseLink 2.4 the MOXY component includes support for JSON binding.  Now you can map the following class:

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
    
To the following XML:

    <?xml version="1.0" encoding="UTF-8"?>
    <Response xmlns="http://earth.google.com/kml/2.0" xmlns:ns="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0">
       <Placemark>
          <ns:AddressDetails>
             <ns:Country>
                <ns:CountryNameCode>US</ns:CountryNameCode>
                <ns:AdministrativeArea>
                   <ns:AdministrativeAreaName>CA</ns:AdministrativeAreaName>
                   <ns:Locality>
                      <ns:LocalityName>Mountain View</ns:LocalityName>
                      <ns:Thoroughfare>
                         <ns:ThoroughfareName>1600 Amphitheatre Pkwy</ns:ThoroughfareName>
                      </ns:Thoroughfare>
                      <ns:PostalCode>
                         <ns:PostalCodeNumber>94043</ns:PostalCodeNumber>
                      </ns:PostalCode>
                   </ns:Locality>
                </ns:AdministrativeArea>
             </ns:Country>
          </ns:AddressDetails>
       </Placemark>
    </Response>

And the following JSON:

    {
       "Placemark" : {
          "AddressDetails" : {
             "Country" : {
                "CountryNameCode" : "US",
                "AdministrativeArea" : {
                   "AdministrativeAreaName" : "CA",
                   "Locality" : {
                      "LocalityName" : "Mountain View",
                      "Thoroughfare" : {
                         "ThoroughfareName" : "1600 Amphitheatre Pkwy"
                      },
                      "PostalCode" : {
                         "PostalCodeNumber" : "94043"
                      }
                   }
                }
             }
          }
       }}

Compile the Example
-------------------

You can compile the example code using the following command.  Maven will automatically fetch the required dependencies.

     mvn compile

Run the Example
---------------

You can run the example using the following command.

    mvn exec:java