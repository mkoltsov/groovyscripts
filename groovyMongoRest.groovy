@Grab(
        group = 'org.codehaus.groovy.modules.http-builder',
        module = 'http-builder',
        version = '0.7.1')
import groovyx.net.http.RESTClient

@Grab(group = 'org.mongodb', module = 'mongo-java-driver', version = '2.11.3')
import com.mongodb.BasicDBObject
import com.mongodb.Mongo

def mongo = new Mongo('127.0.0.1')
def db = mongo.getDB('test')

def col = db.getCollection("user")
def query = col.find([username: 'admin'] as BasicDBObject)
println query.collect { "${it.username} / ${it.password}" }

def locationApi = new RESTClient('http://maps.googleapis.com/maps/api/geocode/')

def city = System.console().readLine 'What is your city? '
def queryString = "json"
def response = locationApi.get(path: queryString,
        query: [address: city, sensor: 'true'])
println response.data.results.formatted_address[0]
def lat = response.data.results.geometry.location[0].lat
def lon = response.data.results.geometry.location[0].lng
println "coordinates are:$lat,$lon"


def cityApi = new RESTClient('https://api.forecast.io/')
def str = "forecast/a0dad77c4f7b382e7d2514b9bae7acdb/$lat,$lon"

def resp = cityApi.get(path: str,
        query: [units: 'si'])

println resp.data.currently.icon
println resp.data.currently.temperature

