package bootstrap.http4s

object ErrorMessages {
  // Notes to developers. Please:
  // 1) Follow (the existing) grouping of messages
  // 2) Stick to existing terminology e.g. use "invalid" or "incorrect" rather than "wrong"
  // 3) Before adding a new message, check that you can't use one that already exists.
  // 4) Use Proper Names for OBP Resources.
  // 5) Don't use abbreviations.
  // 6) Any message defined here should be considered "fair game" to return over the API. Thus:
  // 7) Since the existence of "OBP-D-..." in a message is used to determine if we should display to a user if display_internal_errors=false, do *not* concatenate internal or core banking system error messages to these strings.

  // Infrastructure / config level messages (OBP-D-00XXX)
  val HostnameNotSpecified = "OBP-D-00001: Hostname not specified. Could not get hostname from Props. Please edit your props file. Here are some example settings: hostname=http://127.0.0.1:8080 or hostname=https://www.example.com"
  val DataImportDisabled  = "OBP-D-00002: Data import is disabled for this API instance."
  val TransactionDisabled = "OBP-D-00003: Transaction Requests is disabled in this API instance."

  @deprecated("This is too generic","25-06-2017")
  val ServerAddDataError = "OBP-D-00004: Server error: could not add message" // Do not use this

  val PublicViewsNotAllowedOnThisInstance = "OBP-D-00005: Public views not allowed on this instance. Please set allow_public_views = true in props files. "

  val ApiVersionNotSupported = "OBP-D-00008: The API version you called is not enabled on this server. Please contact your API administrator or use another version."

  val AccountFirehoseNotAllowedOnThisInstance = "OBP-D-00009: Account firehose is not allowed on this instance. Please set allow_account_firehose = true in props files. "
  val MissingPropsValueAtThisInstance = "OBP-D-00010: Missing props value at this API instance - "
  val NoValidElasticsearchIndicesConfigured = "OBP-D-00011: No elasticsearch indices are allowed on this instance. Please set es.warehouse.allowed.indices = index1,index2 (or = ALL for all). "
  val CustomerFirehoseNotAllowedOnThisInstance = "OBP-D-00012: Customer firehose is not allowed on this instance. Please set allow_customer_firehose = true in props files. "
  val ApiInstanceIdNotSpecified = "OBP-D-00013: 'api_instance_id' not specified. Please edit your props file."

  // Exceptions (OBP-D-01XXX) ------------------------------------------------>
  val requestTimeout = "OBP-D-01000: Request Timeout. The OBP API decided to return a timeout. This is probably because a backend service did not respond in time. "
  // <------------------------------------------------ Exceptions (OBP-D-01XXX)
  
  // WebUiProps Exceptions (OBP-D-08XXX)
  val InvalidWebUiProps = "OBP-D-08001: Incorrect format of name."
  val WebUiPropsNotFound = "OBP-D-08002: WebUi props not found. Please specify a valid value for WEB_UI_PROPS_ID."

  // DynamicEntity Exceptions (OBP-D-09XXX)
  val DynamicEntityNotFoundByDynamicEntityId = "OBP-D-09001: DynamicEntity not found. Please specify a valid value for DYNAMIC_ENTITY_ID."
  val DynamicEntityNameAlreadyExists = "OBP-D-09002: DynamicEntity's entityName already exists. Please specify a different value for entityName."
  val DynamicEntityNotExists = "OBP-D-09003: DynamicEntity not exists. Please check entityName." 
  val DynamicEntityMissArgument = "OBP-D-09004: DynamicEntity process related argument is missing."
  val EntityNotFoundByEntityId = "OBP-D-09005: Entity not found. Please specify a valid value for entityId."
  val DynamicEntityOperationNotAllowed = "OBP-D-09006: Operation is not allowed, because Current DynamicEntity have upload data, must to delete all the data before this operation."
  val DynamicEntityInstanceValidateFail = "OBP-D-09007: DynamicEntity data validation failure."

  val DynamicEndpointExists = "OBP-D-09008: DynamicEndpoint already exists."
  val DynamicEndpointNotFoundByDynamicEndpointId = "OBP-D-09009: DynamicEndpoint not found. Please specify a valid value for DYNAMIC_ENDPOINT_ID."
  val InvalidMyDynamicEntityUser = "OBP-D-09010: DynamicEntity can only be updated/deleted by the user who created it. Please try `Update/DELETE Dynamic Entity` endpoint"
  val InvalidMyDynamicEndpointUser = "OBP-D-09011: DynamicEndpoint can only be updated/deleted by the user who created it. Please try `Update/DELETE Dynamic Endpoint` endpoint"
  val InvalidDynamicEndpointSwagger = "OBP-D-09013: Invalid DynamicEndpoint Swagger Json. "
  
  val InvalidRequestPayload = "OBP-D-09014: Incorrect request body Format, it should be a valid json that matches Validation rule."
  val DynamicDataNotFound = "OBP-D-09015: Dynamic Data not found. Please specify a valid value."
  val DuplicateQueryParameters = "OBP-D-09016: Duplicate Query Parameters are not allowed."
  val DuplicateHeaderKeys = "OBP-D-09017: Duplicate Header Keys are not allowed."


  // General messages (OBP-D-10XXX)
  val InvalidJsonFormat = "OBP-D-10001: Incorrect json format."
  val InvalidNumber = "OBP-D-10002: Invalid Number. Could not convert value to a number."
  val InvalidISOCurrencyCode = "OBP-D-10003: Invalid Currency Value. It should be three letters ISO Currency Code. "
  val FXCurrencyCodeCombinationsNotSupported = "OBP-D-10004: ISO Currency code combination not supported for FX. Please modify the FROM_CURRENCY_CODE or TO_CURRENCY_CODE. "
  val InvalidDateFormat = "OBP-D-10005: Invalid Date Format. Could not convert value to a Date."
  val InvalidCurrency = "OBP-D-10006: Invalid Currency Value."
  val IncorrectRoleName = "OBP-D-10007: Incorrect Role name:"
  val CouldNotTransformJsonToInternalModel = "OBP-D-10008: Could not transform Json to internal model."
  val CountNotSaveOrUpdateResource = "OBP-D-10009: Could not save or update resource."
  val NotImplemented = "OBP-D-10010: Not Implemented "
  val InvalidFutureDateValue = "OBP-D-10011: future_date has to be in future."
  val maximumLimitExceeded = "OBP-D-10012: Invalid value. Maximum number is 10000."
  val attemptedToOpenAnEmptyBox = "OBP-D-10013: Attempted to open an empty Box."
  val cannotDecryptValueOfProperty = "OBP-D-10014: Could not decrypt value of property "
  val AllowedValuesAre = "OBP-D-10015: Allowed values are:"
  val InvalidFilterParameterFormat = "OBP-D-10016: Incorrect filter Parameters in URL. "
  val InvalidUrl = "OBP-D-10017: Incorrect URL Format. "
  val TooManyRequests = "OBP-D-10018: Too Many Requests."
  val InvalidBoolean = "OBP-D-10019: Invalid Boolean. Could not convert value to a boolean type."
  val InvalidJsonContent = "OBP-D-10020: Incorrect json."
  val InvalidConnectorName = "OBP-D-10021: Incorrect Connector name."
  val InvalidConnectorMethodName = "OBP-D-10022: Incorrect Connector method name."
  val InvalidOutBoundMapping = "OBP-D-10031: Incorrect outBoundMapping Format, it should be a json structure."
  val InvalidInBoundMapping = "OBP-D-10032: Incorrect inBoundMapping Format, it should be a json structure."
  val invalidIban = "OBP-D-10033: Invalid IBAN."
  val InvalidUrlParameters = "OBP-D-10034: Invalid URL parameters."
  val InvalidUri = "OBP-D-10404: 404 Not Found. The server could not find the requested URI. Please double check your URL, headers and body. " +
    "Note: When you are making a POST or PUT request, the Content-Type header MUST be `application/json`. Note: OBP only supports JSON formatted bodies."
  val ResourceDoesNotExist = "OBP-D-10405: Resource does not exist."
  val InvalidJsonValue = "OBP-D-10035: Incorrect json value."
  val InvalidHttpMethod = "OBP-D-10037: Incorrect http_method."
  val InvalidHttpProtocol = "OBP-D-10038: Incorrect http_protocol."
  val ServiceIsTooBusy = "OBP-D-10040: The Service is too busy, please try it later."
  val InvalidLocale = "OBP-D-10041: This locale is not supported. Only the following can be used: en_GB, es_ES, ro_RO."
  
