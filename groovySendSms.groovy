@Grab(
        group = 'org.codehaus.groovy.modules.http-builder',
        module = 'http-builder',
        version = '0.7.1')
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.URLENC

def twilio = new HTTPBuilder('https://api.twilio.com/2010-04-01/Accounts/AC61182b735ca4c0a896b42551b0b3c597/')
twilio.auth.basic 'AC61182b735ca4c0a896b42551b0b3c597', 'dddf47751b3e43688ffc825f25f13b4c'

def message = System.console().readLine 'What is your message? '

def postBody = [To: '+79263355584', From: '12252284694', Body: message]
twilio.post(path: 'Messages.json', body: postBody,
        requestContentType: URLENC) { resp ->

    println "POST Success: ${resp.statusLine}"
}


