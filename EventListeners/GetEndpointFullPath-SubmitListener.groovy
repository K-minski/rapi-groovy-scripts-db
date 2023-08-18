// Create EventListner "SubmitListener.afterSubmit" (will execute after each submit) and add following script code:
import com.eviware.soapui.impl.rest.support.RestUtils

def rutils = new RestUtils()

def endpoint =  submit.request.getEndpoint() // get Endpoint
def pathTempl = submit.request.getPath() // get Resource template
def path = RestUtils.getExpandedPath(pathTempl,submit.request.getParams(),context.modelItem) // get Resource path with template params expanded
def queryParam = rutils.getQueryParamsString(submit.request) // get Query with parameters

def fullPath = endpoint + path + queryParam
log.info fullPath