  // General Sort and Paging
  val FilterSortDirectionError = "OBP-D-10023: obp_sort_direction parameter can only take two values: DESC or ASC!" // was OBP-D-20023
  val FilterOffersetError = "OBP-D-10024: wrong value for obp_offset parameter. Please send a positive integer (=>0)!" // was OBP-D-20024
  val FilterLimitError = "OBP-D-10025: wrong value for obp_limit parameter. Please send a positive integer (=>1)!" // was OBP-D-20025
  val FilterAnonFormatError = s"OBP-D-10028: anon parameter can only take two values: TRUE or FALSE!"
  val FilterDurationFormatError = s"OBP-D-10029: wrong value for `duration` parameter. Please send a positive integer (=>0)!"
  val FilterIsDeletedFormatError = s"OBP-D-10036: is_deleted parameter can only take two values: TRUE or FALSE!"

  val InvalidApiVersionString = "OBP-D-00027: Invalid API Version string. We could not find the version specified."
  val IncorrectTriggerName = "OBP-D-10039: Incorrect Trigger name:"

  val ScaMethodNotDefined = "OBP-D-10030: Strong customer authentication method is not defined at this instance."

  val createFxCurrencyIssue = "OBP-D-10050: Cannot create FX currency. "




  // Authentication / Authorisation / User messages (OBP-D-20XXX)
  val UserNotLoggedIn = "OBP-D-20001: User not logged in. Authentication is required!"
  val DirectLoginMissingParameters = "OBP-D-20002: These DirectLogin parameters are missing:"
  val DirectLoginInvalidToken = "OBP-D-20003: This DirectLogin token is invalid or expired:"
  val InvalidLoginCredentials = "OBP-D-20004: Invalid login credentials. Check username/password."
  val UserNotFoundById = "OBP-D-20005: User not found. Please specify a valid value for USER_ID."
  val UserHasMissingRoles = "OBP-D-20006: User is missing one or more roles: "
  val UserNotFoundByEmail = "OBP-D-20007: User not found by email."

  val InvalidConsumerKey = "OBP-D-20008: Invalid Consumer Key."
  val InvalidConsumerCredentials = "OBP-D-20009: Invalid consumer credentials"

  val InvalidValueLength = "OBP-D-20010: Value too long"
  val InvalidValueCharacters = "OBP-D-20011: Value contains invalid characters"

  val InvalidDirectLoginParameters = "OBP-D-20012: Invalid direct login parameters"

  val UsernameHasBeenLocked = "OBP-D-20013: The account has been locked, please contact an administrator!"

  val InvalidConsumerId = "OBP-D-20014: Invalid Consumer ID. Please specify a valid value for CONSUMER_ID."

  val UserNoPermissionUpdateConsumer = "OBP-D-20015: Only the developer that created the consumer key should be able to edit it, please login with the right user."

  val UnexpectedErrorDuringLogin = "OBP-D-20016: An unexpected login error occurred. Please try again."

  val UserNoPermissionAccessView = "OBP-D-20017: Current user does not have access to the view. Please specify a valid value for VIEW_ID."


  val InvalidInternalRedirectUrl = "OBP-D-20018: Login failed, invalid internal redirectUrl."
  val UserNoOwnerView = "OBP-D-20019: User does not have access to owner view. "
  val InvalidCustomViewFormat = s"OBP-D-20020: Custom view name/view_id must start with `_`. eg: _work, _life. "
  val InvalidSystemViewFormat = s"OBP-D-20020: System view name/view_id can not start with '_'. eg: owner, standard. "
  val SystemViewsCanNotBeModified = "OBP-D-20021: System Views can not be modified. Only the created views can be modified."
  val ViewDoesNotPermitAccess = "OBP-D-20022: View does not permit the access."

  val ConsumerHasMissingRoles = "OBP-D-20023: Consumer is missing one or more roles:"
  val ConsumerNotFoundById = "OBP-D-20024: Consumer not found. Please specify a valid value for CONSUMER_ID."
  val ScopeNotFound = "OBP-D-20025: Scope not found. Please specify a valid value for SCOPE_ID."
  val ConsumerDoesNotHaveScope = "OBP-D-20026: CONSUMER_ID does not have the SCOPE_ID "

  val UserNotFoundByProviderAndUsername = "OBP-D-20027: User not found by provider and username."
  val GatewayLoginMissingParameters = "OBP-D-20028: These GatewayLogin parameters are missing:"
  val GatewayLoginUnknownError = "OBP-D-20029: Unknown Gateway login error."
  val GatewayLoginHostPropertyMissing = "OBP-D-20030: Property gateway.host is not defined."
  val GatewayLoginWhiteListAddresses = "OBP-D-20031: Gateway login can be done only from allowed addresses."
  val GatewayLoginJwtTokenIsNotValid = "OBP-D-20040: The Gateway login JWT is corrupted/changed during a transport."
  val GatewayLoginCannotExtractJwtToken = "OBP-D-20041: Header, Payload and Signature cannot be extracted from the JWT."
  val GatewayLoginNoNeedToCallCbs = "OBP-D-20042: There is no need to call CBS"
  val GatewayLoginCannotFindUser = "OBP-D-20043: User cannot be found. Please initiate CBS communication in order to create it."
  val GatewayLoginCannotGetCbsToken = "OBP-D-20044: Cannot get the CBSToken response from South side"
  val GatewayLoginCannotGetOrCreateUser = "OBP-D-20045: Cannot get or create user during GatewayLogin process."
  val GatewayLoginNoJwtForResponse = "OBP-D-20046: There is no useful value for JWT."

  val UserLacksPermissionCanGrantAccessToViewForTargetAccount = 
    s"OBP-D-20047: If target viewId is system view,  the current view.can_grant_access_to_views does not contains it. Or" +
      s"if target viewId is custom view, the current view.can_grant_access_to_custom_views is false."
      
  val UserLacksPermissionCanRevokeAccessToViewForTargetAccount =
    s"OBP-D-20048: If target viewId is system view,  the current view.can_revoke_access_to_views does not contains it. Or" +
      s"if target viewId is custom view, the current view.can_revoke_access_to_custom_views is false."
      
  val SourceViewHasLessPermission = "OBP-D-20049: Source view contains less permissions than target view."
  
  val UserNotSuperAdmin = "OBP-D-20050: Current User is not a Super Admin!"

  val ElasticSearchIndexNotFound = "OBP-D-20051: Elasticsearch index or indices not found."
  val NotEnoughtSearchStatisticsResults = "OBP-D-20052: Result set too small. Will not be displayed for reasons of privacy."
  val ElasticSearchEmptyQueryBody = "OBP-D-20053: The Elasticsearch query body cannot be empty"
  val InvalidAmount = "OBP-D-20054: Invalid amount. Please specify a valid value for amount."
  val MissingQueryParams = "OBP-D-20055: These query parameters are missing:"
  val ElasticSearchDisabled  = "OBP-D-20056: Elasticsearch is disabled for this API instance."
  val UserNotFoundByUserId = "OBP-D-20057: User not found by userId."
  val ConsumerIsDisabled = "OBP-D-20058: Consumer is disabled."
  val CouldNotAssignAccountAccess = "OBP-D-20059: Could not assign account access. "
  val NoViewReadAccountsBerlinGroup = s"OBP-D-20060: User does not have access to the view:"
  val FrequencyPerDayError = "OBP-D-20062: Frequency per day must be greater than 0."
  val FrequencyPerDayMustBeOneError = "OBP-D-20063: Frequency per day must be equal to 1 in case of one-off access."

