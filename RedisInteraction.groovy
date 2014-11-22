@Grab('redis.clients:jedis:2.6.0')
import redis.clients.jedis.Jedis
import groovy.json.JsonSlurper

//def redisHost = 'localhost'
def redisHost = '192.168.59.104'
def jedis = new Jedis(redisHost)
jedis.del('athlete')
def athleteId = jedis.incr('athlete')
def athleteKey = "athlete:$athleteId"
jedis.hmset(athleteKey, [first: 'Paul', last: 'Tergat', dob: '1969-06-17'])

jedis.del('record')
def recordKey = "record:${jedis.incr('record')}"
jedis.hmset(recordKey, [time: '' + 2 * 60 * 60 + 4 * 60 + 55,
                        venue: 'Berlin', when: '2003-09-28'])

jedis.del("set:$athleteId")
jedis.sadd("set:$athleteId", recordKey)