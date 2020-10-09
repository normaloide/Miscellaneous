import hashlib as hash
import requests as req
import time as time
from bs4 import BeautifulSoup as bs

def update():
    url = 'https://www.spaceweatherlive.com/en/solar-activity'
    answer = req.get(url)
    
    if answer.status_code == 200:
        soup = bs(answer.text, 'html.parser').find("table", {"class":"table table-sm table-striped mb-0"})

        s = ''
        for i in soup.findNext('tbody'):
            s += i.text

        return hash.sha224(s.encode('utf-8')).hexdigest()

    else:
        print(error)

def main():
    i = 0
    saved_digest = update()
    while i == 0:
        digest = update()
        if digest != saved_digest:
            print("content has changed")
            saved_digest = digest

        time.sleep(600)

main()