  val UserIsDeleted = "OBP-D-20064: The user is deleted!"

  val DAuthCannotGetOrCreateUser = "OBP-D-20065: Cannot get or create user during DAuth process."
  val DAuthMissingParameters = "OBP-D-20066: These DAuth parameters are missing:"
  val DAuthUnknownError = "OBP-D-20067: Unknown DAuth login error."
  val DAuthHostPropertyMissing = "OBP-D-20068: Property dauth.host is not defined."
  val DAuthWhiteListAddresses = "OBP-D-20069: DAuth login can be done only from allowed addresses."
  val DAuthNoJwtForResponse = "OBP-D-20070: There is no useful value for JWT."
  val DAuthJwtTokenIsNotValid = "OBP-D-20071: The DAuth JWT is corrupted/changed during a transport."
  val InvalidDAuthHeaderToken = "OBP-D-20072: DAuth Header value should be one single string."
  
  val InvalidProviderUrl = "OBP-D-20079: Cannot match the local identity provider."
  
  val InvalidAuthorizationHeader = "OBP-D-20080: Authorization Header format is not supported at this instance."
  
  val UserAttributeNotFound = "OBP-D-20081: User Attribute not found by USER_ATTRIBUTE_ID."
  val MissingDirectLoginHeader = "OBP-D-20082: Missing DirectLogin or Authorization header."
  val InvalidDirectLoginHeader = "OBP-D-20083: Missing DirectLogin word at the value of Authorization header."


  val UserLacksPermissionCanGrantAccessToSystemViewForTargetAccount =
    s"OBP-D-20084: The current source view.can_grant_access_to_views does not contains target view."

  val UserLacksPermissionCanGrantAccessToCustomViewForTargetAccount =
    s"OBP-D-20085: The current source view.can_grant_access_to_custom_views is false."

  val UserLacksPermissionCanRevokeAccessToSystemViewForTargetAccount =
    s"OBP-D-20086: The current source view.can_revoke_access_to_views does not contains target view." 
  
  val UserLacksPermissionCanRevokeAccessToCustomViewForTargetAccount =
    s"OBP-D-20087: The current source view.can_revoke_access_to_custom_views is false."
  
  val UserNotSuperAdminOrMissRole = "OBP-D-20101: Current User is not super admin or is missing entitlements:"
  val CannotGetOrCreateUser = "OBP-D-20102: Cannot get or create user."
  val InvalidUserProvider = "OBP-D-20103: Invalid DAuth User Provider."
  val UserNotFoundByProviderAndProvideId= "OBP-D-20104: User not found by PROVIDER and PROVIDER_ID."

  // OAuth 2
  val ApplicationNotIdentified = "OBP-D-20200: The application cannot be identified. "
  val Oauth2IsNotAllowed = "OBP-D-20201: OAuth2 is not allowed at this instance."
  val Oauth2IJwtCannotBeVerified = "OBP-D-20202: OAuth2's Access Token cannot be verified."
  val Oauth2ThereIsNoUrlOfJwkSet = "OBP-D-20203: There is no an URL of OAuth 2.0 server's JWK set, published at a well-known URL."
  val Oauth2BadJWTException = "OBP-D-20204: Bad JWT error. "
  val Oauth2ParseException = "OBP-D-20205: Parse error. "
  val Oauth2BadJOSEException = "OBP-D-20206: Bad JSON Object Signing and Encryption (JOSE) exception. The ID token is invalid or expired. "
  val Oauth2JOSEException = "OBP-D-20207: Bad JSON Object Signing and Encryption (JOSE) exception. An internal JOSE exception was encountered. "
  val Oauth2CannotMatchIssuerAndJwksUriException = "OBP-D-20208: Cannot match the issuer and JWKS URI at this server instance. "
  val Oauth2TokenHaveNoConsumer = "OBP-D-20209: The token have no linked consumer. "
  val Oauth2TokenMatchCertificateFail = "OBP-D-20210: The token is linked with a different client certificate. "
  val Oauth2TokenEndpointAuthMethodForbidden = "OBP-D-20213: The Token Endpoint Auth Method is not supported at this instance: "
  val OneTimePasswordExpired = "OBP-D-20211: The One Time Password (OTP) has expired. "
  val Oauth2IsNotRecognized = "OBP-D-20214: OAuth2 Access Token is not recognised at this instance."
  val Oauth2ValidateAccessTokenError = "OBP-D-20215: There was a problem validating the OAuth2 access token. "

  val AuthorizationHeaderAmbiguity = "OBP-D-20250: Request headers used for authorization are ambiguous. "

  // X.509
  val X509GeneralError = "OBP-D-20300: PEM Encoded Certificate issue."
  val X509ParsingFailed = "OBP-D-20301: Parsing failed for PEM Encoded Certificate."
  val X509CertificateExpired = "OBP-D-20302: PEM Encoded Certificate expired."
  val X509CertificateNotYetValid = "OBP-D-20303: PEM Encoded Certificate not yet valid."
  val X509CannotGetRSAPublicKey = "OBP-D-20304: RSA public key cannot be found at PEM Encoded Certificate."
  val X509CannotGetECPublicKey = "OBP-D-20305: EC public key cannot be found at PEM Encoded Certificate."
  val X509CannotGetCertificate = "OBP-D-20306: PEM Encoded Certificate cannot be found at request header."
  val X509ActionIsNotAllowed = "OBP-D-20307: PEM Encoded Certificate does not provide the proper role for the action has been taken."
  val X509ThereAreNoPsd2Roles = "OBP-D-20308: PEM Encoded Certificate does not contain PSD2 roles."
  val X509CannotGetPublicKey = "OBP-D-20309: Public key cannot be found in the PEM Encoded Certificate."
  val X509PublicKeyCannotVerify = "OBP-D-20310: Certificate's public key cannot be used to verify signed request."
  val X509RequestIsNotSigned = "OBP-D-20311: The Request is not signed."
  
  // OpenID Connect
  val CouldNotExchangeAuthorizationCodeForTokens = "OBP-D-20400: Could not exchange authorization code for tokens."
  val CouldNotSaveOpenIDConnectUser = "OBP-D-20401: Could not get/save OpenID Connect user."
  val CouldNotSaveOpenIDConnectToken = "OBP-D-20402: Could not save OpenID Connect token."
  val InvalidOpenIDConnectState = "OBP-D-20403: Invalid OpenIDConnect state parameter."
  val CouldNotHandleOpenIDConnectData = "OBP-D-20404: Could not handle OpenID Connect data."
  val CouldNotValidateIDToken = "OBP-D-20405: ID token could note be validated."

  // Resource related messages (OBP-D-30XXX)
  val BankNotFound = "OBP-D-30001: Bank not found. Please specify a valid value for BANK_ID."
  val CustomerNotFound = "OBP-D-30002: Customer not found. Please specify a valid value for CUSTOMER_NUMBER."
  val CustomerNotFoundByCustomerId = "OBP-D-30046: Customer not found. Please specify a valid value for CUSTOMER_ID."

  val AccountNotFound = "OBP-D-30003: Account not found. Please specify a valid value for ACCOUNT_ID."
  val CounterpartyNotFound = "OBP-D-30004: Counterparty not found. The BANK_ID / ACCOUNT_ID specified does not exist on this server."

  val ViewNotFound = "OBP-D-30005: View not found for Account. Please specify a valid value for VIEW_ID"

