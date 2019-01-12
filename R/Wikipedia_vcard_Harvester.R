#This script will harvest the "infobox biography vcard" of every Wikipedia page (the page must own a vcard).

library(rvest)
library(magrittr)

webpage <- read_html("https://en.wikipedia.org/wiki/Isaac_Asimov")
table <- webpage %>% html_nodes("table.vcard") %>% html_table(header=F)
table <- table[[1]]
dict <- as.data.frame(table)
