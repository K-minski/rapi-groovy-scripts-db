// Create EventListner "ProjectRunListener.afterRun" (script will execute only if whole project is run) and add following script code:
def testSuites
def testCases
def testSteps

//Iterates and checks TestSuite statuses 
testSuites = projectRunner.getResults()
testSuites.each() {
	if(it.getStatus().toString()=="FAIL")log.info "->TestSuite '" + it.getTestSuite().getName() + "' status: " + it.getStatus().toString() + "..." + it.getTimeTaken() + " ms"
	//Iterates and checks TestCase statuses 
    testCases = it.getResults()
	testCases.each() {
		if(it.getStatus().toString()=="FAIL")log.info "  └--> TestCase '" + it.getTestCase().getName() + "' status: " + it.getStatus().toString() + "..." + it.getTimeTaken() + " ms"
		//Iterates and checks TestStep statuses
        testSteps =it.getResults()
		testSteps.each() {
			if(it.getStatus().toString()=="FAIL")log.info "       └--> TestStep '" + it.getTestStep().getName() + "' status: " + it.getStatus().toString() + "..." + it.getTimeTaken() + " ms"
			}
	}
}