  val CustomerNumberAlreadyExists = "OBP-D-30006: Customer Number already exists. Please specify a different value for BANK_ID or CUSTOMER_NUMBER."
  val CustomerAlreadyExistsForUser = "OBP-D-30007: The User is already linked to a Customer at the bank specified by BANK_ID"
  val UserCustomerLinksNotFoundForUser = "OBP-D-30008: User Customer Link not found by USER_ID"
  val AtmNotFoundByAtmId = "OBP-D-30009: ATM not found. Please specify a valid value for ATM_ID."
  val BranchNotFoundByBranchId = "OBP-D-300010: Branch not found. Please specify a valid value for BRANCH_ID. Or License may not be set. meta.license.id and meta.license.name can not be empty"
  val ProductNotFoundByProductCode = "OBP-D-30011: Product not found. Please specify a valid value for PRODUCT_CODE."
  val CounterpartyNotFoundByIban = "OBP-D-30012: Counterparty not found. Please specify a valid value for IBAN."
  val CounterpartyBeneficiaryPermit = "OBP-D-30013: The account can not send money to the Counterparty. Please set the Counterparty 'isBeneficiary' true first"
  val CounterpartyAlreadyExists = "OBP-D-30014: Counterparty already exists. Please specify a different value for BANK_ID or ACCOUNT_ID or VIEW_ID or NAME."
  val CreateBranchError = "OBP-D-30015: Could not insert the Branch"
  val UpdateBranchError = "OBP-D-30016: Could not update the Branch"
  val CounterpartyNotFoundByCounterpartyId = "OBP-D-30017: Counterparty not found. Please specify a valid value for COUNTERPARTY_ID."
  val BankAccountNotFound = "OBP-D-30018: Bank Account not found. Please specify valid values for BANK_ID and ACCOUNT_ID. "
  val ConsumerNotFoundByConsumerId = "OBP-D-30019: Consumer not found. Please specify a valid value for CONSUMER_ID."
  

  val CreateBankError = "OBP-D-30020: Could not create the Bank"
  val UpdateBankError = "OBP-D-30021: Could not update the Bank"
  val NoViewPermission = "OBP-D-30022: The current view does not have the permission:"
  val UpdateConsumerError = "OBP-D-30023: Cannot update Consumer "
  val CreateConsumerError = "OBP-D-30024: Could not create Consumer "
  val CreateOAuth2ConsumerError = "OBP-D-30077: Could not create OAuth2 Consumer."

  val CreateUserCustomerLinksError = "OBP-D-30025: Could not create user_customer_links "
  val ConsumerKeyAlreadyExists = "OBP-D-30026: Consumer Key already exists. Please specify a different value."
  val NoExistingAccountHolders = "OBP-D-30027: Account Holders not found. The BANK_ID / ACCOUNT_ID specified for account holder does not exist on this server"


  val CreateAtmError = "OBP-D-30028: Could not insert the ATM"
  val DeleteAtmError = "OBP-D-30120: Could not delete the ATM"
  val UpdateAtmError = "OBP-D-30029: Could not update the ATM"

  val CreateProductError = "OBP-D-30030: Could not insert the Product."
  val UpdateProductError = "OBP-D-30031: Could not update the Product."
  val GetProductError = "OBP-D-30320: Could not get the Product."
  val GetProductTreeError = "OBP-D-30321: Could not get the Product Tree."

  val CreateCardError = "OBP-D-30032: Could not insert the Card"
  val UpdateCardError = "OBP-D-30033: Could not update the Card"

  val ViewIdNotSupported = s"OBP-D-30034: This ViewId is not supported. Only the following can be used: " 

  val UserCustomerLinkNotFound = "OBP-D-30035: User Customer Link not found"

  val CreateOrUpdateCounterpartyMetadataError = "OBP-D-30036: Could not create or update CounterpartyMetadata"
  val CounterpartyMetadataNotFound = "OBP-D-30037: CounterpartyMetadata not found. Please specify valid values for BANK_ID, ACCOUNT_ID and COUNTERPARTY_ID. "

  val CreateFxRateError = "OBP-D-30038: Could not insert the Fx Rate"
  val UpdateFxRateError = "OBP-D-30039: Could not update the Fx Rate"
  val UnknownFxRateError = "OBP-D-30040: Unknown Fx Rate error"
  
  val CheckbookOrderNotFound = "OBP-D-30041: CheckbookOrder not found for Account. "
  val GetTopApisError = "OBP-D-30042: Could not get the top apis from database.  "
  val GetMetricsTopConsumersError = "OBP-D-30045: Could not get the top consumers from database.  "
  val GetAggregateMetricsError = "OBP-D-30043: Could not get the aggregate metrics from database.  "

  val DefaultBankIdNotSet = "OBP-D-30044: Default BankId is not set on this instance. Please set defaultBank.bank_id in props files. "

  val CreateWebhookError = "OBP-D-30047: Cannot create Webhook"
  val GetWebhooksError = "OBP-D-30048: Cannot get Webhooks"
  val UpdateWebhookError = "OBP-D-30049: Cannot create Webhook"
  val WebhookNotFound = "OBP-D-30050: Webhook not found. Please specify a valid value for account_webhook_id."
  val CreateCustomerError = "OBP-D-30051: Cannot create Customer"
  val CheckCustomerError = "OBP-D-30052: Cannot check Customer"
  
  val CreateUserAuthContextError = "OBP-D-30053: Could not insert the UserAuthContext"
  val UpdateUserAuthContextError = "OBP-D-30054: Could not update the UserAuthContext"
  val UpdateUserAuthContextNotFound = "OBP-D-30055: UserAuthContext not found. Please specify a valid value for USER_ID."
  val DeleteUserAuthContextNotFound = "OBP-D-30056: UserAuthContext not found by USER_AUTH_CONTEXT_ID."
  val UserAuthContextUpdateNotFound = "OBP-D-30057: User Auth Context Update not found by AUTH_CONTEXT_UPDATE_ID."
  val UpdateCustomerError = "OBP-D-30058: Cannot update the Customer"
  
  val CardNotFound = "OBP-D-30059: This Card can not be found for the user "
  val CardAlreadyExists = "OBP-D-30060: Card already exists. Please specify different values for bankId, card_number and issueNumber."
  val CardAttributeNotFound = "OBP-D-30061: Card Attribute not found. Please specify a valid value for CARD_ATTRIBUTE_ID."
  val ParentProductNotFoundByProductCode = "OBP-D-30062: Parent product not found. Please specify an existing product code for parent_product_code. Leave empty if no parent product exists."
  val CannotGrantAccountAccess = "OBP-D-30063: Cannot grant account access."
  val CannotRevokeAccountAccess = "OBP-D-30064: Cannot revoke account access."
  val CannotFindAccountAccess = "OBP-D-30065: Cannot find account access."
  val CannotGetAccounts = "OBP-D-30066: Could not get accounts."
  val TransactionNotFound = "OBP-D-30067: Transaction not found. Please specify a valid value for TRANSACTION_ID."
  val RefundedTransaction = "OBP-D-30068: Transaction was already refunded . Please specify a valid value for TRANSACTION_ID."
  val CustomerAttributeNotFound = "OBP-D-30069: Customer Attribute not found. Please specify a valid value for CUSTOMER_ATTRIBUTE_ID."
  val TransactionAttributeNotFound = "OBP-D-30070: Transaction Attribute not found. Please specify a valid value for TRANSACTION_ATTRIBUTE_ID."
  val AttributeNotFound = "OBP-D-30071: Attribute Definition not found. Please specify a valid value for ATTRIBUTE_DEFINITION_ID."
  
  val CreateCounterpartyError = "OBP-D-30072: Could not create the Counterparty."

  val BankAccountNotFoundByAccountRouting = "OBP-D-30073: Bank Account not found. Please specify valid values for account routing scheme and address."
  val BankAccountNotFoundByIban = "OBP-D-30074: Bank Account not found. Please specify a valid value for iban."
  val AccountRoutingNotFound = "OBP-D-30075: Account routing not found, Please specify valid values for account routing scheme and address"
  val AccountRoutingNotUnique = "OBP-D-31075: Routing is not unique at this instance"
  val BankAccountNotFoundByAccountId = "OBP-D-30076: Bank Account not found. Please specify a valid value for ACCOUNT_ID."

