import os

for (p,d,f) in os.walk("D:/autocoder"):  
	if p.find('.svn')>0:
		os.popen('rd /s /q %s'%p.replace('/','\\'))
