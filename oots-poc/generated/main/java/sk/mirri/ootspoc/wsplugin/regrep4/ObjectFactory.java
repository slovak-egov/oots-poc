//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.07 at 03:47:41 PM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sk.mirri.ootspoc.wsplugin.regrep4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistryObjectList_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", "RegistryObjectList");
    private final static QName _ObjectRefList_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", "ObjectRefList");
    private final static QName _ObjectRef_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", "ObjectRef");
    private final static QName _RegistryObject_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", "RegistryObject");
    private final static QName _IdentifiableList_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", "IdentifiableList");
    private final static QName _Notification_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", "Notification");
    private final static QName _RegistryRequest_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0", "RegistryRequest");
    private final static QName _RegistryResponse_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0", "RegistryResponse");
    private final static QName _RegistryException_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0", "RegistryException");
    private final static QName _ResponseOption_QNAME = new QName("urn:oasis:names:tc:ebxml-regrep:xsd:query:4.0", "ResponseOption");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sk.mirri.ootspoc.wsplugin.regrep4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubmitObjectsRequest }
     * 
     */
    public SubmitObjectsRequest createSubmitObjectsRequest() {
        return new SubmitObjectsRequest();
    }

    /**
     * Create an instance of {@link RegistryRequestType }
     * 
     */
    public RegistryRequestType createRegistryRequestType() {
        return new RegistryRequestType();
    }

    /**
     * Create an instance of {@link SlotType }
     * 
     */
    public SlotType createSlotType() {
        return new SlotType();
    }

    /**
     * Create an instance of {@link RegistryObjectListType }
     * 
     */
    public RegistryObjectListType createRegistryObjectListType() {
        return new RegistryObjectListType();
    }

    /**
     * Create an instance of {@link UpdateObjectsRequest }
     * 
     */
    public UpdateObjectsRequest createUpdateObjectsRequest() {
        return new UpdateObjectsRequest();
    }

    /**
     * Create an instance of {@link QueryType }
     * 
     */
    public QueryType createQueryType() {
        return new QueryType();
    }

    /**
     * Create an instance of {@link ObjectRefListType }
     * 
     */
    public ObjectRefListType createObjectRefListType() {
        return new ObjectRefListType();
    }

    /**
     * Create an instance of {@link UpdateActionType }
     * 
     */
    public UpdateActionType createUpdateActionType() {
        return new UpdateActionType();
    }

    /**
     * Create an instance of {@link RemoveObjectsRequest }
     * 
     */
    public RemoveObjectsRequest createRemoveObjectsRequest() {
        return new RemoveObjectsRequest();
    }

    /**
     * Create an instance of {@link ObjectRefType }
     * 
     */
    public ObjectRefType createObjectRefType() {
        return new ObjectRefType();
    }

    /**
     * Create an instance of {@link RegistryObjectType }
     * 
     */
    public RegistryObjectType createRegistryObjectType() {
        return new RegistryObjectType();
    }

    /**
     * Create an instance of {@link IdentifiableListType }
     * 
     */
    public IdentifiableListType createIdentifiableListType() {
        return new IdentifiableListType();
    }

    /**
     * Create an instance of {@link NotificationType }
     * 
     */
    public NotificationType createNotificationType() {
        return new NotificationType();
    }

    /**
     * Create an instance of {@link InternationalStringType }
     * 
     */
    public InternationalStringType createInternationalStringType() {
        return new InternationalStringType();
    }

    /**
     * Create an instance of {@link LocalizedStringType }
     * 
     */
    public LocalizedStringType createLocalizedStringType() {
        return new LocalizedStringType();
    }

    /**
     * Create an instance of {@link StringValueType }
     * 
     */
    public StringValueType createStringValueType() {
        return new StringValueType();
    }

    /**
     * Create an instance of {@link DateTimeValueType }
     * 
     */
    public DateTimeValueType createDateTimeValueType() {
        return new DateTimeValueType();
    }

    /**
     * Create an instance of {@link DurationValueType }
     * 
     */
    public DurationValueType createDurationValueType() {
        return new DurationValueType();
    }

    /**
     * Create an instance of {@link IntegerValueType }
     * 
     */
    public IntegerValueType createIntegerValueType() {
        return new IntegerValueType();
    }

    /**
     * Create an instance of {@link BooleanValueType }
     * 
     */
    public BooleanValueType createBooleanValueType() {
        return new BooleanValueType();
    }

    /**
     * Create an instance of {@link FloatValueType }
     * 
     */
    public FloatValueType createFloatValueType() {
        return new FloatValueType();
    }

    /**
     * Create an instance of {@link InternationalStringValueType }
     * 
     */
    public InternationalStringValueType createInternationalStringValueType() {
        return new InternationalStringValueType();
    }

    /**
     * Create an instance of {@link VocabularyTermType }
     * 
     */
    public VocabularyTermType createVocabularyTermType() {
        return new VocabularyTermType();
    }

    /**
     * Create an instance of {@link VocabularyTermValueType }
     * 
     */
    public VocabularyTermValueType createVocabularyTermValueType() {
        return new VocabularyTermValueType();
    }

    /**
     * Create an instance of {@link CollectionValueType }
     * 
     */
    public CollectionValueType createCollectionValueType() {
        return new CollectionValueType();
    }

    /**
     * Create an instance of {@link EntryType }
     * 
     */
    public EntryType createEntryType() {
        return new EntryType();
    }

    /**
     * Create an instance of {@link MapType }
     * 
     */
    public MapType createMapType() {
        return new MapType();
    }

    /**
     * Create an instance of {@link MapValueType }
     * 
     */
    public MapValueType createMapValueType() {
        return new MapValueType();
    }

    /**
     * Create an instance of {@link SlotValueType }
     * 
     */
    public SlotValueType createSlotValueType() {
        return new SlotValueType();
    }

    /**
     * Create an instance of {@link AnyValueType }
     * 
     */
    public AnyValueType createAnyValueType() {
        return new AnyValueType();
    }

    /**
     * Create an instance of {@link DynamicObjectRefType }
     * 
     */
    public DynamicObjectRefType createDynamicObjectRefType() {
        return new DynamicObjectRefType();
    }

    /**
     * Create an instance of {@link AssociationType }
     * 
     */
    public AssociationType createAssociationType() {
        return new AssociationType();
    }

    /**
     * Create an instance of {@link ActionType }
     * 
     */
    public ActionType createActionType() {
        return new ActionType();
    }

    /**
     * Create an instance of {@link AuditableEventType }
     * 
     */
    public AuditableEventType createAuditableEventType() {
        return new AuditableEventType();
    }

    /**
     * Create an instance of {@link ClassificationType }
     * 
     */
    public ClassificationType createClassificationType() {
        return new ClassificationType();
    }

    /**
     * Create an instance of {@link ClassificationNodeType }
     * 
     */
    public ClassificationNodeType createClassificationNodeType() {
        return new ClassificationNodeType();
    }

    /**
     * Create an instance of {@link ClassificationSchemeType }
     * 
     */
    public ClassificationSchemeType createClassificationSchemeType() {
        return new ClassificationSchemeType();
    }

    /**
     * Create an instance of {@link ExternalIdentifierType }
     * 
     */
    public ExternalIdentifierType createExternalIdentifierType() {
        return new ExternalIdentifierType();
    }

    /**
     * Create an instance of {@link ExternalLinkType }
     * 
     */
    public ExternalLinkType createExternalLinkType() {
        return new ExternalLinkType();
    }

    /**
     * Create an instance of {@link SimpleLinkType }
     * 
     */
    public SimpleLinkType createSimpleLinkType() {
        return new SimpleLinkType();
    }

    /**
     * Create an instance of {@link ExtrinsicObjectType }
     * 
     */
    public ExtrinsicObjectType createExtrinsicObjectType() {
        return new ExtrinsicObjectType();
    }

    /**
     * Create an instance of {@link CommentType }
     * 
     */
    public CommentType createCommentType() {
        return new CommentType();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link PersonNameType }
     * 
     */
    public PersonNameType createPersonNameType() {
        return new PersonNameType();
    }

    /**
     * Create an instance of {@link EmailAddressType }
     * 
     */
    public EmailAddressType createEmailAddressType() {
        return new EmailAddressType();
    }

    /**
     * Create an instance of {@link PostalAddressType }
     * 
     */
    public PostalAddressType createPostalAddressType() {
        return new PostalAddressType();
    }

    /**
     * Create an instance of {@link VersionInfoType }
     * 
     */
    public VersionInfoType createVersionInfoType() {
        return new VersionInfoType();
    }

    /**
     * Create an instance of {@link RegistryPackageType }
     * 
     */
    public RegistryPackageType createRegistryPackageType() {
        return new RegistryPackageType();
    }

    /**
     * Create an instance of {@link RoleType }
     * 
     */
    public RoleType createRoleType() {
        return new RoleType();
    }

    /**
     * Create an instance of {@link ServiceType }
     * 
     */
    public ServiceType createServiceType() {
        return new ServiceType();
    }

    /**
     * Create an instance of {@link ServiceEndpointType }
     * 
     */
    public ServiceEndpointType createServiceEndpointType() {
        return new ServiceEndpointType();
    }

    /**
     * Create an instance of {@link ServiceBindingType }
     * 
     */
    public ServiceBindingType createServiceBindingType() {
        return new ServiceBindingType();
    }

    /**
     * Create an instance of {@link ServiceInterfaceType }
     * 
     */
    public ServiceInterfaceType createServiceInterfaceType() {
        return new ServiceInterfaceType();
    }

    /**
     * Create an instance of {@link TelephoneNumberType }
     * 
     */
    public TelephoneNumberType createTelephoneNumberType() {
        return new TelephoneNumberType();
    }

    /**
     * Create an instance of {@link RegistryType }
     * 
     */
    public RegistryType createRegistryType() {
        return new RegistryType();
    }

    /**
     * Create an instance of {@link FederationType }
     * 
     */
    public FederationType createFederationType() {
        return new FederationType();
    }

    /**
     * Create an instance of {@link QueryDefinitionType }
     * 
     */
    public QueryDefinitionType createQueryDefinitionType() {
        return new QueryDefinitionType();
    }

    /**
     * Create an instance of {@link ParameterType }
     * 
     */
    public ParameterType createParameterType() {
        return new ParameterType();
    }

    /**
     * Create an instance of {@link StringQueryExpressionType }
     * 
     */
    public StringQueryExpressionType createStringQueryExpressionType() {
        return new StringQueryExpressionType();
    }

    /**
     * Create an instance of {@link XMLQueryExpressionType }
     * 
     */
    public XMLQueryExpressionType createXMLQueryExpressionType() {
        return new XMLQueryExpressionType();
    }

    /**
     * Create an instance of {@link SubscriptionType }
     * 
     */
    public SubscriptionType createSubscriptionType() {
        return new SubscriptionType();
    }

    /**
     * Create an instance of {@link DeliveryInfoType }
     * 
     */
    public DeliveryInfoType createDeliveryInfoType() {
        return new DeliveryInfoType();
    }

    /**
     * Create an instance of {@link WorkflowActionType }
     * 
     */
    public WorkflowActionType createWorkflowActionType() {
        return new WorkflowActionType();
    }

    /**
     * Create an instance of {@link RegistryResponseType }
     * 
     */
    public RegistryResponseType createRegistryResponseType() {
        return new RegistryResponseType();
    }

    /**
     * Create an instance of {@link RegistryExceptionType }
     * 
     */
    public RegistryExceptionType createRegistryExceptionType() {
        return new RegistryExceptionType();
    }

    /**
     * Create an instance of {@link AuthenticationExceptionType }
     * 
     */
    public AuthenticationExceptionType createAuthenticationExceptionType() {
        return new AuthenticationExceptionType();
    }

    /**
     * Create an instance of {@link AuthorizationExceptionType }
     * 
     */
    public AuthorizationExceptionType createAuthorizationExceptionType() {
        return new AuthorizationExceptionType();
    }

    /**
     * Create an instance of {@link InvalidRequestExceptionType }
     * 
     */
    public InvalidRequestExceptionType createInvalidRequestExceptionType() {
        return new InvalidRequestExceptionType();
    }

    /**
     * Create an instance of {@link ObjectExistsExceptionType }
     * 
     */
    public ObjectExistsExceptionType createObjectExistsExceptionType() {
        return new ObjectExistsExceptionType();
    }

    /**
     * Create an instance of {@link ObjectNotFoundExceptionType }
     * 
     */
    public ObjectNotFoundExceptionType createObjectNotFoundExceptionType() {
        return new ObjectNotFoundExceptionType();
    }

    /**
     * Create an instance of {@link QuotaExceededExceptionType }
     * 
     */
    public QuotaExceededExceptionType createQuotaExceededExceptionType() {
        return new QuotaExceededExceptionType();
    }

    /**
     * Create an instance of {@link ReferencesExistExceptionType }
     * 
     */
    public ReferencesExistExceptionType createReferencesExistExceptionType() {
        return new ReferencesExistExceptionType();
    }

    /**
     * Create an instance of {@link TimeoutExceptionType }
     * 
     */
    public TimeoutExceptionType createTimeoutExceptionType() {
        return new TimeoutExceptionType();
    }

    /**
     * Create an instance of {@link UnresolvedReferenceExceptionType }
     * 
     */
    public UnresolvedReferenceExceptionType createUnresolvedReferenceExceptionType() {
        return new UnresolvedReferenceExceptionType();
    }

    /**
     * Create an instance of {@link UnsupportedCapabilityExceptionType }
     * 
     */
    public UnsupportedCapabilityExceptionType createUnsupportedCapabilityExceptionType() {
        return new UnsupportedCapabilityExceptionType();
    }

    /**
     * Create an instance of {@link ResponseOptionType }
     * 
     */
    public ResponseOptionType createResponseOptionType() {
        return new ResponseOptionType();
    }

    /**
     * Create an instance of {@link QueryRequest }
     * 
     */
    public QueryRequest createQueryRequest() {
        return new QueryRequest();
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link QueryExceptionType }
     * 
     */
    public QueryExceptionType createQueryExceptionType() {
        return new QueryExceptionType();
    }

    /**
     * Create an instance of {@link ValidateObjectsRequest }
     * 
     */
    public ValidateObjectsRequest createValidateObjectsRequest() {
        return new ValidateObjectsRequest();
    }

    /**
     * Create an instance of {@link ValidateObjectsResponse }
     * 
     */
    public ValidateObjectsResponse createValidateObjectsResponse() {
        return new ValidateObjectsResponse();
    }

    /**
     * Create an instance of {@link CatalogObjectsRequest }
     * 
     */
    public CatalogObjectsRequest createCatalogObjectsRequest() {
        return new CatalogObjectsRequest();
    }

    /**
     * Create an instance of {@link CatalogObjectsResponse }
     * 
     */
    public CatalogObjectsResponse createCatalogObjectsResponse() {
        return new CatalogObjectsResponse();
    }

    /**
     * Create an instance of {@link FilterObjectsRequest }
     * 
     */
    public FilterObjectsRequest createFilterObjectsRequest() {
        return new FilterObjectsRequest();
    }

    /**
     * Create an instance of {@link FilterObjectsResponse }
     * 
     */
    public FilterObjectsResponse createFilterObjectsResponse() {
        return new FilterObjectsResponse();
    }

    /**
     * Create an instance of {@link ValidationExceptionType }
     * 
     */
    public ValidationExceptionType createValidationExceptionType() {
        return new ValidationExceptionType();
    }

    /**
     * Create an instance of {@link CatalogingExceptionType }
     * 
     */
    public CatalogingExceptionType createCatalogingExceptionType() {
        return new CatalogingExceptionType();
    }

    /**
     * Create an instance of {@link FilteringExceptionType }
     * 
     */
    public FilteringExceptionType createFilteringExceptionType() {
        return new FilteringExceptionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryObjectListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistryObjectListType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", name = "RegistryObjectList")
    public JAXBElement<RegistryObjectListType> createRegistryObjectList(RegistryObjectListType value) {
        return new JAXBElement<RegistryObjectListType>(_RegistryObjectList_QNAME, RegistryObjectListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectRefListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObjectRefListType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", name = "ObjectRefList")
    public JAXBElement<ObjectRefListType> createObjectRefList(ObjectRefListType value) {
        return new JAXBElement<ObjectRefListType>(_ObjectRefList_QNAME, ObjectRefListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObjectRefType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", name = "ObjectRef")
    public JAXBElement<ObjectRefType> createObjectRef(ObjectRefType value) {
        return new JAXBElement<ObjectRefType>(_ObjectRef_QNAME, ObjectRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistryObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", name = "RegistryObject")
    public JAXBElement<RegistryObjectType> createRegistryObject(RegistryObjectType value) {
        return new JAXBElement<RegistryObjectType>(_RegistryObject_QNAME, RegistryObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifiableListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifiableListType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", name = "IdentifiableList")
    public JAXBElement<IdentifiableListType> createIdentifiableList(IdentifiableListType value) {
        return new JAXBElement<IdentifiableListType>(_IdentifiableList_QNAME, IdentifiableListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", name = "Notification")
    public JAXBElement<NotificationType> createNotification(NotificationType value) {
        return new JAXBElement<NotificationType>(_Notification_QNAME, NotificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistryRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0", name = "RegistryRequest")
    public JAXBElement<RegistryRequestType> createRegistryRequest(RegistryRequestType value) {
        return new JAXBElement<RegistryRequestType>(_RegistryRequest_QNAME, RegistryRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistryResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0", name = "RegistryResponse")
    public JAXBElement<RegistryResponseType> createRegistryResponse(RegistryResponseType value) {
        return new JAXBElement<RegistryResponseType>(_RegistryResponse_QNAME, RegistryResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryExceptionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistryExceptionType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0", name = "RegistryException")
    public JAXBElement<RegistryExceptionType> createRegistryException(RegistryExceptionType value) {
        return new JAXBElement<RegistryExceptionType>(_RegistryException_QNAME, RegistryExceptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseOptionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseOptionType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:query:4.0", name = "ResponseOption")
    public JAXBElement<ResponseOptionType> createResponseOption(ResponseOptionType value) {
        return new JAXBElement<ResponseOptionType>(_ResponseOption_QNAME, ResponseOptionType.class, null, value);
    }

}