  val TransactionRequestAttributeNotFound = "OBP-D-30078: Transaction Request Attribute not found. Please specify a valid value for TRANSACTION_REQUEST_ATTRIBUTE_ID."

  val ApiCollectionNotFound = "OBP-D-30079: ApiCollection not found."
  val CreateApiCollectionError = "OBP-D-30080: Could not create ApiCollection."
  val UpdateApiCollectionError = "OBP-D-3008A: Could not update ApiCollection."
  val DeleteApiCollectionError = "OBP-D-30081: Could not delete ApiCollection."

  val ApiCollectionEndpointNotFound = "OBP-D-30082: ApiCollectionEndpoint not found."
  val CreateApiCollectionEndpointError = "OBP-D-30083: Could not create ApiCollectionEndpoint."
  val DeleteApiCollectionEndpointError = "OBP-D-30084: Could not delete ApiCollectionEndpoint."
  val ApiCollectionEndpointAlreadyExists = "OBP-D-30085: The ApiCollectionEndpoint is already exists."
  val ApiCollectionAlreadyExists = "OBP-D-30086: The ApiCollection is already exists."

  val DoubleEntryTransactionNotFound = "OBP-D-30087: Double Entry Transaction not found."
  
  val InvalidAuthContextUpdateRequestKey = "OBP-D-30088: Invalid Auth Context Update Request Key."

  val UpdateAtmSupportedLanguagesException = "OBP-D-30089: Could not update the Atm Supported Languages."
  
  val UpdateAtmSupportedCurrenciesException = "OBP-D-30091: Could not update the Atm Supported Currencies."
  
  val UpdateAtmAccessibilityFeaturesException = "OBP-D-30092: Could not update the Atm Accessibility Features."
  
  val UpdateAtmServicesException = "OBP-D-30093: Could not update the Atm Services."
  
  val UpdateAtmNotesException = "OBP-D-30094: Could not update the Atm Notes."
  
  val UpdateAtmLocationCategoriesException = "OBP-D-30095: Could not update the Atm Location Categories."

  val CreateEndpointTagError = "OBP-D-30096: Could not insert the Endpoint Tag."
  val UpdateEndpointTagError = "OBP-D-30097: Could not update the Endpoint Tag."
  val UnknownEndpointTagError = "OBP-D-30098: Unknown Endpoint Tag error. "
  val EndpointTagNotFoundByEndpointTagId = "OBP-D-30099: Invalid ENDPOINT_TAG_ID. Please specify a valid value for ENDPOINT_TAG_ID."
  val EndpointTagAlreadyExists = "OBP-D-30100: EndpointTag already exists."

  // Meetings
  val MeetingsNotSupported = "OBP-D-30101: Meetings are not supported on this server."
  val MeetingApiKeyNotConfigured = "OBP-D-30102: Meeting provider API Key is not configured."
  val MeetingApiSecretNotConfigured = "OBP-D-30103: Meeting provider Secret is not configured."
  val MeetingNotFound = "OBP-D-30104: Meeting not found."
  


  val InvalidAccountBalanceCurrency = "OBP-D-30105: Invalid Balance Currency."
  val InvalidAccountBalanceAmount = "OBP-D-30106: Invalid Balance Amount."

  val InvalidUserId = "OBP-D-30107: Invalid User Id."
  val InvalidAccountType = "OBP-D-30108: Invalid Account Type."
  val InitialBalanceMustBeZero = "OBP-D-30109: Initial Balance of Account must be Zero (0)."
  val InvalidAccountIdFormat = "OBP-D-30110: Invalid Account Id. The ACCOUNT_ID should only contain 0-9/a-z/A-Z/'-'/'.'/'_', the length should be smaller than 255."
  val InvalidBankIdFormat = "OBP-D-30111: Invalid Bank Id. The BANK_ID should only contain 0-9/a-z/A-Z/'-'/'.'/'_', the length should be smaller than 255."
  val InvalidAccountInitialBalance = "OBP-D-30112: Invalid Number. Initial balance must be a number, e.g 1000.00"
  val InvalidCustomerBankId = "OBP-D-30113: Invalid Bank Id. The Customer does not belong to this Bank"
  val InvalidAccountRoutings = "OBP-D-30114: Invalid Account Routings."
  val AccountRoutingAlreadyExist = "OBP-D-30115: Account Routing already exist."
  val InvalidPaymentSystemName = "OBP-D-30116: Invalid payment system name. The payment system name should only contain 0-9/a-z/A-Z/'-'/'.'/'_', the length should be smaller than 200."
  
  val ProductFeeNotFoundById = "OBP-D-30117: Product Fee not found. Please specify a valid value for PRODUCT_FEE_ID."
  val CreateProductFeeError = "OBP-D-30118: Could not insert the Product Fee."
  val UpdateProductFeeError = "OBP-D-30119: Could not update the Product Fee."
  
  val InvalidCardNumber = "OBP-D-30200: Card not found. Please specify a valid value for CARD_NUMBER. "
  val AgentNotFound = "OBP-D-30201: Agent not found. Please specify a valid value for AGENT_ID. "
  val CreateAgentError = "OBP-D-30202: Could not create Agent."
  val UpdateAgentError = "OBP-D-30203: Could not update Agent."

  val CustomerAccountLinkNotFound = "OBP-D-30204: Customer Account Link not found"

  val EntitlementIsBankRole = "OBP-D-30205: This entitlement is a Bank Role. Please set bank_id to a valid bank id."
  val EntitlementIsSystemRole = "OBP-D-30206: This entitlement is a System Role. Please set bank_id to empty string."


  val InvalidStrongPasswordFormat = "OBP-D-30207: Invalid Password Format. Your password should EITHER be at least 10 characters long and contain mixed numbers and both upper and lower case letters and at least one special character, OR the length should be > 16 and <= 512."

  val AccountIdAlreadyExists = "OBP-D-30208: Account_ID already exists at the Bank."


  val InsufficientAuthorisationToCreateBranch  = "OBP-D-30209: Insufficient authorisation to Create Branch. You do not have the role CanCreateBranch." // was OBP-D-20019
  val InsufficientAuthorisationToDeleteBranch  = "OBP-D-30218: Insufficient authorisation to Create Branch. You do not have the role CanCreateBranch." // was OBP-D-20019
  val InsufficientAuthorisationToCreateBank  = "OBP-D-30210: Insufficient authorisation to Create Bank. You do not have the role CanCreateBank." // was OBP-D-20020

  val InvalidConnector = "OBP-D-30211: Invalid Connector. Please specify a valid value for CONNECTOR."

  val EntitlementNotFound = "OBP-D-30212: EntitlementId not found"
  val UserDoesNotHaveEntitlement = "OBP-D-30213: USER_ID does not have the ENTITLEMENT_ID."
  val EntitlementRequestAlreadyExists = "OBP-D-30214: Entitlement Request already exists for the user."
  val EntitlementRequestCannotBeAdded = "OBP-D-30217: Entitlement Request cannot be added."
  val EntitlementRequestNotFound = "OBP-D-30215: EntitlementRequestId not found"
  val EntitlementAlreadyExists = "OBP-D-30216: Entitlement already exists for the user."
  val EntitlementCannotBeDeleted = "OBP-D-30219: EntitlementId cannot be deleted."
  val EntitlementCannotBeGranted = "OBP-D-30220: Entitlement cannot be granted."
  val EntitlementCannotBeGrantedGrantorIssue = "OBP-D-30221: Entitlement cannot be granted due to the grantor's insufficient privileges."

  val CounterpartyNotFoundByRoutings = "OBP-D-30222: Counterparty not found. Please specify valid value for Routings."
  val AccountAlreadyExistsForCustomer = "OBP-D-30223: The Account is already linked to a Customer at the bank specified by BANK_ID"
  val CreateCustomerAccountLinkError = "OBP-D-30224: Could not create the customer account link."
  val CustomerAccountLinkNotFoundById = "OBP-D-30225: Customer Account Link not found. Please specify valid values for CUSTOMER_ACCOUNT_LINK_ID."
  val GetCustomerAccountLinksError = "OBP-D-30226: Could not get the customer account links."
  val UpdateCustomerAccountLinkError = "OBP-D-30227: Could not update the customer account link."
  val DeleteCustomerAccountLinkError = "OBP-D-30228: Could not delete the customer account link."
  val GetConsentImplicitSCAError = "OBP-D-30229: Could not get the implicit SCA consent."
  
