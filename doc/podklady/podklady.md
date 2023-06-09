# podklady pre oots-poc
**OOTS HUB**
- https://ec.europa.eu/digital-building-blocks/wikis/display/OOTS/OOTSHUB+Home

**OOTS Technical Design Documents**
- https://ec.europa.eu/digital-building-blocks/wikis/display/TDD/OOTS+Technical+Design+Documents+Home

**SDG Once-Only Collaborative Space**
- https://ec.europa.eu/digital-building-blocks/wikis/pages/viewpage.action?spaceKey=SDGOO&title=SDG+OOTS+-+Home+Page


**Projectathon - AGM Front-Office - Advanced Gateway to your Meetings**
- https://webgate.ec.europa.eu/tools/agm/fo/agm.html#/meetings

**#2 Projectathon Webex**
- #2 OOTS Projectathon (Day 1) https://ecconf.webex.com/ecconf/j.php?MTID=m5e4541bbf7d42a6b19737ff93d7f7f92
- #2 OOTS Projectathon (Day 2) https://ecconf.webex.com/ecconf/j.php?MTID=mc4113a80eeaad8ca49791873f270ccd3
- #2 OOTS Projectathon (Day 3) https://ecconf.webex.com/ecconf/j.php?MTID=mefb62732192a80d470d2cbad8c05400f

**Projectathon - Gazelle**
- https://oots-testing.ihe-catalyst.net/gazelle/home.seam

**Microsoft Teams - GRP-SDG OOTS - Implementers Space**
- https://teams.microsoft.com/_?tenantId=b24c8b06-522c-46fe-9080-70926f8dddb1#/conversations/unknown?groupId=9c61f091-e860-4f64-92ae-2f361a0cf67d&threadId=19:rMq4qrVW4vUQFF-yggsIIiHQLDYhSsQihBwV_BMpgD01@thread.tacv2&ctx=channel

**OOTS Common Services Admin portal**
- https://projectathon.oots-common-services.eu/
- Data Services https://projectathon.oots-common-services.eu/main/data-services
- Evidence Providers https://projectathon.oots-common-services.eu/main/providers
- Evidence Types https://projectathon.oots-common-services.eu/main/evidence-types
- Requirements https://projectathon.oots-common-services.eu/main/requirements
- Procedures https://projectathon.oots-common-services.eu/main/procedures

