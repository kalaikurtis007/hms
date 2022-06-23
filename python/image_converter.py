from PIL import Image
from pytesseract import pytesseract
import sys
import json
from datetime import datetime
path_to_tesseract = r"C:\Program Files (x86)\tesseract"
text = pytesseract.image_to_string(Image.open(str(sys.argv[1])))
lines = text.split("\n")
non_empty_lines = [line for line in lines if line.strip() != ""]

now= datetime.now()

data = {}
data['companyType']= non_empty_lines[1]
data['branch']=non_empty_lines[2]

data['date']= str(datetime.strptime(non_empty_lines[3].split(" ")[1], '%d/%m/%y'))
data['time']= str(datetime.strptime(non_empty_lines[3].split(" ")[3],'%H:%M').time())

data['code']=non_empty_lines[4]

data['name']=non_empty_lines[5].split(":")[1]

indexsix=non_empty_lines[6].split(" ")
data['mtype']=indexsix[2]
data['quantity']=indexsix[4]

indexseven=non_empty_lines[7].replace("%","")
indexseven=indexseven.split(" ")
data['fat']=indexseven[1]
data['snf']=indexseven[3]

data['awm']=non_empty_lines[8].split(" ")[1].replace("%","")

indexnine=non_empty_lines[9].replace("%","").split(" ")
data['rate']=indexnine[2]
data['total']=indexnine[4]

data['clr']=non_empty_lines[10].split(" ")[1]
data['shift']="M/E"

indexeleven=non_empty_lines[11].split(" ")
data['counter']=indexeleven[3]

json_data=json.dumps(data)
print(json_data)