  val CreateSystemViewError = "OBP-D-30250: Could not create the system view"
  val DeleteSystemViewError = "OBP-D-30251: Could not delete the system view"
  val SystemViewNotFound = "OBP-D-30252: System view not found. Please specify a valid value for VIEW_ID"
  val UpdateSystemViewError = "OBP-D-30253: Could not update the system view"
  val SystemViewAlreadyExistsError = "OBP-D-30254: The system view is already exists."
  val EmptyNameOfSystemViewError = "OBP-D-30255: You cannot create a View with an empty Name"
  val DeleteCustomViewError = "OBP-D-30256: Could not delete the custom view"
  val CannotFindCustomViewError = "OBP-D-30257: Could not find the custom view"
  val SystemViewCannotBePublicError = "OBP-D-30258: System view cannot be public"
  val CreateCustomViewError = "OBP-D-30259: Could not create the custom view"
  val UpdateCustomViewError = "OBP-D-30260: Could not update the custom view"
  val CreateCounterpartyLimitError = "OBP-D-30261: Could not create the counterparty limit."
  val UpdateCounterpartyLimitError = "OBP-D-30262: Could not update the counterparty limit."
  val GetCounterpartyLimitError = "OBP-D-30263: Counterparty limit not found. Please specify a valid value for BANK_ID, ACCOUNT_ID, VIEW_ID or COUNTERPARTY_ID."
  val CounterpartyLimitAlreadyExists = "OBP-D-30264: Counterparty limit already exists. Please specify a different value for BANK_ID, ACCOUNT_ID, VIEW_ID or COUNTERPARTY_ID."
  val DeleteCounterpartyLimitError = "OBP-D-30265: Could not delete the counterparty limit."
  val CustomViewAlreadyExistsError = "OBP-D-30266: The custom view is already exists."
  val UserDoesNotHavePermission = "OBP-D-30267: The user does not have the permission:"
  val CounterpartyLimitValidationError = "OBP-D-30268: Counterparty Limit Validation Error."
  val AccountNumberNotUniqueError = "OBP-D-30269: Finding an account by the accountNumber is ambiguous."
  val InvalidAccountNumber = "OBP-D-30270: Account not found. Please specify a valid value for ACCOUNT_NUMBER."
  val BankAccountNotFoundByRoutings = "OBP-D-30271: Bank Account not found. Please specify valid values for routing schemes and addresses."

  val TaxResidenceNotFound = "OBP-D-30300: Tax Residence not found by TAX_RESIDENCE_ID. "
  val CustomerAddressNotFound = "OBP-D-30310: Customer's Address not found by CUSTOMER_ADDRESS_ID. "
  val AccountApplicationNotFound = "OBP-D-30311: AccountApplication not found by ACCOUNT_APPLICATION_ID. "
  val ResourceUserNotFound = "OBP-D-30312: ResourceUser not found by USER_ID. "
  val UserIdAndCustomerIdNotPresent = "OBP-D-30313: userId and customerId not present. "
  val AccountApplicationAlreadyAccepted = "OBP-D-30314: AccountApplication has already been accepted. "
  val UpdateAccountApplicationStatusError = "OBP-D-30315: AccountApplication Status can not be updated. "
  val CreateAccountApplicationError = "OBP-D-30316: AccountApplication Status can not be created. "

  val DeleteCounterpartyError = "OBP-D-30317: Could not delete the Counterparty."
  val DeleteCounterpartyMetadataError = "OBP-D-30318: Could not delete CounterpartyMetadata"
  val UpdateBankAccountLabelError = "OBP-D-30319: Could not update Bank Account Label."

  val GetChargeValueError = "OBP-D-30323: Could not get the Charge Value."
  val GetTransactionRequestTypeChargesError = "OBP-D-30324: Could not get Transaction Request Type Charges."
  val AgentAccountLinkNotFound = "OBP-D-30325: Agent Account Link not found."
  val AgentsNotFound = "OBP-D-30326: Agents not found."
  val CreateAgentAccountLinkError = "OBP-D-30327: Could not create the agent account link."
  val AgentNumberAlreadyExists = "OBP-D-30328: Agent Number already exists. Please specify a different value for BANK_ID or AGENT_NUMBER."
  val GetAgentAccountLinksError = "OBP-D-30329: Could not get the agent account links."
  val AgentBeneficiaryPermit = "OBP-D-30330: The account can not send money to the Agent. Please set the Agent 'is_confirmed_agent' true  and `is_pending_agent` false."
  
  // Branch related messages
  val BranchesNotFoundLicense = "OBP-D-32001: No branches available. License may not be set."
  val BranchesNotFound = "OBP-D-32002: No branches available."

  // ATM related messages
  val atmsNotFoundLicense = "OBP-D-33001: No ATMs available. License may not be set."
  val atmsNotFound = "OBP-D-33002: No ATMs available."
  val DeleteAtmAttributeError = "OBP-D-33003: Could not delete ATM Attribute."
  
  // Bank related messages
  val bankIdAlreadyExists = "OBP-D-34000: Bank Id already exists. Please specify a different value."
  val updateBankError = "OBP-D-34001: Could not update the Bank"

  val RegulatedEntityNotFound = "OBP-D-34100: Regulated Entity not found. Please specify a valid value for REGULATED_ENTITY_ID."
  val RegulatedEntityNotDeleted = "OBP-D-34101: Regulated Entity cannot be deleted. Please specify a valid value for REGULATED_ENTITY_ID."
  val RegulatedEntityNotFoundByCertificate = "OBP-D-34102: Regulated Entity cannot be found by provided certificate."
  val PostJsonIsNotSigned = "OBP-D-34110: JWT at the post json cannot be verified."

