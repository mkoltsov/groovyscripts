@Grab(group = 'com.gmongo', module = 'gmongo', version = '1.0')
import com.gmongo.GMongo

def mongo = new GMongo()

def db = mongo.getDB("dictionaries")
db.rusEn.drop()
new File("Phrasebook - Sheet 1.csv").splitEachLine(",", { line ->
    db.rusEn.insert([languageFrom: line[0],
                     languageTo  : line[1],
                     meaningFrom : line[2],
                     meaningTo   : line[3]])
})