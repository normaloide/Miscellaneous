#!/usr/bin/env Rscript
n1=n2=1;n3=0;print(n1);print(n2);while(!is.infinite(n3)){n3=n1+n2;n1=n2;n2=n3;print(n3)};Sys.sleep(3600)