  // Consents
  val ConsentNotFound = "OBP-D-35001: Consent not found by CONSENT_ID. "
  val ConsentNotBeforeIssue = "OBP-D-35002: The Consent Not Before time (nbf) is in the future. Not Before (nbf) should be in the past. Please make sure the Consent nbf is before the current date time of the OBP API server. "
  val ConsentExpiredIssue = "OBP-D-35003: Consent-Id is expired. "
  val ConsentVerificationIssue = "OBP-D-35004: Consent-Id JWT value couldn't be verified. "
  val ConsentStatusIssue = "OBP-D-35005: Consent-Id is not in status "
  val ConsentCheckExpiredIssue = "OBP-D-35006: Cannot check is Consent-Id expired. "
  val ConsentDisabled = "OBP-D-35007: Consents are not allowed at this instance. "
  val ConsentHeaderNotFound = "OBP-D-35008: Cannot get Consent-Id. "
  val ConsentAllowedScaMethods = "OBP-D-35009: Only SMS, EMAIL and IMPLICIT are supported as SCA methods. "
  val SmsServerNotResponding = "OBP-D-35010: SMS server is not working or SMS server can not send the message to the phone number:"
  val AuthorizationNotFound = "OBP-D-35011: Resource identification of the related Consent authorisation sub-resource not found by AUTHORIZATION_ID. "
  val ConsentAlreadyRevoked = "OBP-D-35012: Consent is already revoked. "
  val RolesAllowedInConsent = "OBP-D-35013: Consents can only contain Roles that you already have access to."
  val ViewsAllowedInConsent = "OBP-D-35014: Consents can only contain Views that you already have access to."
  val ConsentDoesNotMatchConsumer = "OBP-D-35015: The Consent does not match a valid Consumer."
  val ConsumerKeyHeaderMissing = "OBP-D-35016: The Consumer-Key request header is missing. The request header must contain the Consumer-Key of the Consumer that was used to create the Consent."
  val ConsumerAtConsentDisabled = "OBP-D-35017: The Consumer specified in this consent is disabled."
  val ConsumerAtConsentCannotBeFound = "OBP-D-35018: The Consumer specified in this consent cannot be found."
  val ConsumerValidationMethodForConsentNotDefined = "OBP-D-35019: Consumer validation method for consent is not defined at this instance."
  val ConsentMaxTTL = "OBP-D-35020: You exceeded max value of time to live of consents."
  val ConsentViewNotFund = "OBP-D-35021: Consent Views not found by CONSENT_ID."
  val ConsumerNotFound = "OBP-D-35022: The Consumer cannot be found by logged in user."
  val ConsentDoesNotMatchUser = "OBP-D-35023: The Consent does not match a valid User."
  val ConsentUserAlreadyAdded = "OBP-D-35024: The Consent's User is already added."
  val ConsentUpdateStatusError = "OBP-D-35025: The Consent's status cannot be updated."
  val ConsentUserCannotBeAdded = "OBP-D-35026: The Consent's User cannot be added."
  val ConsentUserAuthContextCannotBeAdded = "OBP-D-35027: The Consent's User Auth Context cannot be added."
  val ConsentRequestNotFound = "OBP-D-35028: Consent Request not found by CONSENT_REQUEST_ID. "
  val ConsentRequestIsInvalid = "OBP-D-35029: The CONSENT_REQUEST_ID is invalid. "
  val ConsumerKeyIsInvalid = "OBP-D-35030: The Consumer Key must be alphanumeric. (A-Z, a-z, 0-9)"
  val ConsumerKeyIsToLong = "OBP-D-35031: The Consumer Key max length <= 512"
  val ConsentHeaderValueInvalid = "OBP-D-35032: The Consent's Request Header value is not formatted as UUID or JWT."
  val UserAuthContextUpdateRequestAllowedScaMethods = "OBP-D-35034: Unsupported as SCA method. "

  //Authorisations
  val AuthorisationNotFound = "OBP-D-36001: Authorisation not found. Please specify valid values for PAYMENT_ID and AUTHORISATION_ID. "
  val InvalidAuthorisationStatus = "OBP-D-36002: Authorisation Status is Invalid"
  val AuthorisationNotFoundByPaymentId = "OBP-D-36003: Authorisation not found. Please specify valid values for PAYMENT_ID. "

  //EndpointMappings
  val EndpointMappingNotFoundByEndpointMappingId = "OBP-D-36004: Endpoint Mapping not found. Please specify valid values for ENDPOINT_MAPPING_ID. "
  val EndpointMappingNotFoundByOperationId = "OBP-D-36005: Endpoint Mapping not found. Please specify valid values for OPERATION_ID. "
  val InvalidEndpointMapping = "OBP-D-36006: Invalid Endpoint Mapping. "
  // General Resource related messages above here

  // User Invitation
  val CannotCreateUserInvitation = "OBP-D-37081: Cannot create user invitation."
  val CannotGetUserInvitation = "OBP-D-37882: Cannot get user invitation."
  val CannotFindUserInvitation = "OBP-D-37883: Cannot find user invitation."


  // Transaction Request related messages (OBP-D-40XXX)
  val InvalidTransactionRequestType = "OBP-D-40001: Invalid value for TRANSACTION_REQUEST_TYPE"
  val InsufficientAuthorisationToCreateTransactionRequest  = "OBP-D-40002: Insufficient authorisation to create TransactionRequest. " 
  val InvalidTransactionRequestId = "OBP-D-40004: Transaction Request Id not found."
  val InsufficientAuthorisationToCreateTransactionType  = "OBP-D-40005: Insufficient authorisation to Create Transaction Type offered by the bank. The Request could not be created because you don't have access to CanCreateTransactionType."
  val CreateTransactionTypeInsertError  = "OBP-D-40006: Could not insert Transaction Type: Non unique BANK_ID / SHORT_CODE"
  val CreateTransactionTypeUpdateError  = "OBP-D-40007: Could not update Transaction Type: Non unique BANK_ID / SHORT_CODE"
  val NotPositiveAmount = "OBP-D-40008: Can't send a payment with a value of 0 or less."
  val TransactionRequestTypeHasChanged = "OBP-D-40009: The TRANSACTION_REQUEST_TYPE has changed."
  val InvalidTransactionRequestChallengeId = "OBP-D-40010: Invalid Challenge Id. Please specify a valid value for CHALLENGE_ID."
  val TransactionRequestStatusNotInitiated = "OBP-D-40011: Transaction Request Status is not INITIATED."
  val CounterpartyNotFoundOtherAccountProvider = "OBP-D-40012: Please set up the otherAccountRoutingScheme and otherBankRoutingScheme fields of the Counterparty to 'OBP'"
  val InvalidChargePolicy = "OBP-D-40013: Invalid Charge Policy. Please specify a valid value for Charge_Policy: SHARED, SENDER or RECEIVER. "
  val AllowedAttemptsUsedUp = "OBP-D-40014: Sorry, you've used up your allowed attempts. "
  val InvalidChallengeType = "OBP-D-40015: Invalid Challenge Type. Please specify a valid value for CHALLENGE_TYPE, when you create the transaction request."
  val InvalidChallengeAnswer = s"OBP-D-40016: Invalid Challenge Answer. Please specify a valid value for answer in Json body. " +
    s"The challenge answer may be expired." +
    s"Or you've used up your allowed attempts." +
    "Or if connector = mapped and transactionRequestType_OTP_INSTRUCTION_TRANSPORT = DUMMY and suggested_default_sca_method=DUMMY, the answer must be `123`. " +
    "Or if connector = others, the challenge answer can be got by phone message or other security ways."
  val InvalidPhoneNumber = "OBP-D-40017: Invalid Phone Number. Please specify a valid value for PHONE_NUMBER. Eg:+9722398746 "
  val TransactionRequestsNotEnabled = "OBP-D-40018: Sorry, Transaction Requests are not enabled in this API instance."
  val InvalidChallengeTransactionRequestId = "OBP-D-40021: Invalid Challenge PaymentId or TRANSACTION_REQUEST_ID. "
  val InvalidChallengeChallengeId = "OBP-D-40022: Invalid ChallengeId. "
  val TransactionRequestCannotBeCancelled = "OBP-D-40023: Transaction Request cannot be cancelled. "
  val JsonSchemaIllegal = "OBP-D-40026: Incorrect json-schema Format. "
  val JsonSchemaValidationNotFound = "OBP-D-40027: JSON Schema Validation not found, please specify valid query parameter. "
  val ValidationDeleteError = "OBP-D-40028: Could not delete the JSON Schema Validation. "
  val OperationIdExistsError = "OBP-D-40029: OPERATION_ID already exists. Please specify different values for OPERATION_ID. "


  val AuthenticationTypeNameIllegal= s"OBP-D-40030: AuthenticationType name not correct. "
  val AuthenticationTypeValidationNotFound = "OBP-D-40032: AuthenticationTypeValidation not found, please specify valid query parameter. "
  val AuthenticationTypeValidationDeleteError = "OBP-D-40033: Could not delete the AuthenticationTypeValidation. "
  val AuthenticationTypeIllegal = "OBP-D-40034: Current request authentication type is illegal. "

  val ForceErrorInvalid = "OBP-D-40035: Force Error request header is invalid. "

  val ConnectorMethodNotFound = "OBP-D-40036: ConnectorMethod not found, please specify valid CONNECTOR_METHOD_ID. "
  val ConnectorMethodAlreadyExists = "OBP-D-40037: ConnectorMethod already exists. "
  val ConnectorMethodBodyCompileFail = "OBP-D-40038: ConnectorMethod methodBody is illegal scala code, compilation failed. "
  val DynamicResourceDocAlreadyExists = "OBP-D-40039: DynamicResourceDoc already exists."
  val DynamicResourceDocNotFound = "OBP-D-40040: DynamicResourceDoc not found, please specify valid DYNAMIC_RESOURCE_DOC_ID. "
  val DynamicResourceDocDeleteError = "OBP-D-40041: DynamicResourceDoc can not be deleted. "

