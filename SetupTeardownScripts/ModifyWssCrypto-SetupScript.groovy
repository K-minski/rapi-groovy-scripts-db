def scriptScope = project.getWssContainer() // Depending on Setup Script level (Project/TestSuite/TestCase) scope have to be adjusted
//eg. : 
// Project level:  project.getWssContainer()
// Test Suite level: testSuite.project.getWssContainer()
// Test Case level:
def contextScope = context.getProject() // Depending on Setup Script level (Project/TestSuite/TestCase) scope have to be adjusted
//eg. : 
// Project level:  context.getProject()
// Test Suite level: context.getTestSuite().getProject()
// Test Case level:

// Helpers
log.info "List of set WSS keystores/truststores: " + scriptScope.getCryptoList()
log.info " List of Custom project properties: " + contextScope.getPropertyNames().toString()
//-----------


def cryptoName = "KeystoreTruststoreName" // Set name of keystore/truststore
def cryptoPassword = contextScope.getPropertyValue("CustomPropertyName") // Get Custom property value NOTE: Mind context scope depending on level where script is run

// Modify existing Keystore/Trustsote
def crypto = scriptScope.getCryptoByName(cryptoName)  // Selects keystore/truststore object
log.info "_________________________________Details" + crypto.getType() + ": " + cryptoName  + "_________________________________"
log.info "Source path of picked keystore/trustsote: " + crypto.getSource()

//crypto.setPassword(cryptoPassword) // Set up current Password (write manually or set property)
log.info "Password was set to: " + crypto.getPassword()

//crypto.setDefaultAlias("PropertyName")  // Set up current Default Alias (write manually or set property)
log.info "Default Alias was set to: " + crypto.getDefaultAlias()

//crypto.setAliasPassword("PropertyName")  // Set up current Alias Password (write manually or set property)
log.info "Alias Password was set to: " + crypto.getAliasPassword()

log.info "Current status of  "+ cryptoName +" : " + crypto.getStatus() // get Status after setup