**Evidence Broker and Data Service Directory specifications**
- REST API dokumentácia https://oots.pages.code.europa.eu/tdd/apidoc/
- **Evidence Broker** https://oots.pages.code.europa.eu/tdd/apidoc/evidence-broker
  - **Get List of Requirements** https://oots.pages.code.europa.eu/tdd/apidoc/evidence-broker/get-requirements
    - príklad na získanie požiadaviek pre postup T2 (Submitting an initial application for admission to public tertiary education institution) za krajinu PL (Poľsko)
      - https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:requirements-by-procedure-and-jurisdiction&procedure-id=T2&country-code=PL
  - **Get Evidence Types** https://oots.pages.code.europa.eu/tdd/apidoc/evidence-broker/get-evidence-types
    - príklad na získanie typov dôkazov pre požiadavku "Proof of Residence" (https://projectathon.oots-common-services.eu/main/requirements/details/15) za krajinu SK (Slovensko)
      - https://projectathon.oots-common-services.eu/query/eb/rest/search?queryId=urn:fdc:oots:eb:ebxml-regrep:queries:evidence-types-by-requirement-and-jurisdiction&country-code=SK&requirement-id=https://sr.oots.tech.europa.eu/requirements/1e0372b7-8343-4560-8f84-adb5eec410d6
- **Data Service Directory** https://oots.pages.code.europa.eu/tdd/apidoc/data-services-directory
  - **Find Data Services of Evidence Providers** https://oots.pages.code.europa.eu/tdd/apidoc/data-services-directory/find-data-services
    - príklad na získanie poskytovateľov dôkazov pre typ dôkazu "EU-Wide Diploma/Bachelor's Degree" (https://projectathon.oots-common-services.eu/main/evidence-types/details/1) za krajinu PL (Poľsko)
      - https://projectathon.oots-common-services.eu/query/dsd/rest/search?queryId=urn:fdc:oots:dsd:ebxml-regrep:queries:dataservices-by-evidencetype-and-jurisdiction&country-code=PL&evidence-type-classification=https://sr.oots.tech.europa.eu/evidencetypeclassifications/EU/b6a49e54-8b3c-4688-acad-380440dc5962

**Postman Collection pre Common Services REST API Evidence Broker a Data Service Directory**
- https://github.com/slovak-egov/oots-poc/blob/main/postman\
- https://github.com/slovak-egov/oots-poc/blob/main/postman/OOTS%20April%20Projectathon%20Common%20Service%20Requests.postman_collection.json

**eDelivery Access Point SK**
- Domibus z docker image
  - GUI Domibus http://oots.mirri.tech:8080/domibus/login
  - WSDL Backend http://oots.mirri.tech:8080/domibus/services/backend?wsdl
  - WSDL WS Plugin http://oots.mirri.tech:8080/domibus/services/wsplugin?wsdl
  
**SoapUI projekt**
- https://github.com/slovak-egov/oots-poc/blob/main/soapui/
- https://github.com/slovak-egov/oots-poc/blob/main/soapui/OOTS-eDelivery-AS4-soapui-project.xml
- https://github.com/slovak-egov/oots-poc/blob/main/soapui/OOTS-CS-LCMInterface-soapui-project.xml

**OOTS Evidence Mapping**
- https://ec.europa.eu/digital-building-blocks/wikis/display/SDGOOPE/Evidence+Mapping+-+Once+Only+Technical+System
- Studying Procedures
	- 3# - Applying for a tertiary education study financing, such as study grants and loans from a public body or institution.
		- https://ec.europa.eu/digital-building-blocks/wikis/pages/viewpage.action?pageId=668532853
		- https://airtable.com/shrBmYxtA5kcf5TwC/tbljiEbleZEs4QIp4?backgroundColor=purple&viewControls=on
- Moving Procedures
	- #11 - Registering a motor vehicle originating from or already registered in a Member state, in standard procedures
		- https://ec.europa.eu/digital-building-blocks/wikis/pages/viewpage.action?pageId=668532819
		- https://airtable.com/shrs0j6mef1MomFOD/tbljiEbleZEs4QIp4?backgroundColor=purple&viewControls=on
	- #12 - Obtaining stickers for the use of the national road infrastructure: time-based charges (vignette), distance-based charges (toll), issued by a public body or institution
		- https://ec.europa.eu/digital-building-blocks/wikis/pages/viewpage.action?pageId=668532930
		- https://airtable.com/shr508bUJVIisGx2R/tbljiEbleZEs4QIp4?backgroundColor=purple&viewControls=on
	- #13 - Obtaining emission stickers issued by a public body or institution
		- https://ec.europa.eu/digital-building-blocks/wikis/pages/viewpage.action?pageId=668532962
		- https://airtable.com/shrBECI1SrT4uxGzp/tbljiEbleZEs4QIp4?backgroundColor=purple&viewControls=on
		
**https://code.europa.eu/oots/tdd/tdd_chapters**
- https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/codelists
    - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/codelists/External
    - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/codelists/OOTS
    - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/codelists/xlsx
- https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/sch #Schematron validation
- https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/sch_fatal_error
- https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xlsx
- https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xml
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xml/DSD
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xml/EB
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xml/LCM
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xml/Request-Response%20Samples
- https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xsd
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xsd/regrep4
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xsd/sdg
    - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xsd/sdg/documentation
  - https://code.europa.eu/oots/tdd/tdd_chapters/-/tree/master/OOTS-EDM/xsd/xml