  val DynamicMessageDocAlreadyExists = "OBP-D-40042: DynamicMessageDoc already exists."
  val DynamicMessageDocNotFound = "OBP-D-40043: DynamicMessageDoc not found, please specify valid DYNAMIC_MESSAGE_DOC_ID. "
  val DynamicMessageDocDeleteError = "OBP-D-40044: DynamicMessageDoc can not be deleted. "
  val DynamicCodeCompileFail = "OBP-D-40045: The code to do compile is illegal scala code, compilation failed. "

  val DynamicResourceDocMethodDependency = "OBP-D-40046: DynamicResourceDoc method call forbidden methods. "
  val DynamicResourceDocMethodPermission = "OBP-D-40047: DynamicResourceDoc method have no enough permissions. "
  val DynamicCodeLangNotSupport = "OBP-D-40049: This language of dynamic code is not supported. "

  val InvalidOperationId = "OBP-D-40048: Invalid operation_id, please specify valid operation_id."
  // Exceptions (OBP-D-50XXX)
  val UnknownError = "OBP-D-50000: Unknown Error."
  val FutureTimeoutException = "OBP-D-50001: Future Timeout Exception."
  val AdapterOrCoreBankingSystemException = "OBP-D-50003: Adapter Or Core Banking System Exception. Failed to get a valid response from the south side Adapter or Core Banking System."
  // This error may not be shown to user, just for debugging.
  val CurrentUserNotFoundException = "OBP-D-50004: Method (AuthUser.getCurrentUser) can not find the current user in the current context!"
  val AnUnspecifiedOrInternalErrorOccurred = "OBP-D-50005: An unspecified or internal error occurred."
  val ScalaEmptyBoxToLiftweb = "OBP-D-50010: Scala return Empty box to Liftweb."
  val NoCallContext = "OBP-D-50012: Can not get the CallContext object here."
  val UnspecifiedCbsError = "OBP-D-50013: The Core Banking System returned an unspecified error or response."
  val RefreshUserError = "OBP-D-50014: Can not refresh User."
  val InternalServerError = "OBP-D-50015: The server encountered an unexpected condition which prevented it from fulfilling the request."
  val NotAllowedEndpoint = "OBP-D-50017: The endpoint is forbidden at this API instance."
  val UnderConstructionError = "OBP-D-50018: Under Construction Error."
  val DatabaseConnectionClosedError = "OBP-D-50019: Cannot connect to the OBP database."


  // Connector Data Exceptions (OBP-D-502XX)
  val InvalidConnectorResponse = "OBP-D-50200: Connector cannot return the data we requested." // was OBP-D-30200
  val InvalidConnectorResponseForGetBankAccounts = "OBP-D-50201: Connector did not return the set of accounts we requested."  // was OBP-D-30201
  val InvalidConnectorResponseForGetBankAccount = "OBP-D-50202: Connector did not return the account we requested."  // was OBP-D-30202
  val InvalidConnectorResponseForGetTransaction = "OBP-D-50203: Connector did not return the transaction we requested."  // was OBP-D-30203
  val InvalidConnectorResponseForGetTransactions = "OBP-D-50204: Connector did not return the set of transactions we requested."  // was OBP-D-30204
  val InvalidConnectorResponseForGetTransactionRequests210 = "OBP-D-50205: Connector did not return the set of transaction requests we requested."
  val InvalidConnectorResponseForGetChallengeThreshold = "OBP-D-50206: Connector did not return the set of challenge threshold we requested."
  val InvalidConnectorResponseForGetChargeLevel = "OBP-D-50207: Connector did not return the set of challenge level we requested."
  val InvalidConnectorResponseForCreateTransactionRequestImpl210 = "OBP-D-50208: Connector did not return the set of transactions requests we requested."
  val InvalidConnectorResponseForMakePayment = "OBP-D-50209: Connector did not return the set of transactions we requested."
  val InvalidConnectorResponseForGetCheckbookOrdersFuture = "OBP-D-50211: Connector did not return the set of check book."
  val InvalidConnectorResponseForGetStatusOfCreditCardOrderFuture = "OBP-D-50212: Connector did not return the set of status of credit card."
  val InvalidConnectorResponseForCreateTransactionAfterChallengev300 = "OBP-D-50213: The Connector did not return a valid response for payments."
  val InvalidConnectorResponseForMissingRequiredValues = "OBP-D-50214: Connector return the data, but the data has missing required values."
  val InvalidConnectorResponseForCreateChallenge = "OBP-D-50215: Connector did not return the set of challenge we requested."
  val InvalidConnectorResponseForSaveDoubleEntryBookTransaction = "OBP-D-50216: The Connector did not return a valid response for saving double-entry transaction."
  val InvalidConnectorResponseForCancelPayment = "OBP-D-50217: Connector did not return the transaction we requested."
  val InvalidConnectorResponseForGetEndpointTags = "OBP-D-50218: Connector did not return the set of endpoint tags we requested."
  val InvalidConnectorResponseForGetBankAccountsWithAttributes = "OBP-D-50219: Connector did not return the bank accounts we requested."
  val InvalidConnectorResponseForGetPaymentLimit = "OBP-D-50220: Connector did not return the payment limit we requested."
  val InvalidConnectorResponseForCreateTransactionRequestBGV1 = "OBP-D-50221: CreateTransactionRequestBGV1 Connector did not return the data we requested."
  val InvalidConnectorResponseForGetStatus = "OBP-D-50222: Connector method getStatus did not return the data we requested."
  
  // Adapter Exceptions (OBP-D-6XXXX)
  // Also used for connector == mapped, and show it as the Internal errors.
  val GetStatusException = "OBP-D-60001: Save Transaction Exception. "
  val GetChargeValueException = "OBP-D-60002: Get ChargeValue Exception. "
  val CreateTransactionsException = "OBP-D-60003: Create transaction Exception. "
  val UpdateBankAccountException = "OBP-D-60004: Update bank account Exception. "
  val SaveTransactionRequestTransactionException = "OBP-D-60005: Save Transaction Request Transaction Exception. "
  val SaveTransactionRequestChallengeException = "OBP-D-60006: Save Transaction Request Challenge Exception. "
  val SaveTransactionRequestStatusException = "OBP-D-60007: Save Transaction Request Status Exception. "
  val TransactionRequestDetailsExtractException = "OBP-D-60008: Transaction detail body extract exception. "
  val GetTransactionsException = "OBP-D-60009: Get Transaction Exception. "
  val GetTransactionRequestsException = "OBP-D-60010: Get Transaction Requests Exception. "
  val CreateMeetingException = "OBP-D-60011: Create Meeting Exception. "
  val CreateMeetingInviteeException = "OBP-D-60012: Create Meeting Invitee Exception. "
  val AdapterUnknownError = "OBP-D-60013: Adapter Unknown Error. "
  val AdapterTimeOurError = "OBP-D-60014: Adapter Timeout Error. "
  val AdapterFunctionNotImplemented = "OBP-D-60015: Adapter Function Not Implemented."
  val SaveTransactionRequestDescriptionException = "OBP-D-60016: Save Transaction Request Description Exception. "

  // MethodRouting Exceptions (OBP-D-7XXXX)
  val InvalidBankIdRegex = "OBP-D-70001: Incorrect regex for bankIdPattern."
  val MethodRoutingNotFoundByMethodRoutingId = "OBP-D-70002: MethodRouting not found. Please specify a valid value for method_routing_id."
  val MethodRoutingAlreadyExistsError = "OBP-D-70003: Method Routing is already exists."

  // Cascade Deletion Exceptions (OBP-D-8XXXX)
  val CouldNotDeleteCascade = "OBP-D-80001: Could not delete cascade."
  
}
