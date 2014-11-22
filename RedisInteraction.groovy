@Grab('redis.clients:jedis:2.6.0')
import redis.clients.jedis.Jedis

def redisHost = '137.135.204.110'
def jedis = new Jedis(redisHost)
jedis.set("chef","pupa")
println jedis.get("chef")
jedis.set("pupa","chef")
println jedis.get("pupa")
